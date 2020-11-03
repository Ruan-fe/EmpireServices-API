package com.empire.service.repository;

import com.empire.service.model.entity.ServicoConcluidoEntity;
import com.empire.service.model.entity.ServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServicoConcluidoRepository extends JpaRepository<ServicoEntity,Integer> {

    Long countByStatus(Character status);
}
