package com.yck12.dicom;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.VR;
import org.dcm4che3.io.DicomInputStream;
import org.dcm4che3.io.DicomOutputStream;
import org.dcm4che3.net.Association;
import org.dcm4che3.net.PDVInputStream;
import org.dcm4che3.net.pdu.PresentationContext;
import org.dcm4che3.net.service.BasicCStoreSCP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomStoreScp extends BasicCStoreSCP {
    private final String storageDir;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public CustomStoreScp(String storageDir) {
        super(new String[]{"*"});
        this.storageDir = storageDir;
    }

    protected void store(Association as, PresentationContext pc, Attributes rq, PDVInputStream data, Attributes rsp) {
        rsp.setInt(2304, VR.US, new int[]{0});
        if (this.storageDir != null) {
            String cuid = rq.getString(2);
            String iuid = rq.getString(4096);
            String tsuid = pc.getTransferSyntax();
            File file = new File(this.storageDir, "studies" + File.separator + iuid + ".part");

            try {
               this.write(as.createFileMetaInformation(iuid, cuid, tsuid), data, file);
                DcmUID dcmUID = DicomUtil.parseUids(file);
                String studyInstanceUID = dcmUID.getStudyInstanceUID();
                String dcmStorePath = Paths.get(this.storageDir, "studies", studyInstanceUID, dcmUID.getSeriesInstanceUID(), dcmUID.getSopInstanceUID() + ".dcm").toString();
                File finalDcm = new File(dcmStorePath);
//                FileCopyUtils.copy(file, finalDcm);
                FileUtils.move(file, finalDcm);
                TransferCache.getInstance().add(as, studyInstanceUID);
            } catch (Exception e) {
                this.logger.error(e.toString());
//                this.logger.error("receive error, delete {} {}", file.getAbsolutePath(), file.delete());
            }
        }
    }

    private void write(Attributes fmi, PDVInputStream data, File file) throws IOException {
        file.getParentFile().mkdirs();
        boolean isGEPrivateTS = false;
        if ("1.2.840.113619.5.2".equals(fmi.getString(131088))) {
            fmi.setString(131088, VR.UI, "1.2.840.10008.1.2");
            isGEPrivateTS = true;
            this.logger.info("change pixelData for GE Private Transfer Syntax[1.2.840.113619.5.2]");
        }

        DicomOutputStream out = new DicomOutputStream(file);
        Throwable var6 = null;

        try {
            out.writeFileMetaInformation(fmi);
            data.copyTo(out);
            if (isGEPrivateTS) {
                this.convertGEPrivate(file);
            }
        } catch (Throwable var15) {
            var6 = var15;
            throw var15;
        } finally {
            if (out != null) {
                if (var6 != null) {
                    try {
                        out.close();
                    } catch (Throwable var14) {
                        var6.addSuppressed(var14);
                    }
                } else {
                    out.close();
                }
            }

        }

    }

    private void convertGEPrivate(File file) throws IOException {
        DicomInputStream input = new DicomInputStream(file);
        Attributes attrs = input.readDataset(-1, -1);
        byte[] pixelDataBytes = attrs.getBytes(2145386512);
        byte[] newPixelDataBytes = new byte[pixelDataBytes.length];

        for (int i = 0; i < pixelDataBytes.length / 2; ++i) {
            newPixelDataBytes[2 * i] = pixelDataBytes[2 * i + 1];
            newPixelDataBytes[2 * i + 1] = pixelDataBytes[2 * i];
        }

        attrs.setBytes(2145386512, VR.OW, newPixelDataBytes);
        File fileTemp = new File(file.getAbsolutePath() + ".tmp");
        DicomOutputStream outTemp = new DicomOutputStream(fileTemp);
        outTemp.writeDataset(input.getFileMetaInformation(), attrs);
        input.close();
        outTemp.close();
        String path = file.getAbsolutePath();
        if (!file.delete()) {
            this.logger.info("Failed to delete ole file[{}] ", path);
        }

        if (!fileTemp.renameTo(new File(path))) {
            this.logger.error("Failed to rename {} to {}", fileTemp.getAbsolutePath(), path);
            throw new IOException("Failed to rename " + fileTemp + " to " + path);
        }
    }
}
