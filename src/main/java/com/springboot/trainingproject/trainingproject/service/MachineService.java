package com.springboot.trainingproject.trainingproject.service;

import com.springboot.trainingproject.trainingproject.USER.User;
import com.springboot.trainingproject.trainingproject.entity.Machine;
import com.springboot.trainingproject.trainingproject.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineService {


    @Autowired
    private MachineRepository repository;

    public Machine saveMachine(Machine machine, int userId) {

        User currentUser = new User();
        currentUser.setUserId(userId);
        machine.setUser(currentUser);
        machine.getUser().setMachines(null);

        Machine result= repository.save(machine);
        result.getUser().setMachines(null);
        return result;
    }


    public List<Machine> getMachines(int userId) {
        List<Machine> result = repository.findAll();
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).getUser().getUserId() != userId) {
                result.remove(i);
                i--;
            }
        }
        result.forEach(machine -> machine.getUser().setMachines(null));

        return result;
    }

    public Machine getMachineById(String id) {
        Machine result = repository.findById(id).orElse(null);
        result.getUser().setMachines(null);
        return result;
    }

    public String deleteMachine(int userId) {

        List<Machine> result = repository.findAll();
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).getUser().getUserId() == userId) {
                repository.delete(result.get(i));
            }
        }
        return "delete successfully.";
    }

    public Machine updateMachine(Machine machine, String id, int userId) {
        if (id != null) {
            Machine result = repository.findById(id).orElse(null);
            machine.setDeviceId(result.getDeviceId());
            if(result==null){
                return null;
            }
            if (userId == (result.getUser().getUserId())) {
                machine.setUser(result.getUser());
                result= repository.save(machine);
                result.getUser().setMachines(null);
                return result;
            } else {

                return null;
            }

        } else
            return null;
    }


}


