// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ToucanSetting.java

package com.yck12.dicom;


public class DicomSCPSetting
{
    public static class Modality
    {

        public String getIgnore()
        {
            return ignore;
        }

        public void setIgnore(String ignore)
        {
            this.ignore = ignore;
        }

        public boolean equals(Object o)
        {
            if(o == this)
                return true;
            if(!(o instanceof Modality))
                return false;
            Modality other = (Modality)o;
            if(!other.canEqual(this))
                return false;
            Object this$ignore = getIgnore();
            Object other$ignore = other.getIgnore();
            return this$ignore != null ? this$ignore.equals(other$ignore) : other$ignore == null;
        }

        protected boolean canEqual(Object other)
        {
            return other instanceof Modality;
        }

        public int hashCode()
        {
            int PRIME = 59;
            int result = 1;
            Object $ignore = getIgnore();
            result = result * 59 + ($ignore != null ? $ignore.hashCode() : 43);
            return result;
        }

        public String toString()
        {
            return (new StringBuilder()).append("ToucanSetting.Modality(ignore=").append(getIgnore()).append(")").toString();
        }

        private String ignore;

        public Modality()
        {
        }
    }

    public static class SCP
    {

        public String getAet()
        {
            return aet;
        }

        public Integer getPort()
        {
            return port;
        }

        public String getStorage()
        {
            return storage;
        }

        public String getCleanCron()
        {
            return cleanCron;
        }

        public int getKeepDays()
        {
            return keepDays;
        }

        public void setAet(String aet)
        {
            this.aet = aet;
        }

        public void setPort(Integer port)
        {
            this.port = port;
        }

        public void setStorage(String storage)
        {
            this.storage = storage;
        }

        public void setCleanCron(String cleanCron)
        {
            this.cleanCron = cleanCron;
        }

        public void setKeepDays(int keepDays)
        {
            this.keepDays = keepDays;
        }

        public boolean equals(Object o)
        {
            if(o == this)
                return true;
            if(!(o instanceof SCP))
                return false;
            SCP other = (SCP)o;
            if(!other.canEqual(this))
                return false;
            Object this$aet = getAet();
            Object other$aet = other.getAet();
            if(this$aet != null ? !this$aet.equals(other$aet) : other$aet != null)
                return false;
            Object this$port = getPort();
            Object other$port = other.getPort();
            if(this$port != null ? !this$port.equals(other$port) : other$port != null)
                return false;
            Object this$storage = getStorage();
            Object other$storage = other.getStorage();
            if(this$storage != null ? !this$storage.equals(other$storage) : other$storage != null)
                return false;
            Object this$cleanCron = getCleanCron();
            Object other$cleanCron = other.getCleanCron();
            if(this$cleanCron != null ? !this$cleanCron.equals(other$cleanCron) : other$cleanCron != null)
                return false;
            return getKeepDays() == other.getKeepDays();
        }

        protected boolean canEqual(Object other)
        {
            return other instanceof SCP;
        }

        public int hashCode()
        {
            int PRIME = 59;
            int result = 1;
            Object $aet = getAet();
            result = result * 59 + ($aet != null ? $aet.hashCode() : 43);
            Object $port = getPort();
            result = result * 59 + ($port != null ? $port.hashCode() : 43);
            Object $storage = getStorage();
            result = result * 59 + ($storage != null ? $storage.hashCode() : 43);
            Object $cleanCron = getCleanCron();
            result = result * 59 + ($cleanCron != null ? $cleanCron.hashCode() : 43);
            result = result * 59 + getKeepDays();
            return result;
        }

        public String toString()
        {
            return (new StringBuilder()).append("ToucanSetting.SCP(aet=").append(getAet()).append(", port=").append(getPort()).append(", storage=").append(getStorage()).append(", cleanCron=").append(getCleanCron()).append(", keepDays=").append(getKeepDays()).append(")").toString();
        }

        private String aet;
        private Integer port;
        private String storage;
        private String cleanCron;
        private int keepDays;

        public SCP()
        {
        }
    }

    public static class Gateway
    {

        public boolean isDebug()
        {
            return debug;
        }

        public String getUrl()
        {
            return url;
        }

        public void setDebug(boolean debug)
        {
            this.debug = debug;
        }

        public void setUrl(String url)
        {
            this.url = url;
        }

        public boolean equals(Object o)
        {
            if(o == this)
                return true;
            if(!(o instanceof Gateway))
                return false;
            Gateway other = (Gateway)o;
            if(!other.canEqual(this))
                return false;
            if(isDebug() != other.isDebug())
                return false;
            Object this$url = getUrl();
            Object other$url = other.getUrl();
            return this$url != null ? this$url.equals(other$url) : other$url == null;
        }

        protected boolean canEqual(Object other)
        {
            return other instanceof Gateway;
        }

        public int hashCode()
        {
            int PRIME = 59;
            int result = 1;
            result = result * 59 + (isDebug() ? 79 : 97);
            Object $url = getUrl();
            result = result * 59 + ($url != null ? $url.hashCode() : 43);
            return result;
        }

        public String toString()
        {
            return (new StringBuilder()).append("ToucanSetting.Gateway(debug=").append(isDebug()).append(", url=").append(getUrl()).append(")").toString();
        }

        private boolean debug;
        private String url;

        public Gateway()
        {
        }
    }


    public DicomSCPSetting()
    {
    }

    public Gateway getGateway()
    {
        return gateway;
    }

    public SCP getScp()
    {
        return scp;
    }

    public Modality getModality()
    {
        return modality;
    }

    public void setGateway(Gateway gateway)
    {
        this.gateway = gateway;
    }

    public void setScp(SCP scp)
    {
        this.scp = scp;
    }

    public void setModality(Modality modality)
    {
        this.modality = modality;
    }

    public boolean equals(Object o)
    {
        if(o == this)
            return true;
        if(!(o instanceof DicomSCPSetting))
            return false;
        DicomSCPSetting other = (DicomSCPSetting)o;
        if(!other.canEqual(this))
            return false;
        Object this$gateway = getGateway();
        Object other$gateway = other.getGateway();
        if(this$gateway != null ? !this$gateway.equals(other$gateway) : other$gateway != null)
            return false;
        Object this$scp = getScp();
        Object other$scp = other.getScp();
        if(this$scp != null ? !this$scp.equals(other$scp) : other$scp != null)
            return false;
        Object this$modality = getModality();
        Object other$modality = other.getModality();
        return this$modality != null ? this$modality.equals(other$modality) : other$modality == null;
    }

    protected boolean canEqual(Object other)
    {
        return other instanceof DicomSCPSetting;
    }

    public int hashCode()
    {
        int PRIME = 59;
        int result = 1;
        Object $gateway = getGateway();
        result = result * 59 + ($gateway != null ? $gateway.hashCode() : 43);
        Object $scp = getScp();
        result = result * 59 + ($scp != null ? $scp.hashCode() : 43);
        Object $modality = getModality();
        result = result * 59 + ($modality != null ? $modality.hashCode() : 43);
        return result;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ToucanSetting(gateway=").append(getGateway()).append(", scp=").append(getScp()).append(", modality=").append(getModality()).append(")").toString();
    }

    public Gateway gateway;
    public SCP scp;
    public Modality modality;
}
