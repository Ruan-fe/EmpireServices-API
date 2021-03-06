package com.empire.service.repository;


import com.empire.service.model.entity.ComputadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComputadorRepository extends JpaRepository<ComputadorEntity,Integer> {

 List<ComputadorEntity>findByLaboratorioId(Integer idLaboratorio);

}
