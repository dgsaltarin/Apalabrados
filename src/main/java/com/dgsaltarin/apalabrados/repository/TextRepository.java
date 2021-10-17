package com.dgsaltarin.apalabrados.repository;

import com.dgsaltarin.apalabrados.models.Text;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TextRepository extends MongoRepository<Text, String> {

}
