package com.springboot.trainingproject.trainingproject.entity;


import com.springboot.trainingproject.trainingproject.USER.User;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name="machine")
public class Machine {

    @Id
    @Column(name = "id", length = 50)
    private String deviceId;
    @Column(name="name")
    private String name;
    @Column(name="ip-address")
    private String ipAddress;
    @Column(name="location")
    private String location;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;


    public Machine() {

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        this.deviceId = "device_".concat(formatter.format(date));

    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String IPAddress) {
        this.ipAddress = IPAddress;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
