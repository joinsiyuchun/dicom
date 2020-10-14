
package com.yck12.dicom;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipRepository
    extends JpaRepository
{

    public abstract Equip getById(Long long1);

    public abstract Equip getByUid(String s);

    public abstract Equip findFirstByClientId(Long long1);

    public abstract Page list(Pageable pageable);

    public abstract Page listByName(String s, Pageable pageable);

    public abstract Page listByUid(String s, Pageable pageable);

    public abstract Page listByNameAndUid(String s, String s1, Pageable pageable);
}
