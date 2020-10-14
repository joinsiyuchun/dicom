package com.yck12.dicom;

import org.springframework.shell.standard.*;


@ShellComponent
public class DicomCommand {

    @ShellMethod("start")
    public void start() {
        new DicomReceiver().start();
    }
}
