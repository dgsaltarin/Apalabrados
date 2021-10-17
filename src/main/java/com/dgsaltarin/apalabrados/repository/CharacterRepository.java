package com.dgsaltarin.apalabrados.repository;

import com.dgsaltarin.apalabrados.models.Character;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CharacterRepository extends MongoRepository<Character, String> {
}
