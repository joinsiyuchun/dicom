// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TagStudy.java

package com.yck12.dicom.gateway;


public class TagStudy
{

    public TagStudy()
    {
    }

    public String getStudyInstanceUid()
    {
        return studyInstanceUid;
    }

    public String getStudyId()
    {
        return studyId;
    }

    public String getPatientId()
    {
        return patientId;
    }

    public String getDeviceId()
    {
        return deviceId;
    }

    public String getStudyDate()
    {
        return studyDate;
    }

    public String getStudyTime()
    {
        return studyTime;
    }

    public String getStudyDescription()
    {
        return studyDescription;
    }

    public String getModalitiesInStudy()
    {
        return modalitiesInStudy;
    }

    public String getAccessionNumber()
    {
        return accessionNumber;
    }

    public String getBodyPartExamined()
    {
        return bodyPartExamined;
    }

    public String getRequestedProcedureDescription()
    {
        return requestedProcedureDescription;
    }

    public String getPath()
    {
        return path;
    }

    public void setStudyInstanceUid(String studyInstanceUid)
    {
        this.studyInstanceUid = studyInstanceUid;
    }

    public void setStudyId(String studyId)
    {
        this.studyId = studyId;
    }

    public void setPatientId(String patientId)
    {
        this.patientId = patientId;
    }

    public void setDeviceId(String deviceId)
    {
        this.deviceId = deviceId;
    }

    public void setStudyDate(String studyDate)
    {
        this.studyDate = studyDate;
    }

    public void setStudyTime(String studyTime)
    {
        this.studyTime = studyTime;
    }

    public void setStudyDescription(String studyDescription)
    {
        this.studyDescription = studyDescription;
    }

    public void setModalitiesInStudy(String modalitiesInStudy)
    {
        this.modalitiesInStudy = modalitiesInStudy;
    }

    public void setAccessionNumber(String accessionNumber)
    {
        this.accessionNumber = accessionNumber;
    }

    public void setBodyPartExamined(String bodyPartExamined)
    {
        this.bodyPartExamined = bodyPartExamined;
    }

    public void setRequestedProcedureDescription(String requestedProcedureDescription)
    {
        this.requestedProcedureDescription = requestedProcedureDescription;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public boolean equals(Object o)
    {
        if(o == this)
            return true;
        if(!(o instanceof TagStudy))
            return false;
        TagStudy other = (TagStudy)o;
        if(!other.canEqual(this))
            return false;
        Object this$studyInstanceUid = getStudyInstanceUid();
        Object other$studyInstanceUid = other.getStudyInstanceUid();
        if(this$studyInstanceUid != null ? !this$studyInstanceUid.equals(other$studyInstanceUid) : other$studyInstanceUid != null)
            return false;
        Object this$studyId = getStudyId();
        Object other$studyId = other.getStudyId();
        if(this$studyId != null ? !this$studyId.equals(other$studyId) : other$studyId != null)
            return false;
        Object this$patientId = getPatientId();
        Object other$patientId = other.getPatientId();
        if(this$patientId != null ? !this$patientId.equals(other$patientId) : other$patientId != null)
            return false;
        Object this$deviceId = getDeviceId();
        Object other$deviceId = other.getDeviceId();
        if(this$deviceId != null ? !this$deviceId.equals(other$deviceId) : other$deviceId != null)
            return false;
        Object this$studyDate = getStudyDate();
        Object other$studyDate = other.getStudyDate();
        if(this$studyDate != null ? !this$studyDate.equals(other$studyDate) : other$studyDate != null)
            return false;
        Object this$studyTime = getStudyTime();
        Object other$studyTime = other.getStudyTime();
        if(this$studyTime != null ? !this$studyTime.equals(other$studyTime) : other$studyTime != null)
            return false;
        Object this$studyDescription = getStudyDescription();
        Object other$studyDescription = other.getStudyDescription();
        if(this$studyDescription != null ? !this$studyDescription.equals(other$studyDescription) : other$studyDescription != null)
            return false;
        Object this$modalitiesInStudy = getModalitiesInStudy();
        Object other$modalitiesInStudy = other.getModalitiesInStudy();
        if(this$modalitiesInStudy != null ? !this$modalitiesInStudy.equals(other$modalitiesInStudy) : other$modalitiesInStudy != null)
            return false;
        Object this$accessionNumber = getAccessionNumber();
        Object other$accessionNumber = other.getAccessionNumber();
        if(this$accessionNumber != null ? !this$accessionNumber.equals(other$accessionNumber) : other$accessionNumber != null)
            return false;
        Object this$bodyPartExamined = getBodyPartExamined();
        Object other$bodyPartExamined = other.getBodyPartExamined();
        if(this$bodyPartExamined != null ? !this$bodyPartExamined.equals(other$bodyPartExamined) : other$bodyPartExamined != null)
            return false;
        Object this$requestedProcedureDescription = getRequestedProcedureDescription();
        Object other$requestedProcedureDescription = other.getRequestedProcedureDescription();
        if(this$requestedProcedureDescription != null ? !this$requestedProcedureDescription.equals(other$requestedProcedureDescription) : other$requestedProcedureDescription != null)
            return false;
        Object this$path = getPath();
        Object other$path = other.getPath();
        return this$path != null ? this$path.equals(other$path) : other$path == null;
    }

    protected boolean canEqual(Object other)
    {
        return other instanceof TagStudy;
    }

    public int hashCode()
    {
        int PRIME = 59;
        int result = 1;
        Object $studyInstanceUid = getStudyInstanceUid();
        result = result * 59 + ($studyInstanceUid != null ? $studyInstanceUid.hashCode() : 43);
        Object $studyId = getStudyId();
        result = result * 59 + ($studyId != null ? $studyId.hashCode() : 43);
        Object $patientId = getPatientId();
        result = result * 59 + ($patientId != null ? $patientId.hashCode() : 43);
        Object $deviceId = getDeviceId();
        result = result * 59 + ($deviceId != null ? $deviceId.hashCode() : 43);
        Object $studyDate = getStudyDate();
        result = result * 59 + ($studyDate != null ? $studyDate.hashCode() : 43);
        Object $studyTime = getStudyTime();
        result = result * 59 + ($studyTime != null ? $studyTime.hashCode() : 43);
        Object $studyDescription = getStudyDescription();
        result = result * 59 + ($studyDescription != null ? $studyDescription.hashCode() : 43);
        Object $modalitiesInStudy = getModalitiesInStudy();
        result = result * 59 + ($modalitiesInStudy != null ? $modalitiesInStudy.hashCode() : 43);
        Object $accessionNumber = getAccessionNumber();
        result = result * 59 + ($accessionNumber != null ? $accessionNumber.hashCode() : 43);
        Object $bodyPartExamined = getBodyPartExamined();
        result = result * 59 + ($bodyPartExamined != null ? $bodyPartExamined.hashCode() : 43);
        Object $requestedProcedureDescription = getRequestedProcedureDescription();
        result = result * 59 + ($requestedProcedureDescription != null ? $requestedProcedureDescription.hashCode() : 43);
        Object $path = getPath();
        result = result * 59 + ($path != null ? $path.hashCode() : 43);
        return result;
    }

    public String toString()
    {
        return (new StringBuilder()).append("TagStudy(studyInstanceUid=").append(getStudyInstanceUid()).append(", studyId=").append(getStudyId()).append(", patientId=").append(getPatientId()).append(", deviceId=").append(getDeviceId()).append(", studyDate=").append(getStudyDate()).append(", studyTime=").append(getStudyTime()).append(", studyDescription=").append(getStudyDescription()).append(", modalitiesInStudy=").append(getModalitiesInStudy()).append(", accessionNumber=").append(getAccessionNumber()).append(", bodyPartExamined=").append(getBodyPartExamined()).append(", requestedProcedureDescription=").append(getRequestedProcedureDescription()).append(", path=").append(getPath()).append(")").toString();
    }

    private String studyInstanceUid;
    private String studyId;
    private String patientId;
    private String deviceId;
    private String studyDate;
    private String studyTime;
    private String studyDescription;
    private String modalitiesInStudy;
    private String accessionNumber;
    private String bodyPartExamined;
    private String requestedProcedureDescription;
    private String path;
}
