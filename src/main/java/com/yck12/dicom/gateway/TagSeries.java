// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TagSeries.java

package com.yck12.dicom.gateway;


public class TagSeries
{

    public TagSeries()
    {
    }

    public String getSeriesInstanceUid()
    {
        return seriesInstanceUid;
    }

    public String getStudyInstanceUid()
    {
        return studyInstanceUid;
    }

    public String getModality()
    {
        return modality;
    }

    public String getBodyPartExamined()
    {
        return bodyPartExamined;
    }

    public String getSeriesDescription()
    {
        return seriesDescription;
    }

    public String getSeriesNumber()
    {
        return seriesNumber;
    }

    public String getSeriesDate()
    {
        return seriesDate;
    }

    public String getSeriesTime()
    {
        return seriesTime;
    }

    public String getImagePositionPatient()
    {
        return imagePositionPatient;
    }

    public String getImageOrientationPatient()
    {
        return imageOrientationPatient;
    }

    public String getSliceThickness()
    {
        return sliceThickness;
    }

    public String getSpacingBetweenSlices()
    {
        return spacingBetweenSlices;
    }

    public String getSliceLocation()
    {
        return sliceLocation;
    }

    public String getPerformedProcedureStepStartDate()
    {
        return performedProcedureStepStartDate;
    }

    public String getPerformedProcedureStepStartTime()
    {
        return performedProcedureStepStartTime;
    }

    public String getPerformedProcedureStepEndDate()
    {
        return performedProcedureStepEndDate;
    }

    public String getPerformedProcedureStepEndTime()
    {
        return performedProcedureStepEndTime;
    }

    public String getRepetitionTime()
    {
        return repetitionTime;
    }

    public String getAcquisitionDuration()
    {
        return acquisitionDuration;
    }

    public String getEchoTime()
    {
        return echoTime;
    }

    public String getInversionTime()
    {
        return inversionTime;
    }

    public String getFlipAngle()
    {
        return flipAngle;
    }

    public String getProcessingFunction()
    {
        return processingFunction;
    }

    public String getPath()
    {
        return path;
    }

    public void setSeriesInstanceUid(String seriesInstanceUid)
    {
        this.seriesInstanceUid = seriesInstanceUid;
    }

    public void setStudyInstanceUid(String studyInstanceUid)
    {
        this.studyInstanceUid = studyInstanceUid;
    }

    public void setModality(String modality)
    {
        this.modality = modality;
    }

    public void setBodyPartExamined(String bodyPartExamined)
    {
        this.bodyPartExamined = bodyPartExamined;
    }

    public void setSeriesDescription(String seriesDescription)
    {
        this.seriesDescription = seriesDescription;
    }

    public void setSeriesNumber(String seriesNumber)
    {
        this.seriesNumber = seriesNumber;
    }

    public void setSeriesDate(String seriesDate)
    {
        this.seriesDate = seriesDate;
    }

    public void setSeriesTime(String seriesTime)
    {
        this.seriesTime = seriesTime;
    }

    public void setImagePositionPatient(String imagePositionPatient)
    {
        this.imagePositionPatient = imagePositionPatient;
    }

    public void setImageOrientationPatient(String imageOrientationPatient)
    {
        this.imageOrientationPatient = imageOrientationPatient;
    }

    public void setSliceThickness(String sliceThickness)
    {
        this.sliceThickness = sliceThickness;
    }

    public void setSpacingBetweenSlices(String spacingBetweenSlices)
    {
        this.spacingBetweenSlices = spacingBetweenSlices;
    }

    public void setSliceLocation(String sliceLocation)
    {
        this.sliceLocation = sliceLocation;
    }

    public void setPerformedProcedureStepStartDate(String performedProcedureStepStartDate)
    {
        this.performedProcedureStepStartDate = performedProcedureStepStartDate;
    }

    public void setPerformedProcedureStepStartTime(String performedProcedureStepStartTime)
    {
        this.performedProcedureStepStartTime = performedProcedureStepStartTime;
    }

    public void setPerformedProcedureStepEndDate(String performedProcedureStepEndDate)
    {
        this.performedProcedureStepEndDate = performedProcedureStepEndDate;
    }

    public void setPerformedProcedureStepEndTime(String performedProcedureStepEndTime)
    {
        this.performedProcedureStepEndTime = performedProcedureStepEndTime;
    }

    public void setRepetitionTime(String repetitionTime)
    {
        this.repetitionTime = repetitionTime;
    }

    public void setAcquisitionDuration(String acquisitionDuration)
    {
        this.acquisitionDuration = acquisitionDuration;
    }

    public void setEchoTime(String echoTime)
    {
        this.echoTime = echoTime;
    }

    public void setInversionTime(String inversionTime)
    {
        this.inversionTime = inversionTime;
    }

    public void setFlipAngle(String flipAngle)
    {
        this.flipAngle = flipAngle;
    }

    public void setProcessingFunction(String processingFunction)
    {
        this.processingFunction = processingFunction;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public boolean equals(Object o)
    {
        if(o == this)
            return true;
        if(!(o instanceof TagSeries))
            return false;
        TagSeries other = (TagSeries)o;
        if(!other.canEqual(this))
            return false;
        Object this$seriesInstanceUid = getSeriesInstanceUid();
        Object other$seriesInstanceUid = other.getSeriesInstanceUid();
        if(this$seriesInstanceUid != null ? !this$seriesInstanceUid.equals(other$seriesInstanceUid) : other$seriesInstanceUid != null)
            return false;
        Object this$studyInstanceUid = getStudyInstanceUid();
        Object other$studyInstanceUid = other.getStudyInstanceUid();
        if(this$studyInstanceUid != null ? !this$studyInstanceUid.equals(other$studyInstanceUid) : other$studyInstanceUid != null)
            return false;
        Object this$modality = getModality();
        Object other$modality = other.getModality();
        if(this$modality != null ? !this$modality.equals(other$modality) : other$modality != null)
            return false;
        Object this$bodyPartExamined = getBodyPartExamined();
        Object other$bodyPartExamined = other.getBodyPartExamined();
        if(this$bodyPartExamined != null ? !this$bodyPartExamined.equals(other$bodyPartExamined) : other$bodyPartExamined != null)
            return false;
        Object this$seriesDescription = getSeriesDescription();
        Object other$seriesDescription = other.getSeriesDescription();
        if(this$seriesDescription != null ? !this$seriesDescription.equals(other$seriesDescription) : other$seriesDescription != null)
            return false;
        Object this$seriesNumber = getSeriesNumber();
        Object other$seriesNumber = other.getSeriesNumber();
        if(this$seriesNumber != null ? !this$seriesNumber.equals(other$seriesNumber) : other$seriesNumber != null)
            return false;
        Object this$seriesDate = getSeriesDate();
        Object other$seriesDate = other.getSeriesDate();
        if(this$seriesDate != null ? !this$seriesDate.equals(other$seriesDate) : other$seriesDate != null)
            return false;
        Object this$seriesTime = getSeriesTime();
        Object other$seriesTime = other.getSeriesTime();
        if(this$seriesTime != null ? !this$seriesTime.equals(other$seriesTime) : other$seriesTime != null)
            return false;
        Object this$imagePositionPatient = getImagePositionPatient();
        Object other$imagePositionPatient = other.getImagePositionPatient();
        if(this$imagePositionPatient != null ? !this$imagePositionPatient.equals(other$imagePositionPatient) : other$imagePositionPatient != null)
            return false;
        Object this$imageOrientationPatient = getImageOrientationPatient();
        Object other$imageOrientationPatient = other.getImageOrientationPatient();
        if(this$imageOrientationPatient != null ? !this$imageOrientationPatient.equals(other$imageOrientationPatient) : other$imageOrientationPatient != null)
            return false;
        Object this$sliceThickness = getSliceThickness();
        Object other$sliceThickness = other.getSliceThickness();
        if(this$sliceThickness != null ? !this$sliceThickness.equals(other$sliceThickness) : other$sliceThickness != null)
            return false;
        Object this$spacingBetweenSlices = getSpacingBetweenSlices();
        Object other$spacingBetweenSlices = other.getSpacingBetweenSlices();
        if(this$spacingBetweenSlices != null ? !this$spacingBetweenSlices.equals(other$spacingBetweenSlices) : other$spacingBetweenSlices != null)
            return false;
        Object this$sliceLocation = getSliceLocation();
        Object other$sliceLocation = other.getSliceLocation();
        if(this$sliceLocation != null ? !this$sliceLocation.equals(other$sliceLocation) : other$sliceLocation != null)
            return false;
        Object this$performedProcedureStepStartDate = getPerformedProcedureStepStartDate();
        Object other$performedProcedureStepStartDate = other.getPerformedProcedureStepStartDate();
        if(this$performedProcedureStepStartDate != null ? !this$performedProcedureStepStartDate.equals(other$performedProcedureStepStartDate) : other$performedProcedureStepStartDate != null)
            return false;
        Object this$performedProcedureStepStartTime = getPerformedProcedureStepStartTime();
        Object other$performedProcedureStepStartTime = other.getPerformedProcedureStepStartTime();
        if(this$performedProcedureStepStartTime != null ? !this$performedProcedureStepStartTime.equals(other$performedProcedureStepStartTime) : other$performedProcedureStepStartTime != null)
            return false;
        Object this$performedProcedureStepEndDate = getPerformedProcedureStepEndDate();
        Object other$performedProcedureStepEndDate = other.getPerformedProcedureStepEndDate();
        if(this$performedProcedureStepEndDate != null ? !this$performedProcedureStepEndDate.equals(other$performedProcedureStepEndDate) : other$performedProcedureStepEndDate != null)
            return false;
        Object this$performedProcedureStepEndTime = getPerformedProcedureStepEndTime();
        Object other$performedProcedureStepEndTime = other.getPerformedProcedureStepEndTime();
        if(this$performedProcedureStepEndTime != null ? !this$performedProcedureStepEndTime.equals(other$performedProcedureStepEndTime) : other$performedProcedureStepEndTime != null)
            return false;
        Object this$repetitionTime = getRepetitionTime();
        Object other$repetitionTime = other.getRepetitionTime();
        if(this$repetitionTime != null ? !this$repetitionTime.equals(other$repetitionTime) : other$repetitionTime != null)
            return false;
        Object this$acquisitionDuration = getAcquisitionDuration();
        Object other$acquisitionDuration = other.getAcquisitionDuration();
        if(this$acquisitionDuration != null ? !this$acquisitionDuration.equals(other$acquisitionDuration) : other$acquisitionDuration != null)
            return false;
        Object this$echoTime = getEchoTime();
        Object other$echoTime = other.getEchoTime();
        if(this$echoTime != null ? !this$echoTime.equals(other$echoTime) : other$echoTime != null)
            return false;
        Object this$inversionTime = getInversionTime();
        Object other$inversionTime = other.getInversionTime();
        if(this$inversionTime != null ? !this$inversionTime.equals(other$inversionTime) : other$inversionTime != null)
            return false;
        Object this$flipAngle = getFlipAngle();
        Object other$flipAngle = other.getFlipAngle();
        if(this$flipAngle != null ? !this$flipAngle.equals(other$flipAngle) : other$flipAngle != null)
            return false;
        Object this$processingFunction = getProcessingFunction();
        Object other$processingFunction = other.getProcessingFunction();
        if(this$processingFunction != null ? !this$processingFunction.equals(other$processingFunction) : other$processingFunction != null)
            return false;
        Object this$path = getPath();
        Object other$path = other.getPath();
        return this$path != null ? this$path.equals(other$path) : other$path == null;
    }

    protected boolean canEqual(Object other)
    {
        return other instanceof TagSeries;
    }

    public int hashCode()
    {
        int PRIME = 59;
        int result = 1;
        Object $seriesInstanceUid = getSeriesInstanceUid();
        result = result * 59 + ($seriesInstanceUid != null ? $seriesInstanceUid.hashCode() : 43);
        Object $studyInstanceUid = getStudyInstanceUid();
        result = result * 59 + ($studyInstanceUid != null ? $studyInstanceUid.hashCode() : 43);
        Object $modality = getModality();
        result = result * 59 + ($modality != null ? $modality.hashCode() : 43);
        Object $bodyPartExamined = getBodyPartExamined();
        result = result * 59 + ($bodyPartExamined != null ? $bodyPartExamined.hashCode() : 43);
        Object $seriesDescription = getSeriesDescription();
        result = result * 59 + ($seriesDescription != null ? $seriesDescription.hashCode() : 43);
        Object $seriesNumber = getSeriesNumber();
        result = result * 59 + ($seriesNumber != null ? $seriesNumber.hashCode() : 43);
        Object $seriesDate = getSeriesDate();
        result = result * 59 + ($seriesDate != null ? $seriesDate.hashCode() : 43);
        Object $seriesTime = getSeriesTime();
        result = result * 59 + ($seriesTime != null ? $seriesTime.hashCode() : 43);
        Object $imagePositionPatient = getImagePositionPatient();
        result = result * 59 + ($imagePositionPatient != null ? $imagePositionPatient.hashCode() : 43);
        Object $imageOrientationPatient = getImageOrientationPatient();
        result = result * 59 + ($imageOrientationPatient != null ? $imageOrientationPatient.hashCode() : 43);
        Object $sliceThickness = getSliceThickness();
        result = result * 59 + ($sliceThickness != null ? $sliceThickness.hashCode() : 43);
        Object $spacingBetweenSlices = getSpacingBetweenSlices();
        result = result * 59 + ($spacingBetweenSlices != null ? $spacingBetweenSlices.hashCode() : 43);
        Object $sliceLocation = getSliceLocation();
        result = result * 59 + ($sliceLocation != null ? $sliceLocation.hashCode() : 43);
        Object $performedProcedureStepStartDate = getPerformedProcedureStepStartDate();
        result = result * 59 + ($performedProcedureStepStartDate != null ? $performedProcedureStepStartDate.hashCode() : 43);
        Object $performedProcedureStepStartTime = getPerformedProcedureStepStartTime();
        result = result * 59 + ($performedProcedureStepStartTime != null ? $performedProcedureStepStartTime.hashCode() : 43);
        Object $performedProcedureStepEndDate = getPerformedProcedureStepEndDate();
        result = result * 59 + ($performedProcedureStepEndDate != null ? $performedProcedureStepEndDate.hashCode() : 43);
        Object $performedProcedureStepEndTime = getPerformedProcedureStepEndTime();
        result = result * 59 + ($performedProcedureStepEndTime != null ? $performedProcedureStepEndTime.hashCode() : 43);
        Object $repetitionTime = getRepetitionTime();
        result = result * 59 + ($repetitionTime != null ? $repetitionTime.hashCode() : 43);
        Object $acquisitionDuration = getAcquisitionDuration();
        result = result * 59 + ($acquisitionDuration != null ? $acquisitionDuration.hashCode() : 43);
        Object $echoTime = getEchoTime();
        result = result * 59 + ($echoTime != null ? $echoTime.hashCode() : 43);
        Object $inversionTime = getInversionTime();
        result = result * 59 + ($inversionTime != null ? $inversionTime.hashCode() : 43);
        Object $flipAngle = getFlipAngle();
        result = result * 59 + ($flipAngle != null ? $flipAngle.hashCode() : 43);
        Object $processingFunction = getProcessingFunction();
        result = result * 59 + ($processingFunction != null ? $processingFunction.hashCode() : 43);
        Object $path = getPath();
        result = result * 59 + ($path != null ? $path.hashCode() : 43);
        return result;
    }

    public String toString()
    {
        return (new StringBuilder()).append("TagSeries(seriesInstanceUid=").append(getSeriesInstanceUid()).append(", studyInstanceUid=").append(getStudyInstanceUid()).append(", modality=").append(getModality()).append(", bodyPartExamined=").append(getBodyPartExamined()).append(", seriesDescription=").append(getSeriesDescription()).append(", seriesNumber=").append(getSeriesNumber()).append(", seriesDate=").append(getSeriesDate()).append(", seriesTime=").append(getSeriesTime()).append(", imagePositionPatient=").append(getImagePositionPatient()).append(", imageOrientationPatient=").append(getImageOrientationPatient()).append(", sliceThickness=").append(getSliceThickness()).append(", spacingBetweenSlices=").append(getSpacingBetweenSlices()).append(", sliceLocation=").append(getSliceLocation()).append(", performedProcedureStepStartDate=").append(getPerformedProcedureStepStartDate()).append(", performedProcedureStepStartTime=").append(getPerformedProcedureStepStartTime()).append(", performedProcedureStepEndDate=").append(getPerformedProcedureStepEndDate()).append(", performedProcedureStepEndTime=").append(getPerformedProcedureStepEndTime()).append(", repetitionTime=").append(getRepetitionTime()).append(", acquisitionDuration=").append(getAcquisitionDuration()).append(", echoTime=").append(getEchoTime()).append(", inversionTime=").append(getInversionTime()).append(", flipAngle=").append(getFlipAngle()).append(", processingFunction=").append(getProcessingFunction()).append(", path=").append(getPath()).append(")").toString();
    }

    private String seriesInstanceUid;
    private String studyInstanceUid;
    private String modality;
    private String bodyPartExamined;
    private String seriesDescription;
    private String seriesNumber;
    private String seriesDate;
    private String seriesTime;
    private String imagePositionPatient;
    private String imageOrientationPatient;
    private String sliceThickness;
    private String spacingBetweenSlices;
    private String sliceLocation;
    private String performedProcedureStepStartDate;
    private String performedProcedureStepStartTime;
    private String performedProcedureStepEndDate;
    private String performedProcedureStepEndTime;
    private String repetitionTime;
    private String acquisitionDuration;
    private String echoTime;
    private String inversionTime;
    private String flipAngle;
    private String processingFunction;
    private String path;
}
