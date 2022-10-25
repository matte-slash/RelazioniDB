package com.ITCube.RelazioniDB.repository;

import com.ITCube.RelazioniDB.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}
