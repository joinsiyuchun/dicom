package com.yck12.dicom;

import com.yck12.dicom.ReceivedEvent;
import com.yck12.dicom.ScuProfile;
import com.yck12.dicom.Client;
import com.yck12.dicom.Equip;
import com.yck12.dicom.ClientRepository;
import com.yck12.dicom.EquipRepository;
import com.yck12.dicom.MainService;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class AssociationService {

    private static final Logger log = LoggerFactory.getLogger(AssociationService.class);
    private final ExecutorService executorService;
    private final ClientRepository clientRepository;
    private final EquipRepository equipRepository;
    private final MainService mainService;


    @Autowired
    public AssociationService(ExecutorService executorService, ClientRepository clientRepository, EquipRepository equipRepository, MainService mainService) {
        this.executorService = executorService;
        this.clientRepository = clientRepository;
        this.equipRepository = equipRepository;
        this.mainService = mainService;
    }

    public void handleRelease(ScuProfile scuProfile, Set studies) {
        Client classUser = this.saveScu(scuProfile);
        Equip equip = this.equipRepository.findFirstByClientId(classUser.getId());
        String equipId = ObjectUtils.isEmpty(equip)?null:equip.getUid();
        log.info("Association >>> receive {} studies from [AeTitle:{}, host:{}]", new Object[]{Integer.valueOf(studies.size()), classUser.getAet(), classUser.getHost()});
        Iterator var6 = studies.iterator();

        while(var6.hasNext()) {
            String studyInstanceUID = (String)var6.next();
            this.executorService.execute(() -> {
                this.mainService.start(new ReceivedEvent(studyInstanceUID, classUser.getAet(), equipId));
            });
        }

    }

    private Client saveScu(ScuProfile scuProfile) {
        Client client = this.clientRepository.getByAet(scuProfile.getAet());
        if(ObjectUtils.isEmpty(client)) {
            client = new Client();
            BeanUtils.copyProperties(scuProfile, client);
            client.setCreateTime(LocalDateTime.now());
            this.clientRepository.save(client);
            log.info("SCU >>> save! aet:{}, host:{}, port:{}", new Object[]{client.getAet(), client.getHost(), client.getPort()});
        }

        return client;
    }

}