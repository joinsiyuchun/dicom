package com.yck12.dicom;
public class ReceivedEvent {

    private String studyInstanceUID;
    private String scuAet;
    private String equipId;
    public ReceivedEvent(String studyInstanceUID, String scuAet, String equipId) {
        this.studyInstanceUID = studyInstanceUID;
        this.scuAet = scuAet;
        this.equipId = equipId;
    }

    public String getStudyInstanceUID() {
        return this.studyInstanceUID;
    }

    public String getScuAet() {
        return this.scuAet;
    }

    public String getEquipId() {
        return this.equipId;
    }

    public void setStudyInstanceUID(String studyInstanceUID) {
        this.studyInstanceUID = studyInstanceUID;
    }

    public void setScuAet(String scuAet) {
        this.scuAet = scuAet;
    }

    public void setEquipId(String equipId) {
        this.equipId = equipId;
    }

    public boolean equals(Object o) {
        if(o == this) {
            return true;
        } else if(!(o instanceof ReceivedEvent)) {
            return false;
        } else {
            ReceivedEvent other = (ReceivedEvent)o;
            if(!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    String this$studyInstanceUID = this.getStudyInstanceUID();
                    String other$studyInstanceUID = other.getStudyInstanceUID();
                    if(this$studyInstanceUID == null) {
                        if(other$studyInstanceUID == null) {
                            break label47;
                        }
                    } else if(this$studyInstanceUID.equals(other$studyInstanceUID)) {
                        break label47;
                    }

                    return false;
                }

                String this$scuAet = this.getScuAet();
                String other$scuAet = other.getScuAet();
                if(this$scuAet == null) {
                    if(other$scuAet != null) {
                        return false;
                    }
                } else if(!this$scuAet.equals(other$scuAet)) {
                    return false;
                }

                String this$equipId = this.getEquipId();
                String other$equipId = other.getEquipId();
                if(this$equipId == null) {
                    if(other$equipId != null) {
                        return false;
                    }
                } else if(!this$equipId.equals(other$equipId)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof ReceivedEvent;
    }

    public int hashCode() {
        int PRIME = 59;
        byte result = 1;
        String $studyInstanceUID = this.getStudyInstanceUID();
        int result1 = result * PRIME + ($studyInstanceUID == null?43:$studyInstanceUID.hashCode());
        String $scuAet = this.getScuAet();
        result1 = result1 * PRIME + ($scuAet == null?43:$scuAet.hashCode());
        String $equipId = this.getEquipId();
        result1 = result1 * PRIME + ($equipId == null?43:$equipId.hashCode());
        return result1;
    }

    public String toString() {
        return "ReceivedEvent(studyInstanceUID=" + this.getStudyInstanceUID() + ", scuAet=" + this.getScuAet() + ", equipId=" + this.getEquipId() + ")";
    }


}