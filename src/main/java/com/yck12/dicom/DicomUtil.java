package com.yck12.dicom;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.dcm4che3.data.Sequence;
import org.dcm4che3.data.UID;
import org.dcm4che3.data.VR;
import org.dcm4che3.io.DicomInputStream;
import org.dcm4che3.data.Attributes;
import org.dcm4che3.util.StringUtils;
import org.dcm4che3.util.TagUtils;
import org.springframework.util.ObjectUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Data
@Slf4j
public final class DicomUtil {

    /**
     * public static String dicomJsonContent(File dicomFile) {
     * String dicomJsonString = "";
     * <p>
     * try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
     * DicomInputStream dis = new DicomInputStream(dicomFile)) {
     * IncludeBulkData includeBulkData = IncludeBulkData.URI;
     * dis.setIncludeBulkData(includeBulkData);
     * <p>
     * JsonGenerator jsonGen = Json.createGenerator(baos);
     * JSONWriter jsonWriter = new JSONWriter(jsonGen);
     * dis.setDicomInputHandler(jsonWriter);
     * dis.readDataset(-1, -1);
     * jsonGen.flush();
     * dicomJsonString = new String(baos.toByteArray(), "UTF-8");
     * } catch (Exception e) {
     * System.out.println("error processing dicom: " + e.getMessage());
     * }
     * <p>
     * return dicomJsonString;
     * }
     */

    public static DcmMetaData parse(File file) throws Exception {
        DicomInputStream dis = new DicomInputStream(file);

        DcmMetaData dcmMetaData;
        try {
            dis.setIncludeBulkData(DicomInputStream.IncludeBulkData.NO);
            Attributes dataset = dis.readDataset(-1, -1);
            dcmMetaData = new DcmMetaData(file.getAbsolutePath(), dis.getFileMetaInformation(), dataset);
        } catch (Exception e) {
            throw e;
        } finally {
            if (dis != null) {
                try {
                    dis.close();
                } catch (Exception e) {
                    throw e;
                }
            } else {
                dis.close();
            }
        }

        return dcmMetaData;
    }

    public static DcmUID parseUids(File file) throws Exception {
        DicomInputStream dis = new DicomInputStream(file);
        DcmUID dcmUID;
        try {
            dis.setIncludeBulkData(DicomInputStream.IncludeBulkData.NO);
            Attributes dataset = dis.readDataset(-1, -1);
            dcmUID = new DcmUID(dataset.getString(0x20000D), dataset.getString(0x20000E), dataset.getString(0x00080018));
        } catch (Exception e) {
            throw e;
        } finally {
            if (dis != null) {
                try {
                    dis.close();
                } catch (Exception e) {
                    throw e;
                }
            } else {
                dis.close();
            }
        }
        return dcmUID;
    }

    public static String toUID(String uid) {
        uid = uid.trim();
        return !uid.equals("*") && !Character.isDigit(uid.charAt(0)) ? UID.forName(uid) : uid;
    }

    public static String[] toUIDs(String s) {
        if (s.equals("*")) {
            return new String[]{"*"};
        } else {
            String[] uids = StringUtils.split(s, ',');

            for (int i = 0; i < uids.length; ++i) {
                uids[i] = toUID(uids[i]);
            }

            return uids;
        }
    }

    public static String getTitleKey(int tag) {
        return "Tag" + TagUtils.toHexString(tag);
    }

    public static Map<String, String> readAllTags(Attributes meta, Attributes dataset) {
        Map<String, String> map = new HashMap<>();
        int[] tags = meta.tags();
        int tagLength = tags.length;
        int tag;
        String tagName;
        for (int i = 0; i < tagLength; ++i) {
            tag = tags[i];
            tagName = TagTitleUtils.getTitle(getTitleKey(tag));
            if (tagName.startsWith("Tag")) {
                //log.debug("Private Tag {} not supported", TagUtils.toString(tag));
            } else {
                map.put(tagName, readTagValue(meta, tag));
            }
        }

        tags = dataset.tags();
        tagLength = tags.length;

        for (int i = 0; i < tagLength; ++i) {
            tag = tags[i];
            tagName = TagTitleUtils.getTitle(getTitleKey(tag));
            if (tagName.startsWith("Tag")) {
                //log.debug("Private Tag {} not supported", TagUtils.toString(tag));
            } else {
                map.put(tagName, readTagValue(dataset, tag));
            }
        }

        return map;
    }

    private static String readTagValue(Attributes attr, int tag) {
        VR vr = attr.getVR(tag);
        if (!ObjectUtils.isEmpty(vr) && (vr == VR.DA || vr == VR.TM || vr == VR.OB || vr == VR.SQ)) {
            if (vr == VR.DA) {
                return DateUtils.formatDcmDate(attr.getString(tag));
            } else if (vr == VR.TM) {
                return DateUtils.formatDcmTime(attr.getString(tag));
            } else if (vr == VR.OB) {
                return null;
            } else {
                Sequence seq = attr.getSequence(tag);
                if (ObjectUtils.isEmpty(seq)) {
                    //log.info("Tag >>> SQ[{}] is null", TagUtils.toString(tag));
                    return null;
                } else {
                    JSONArray jsonArray = new JSONArray();
                    Iterator iterator = seq.iterator();


                    while (iterator.hasNext()) {
                        Attributes item = (Attributes) iterator.next();
                        JSONObject obj = new JSONObject();
                        int[] tags = item.tags();
                        int tagLength = tags.length;

                        for (int i = 0; i < tagLength; ++i) {
                            int itemTag = tags[i];
                            if (item.getVR(itemTag) != VR.SQ) {
                                obj.put(TagTitleUtils.getTitle(getTitleKey(itemTag)), item.getString(itemTag));
                            }
                        }

                        jsonArray.add(obj);
                    }

                    return jsonArray.toJSONString();
                }
            }
        } else {
            return attr.getString(tag);
        }
    }
}

