package com.yck12.dicom;

import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import lombok.extern.slf4j.Slf4j;
import org.dcm4che3.net.ApplicationEntity;
import org.dcm4che3.net.Connection;
import org.dcm4che3.net.Device;
import org.dcm4che3.net.TransferCapability;
import org.dcm4che3.net.TransferCapability.Role;
import org.dcm4che3.net.service.BasicCEchoSCP;
import org.dcm4che3.net.service.DicomServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class DicomReceiver {
    private final Connection conn = new Connection();
    private final Device device = new Device("STORE-SCP");
    private final ApplicationEntity ae = new ApplicationEntity("*");
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void start() {
        try {
            //SCP server listening port/AET,in SCU side configuration includes server ip/port/aet
            this.conn.setPort(5090);
            this.ae.setAETitle("MEDATC");
            //DICOM Upper layer Service:PDU(Protocol Data Unit) for different connection status
            //DICOM Application message Exchange:DIMSE（DICOM Message Service Element）
            //RQ:request question 连接打开后的会话请求
            //为SCP设置会话处理的服务程序（dimse层），将.dcm文件持久化到硬盘
            this.device.setDimseRQHandler(this.createServiceRegistry("/Users/tiger/Downloads"));
            //为服务端设置连接的网络端口/AE
            this.device.addConnection(this.conn);
            this.device.addApplicationEntity(this.ae);
            //为服务端设置连接处理程序(PDU层)，区分不同的SCU的数据来源，并将.dcm文件解析并且发送给http网关
            this.device.setAssociationHandler(CustomAssociationRelease.getInstance());
            //为SCP的这个AE设置网络连接
            this.ae.setAssociationAcceptor(true);
            this.ae.addConnection(this.conn);
            //根据PDU协议配置网络层（DICOM Upper layer Service）的参数，连接超时等等
            this.configureServer();
            //sop-classes.properties中配置的网络参数
            this.configureTransferCapability();
            //使用java并发机制绑定监听端口，建立单线程线程池，周期调度线程池
            ExecutorService executorService = Executors.newCachedThreadPool((new ThreadFactoryBuilder()).setNameFormat("SCP-%d").setDaemon(true).build());
            ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor((new ThreadFactoryBuilder()).setNameFormat("Association-%d").setDaemon(true).build());
            this.device.setScheduledExecutor(scheduledExecutorService);
            this.device.setExecutor(executorService);
            this.device.bindConnections();
        } catch (Exception e) {
            this.logger.error("dcm scp: " + e.getMessage(), e);
            System.exit(2);
        }

    }

    private DicomServiceRegistry createServiceRegistry(String storageDir) {
        DicomServiceRegistry serviceRegistry = new DicomServiceRegistry();
        serviceRegistry.addDicomService(new BasicCEchoSCP());
        serviceRegistry.addDicomService(new CustomStoreScp(storageDir));
        return serviceRegistry;
    }

    private void configureServer() {
        this.conn.setReceivePDULength(16378);
        this.conn.setSendPDULength(16378);
        this.conn.setMaxOpsInvoked(0);
        this.conn.setMaxOpsPerformed(0);
        this.conn.setPackPDV(true);
        this.conn.setConnectTimeout(0);
        this.conn.setRequestTimeout(0);
        this.conn.setAcceptTimeout(0);
        this.conn.setReleaseTimeout(0);
        this.conn.setResponseTimeout(0);
        this.conn.setRetrieveTimeout(0);
        this.conn.setIdleTimeout(0);
        this.conn.setSocketCloseDelay(50);
        this.conn.setSendBufferSize(0);
        this.conn.setReceiveBufferSize(0);
        this.conn.setTcpNoDelay(true);
    }

    private void configureTransferCapability() {
        Properties prop = FileUtils.loadProperties("resource:sop-classes.properties");
        Iterator props = prop.stringPropertyNames().iterator();

        while (props.hasNext()) {
            String cuid = (String) props.next();
            String ts = prop.getProperty(cuid);
            TransferCapability tc = new TransferCapability((String) null, DicomUtil.toUID(cuid), Role.SCP, DicomUtil.toUIDs(ts));
            this.ae.addTransferCapability(tc);
        }

    }
}