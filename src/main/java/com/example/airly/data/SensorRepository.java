package com.example.airly.data;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class SensorRepository {
    private final Map<Long, Sensor> map;

    public SensorRepository() {
        this.map = new HashMap<>();
    }

    public long addSensor(SensorDTO sensorDTO) {
        if (sensorDTO.getAddress() == null || sensorDTO.getAddress().equals("")) {
            return -1;
        }
        if (sensorDTO.getOwner() == null || sensorDTO.getOwner().equals("")) {
            return -1;
        }
        long id = new Date().getTime();
        Sensor sensor = new Sensor(id, sensorDTO.getAddress(), sensorDTO.getOwner());
        this.map.put(id, sensor);
        return id;
    }

    public List<Sensor> getAllSensors() {
        List<Sensor> list = new ArrayList<>();
        for (long key : this.map.keySet()) {
            list.add(this.map.get(key));
        }
        return list;
    }

    public Sensor getSensor(long id) {
        return map.get(id);
    }

    public boolean deleteSensor(long id) {
        Sensor sensor = map.remove(id);
        return sensor != null;
    }

    public boolean editSensor(Sensor sensor) {
        if (!this.map.containsKey(sensor.getId())) {
            return false;
        } else {
            this.map.put(sensor.getId(), sensor);
            return true;
        }
    }
}
