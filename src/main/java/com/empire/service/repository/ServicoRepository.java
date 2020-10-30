package com.empire.service.repository;

import com.empire.service.model.entity.ServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicoRepository extends JpaRepository<ServicoEntity, Integer> {
    List<ServicoEntity> findByStatusOrderByIdDesc(Character status);
}
