package com.yck12.dicom;

import com.lifeccp.common.bo.TagParseResult;
import com.lifeccp.common.dto.gateway.TagImage;
import com.lifeccp.common.dto.gateway.TagPatient;
import com.lifeccp.common.dto.gateway.TagSeries;
import com.lifeccp.common.dto.gateway.TagStudy;
import com.lifeccp.common.util.DcmUtils;
import com.lifeccp.image.component.ToucanSetting.Modality;
import org.dcm4che3.data.Attributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class DcmAnalyser {

    private static final Logger log = LoggerFactory.getLogger(DcmAnalyser.class);
    @Value("#{setting.modality}")
    private Modality modality;
    @Value("#{setting.gateway.debug}")
    private boolean debug;


    public TagParseResult parse(String seriesPath) {
        DcmMetaData metaData = this.getDcmInfo(seriesPath);
        return ObjectUtils.isEmpty(metaData)?null:this.read(metaData);
    }

    private DcmMetaData getDcmInfo(String seriesPath) {
        try {
            File[] e = FileUtils.list(seriesPath);
            File[] var3 = e;
            int var4 = e.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                File image = var3[var5];
                DcmMetaData metaData = DcmUtils.parse(image);
                String dcmModality = metaData.getDataset().getString(524384);
                if(!StringUtils.isEmpty(dcmModality) && !this.modality.getIgnore().contains(dcmModality.toUpperCase())) {
                    return metaData;
                }
            }
        } catch (IOException var9) {
            log.error(var9.getMessage(), var9);
        }

        return null;
    }

    private TagParseResult read(DcmMetaData metaData) {
        TagParseResult result = new TagParseResult();
        Attributes dataset = metaData.getDataset();
        result.setPatient(this.readPatient(dataset));
        TagImage image = this.readImage(dataset);
        result.setImage(image);
        TagSeries series = this.readSeries(dataset);
        series.setSeriesInstanceUid(image.getSeriesInstanceUid());
        series.setStudyInstanceUid(image.getStudyInstanceUid());
        result.setSeries(series);
        TagStudy study = this.readStudy(dataset);
        study.setStudyInstanceUid(image.getStudyInstanceUid());
        study.setPatientId(result.getPatient().getPatientId());
        result.setStudy(study);
        Map others = DcmUtils.readAllTags(metaData.getMeta(), dataset);
        others.put(TagTitleUtils.getTitle(DcmUtils.getTitleKey(524312)), image.getSopInstanceUid());
        result.setOthers(others);
        if(this.debug) {
            result.getPatient().setPath(metaData.getFilePath());
            result.getStudy().setPath(metaData.getFilePath());
            result.getSeries().setPath(metaData.getFilePath());
            result.getImage().setPath(metaData.getFilePath());
            result.getOthers().put("path", metaData.getFilePath());
        }

        return result;
    }

    private TagPatient readPatient(Attributes dataset) {
        TagPatient patient = new TagPatient();
        patient.setPatientId(this.readAndRemoveTag(dataset, 1048608));
        patient.setPatientName(this.readAndRemoveTag(dataset, 1048592));
        patient.setPatientBirthDate(DateUtils.formatDcmDate(this.readAndRemoveTag(dataset, 1048624)));
        patient.setPatientBirthTime(DateUtils.formatDcmTime(this.readAndRemoveTag(dataset, 1048626)));
        patient.setPatientSex(this.readAndRemoveTag(dataset, 1048640));
        patient.setPatientAge(this.readAndRemoveTag(dataset, 1052688));
        patient.setPatientSize(this.readAndRemoveTag(dataset, 1052704));
        patient.setPatientWeight(this.readAndRemoveTag(dataset, 1052720));
        patient.setPatientAddress(this.readAndRemoveTag(dataset, 1052736));
        patient.setIssuerOfPatientId(this.readAndRemoveTag(dataset, 1048609));
        patient.setTypeOfPatientId(this.readAndRemoveTag(dataset, 1048610));
        patient.setPatientBirthName(this.readAndRemoveTag(dataset, 1052677));
        patient.setMotherBirthName(this.readAndRemoveTag(dataset, 1052768));
        patient.setPregnancyStatus(this.readAndRemoveTag(dataset, 1057216));
        return patient;
    }

    private TagImage readImage(Attributes dataset) {
        TagImage image = new TagImage();
        image.setSopInstanceUid(this.readAndRemoveTag(dataset, 524312));
        image.setSeriesInstanceUid(this.readAndRemoveTag(dataset, 2097166));
        image.setStudyInstanceUid(this.readAndRemoveTag(dataset, 2097165));
        image.setStationName(this.readAndRemoveTag(dataset, 528400));
        image.setKvp(this.readAndRemoveTag(dataset, 1572960));
        image.setExposureTime(this.readAndRemoveTag(dataset, 1577296));
        image.setTubeCurrent(this.readAndRemoveTag(dataset, 1577297));
        image.setCtdiVol(this.readAndRemoveTag(dataset, 1610565));
        image.setAcquisitionDuration(this.readAndRemoveTag(dataset, 1609843));
        image.setDiffusionBValue(this.readAndRemoveTag(dataset, 1609863));
        image.setImageType(this.readAndRemoveTag(dataset, 524296));
        image.setContentDate(DateUtils.formatDcmDate(this.readAndRemoveTag(dataset, 524323)));
        image.setContentTime(DateUtils.formatDcmTime(this.readAndRemoveTag(dataset, 524339)));
        image.setInstanceNumber(this.readAndRemoveTag(dataset, 2097171));
        image.setSamplesPerPixel(this.readAndRemoveTag(dataset, 2621442));
        image.setPhotometricInterpretation(this.readAndRemoveTag(dataset, 2621444));
        image.setRows(this.readAndRemoveTag(dataset, 2621456));
        image.setColumns(this.readAndRemoveTag(dataset, 2621457));
        image.setPixelSpacing(this.readAndRemoveTag(dataset, 2621488));
        image.setBitsAllocated(this.readAndRemoveTag(dataset, 2621696));
        image.setBitsStored(this.readAndRemoveTag(dataset, 2621697));
        image.setHighBit(this.readAndRemoveTag(dataset, 2621698));
        image.setPixelRepresentation(this.readAndRemoveTag(dataset, 2621699));
        image.setWindowCenter(this.readAndRemoveTag(dataset, 2625616));
        image.setWindowWidth(this.readAndRemoveTag(dataset, 2625617));
        image.setRescaleIntercept(this.readAndRemoveTag(dataset, 2625618));
        image.setRescaleSlope(this.readAndRemoveTag(dataset, 2625619));
        image.setRescaleType(this.readAndRemoveTag(dataset, 2625620));
        return image;
    }

    private TagSeries readSeries(Attributes dataset) {
        TagSeries series = new TagSeries();
        series.setModality(this.readAndRemoveTag(dataset, 524384));
        series.setBodyPartExamined(this.readAndRemoveTag(dataset, 1572885));
        series.setSeriesDescription(this.readAndRemoveTag(dataset, 528446));
        series.setSeriesNumber(this.readAndRemoveTag(dataset, 2097169));
        series.setSeriesDate(DateUtils.formatDcmDate(this.readAndRemoveTag(dataset, 524321)));
        series.setSeriesTime(DateUtils.formatDcmTime(this.readAndRemoveTag(dataset, 524337)));
        series.setImagePositionPatient(this.readAndRemoveTag(dataset, 2097202));
        series.setImageOrientationPatient(this.readAndRemoveTag(dataset, 2097207));
        series.setSliceThickness(this.readAndRemoveTag(dataset, 1572944));
        series.setSpacingBetweenSlices(this.readAndRemoveTag(dataset, 1573000));
        series.setSliceLocation(this.readAndRemoveTag(dataset, 2101313));
        series.setPerformedProcedureStepStartDate(DateUtils.formatDcmDate(this.readAndRemoveTag(dataset, 4194884)));
        series.setPerformedProcedureStepStartTime(DateUtils.formatDcmTime(this.readAndRemoveTag(dataset, 4194885)));
        series.setPerformedProcedureStepEndDate(DateUtils.formatDcmDate(this.readAndRemoveTag(dataset, 4194896)));
        series.setPerformedProcedureStepEndTime(DateUtils.formatDcmTime(this.readAndRemoveTag(dataset, 4194897)));
        series.setRepetitionTime(this.readAndRemoveTag(dataset, 1572992));
        series.setAcquisitionDuration(this.readAndRemoveTag(dataset, 1609843));
        series.setEchoTime(this.readAndRemoveTag(dataset, 1572993));
        series.setInversionTime(this.readAndRemoveTag(dataset, 1572994));
        series.setFlipAngle(this.readAndRemoveTag(dataset, 1577748));
        series.setProcessingFunction(this.readAndRemoveTag(dataset, 1593376));
        return series;
    }

    private TagStudy readStudy(Attributes dataset) {
        TagStudy study = new TagStudy();
        study.setStudyId(this.readAndRemoveTag(dataset, 2097168));
        study.setStudyDate(DateUtils.formatDcmDate(this.readAndRemoveTag(dataset, 524320)));
        study.setStudyTime(DateUtils.formatDcmTime(this.readAndRemoveTag(dataset, 524336)));
        study.setStudyDescription(this.readAndRemoveTag(dataset, 528432));
        study.setModalitiesInStudy(this.readAndRemoveTag(dataset, 524385));
        study.setAccessionNumber(this.readAndRemoveTag(dataset, 524368));
        study.setRequestedProcedureDescription(this.readAndRemoveTag(dataset, 3280992));
        return study;
    }

    private String readAndRemoveTag(Attributes dataset, int tag) {
        String tagValue = dataset.getString(tag);
        if(!StringUtils.isEmpty(tagValue)) {
            dataset.remove(tag);
            return tagValue;
        } else {
            return null;
        }
    }

}