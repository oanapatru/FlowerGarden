package com.garden.data;

import org.springframework.data.repository.CrudRepository;

import com.garden.beans.Plant;

public interface PlantRepository extends CrudRepository<Plant, Long> {

}
