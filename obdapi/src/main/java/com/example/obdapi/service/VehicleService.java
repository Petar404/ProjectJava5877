package com.example.obdapi.service;

import com.example.obdapi.model.*;
import com.example.obdapi.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepo;
    private final DtcCodeRepository dtcRepo;
    private final MaintenanceRepository maintenanceRepo;

    public VehicleService(VehicleRepository vehicleRepo, DtcCodeRepository dtcRepo, MaintenanceRepository maintenanceRepo) {
        this.vehicleRepo = vehicleRepo;
        this.dtcRepo = dtcRepo;
        this.maintenanceRepo = maintenanceRepo;
    }

    public Vehicle registerVehicle(Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }

    public void deleteVehicle(String vin) {
        vehicleRepo.deleteById(vin);
    }

    public List<DtcCode> getDtcCodes(String vin) {
        return dtcRepo.findByVehicleVin(vin);
    }

    public MaintenanceLog saveMaintenanceLog(String vin, MaintenanceLog log) {
        log.setVehicleVin(vin);
        return maintenanceRepo.save(log);
    }

    public List<MaintenanceLog> getMaintenanceLogs(String vin) {
        return maintenanceRepo.findByVehicleVin(vin);
    }
}
