package com.garden.data;

import org.springframework.data.repository.CrudRepository;

import com.garden.beans.Painter;

public interface PainterRepository extends CrudRepository<Painter, Long> {

}
