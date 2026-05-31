package com.algaworks_algasensors.device.management.api.controller;

import com.algaworks_algasensors.device.management.api.model.SensorInput;
import com.algaworks_algasensors.device.management.common.IdGenerator;
import com.algaworks_algasensors.device.management.domain.model.Sensor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sensor create(@RequestBody SensorInput sensor){
        return Sensor.builder().
                id(IdGenerator.generateTSID())
                .name(sensor.getName())
                .ip(sensor.getIp())
                .location(sensor.getLocation())
                .model(sensor.getModel())
                .protocol(sensor.getProtocol())
                .enabled(false)
                .build();
    }


}
