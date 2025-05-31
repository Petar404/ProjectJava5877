package com.example.obdapi.controller;

import com.example.obdapi.model.*;
import com.example.obdapi.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<Vehicle> register(@RequestBody Vehicle vehicle) {
        return ResponseEntity.ok(vehicleService.registerVehicle(vehicle));
    }

    @DeleteMapping("/{vin}")
    public ResponseEntity<Void> delete(@PathVariable String vin) {
        vehicleService.deleteVehicle(vin);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{vin}/dtc")
    public ResponseEntity<List<DtcCode>> getDtcCodes(@PathVariable String vin) {
        return ResponseEntity.ok(vehicleService.getDtcCodes(vin));
    }

    @PostMapping("/{vin}/logs")
    public ResponseEntity<MaintenanceLog> uploadLog(@PathVariable String vin, @RequestBody MaintenanceLog log) {
        return ResponseEntity.ok(vehicleService.saveMaintenanceLog(vin, log));
    }

    @GetMapping("/{vin}/logs")
    public ResponseEntity<List<MaintenanceLog>> getLogs(@PathVariable String vin) {
        return ResponseEntity.ok(vehicleService.getMaintenanceLogs(vin));
    }
}
