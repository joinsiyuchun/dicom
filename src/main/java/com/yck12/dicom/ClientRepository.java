// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ClientRepository.java

package com.yck12.dicom;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository
    extends JpaRepository
{

    public abstract Client getById(Long long1);

    public abstract Client getByAet(String s);

    public abstract Page findByAetLike(String s, Pageable pageable);

    public abstract List findAvailable();
}
