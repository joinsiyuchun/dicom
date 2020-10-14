// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TagParseResult.java

package com.yck12.dicom;

import com.yck12.dicom.gateway.*;

import java.util.Map;

public class TagParseResult
{

    public TagParseResult()
    {
    }

    public String getScuAet()
    {
        return scuAet;
    }

    public TagPatient getPatient()
    {
        return patient;
    }

    public TagStudy getStudy()
    {
        return study;
    }

    public TagSeries getSeries()
    {
        return series;
    }

    public TagImage getImage()
    {
        return image;
    }

    public Map getOthers()
    {
        return others;
    }

    public void setScuAet(String scuAet)
    {
        this.scuAet = scuAet;
    }

    public void setPatient(TagPatient patient)
    {
        this.patient = patient;
    }

    public void setStudy(TagStudy study)
    {
        this.study = study;
    }

    public void setSeries(TagSeries series)
    {
        this.series = series;
    }

    public void setImage(TagImage image)
    {
        this.image = image;
    }

    public void setOthers(Map others)
    {
        this.others = others;
    }

    public boolean equals(Object o)
    {
        if(o == this)
            return true;
        if(!(o instanceof TagParseResult))
            return false;
        TagParseResult other = (TagParseResult)o;
        if(!other.canEqual(this))
            return false;
        Object this$scuAet = getScuAet();
        Object other$scuAet = other.getScuAet();
        if(this$scuAet != null ? !this$scuAet.equals(other$scuAet) : other$scuAet != null)
            return false;
        Object this$patient = getPatient();
        Object other$patient = other.getPatient();
        if(this$patient != null ? !this$patient.equals(other$patient) : other$patient != null)
            return false;
        Object this$study = getStudy();
        Object other$study = other.getStudy();
        if(this$study != null ? !this$study.equals(other$study) : other$study != null)
            return false;
        Object this$series = getSeries();
        Object other$series = other.getSeries();
        if(this$series != null ? !this$series.equals(other$series) : other$series != null)
            return false;
        Object this$image = getImage();
        Object other$image = other.getImage();
        if(this$image != null ? !this$image.equals(other$image) : other$image != null)
            return false;
        Object this$others = getOthers();
        Object other$others = other.getOthers();
        return this$others != null ? this$others.equals(other$others) : other$others == null;
    }

    protected boolean canEqual(Object other)
    {
        return other instanceof TagParseResult;
    }

    public int hashCode()
    {
        int PRIME = 59;
        int result = 1;
        Object $scuAet = getScuAet();
        result = result * 59 + ($scuAet != null ? $scuAet.hashCode() : 43);
        Object $patient = getPatient();
        result = result * 59 + ($patient != null ? $patient.hashCode() : 43);
        Object $study = getStudy();
        result = result * 59 + ($study != null ? $study.hashCode() : 43);
        Object $series = getSeries();
        result = result * 59 + ($series != null ? $series.hashCode() : 43);
        Object $image = getImage();
        result = result * 59 + ($image != null ? $image.hashCode() : 43);
        Object $others = getOthers();
        result = result * 59 + ($others != null ? $others.hashCode() : 43);
        return result;
    }

    public String toString()
    {
        return (new StringBuilder()).append("TagParseResult(scuAet=").append(getScuAet()).append(", patient=").append(getPatient()).append(", study=").append(getStudy()).append(", series=").append(getSeries()).append(", image=").append(getImage()).append(", others=").append(getOthers()).append(")").toString();
    }

    private String scuAet;
    private TagPatient patient;
    private TagStudy study;
    private TagSeries series;
    private TagImage image;
    private Map others;
}
