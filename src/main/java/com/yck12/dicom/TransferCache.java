// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TransferCache.java

package com.yck12.dicom;

import org.dcm4che3.net.Association;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TransferCache
{
    private static class TransferCacheInstance
    {

        private static final TransferCache instance = new TransferCache();



        private TransferCacheInstance()
        {
        }
    }


    private TransferCache()
    {
        studies = new HashMap();
        logger = LoggerFactory.getLogger(getClass());
    }

    public static TransferCache getInstance()
    {
        return TransferCacheInstance.instance;
    }

    public String getScuLink(Association association)
    {
        SocketAddress socketAddress = association.getSocket().getRemoteSocketAddress();
        InetSocketAddress inetSocketAddress = (InetSocketAddress)socketAddress;
        return (new StringBuilder()).append(association.getRemoteAET()).append("#").append(inetSocketAddress.getAddress().getHostAddress()).append("#").append(inetSocketAddress.getPort()).toString();
    }

    public void add(Association association, String studyInstanceUID)
    {
        String key = getScuLink(association);
        if(!studies.containsKey(key) || !((Set)studies.get(key)).contains(studyInstanceUID))
            synchronized(this)
            {
                if(!studies.containsKey(key))
                    studies.put(key, new HashSet());
                if(!((Set)studies.get(key)).contains(studyInstanceUID))
                {
                    ((Set)studies.get(key)).add(studyInstanceUID);
                    logger.info("add >>> scu:{}, study:{}", key, studyInstanceUID);
                }
            }
    }

    public Set get(String scu)
    {
        logger.info("get >>> key:{}, studies:{}", scu, Integer.valueOf(((Set)studies.get(scu)).size()));
        return (Set)studies.get(scu);
    }

    public int size()
    {
        return studies.size();
    }

    public void delete(String key)
    {
        if(studies.containsKey(key))
            synchronized(this)
            {
                if(studies.containsKey(key))
                {
                    logger.info("remove >>> scu:{}, studies:{}", key, Integer.valueOf(((Set)studies.get(key)).size()));
                    studies.remove(key);
                }
            }
    }


    private final Map studies;
    private Logger logger;
}
