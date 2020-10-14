package com.yck12.dicom;

import com.yck12.dicom.TagParseResult;
import com.yck12.dicom.DicomSCPSetting.SCP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.file.Paths;
import java.util.List;

@Service
public class MainService {

    private static final Logger log = LoggerFactory.getLogger(MainService.class);
    @Value("#{setting.scp}")
    private SCP scp;
    private final DcmAnalyser dcmAnalyser;
    private final TagSender tagSender;


    @Autowired
    public MainService(DcmAnalyser dcmAnalyser, TagSender tagSender) {
        this.dcmAnalyser = dcmAnalyser;
        this.tagSender = tagSender;
    }

    public void start(ReceivedEvent event) {
        log.info("Study[{}] >>> start parsing", event.getStudyInstanceUID());
        String studyDir = Paths.get(this.scp.getStorage(), new String[]{"studies", event.getStudyInstanceUID()}).toString();
        List list = FileUtils.listDirectory(studyDir);
        log.info("Study[{}] >>> has {} series", event.getStudyInstanceUID(), Integer.valueOf(list.size()));
        list.forEach((seriesPath) -> {
            TagParseResult result = this.dcmAnalyser.parse(seriesPath);
            result.setScuAet(event.getScuAet());
            result.getStudy().setDeviceId(event.getEquipId());
            this.tagSender.send(result);
        });
    }

}