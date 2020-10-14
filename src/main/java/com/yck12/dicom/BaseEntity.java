// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BaseEntity.java

package com.yck12.dicom;

import java.time.LocalDateTime;

public abstract class BaseEntity
{

    public BaseEntity()
    {
    }

    public Long getId()
    {
        return id;
    }

    public LocalDateTime getCreateTime()
    {
        return createTime;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setCreateTime(LocalDateTime createTime)
    {
        this.createTime = createTime;
    }

    private Long id;
    private LocalDateTime createTime;
}
