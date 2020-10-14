package com.yck12.dicom;

import lombok.Data;

@Data
public class DcmUID {

    public DcmUID(String studyInstanceUID, String seriesInstanceUID, String sopInstanceUID) {
        this.studyInstanceUID = studyInstanceUID;
        this.seriesInstanceUID = seriesInstanceUID;
        this.sopInstanceUID = sopInstanceUID;
    }

    private String studyInstanceUID;

    public String getStudyInstanceUID() {
        return studyInstanceUID;
    }

    public void setStudyInstanceUID(String studyInstanceUID) {
        this.studyInstanceUID = studyInstanceUID;
    }

    public String getSeriesInstanceUID() {
        return seriesInstanceUID;
    }

    public void setSeriesInstanceUID(String seriesInstanceUID) {
        this.seriesInstanceUID = seriesInstanceUID;
    }

    public String getSopInstanceUID() {
        return sopInstanceUID;
    }

    public void setSopInstanceUID(String sopInstanceUID) {
        this.sopInstanceUID = sopInstanceUID;
    }

    private String seriesInstanceUID;
    private String sopInstanceUID;
}