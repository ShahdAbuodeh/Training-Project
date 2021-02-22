package com.springboot.trainingproject.trainingproject.USER;

import com.springboot.trainingproject.trainingproject.entity.Machine;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
public class User {

    @Id
    private int userId;

    @OneToMany(targetEntity = Machine.class, mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Machine> machines;

    public User() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines){
        this.machines = machines;
    }

}
