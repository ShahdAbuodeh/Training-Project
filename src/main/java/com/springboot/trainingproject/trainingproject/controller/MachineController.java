package com.springboot.trainingproject.trainingproject.controller;

import com.springboot.trainingproject.trainingproject.USER.User;
import com.springboot.trainingproject.trainingproject.entity.Machine;
import com.springboot.trainingproject.trainingproject.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MachineController {
    public static final String URL="/tenant/{userId}/machine/device";

    @Autowired
    private MachineService service;

    @PostMapping(URL)
    public Machine addMachine(@RequestBody Machine machine,@PathVariable int userId) {
        return service.saveMachine(machine,userId);
    }


    @GetMapping(URL)
    public List<Machine> findAllMachines(@PathVariable int userId) {
        return service.getMachines(userId);
    }

    @GetMapping(URL+"/{id}")
    public Machine findMachineById(@PathVariable String id) {
        return service.getMachineById(id);
    }

    @PutMapping(URL+"/{id}")
    public Machine updateMachine(@RequestBody Machine machine, @PathVariable String id ,@PathVariable int userId) {
        return service.updateMachine(machine ,id, userId);
    }

    @DeleteMapping(URL)
    public String deleteMachine(@PathVariable int userId) {
        return service.deleteMachine(userId);
    }
}

