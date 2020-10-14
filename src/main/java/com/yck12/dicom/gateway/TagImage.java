// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TagImage.java

package com.yck12.dicom.gateway;


public class TagImage
{

    public TagImage()
    {
    }

    public String getSopInstanceUid()
    {
        return sopInstanceUid;
    }

    public String getSeriesInstanceUid()
    {
        return seriesInstanceUid;
    }

    public String getStudyInstanceUid()
    {
        return studyInstanceUid;
    }

    public String getStationName()
    {
        return stationName;
    }

    public String getKvp()
    {
        return kvp;
    }

    public String getExposureTime()
    {
        return exposureTime;
    }

    public String getTubeCurrent()
    {
        return tubeCurrent;
    }

    public String getCtdiVol()
    {
        return ctdiVol;
    }

    public String getAcquisitionDuration()
    {
        return acquisitionDuration;
    }

    public String getDiffusionBValue()
    {
        return diffusionBValue;
    }

    public String getImageType()
    {
        return imageType;
    }

    public String getContentDate()
    {
        return contentDate;
    }

    public String getContentTime()
    {
        return contentTime;
    }

    public String getInstanceNumber()
    {
        return instanceNumber;
    }

    public String getSamplesPerPixel()
    {
        return samplesPerPixel;
    }

    public String getPhotometricInterpretation()
    {
        return photometricInterpretation;
    }

    public String getRows()
    {
        return rows;
    }

    public String getColumns()
    {
        return columns;
    }

    public String getPixelSpacing()
    {
        return pixelSpacing;
    }

    public String getBitsAllocated()
    {
        return bitsAllocated;
    }

    public String getBitsStored()
    {
        return bitsStored;
    }

    public String getHighBit()
    {
        return highBit;
    }

    public String getPixelRepresentation()
    {
        return pixelRepresentation;
    }

    public String getWindowCenter()
    {
        return windowCenter;
    }

    public String getWindowWidth()
    {
        return windowWidth;
    }

    public String getRescaleIntercept()
    {
        return rescaleIntercept;
    }

    public String getRescaleSlope()
    {
        return rescaleSlope;
    }

    public String getRescaleType()
    {
        return rescaleType;
    }

    public String getPath()
    {
        return path;
    }

    public void setSopInstanceUid(String sopInstanceUid)
    {
        this.sopInstanceUid = sopInstanceUid;
    }

    public void setSeriesInstanceUid(String seriesInstanceUid)
    {
        this.seriesInstanceUid = seriesInstanceUid;
    }

    public void setStudyInstanceUid(String studyInstanceUid)
    {
        this.studyInstanceUid = studyInstanceUid;
    }

    public void setStationName(String stationName)
    {
        this.stationName = stationName;
    }

    public void setKvp(String kvp)
    {
        this.kvp = kvp;
    }

    public void setExposureTime(String exposureTime)
    {
        this.exposureTime = exposureTime;
    }

    public void setTubeCurrent(String tubeCurrent)
    {
        this.tubeCurrent = tubeCurrent;
    }

    public void setCtdiVol(String ctdiVol)
    {
        this.ctdiVol = ctdiVol;
    }

    public void setAcquisitionDuration(String acquisitionDuration)
    {
        this.acquisitionDuration = acquisitionDuration;
    }

    public void setDiffusionBValue(String diffusionBValue)
    {
        this.diffusionBValue = diffusionBValue;
    }

    public void setImageType(String imageType)
    {
        this.imageType = imageType;
    }

    public void setContentDate(String contentDate)
    {
        this.contentDate = contentDate;
    }

    public void setContentTime(String contentTime)
    {
        this.contentTime = contentTime;
    }

    public void setInstanceNumber(String instanceNumber)
    {
        this.instanceNumber = instanceNumber;
    }

    public void setSamplesPerPixel(String samplesPerPixel)
    {
        this.samplesPerPixel = samplesPerPixel;
    }

    public void setPhotometricInterpretation(String photometricInterpretation)
    {
        this.photometricInterpretation = photometricInterpretation;
    }

    public void setRows(String rows)
    {
        this.rows = rows;
    }

    public void setColumns(String columns)
    {
        this.columns = columns;
    }

    public void setPixelSpacing(String pixelSpacing)
    {
        this.pixelSpacing = pixelSpacing;
    }

    public void setBitsAllocated(String bitsAllocated)
    {
        this.bitsAllocated = bitsAllocated;
    }

    public void setBitsStored(String bitsStored)
    {
        this.bitsStored = bitsStored;
    }

    public void setHighBit(String highBit)
    {
        this.highBit = highBit;
    }

    public void setPixelRepresentation(String pixelRepresentation)
    {
        this.pixelRepresentation = pixelRepresentation;
    }

    public void setWindowCenter(String windowCenter)
    {
        this.windowCenter = windowCenter;
    }

    public void setWindowWidth(String windowWidth)
    {
        this.windowWidth = windowWidth;
    }

    public void setRescaleIntercept(String rescaleIntercept)
    {
        this.rescaleIntercept = rescaleIntercept;
    }

    public void setRescaleSlope(String rescaleSlope)
    {
        this.rescaleSlope = rescaleSlope;
    }

    public void setRescaleType(String rescaleType)
    {
        this.rescaleType = rescaleType;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public boolean equals(Object o)
    {
        if(o == this)
            return true;
        if(!(o instanceof TagImage))
            return false;
        TagImage other = (TagImage)o;
        if(!other.canEqual(this))
            return false;
        Object this$sopInstanceUid = getSopInstanceUid();
        Object other$sopInstanceUid = other.getSopInstanceUid();
        if(this$sopInstanceUid != null ? !this$sopInstanceUid.equals(other$sopInstanceUid) : other$sopInstanceUid != null)
            return false;
        Object this$seriesInstanceUid = getSeriesInstanceUid();
        Object other$seriesInstanceUid = other.getSeriesInstanceUid();
        if(this$seriesInstanceUid != null ? !this$seriesInstanceUid.equals(other$seriesInstanceUid) : other$seriesInstanceUid != null)
            return false;
        Object this$studyInstanceUid = getStudyInstanceUid();
        Object other$studyInstanceUid = other.getStudyInstanceUid();
        if(this$studyInstanceUid != null ? !this$studyInstanceUid.equals(other$studyInstanceUid) : other$studyInstanceUid != null)
            return false;
        Object this$stationName = getStationName();
        Object other$stationName = other.getStationName();
        if(this$stationName != null ? !this$stationName.equals(other$stationName) : other$stationName != null)
            return false;
        Object this$kvp = getKvp();
        Object other$kvp = other.getKvp();
        if(this$kvp != null ? !this$kvp.equals(other$kvp) : other$kvp != null)
            return false;
        Object this$exposureTime = getExposureTime();
        Object other$exposureTime = other.getExposureTime();
        if(this$exposureTime != null ? !this$exposureTime.equals(other$exposureTime) : other$exposureTime != null)
            return false;
        Object this$tubeCurrent = getTubeCurrent();
        Object other$tubeCurrent = other.getTubeCurrent();
        if(this$tubeCurrent != null ? !this$tubeCurrent.equals(other$tubeCurrent) : other$tubeCurrent != null)
            return false;
        Object this$ctdiVol = getCtdiVol();
        Object other$ctdiVol = other.getCtdiVol();
        if(this$ctdiVol != null ? !this$ctdiVol.equals(other$ctdiVol) : other$ctdiVol != null)
            return false;
        Object this$acquisitionDuration = getAcquisitionDuration();
        Object other$acquisitionDuration = other.getAcquisitionDuration();
        if(this$acquisitionDuration != null ? !this$acquisitionDuration.equals(other$acquisitionDuration) : other$acquisitionDuration != null)
            return false;
        Object this$diffusionBValue = getDiffusionBValue();
        Object other$diffusionBValue = other.getDiffusionBValue();
        if(this$diffusionBValue != null ? !this$diffusionBValue.equals(other$diffusionBValue) : other$diffusionBValue != null)
            return false;
        Object this$imageType = getImageType();
        Object other$imageType = other.getImageType();
        if(this$imageType != null ? !this$imageType.equals(other$imageType) : other$imageType != null)
            return false;
        Object this$contentDate = getContentDate();
        Object other$contentDate = other.getContentDate();
        if(this$contentDate != null ? !this$contentDate.equals(other$contentDate) : other$contentDate != null)
            return false;
        Object this$contentTime = getContentTime();
        Object other$contentTime = other.getContentTime();
        if(this$contentTime != null ? !this$contentTime.equals(other$contentTime) : other$contentTime != null)
            return false;
        Object this$instanceNumber = getInstanceNumber();
        Object other$instanceNumber = other.getInstanceNumber();
        if(this$instanceNumber != null ? !this$instanceNumber.equals(other$instanceNumber) : other$instanceNumber != null)
            return false;
        Object this$samplesPerPixel = getSamplesPerPixel();
        Object other$samplesPerPixel = other.getSamplesPerPixel();
        if(this$samplesPerPixel != null ? !this$samplesPerPixel.equals(other$samplesPerPixel) : other$samplesPerPixel != null)
            return false;
        Object this$photometricInterpretation = getPhotometricInterpretation();
        Object other$photometricInterpretation = other.getPhotometricInterpretation();
        if(this$photometricInterpretation != null ? !this$photometricInterpretation.equals(other$photometricInterpretation) : other$photometricInterpretation != null)
            return false;
        Object this$rows = getRows();
        Object other$rows = other.getRows();
        if(this$rows != null ? !this$rows.equals(other$rows) : other$rows != null)
            return false;
        Object this$columns = getColumns();
        Object other$columns = other.getColumns();
        if(this$columns != null ? !this$columns.equals(other$columns) : other$columns != null)
            return false;
        Object this$pixelSpacing = getPixelSpacing();
        Object other$pixelSpacing = other.getPixelSpacing();
        if(this$pixelSpacing != null ? !this$pixelSpacing.equals(other$pixelSpacing) : other$pixelSpacing != null)
            return false;
        Object this$bitsAllocated = getBitsAllocated();
        Object other$bitsAllocated = other.getBitsAllocated();
        if(this$bitsAllocated != null ? !this$bitsAllocated.equals(other$bitsAllocated) : other$bitsAllocated != null)
            return false;
        Object this$bitsStored = getBitsStored();
        Object other$bitsStored = other.getBitsStored();
        if(this$bitsStored != null ? !this$bitsStored.equals(other$bitsStored) : other$bitsStored != null)
            return false;
        Object this$highBit = getHighBit();
        Object other$highBit = other.getHighBit();
        if(this$highBit != null ? !this$highBit.equals(other$highBit) : other$highBit != null)
            return false;
        Object this$pixelRepresentation = getPixelRepresentation();
        Object other$pixelRepresentation = other.getPixelRepresentation();
        if(this$pixelRepresentation != null ? !this$pixelRepresentation.equals(other$pixelRepresentation) : other$pixelRepresentation != null)
            return false;
        Object this$windowCenter = getWindowCenter();
        Object other$windowCenter = other.getWindowCenter();
        if(this$windowCenter != null ? !this$windowCenter.equals(other$windowCenter) : other$windowCenter != null)
            return false;
        Object this$windowWidth = getWindowWidth();
        Object other$windowWidth = other.getWindowWidth();
        if(this$windowWidth != null ? !this$windowWidth.equals(other$windowWidth) : other$windowWidth != null)
            return false;
        Object this$rescaleIntercept = getRescaleIntercept();
        Object other$rescaleIntercept = other.getRescaleIntercept();
        if(this$rescaleIntercept != null ? !this$rescaleIntercept.equals(other$rescaleIntercept) : other$rescaleIntercept != null)
            return false;
        Object this$rescaleSlope = getRescaleSlope();
        Object other$rescaleSlope = other.getRescaleSlope();
        if(this$rescaleSlope != null ? !this$rescaleSlope.equals(other$rescaleSlope) : other$rescaleSlope != null)
            return false;
        Object this$rescaleType = getRescaleType();
        Object other$rescaleType = other.getRescaleType();
        if(this$rescaleType != null ? !this$rescaleType.equals(other$rescaleType) : other$rescaleType != null)
            return false;
        Object this$path = getPath();
        Object other$path = other.getPath();
        return this$path != null ? this$path.equals(other$path) : other$path == null;
    }

    protected boolean canEqual(Object other)
    {
        return other instanceof TagImage;
    }

    public int hashCode()
    {
        int PRIME = 59;
        int result = 1;
        Object $sopInstanceUid = getSopInstanceUid();
        result = result * 59 + ($sopInstanceUid != null ? $sopInstanceUid.hashCode() : 43);
        Object $seriesInstanceUid = getSeriesInstanceUid();
        result = result * 59 + ($seriesInstanceUid != null ? $seriesInstanceUid.hashCode() : 43);
        Object $studyInstanceUid = getStudyInstanceUid();
        result = result * 59 + ($studyInstanceUid != null ? $studyInstanceUid.hashCode() : 43);
        Object $stationName = getStationName();
        result = result * 59 + ($stationName != null ? $stationName.hashCode() : 43);
        Object $kvp = getKvp();
        result = result * 59 + ($kvp != null ? $kvp.hashCode() : 43);
        Object $exposureTime = getExposureTime();
        result = result * 59 + ($exposureTime != null ? $exposureTime.hashCode() : 43);
        Object $tubeCurrent = getTubeCurrent();
        result = result * 59 + ($tubeCurrent != null ? $tubeCurrent.hashCode() : 43);
        Object $ctdiVol = getCtdiVol();
        result = result * 59 + ($ctdiVol != null ? $ctdiVol.hashCode() : 43);
        Object $acquisitionDuration = getAcquisitionDuration();
        result = result * 59 + ($acquisitionDuration != null ? $acquisitionDuration.hashCode() : 43);
        Object $diffusionBValue = getDiffusionBValue();
        result = result * 59 + ($diffusionBValue != null ? $diffusionBValue.hashCode() : 43);
        Object $imageType = getImageType();
        result = result * 59 + ($imageType != null ? $imageType.hashCode() : 43);
        Object $contentDate = getContentDate();
        result = result * 59 + ($contentDate != null ? $contentDate.hashCode() : 43);
        Object $contentTime = getContentTime();
        result = result * 59 + ($contentTime != null ? $contentTime.hashCode() : 43);
        Object $instanceNumber = getInstanceNumber();
        result = result * 59 + ($instanceNumber != null ? $instanceNumber.hashCode() : 43);
        Object $samplesPerPixel = getSamplesPerPixel();
        result = result * 59 + ($samplesPerPixel != null ? $samplesPerPixel.hashCode() : 43);
        Object $photometricInterpretation = getPhotometricInterpretation();
        result = result * 59 + ($photometricInterpretation != null ? $photometricInterpretation.hashCode() : 43);
        Object $rows = getRows();
        result = result * 59 + ($rows != null ? $rows.hashCode() : 43);
        Object $columns = getColumns();
        result = result * 59 + ($columns != null ? $columns.hashCode() : 43);
        Object $pixelSpacing = getPixelSpacing();
        result = result * 59 + ($pixelSpacing != null ? $pixelSpacing.hashCode() : 43);
        Object $bitsAllocated = getBitsAllocated();
        result = result * 59 + ($bitsAllocated != null ? $bitsAllocated.hashCode() : 43);
        Object $bitsStored = getBitsStored();
        result = result * 59 + ($bitsStored != null ? $bitsStored.hashCode() : 43);
        Object $highBit = getHighBit();
        result = result * 59 + ($highBit != null ? $highBit.hashCode() : 43);
        Object $pixelRepresentation = getPixelRepresentation();
        result = result * 59 + ($pixelRepresentation != null ? $pixelRepresentation.hashCode() : 43);
        Object $windowCenter = getWindowCenter();
        result = result * 59 + ($windowCenter != null ? $windowCenter.hashCode() : 43);
        Object $windowWidth = getWindowWidth();
        result = result * 59 + ($windowWidth != null ? $windowWidth.hashCode() : 43);
        Object $rescaleIntercept = getRescaleIntercept();
        result = result * 59 + ($rescaleIntercept != null ? $rescaleIntercept.hashCode() : 43);
        Object $rescaleSlope = getRescaleSlope();
        result = result * 59 + ($rescaleSlope != null ? $rescaleSlope.hashCode() : 43);
        Object $rescaleType = getRescaleType();
        result = result * 59 + ($rescaleType != null ? $rescaleType.hashCode() : 43);
        Object $path = getPath();
        result = result * 59 + ($path != null ? $path.hashCode() : 43);
        return result;
    }

    public String toString()
    {
        return (new StringBuilder()).append("TagImage(sopInstanceUid=").append(getSopInstanceUid()).append(", seriesInstanceUid=").append(getSeriesInstanceUid()).append(", studyInstanceUid=").append(getStudyInstanceUid()).append(", stationName=").append(getStationName()).append(", kvp=").append(getKvp()).append(", exposureTime=").append(getExposureTime()).append(", tubeCurrent=").append(getTubeCurrent()).append(", ctdiVol=").append(getCtdiVol()).append(", acquisitionDuration=").append(getAcquisitionDuration()).append(", diffusionBValue=").append(getDiffusionBValue()).append(", imageType=").append(getImageType()).append(", contentDate=").append(getContentDate()).append(", contentTime=").append(getContentTime()).append(", instanceNumber=").append(getInstanceNumber()).append(", samplesPerPixel=").append(getSamplesPerPixel()).append(", photometricInterpretation=").append(getPhotometricInterpretation()).append(", rows=").append(getRows()).append(", columns=").append(getColumns()).append(", pixelSpacing=").append(getPixelSpacing()).append(", bitsAllocated=").append(getBitsAllocated()).append(", bitsStored=").append(getBitsStored()).append(", highBit=").append(getHighBit()).append(", pixelRepresentation=").append(getPixelRepresentation()).append(", windowCenter=").append(getWindowCenter()).append(", windowWidth=").append(getWindowWidth()).append(", rescaleIntercept=").append(getRescaleIntercept()).append(", rescaleSlope=").append(getRescaleSlope()).append(", rescaleType=").append(getRescaleType()).append(", path=").append(getPath()).append(")").toString();
    }

    private String sopInstanceUid;
    private String seriesInstanceUid;
    private String studyInstanceUid;
    private String stationName;
    private String kvp;
    private String exposureTime;
    private String tubeCurrent;
    private String ctdiVol;
    private String acquisitionDuration;
    private String diffusionBValue;
    private String imageType;
    private String contentDate;
    private String contentTime;
    private String instanceNumber;
    private String samplesPerPixel;
    private String photometricInterpretation;
    private String rows;
    private String columns;
    private String pixelSpacing;
    private String bitsAllocated;
    private String bitsStored;
    private String highBit;
    private String pixelRepresentation;
    private String windowCenter;
    private String windowWidth;
    private String rescaleIntercept;
    private String rescaleSlope;
    private String rescaleType;
    private String path;
}
