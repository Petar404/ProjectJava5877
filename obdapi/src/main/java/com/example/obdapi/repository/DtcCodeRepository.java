package com.example.obdapi.repository;

import com.example.obdapi.model.DtcCode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DtcCodeRepository extends CrudRepository<DtcCode, Long> {
    List<DtcCode> findByVehicleVin(String vin);
}
