package com.dgsaltarin.apalabrados.repository;

import com.dgsaltarin.apalabrados.models.Number;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NumberRepository extends MongoRepository<Number, String> {

    public List<Number> findAllByAccumulatedOrderByAccumulatedAsc();
}
