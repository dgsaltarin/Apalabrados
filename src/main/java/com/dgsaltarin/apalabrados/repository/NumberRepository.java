package com.dgsaltarin.apalabrados.repository;

import com.dgsaltarin.apalabrados.models.Number;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NumberRepository extends MongoRepository<Number, String> {

}
