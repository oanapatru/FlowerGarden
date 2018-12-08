package com.garden.data;

import org.springframework.data.repository.CrudRepository;

import com.garden.beans.GardenOwner;

public interface GardenOwnerRepository extends CrudRepository<GardenOwner, Long> {

}
