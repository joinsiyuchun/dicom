// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ScuProfile.java

package com.yck12.dicom;


public class ScuProfile
{
    public ScuProfile(String aet, String host, String port)
    {
        this.aet = aet;
        this.host = host;
        this.port = port;
    }

    public String aet;

    public String getAet() {
        return aet;
    }

    public void setAet(String aet) {
        this.aet = aet;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String host;
    public String port;

    public boolean equals(Object o)
    {
        if(o == this)
            return true;
        if(!(o instanceof ScuProfile))
            return false;
        ScuProfile other = (ScuProfile)o;
        if(!other.canEqual(this))
            return false;
        Object this$aet = getAet();
        Object other$aet = other.getAet();
        if(this$aet != null ? !this$aet.equals(other$aet) : other$aet != null)
            return false;
        Object this$host = getHost();
        Object other$host = other.getHost();
        if(this$host != null ? !this$host.equals(other$host) : other$host != null)
            return false;
        Object this$port = getPort();
        Object other$port = other.getPort();
        return this$port != null ? this$port.equals(other$port) : other$port == null;
    }

    protected boolean canEqual(Object other)
    {
        return other instanceof ScuProfile;
    }

    public int hashCode()
    {
        int PRIME = 59;
        int result = 1;
        Object $aet = getAet();
        result = result * PRIME + ($aet != null ? $aet.hashCode() : 43);
        Object $host = getHost();
        result = result * PRIME + ($host != null ? $host.hashCode() : 43);
        Object $port = getPort();
        result = result * PRIME + ($port != null ? $port.hashCode() : 43);
        return result;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ScuProfile(aet=").append(getAet()).append(", host=").append(getHost()).append(", port=").append(getPort()).append(")").toString();
    }


}
