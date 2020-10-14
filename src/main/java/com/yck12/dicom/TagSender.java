// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TagSender.java

package com.yck12.dicom;

import com.alibaba.fastjson.JSON;
import com.yck12.dicom.TagParseResult;
import com.yck12.dicom.gateway.*;
import com.yck12.dicom.HttpHolder;
import com.yck12.dicom.Series;
import com.yck12.dicom.Study;
import com.yck12.dicom.SeriesRepository;
import com.yck12.dicom.StudyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

import java.nio.file.Paths;
import java.time.LocalDateTime;

public class TagSender
{

    public TagSender(StudyRepository studyRepository, SeriesRepository seriesRepository, HttpHolder httpHolder)
    {
        this.studyRepository = studyRepository;
        this.seriesRepository = seriesRepository;
        this.httpHolder = httpHolder;
    }

    public void send(TagParseResult result)
    {
        TagStudy tagStudy = result.getStudy();
        TagSeries tagSeries = result.getSeries();
        log.info("Study[{}] >>> sync series:{}", tagStudy.getStudyInstanceUid(), tagSeries.getSeriesInstanceUid());
        Study study = studyRepository.getByStudyUid(tagStudy.getStudyInstanceUid());
        if(ObjectUtils.isEmpty(study))
        {
            TagPatient tagPatient = result.getPatient();
            httpHolder.post((new StringBuilder()).append(gatewayUrl).append("/patients").toString(), JSON.toJSONString(tagPatient));
            httpHolder.post((new StringBuilder()).append(gatewayUrl).append("/studies").toString(), JSON.toJSONString(tagStudy));
            study = new Study();
            study.setStudyUid(tagStudy.getStudyInstanceUid());
            study.setPatientName(tagPatient.getPatientName());
            study.setPatientId(tagPatient.getPatientId());
            study.setAccessionNumber(tagStudy.getAccessionNumber());
            study.setSourceAet(result.getScuAet());
            study.setCreateTime(LocalDateTime.now());
            studyRepository.save(study);
        }
        Series series = seriesRepository.getBySeriesUid(tagSeries.getSeriesInstanceUid());
        if(ObjectUtils.isEmpty(series))
        {
            httpHolder.post((new StringBuilder()).append(gatewayUrl).append("/series").toString(), JSON.toJSONString(tagSeries));
            httpHolder.post((new StringBuilder()).append(gatewayUrl).append("/instances").toString(), JSON.toJSONString(result.getImage()));
            httpHolder.post((new StringBuilder()).append(gatewayUrl).append("/tags").toString(), JSON.toJSONString(result.getOthers()));
            series = new Series();
            series.setSeriesUid(tagSeries.getSeriesInstanceUid());
            series.setModality(tagSeries.getModality());
            series.setBodyPart(tagSeries.getBodyPartExamined());
            series.setStudyId(study.getId());
            series.setCreateTime(LocalDateTime.now());
            seriesRepository.save(series);
            log.info("Study[{}] >>> save series[{}]", study.getStudyUid(), series.getSeriesUid());
        }
        String studySourcePath = Paths.get(storage, new String[] {
            "studies", study.getStudyUid()
        }).toString();
        String seriesSourcePath = Paths.get(studySourcePath, new String[] {
            series.getSeriesUid()
        }).toString();
        String seriesBackupPath = Paths.get(storage, new String[] {
            "backup", DateUtils.formatDate(LocalDateTime.now()), study.getStudyUid(), series.getSeriesUid()
        }).toString();
        FileUtils.moveFolder(seriesSourcePath, seriesBackupPath);
        log.info("Study[{}] >>> backup {} to {}", new Object[] {
            study.getStudyUid(), seriesSourcePath, seriesBackupPath
        });
        FileUtils.deleteEmptyFolder(studySourcePath);
    }

    private static final Logger log = LoggerFactory.getLogger(com/lifeccp/image/service/TagSender);
    private String storage;
    private String gatewayUrl;
    private final StudyRepository studyRepository;
    private final SeriesRepository seriesRepository;
    private final HttpHolder httpHolder;

}
