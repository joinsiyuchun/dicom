package com.yck12.dicom;

import org.dcm4che3.net.Association;
import org.dcm4che3.net.AssociationHandler;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

public class CustomAssociationRelease extends AssociationHandler {

    public static CustomAssociationRelease getInstance() {
        return CustomAssociationRelease.CustomAssociationReleaseInstance.customAssociationService;
    }

    private static class CustomAssociationReleaseInstance {
        private static final CustomAssociationRelease customAssociationService = new CustomAssociationRelease();

        private CustomAssociationReleaseInstance() {
        }
    }

    @Override
    protected void onClose(Association as) {

        super.onClose(as);
        TransferCache transferCache = TransferCache.getInstance();
        String key = transferCache.getScuLink(as);
        Set studies = (Set) Optional.ofNullable(transferCache.get(key)).orElse(Collections.emptySet());
        ScuProfile scuProfile = this.parseScu(key);
        handleRelease(scuProfile, studies);
        transferCache.delete(key);
    }

    private ScuProfile parseScu(String scuStr) {
        String[] array = scuStr.split("#");
        return new ScuProfile(array[0], array[1], array[2]);
    }


}
