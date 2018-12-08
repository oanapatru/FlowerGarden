package com.garden.data;

import org.springframework.data.repository.CrudRepository;

import com.garden.beans.Garden;

public interface GardenRepository extends CrudRepository<Garden, Long> {

}
