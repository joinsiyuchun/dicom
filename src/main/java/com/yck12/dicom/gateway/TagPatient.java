// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TagPatient.java

package com.yck12.dicom.gateway;


public class TagPatient
{

    public TagPatient()
    {
    }

    public String getPatientId()
    {
        return patientId;
    }

    public String getPatientName()
    {
        return patientName;
    }

    public String getPatientBirthDate()
    {
        return patientBirthDate;
    }

    public String getPatientBirthTime()
    {
        return patientBirthTime;
    }

    public String getPatientSex()
    {
        return patientSex;
    }

    public String getPatientAge()
    {
        return patientAge;
    }

    public String getPatientSize()
    {
        return patientSize;
    }

    public String getPatientWeight()
    {
        return patientWeight;
    }

    public String getPatientAddress()
    {
        return patientAddress;
    }

    public String getIssuerOfPatientId()
    {
        return issuerOfPatientId;
    }

    public String getTypeOfPatientId()
    {
        return typeOfPatientId;
    }

    public String getPatientBirthName()
    {
        return patientBirthName;
    }

    public String getMotherBirthName()
    {
        return motherBirthName;
    }

    public String getPregnancyStatus()
    {
        return pregnancyStatus;
    }

    public String getPath()
    {
        return path;
    }

    public void setPatientId(String patientId)
    {
        this.patientId = patientId;
    }

    public void setPatientName(String patientName)
    {
        this.patientName = patientName;
    }

    public void setPatientBirthDate(String patientBirthDate)
    {
        this.patientBirthDate = patientBirthDate;
    }

    public void setPatientBirthTime(String patientBirthTime)
    {
        this.patientBirthTime = patientBirthTime;
    }

    public void setPatientSex(String patientSex)
    {
        this.patientSex = patientSex;
    }

    public void setPatientAge(String patientAge)
    {
        this.patientAge = patientAge;
    }

    public void setPatientSize(String patientSize)
    {
        this.patientSize = patientSize;
    }

    public void setPatientWeight(String patientWeight)
    {
        this.patientWeight = patientWeight;
    }

    public void setPatientAddress(String patientAddress)
    {
        this.patientAddress = patientAddress;
    }

    public void setIssuerOfPatientId(String issuerOfPatientId)
    {
        this.issuerOfPatientId = issuerOfPatientId;
    }

    public void setTypeOfPatientId(String typeOfPatientId)
    {
        this.typeOfPatientId = typeOfPatientId;
    }

    public void setPatientBirthName(String patientBirthName)
    {
        this.patientBirthName = patientBirthName;
    }

    public void setMotherBirthName(String motherBirthName)
    {
        this.motherBirthName = motherBirthName;
    }

    public void setPregnancyStatus(String pregnancyStatus)
    {
        this.pregnancyStatus = pregnancyStatus;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public boolean equals(Object o)
    {
        if(o == this)
            return true;
        if(!(o instanceof TagPatient))
            return false;
        TagPatient other = (TagPatient)o;
        if(!other.canEqual(this))
            return false;
        Object this$patientId = getPatientId();
        Object other$patientId = other.getPatientId();
        if(this$patientId != null ? !this$patientId.equals(other$patientId) : other$patientId != null)
            return false;
        Object this$patientName = getPatientName();
        Object other$patientName = other.getPatientName();
        if(this$patientName != null ? !this$patientName.equals(other$patientName) : other$patientName != null)
            return false;
        Object this$patientBirthDate = getPatientBirthDate();
        Object other$patientBirthDate = other.getPatientBirthDate();
        if(this$patientBirthDate != null ? !this$patientBirthDate.equals(other$patientBirthDate) : other$patientBirthDate != null)
            return false;
        Object this$patientBirthTime = getPatientBirthTime();
        Object other$patientBirthTime = other.getPatientBirthTime();
        if(this$patientBirthTime != null ? !this$patientBirthTime.equals(other$patientBirthTime) : other$patientBirthTime != null)
            return false;
        Object this$patientSex = getPatientSex();
        Object other$patientSex = other.getPatientSex();
        if(this$patientSex != null ? !this$patientSex.equals(other$patientSex) : other$patientSex != null)
            return false;
        Object this$patientAge = getPatientAge();
        Object other$patientAge = other.getPatientAge();
        if(this$patientAge != null ? !this$patientAge.equals(other$patientAge) : other$patientAge != null)
            return false;
        Object this$patientSize = getPatientSize();
        Object other$patientSize = other.getPatientSize();
        if(this$patientSize != null ? !this$patientSize.equals(other$patientSize) : other$patientSize != null)
            return false;
        Object this$patientWeight = getPatientWeight();
        Object other$patientWeight = other.getPatientWeight();
        if(this$patientWeight != null ? !this$patientWeight.equals(other$patientWeight) : other$patientWeight != null)
            return false;
        Object this$patientAddress = getPatientAddress();
        Object other$patientAddress = other.getPatientAddress();
        if(this$patientAddress != null ? !this$patientAddress.equals(other$patientAddress) : other$patientAddress != null)
            return false;
        Object this$issuerOfPatientId = getIssuerOfPatientId();
        Object other$issuerOfPatientId = other.getIssuerOfPatientId();
        if(this$issuerOfPatientId != null ? !this$issuerOfPatientId.equals(other$issuerOfPatientId) : other$issuerOfPatientId != null)
            return false;
        Object this$typeOfPatientId = getTypeOfPatientId();
        Object other$typeOfPatientId = other.getTypeOfPatientId();
        if(this$typeOfPatientId != null ? !this$typeOfPatientId.equals(other$typeOfPatientId) : other$typeOfPatientId != null)
            return false;
        Object this$patientBirthName = getPatientBirthName();
        Object other$patientBirthName = other.getPatientBirthName();
        if(this$patientBirthName != null ? !this$patientBirthName.equals(other$patientBirthName) : other$patientBirthName != null)
            return false;
        Object this$motherBirthName = getMotherBirthName();
        Object other$motherBirthName = other.getMotherBirthName();
        if(this$motherBirthName != null ? !this$motherBirthName.equals(other$motherBirthName) : other$motherBirthName != null)
            return false;
        Object this$pregnancyStatus = getPregnancyStatus();
        Object other$pregnancyStatus = other.getPregnancyStatus();
        if(this$pregnancyStatus != null ? !this$pregnancyStatus.equals(other$pregnancyStatus) : other$pregnancyStatus != null)
            return false;
        Object this$path = getPath();
        Object other$path = other.getPath();
        return this$path != null ? this$path.equals(other$path) : other$path == null;
    }

    protected boolean canEqual(Object other)
    {
        return other instanceof TagPatient;
    }

    public int hashCode()
    {
        int PRIME = 59;
        int result = 1;
        Object $patientId = getPatientId();
        result = result * 59 + ($patientId != null ? $patientId.hashCode() : 43);
        Object $patientName = getPatientName();
        result = result * 59 + ($patientName != null ? $patientName.hashCode() : 43);
        Object $patientBirthDate = getPatientBirthDate();
        result = result * 59 + ($patientBirthDate != null ? $patientBirthDate.hashCode() : 43);
        Object $patientBirthTime = getPatientBirthTime();
        result = result * 59 + ($patientBirthTime != null ? $patientBirthTime.hashCode() : 43);
        Object $patientSex = getPatientSex();
        result = result * 59 + ($patientSex != null ? $patientSex.hashCode() : 43);
        Object $patientAge = getPatientAge();
        result = result * 59 + ($patientAge != null ? $patientAge.hashCode() : 43);
        Object $patientSize = getPatientSize();
        result = result * 59 + ($patientSize != null ? $patientSize.hashCode() : 43);
        Object $patientWeight = getPatientWeight();
        result = result * 59 + ($patientWeight != null ? $patientWeight.hashCode() : 43);
        Object $patientAddress = getPatientAddress();
        result = result * 59 + ($patientAddress != null ? $patientAddress.hashCode() : 43);
        Object $issuerOfPatientId = getIssuerOfPatientId();
        result = result * 59 + ($issuerOfPatientId != null ? $issuerOfPatientId.hashCode() : 43);
        Object $typeOfPatientId = getTypeOfPatientId();
        result = result * 59 + ($typeOfPatientId != null ? $typeOfPatientId.hashCode() : 43);
        Object $patientBirthName = getPatientBirthName();
        result = result * 59 + ($patientBirthName != null ? $patientBirthName.hashCode() : 43);
        Object $motherBirthName = getMotherBirthName();
        result = result * 59 + ($motherBirthName != null ? $motherBirthName.hashCode() : 43);
        Object $pregnancyStatus = getPregnancyStatus();
        result = result * 59 + ($pregnancyStatus != null ? $pregnancyStatus.hashCode() : 43);
        Object $path = getPath();
        result = result * 59 + ($path != null ? $path.hashCode() : 43);
        return result;
    }

    public String toString()
    {
        return (new StringBuilder()).append("TagPatient(patientId=").append(getPatientId()).append(", patientName=").append(getPatientName()).append(", patientBirthDate=").append(getPatientBirthDate()).append(", patientBirthTime=").append(getPatientBirthTime()).append(", patientSex=").append(getPatientSex()).append(", patientAge=").append(getPatientAge()).append(", patientSize=").append(getPatientSize()).append(", patientWeight=").append(getPatientWeight()).append(", patientAddress=").append(getPatientAddress()).append(", issuerOfPatientId=").append(getIssuerOfPatientId()).append(", typeOfPatientId=").append(getTypeOfPatientId()).append(", patientBirthName=").append(getPatientBirthName()).append(", motherBirthName=").append(getMotherBirthName()).append(", pregnancyStatus=").append(getPregnancyStatus()).append(", path=").append(getPath()).append(")").toString();
    }

    private String patientId;
    private String patientName;
    private String patientBirthDate;
    private String patientBirthTime;
    private String patientSex;
    private String patientAge;
    private String patientSize;
    private String patientWeight;
    private String patientAddress;
    private String issuerOfPatientId;
    private String typeOfPatientId;
    private String patientBirthName;
    private String motherBirthName;
    private String pregnancyStatus;
    private String path;
}
