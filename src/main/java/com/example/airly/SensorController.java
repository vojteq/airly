package com.example.airly;

import com.example.airly.data.Sensor;
import com.example.airly.data.SensorDTO;
import com.example.airly.data.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airly")
public class SensorController {

    private final SensorRepository repository;

    @Autowired
    public SensorController(SensorRepository repository) {
        this.repository = repository;
    }

    @PutMapping(
            value = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> addSensor(@RequestBody SensorDTO sensorDTO) {
        long id = repository.addSensor(sensorDTO);
        if (id != -1) {
            return ResponseEntity.status(200).body("sensor added successfully with id: " + id);
        } else {
            return ResponseEntity.status(400).body("sensor does not have required fields");
        }
    }

    @GetMapping(value = "/get_all")
    public ResponseEntity<List<Sensor>> getAllSensors() {
        return ResponseEntity.status(200).body(repository.getAllSensors());
    }

    @GetMapping(value = "/get_one")
    public ResponseEntity getSensor(@RequestParam("sensor_id") long sensorId) {
        Sensor sensor = repository.getSensor(sensorId);
        if (sensor ==  null) {
            return ResponseEntity.status(400).body("no sensor with such id");
        } else {
            return ResponseEntity.status(200).body(sensor);
        }
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> deleteSensor(@RequestParam("sensor_id") long sensorId) {
        if (repository.deleteSensor(sensorId)) {
            return ResponseEntity.status(200).body("sensor deleted successfully");
        } else {
            return ResponseEntity.status(400).body("no sensor with such id");
        }
    }

    @PostMapping(
            value = "/edit",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> editSensor(@RequestBody Sensor sensor) {
        if (repository.editSensor(sensor)) {
            return ResponseEntity.status(200).body("sensor edited successfully");
        } else {
            return ResponseEntity.status(400).body("no sensor with such id");
        }
    }
}
