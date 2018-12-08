package com.garden.data;

import org.springframework.data.repository.CrudRepository;

import com.garden.beans.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {

}
