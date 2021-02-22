package com.springboot.trainingproject.trainingproject.repository;

import com.springboot.trainingproject.trainingproject.entity.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineRepository extends JpaRepository<Machine, String> {

   // Machine findByName(String name);
}
