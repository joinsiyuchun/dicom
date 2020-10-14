// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Equip.java

package com.yck12.dicom;


// Referenced classes of package com.lifeccp.image.entity:
//            BaseEntity

public class Equip extends BaseEntity
{

    public Equip()
    {
    }

    public String getName()
    {
        return name;
    }

    public String getUid()
    {
        return uid;
    }

    public String getCode()
    {
        return code;
    }

    public String getSoubriquet()
    {
        return soubriquet;
    }

    public Long getClientId()
    {
        return clientId;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setUid(String uid)
    {
        this.uid = uid;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public void setSoubriquet(String soubriquet)
    {
        this.soubriquet = soubriquet;
    }

    public void setClientId(Long clientId)
    {
        this.clientId = clientId;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Equip(name=").append(getName()).append(", uid=").append(getUid()).append(", code=").append(getCode()).append(", soubriquet=").append(getSoubriquet()).append(", clientId=").append(getClientId()).append(")").toString();
    }

    public boolean equals(Object o)
    {
        if(o == this)
            return true;
        if(!(o instanceof Equip))
            return false;
        Equip other = (Equip)o;
        if(!other.canEqual(this))
            return false;
        if(!super.equals(o))
            return false;
        Object this$name = getName();
        Object other$name = other.getName();
        if(this$name != null ? !this$name.equals(other$name) : other$name != null)
            return false;
        Object this$uid = getUid();
        Object other$uid = other.getUid();
        if(this$uid != null ? !this$uid.equals(other$uid) : other$uid != null)
            return false;
        Object this$code = getCode();
        Object other$code = other.getCode();
        if(this$code != null ? !this$code.equals(other$code) : other$code != null)
            return false;
        Object this$soubriquet = getSoubriquet();
        Object other$soubriquet = other.getSoubriquet();
        if(this$soubriquet != null ? !this$soubriquet.equals(other$soubriquet) : other$soubriquet != null)
            return false;
        Object this$clientId = getClientId();
        Object other$clientId = other.getClientId();
        return this$clientId != null ? this$clientId.equals(other$clientId) : other$clientId == null;
    }

    protected boolean canEqual(Object other)
    {
        return other instanceof Equip;
    }

    public int hashCode()
    {
        int PRIME = 59;
        int result = super.hashCode();
        Object $name = getName();
        result = result * 59 + ($name != null ? $name.hashCode() : 43);
        Object $uid = getUid();
        result = result * 59 + ($uid != null ? $uid.hashCode() : 43);
        Object $code = getCode();
        result = result * 59 + ($code != null ? $code.hashCode() : 43);
        Object $soubriquet = getSoubriquet();
        result = result * 59 + ($soubriquet != null ? $soubriquet.hashCode() : 43);
        Object $clientId = getClientId();
        result = result * 59 + ($clientId != null ? $clientId.hashCode() : 43);
        return result;
    }

    private String name;
    private String uid;
    private String code;
    private String soubriquet;
    private Long clientId;
}
