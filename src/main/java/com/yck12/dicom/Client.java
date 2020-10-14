// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Client.java

package com.yck12.dicom;


// Referenced classes of package com.lifeccp.image.entity:
//            BaseEntity

public class Client extends BaseEntity
{

    public Client()
    {
    }

    public String getAet()
    {
        return aet;
    }

    public String getHost()
    {
        return host;
    }

    public String getPort()
    {
        return port;
    }

    public void setAet(String aet)
    {
        this.aet = aet;
    }

    public void setHost(String host)
    {
        this.host = host;
    }

    public void setPort(String port)
    {
        this.port = port;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Client(aet=").append(getAet()).append(", host=").append(getHost()).append(", port=").append(getPort()).append(")").toString();
    }

    public boolean equals(Object o)
    {
        if(o == this)
            return true;
        if(!(o instanceof Client))
            return false;
        Client other = (Client)o;
        if(!other.canEqual(this))
            return false;
        if(!super.equals(o))
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
        return other instanceof Client;
    }

    public int hashCode()
    {
        int PRIME = 59;
        int result = super.hashCode();
        Object $aet = getAet();
        result = result * 59 + ($aet != null ? $aet.hashCode() : 43);
        Object $host = getHost();
        result = result * 59 + ($host != null ? $host.hashCode() : 43);
        Object $port = getPort();
        result = result * 59 + ($port != null ? $port.hashCode() : 43);
        return result;
    }

    private String aet;
    private String host;
    private String port;
}
