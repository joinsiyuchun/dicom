package com.yck12.dicom;

import lombok.Data;

import org.dcm4che3.data.Attributes;

@Data
public class DcmMetaData {

    public DcmMetaData(String filePath, Attributes meta, Attributes dataset) {
        this.filePath = filePath;
        this.meta = meta;
        this.dataset = dataset;
    }

    private String filePath;
    private Attributes meta;
    private Attributes dataset;
}