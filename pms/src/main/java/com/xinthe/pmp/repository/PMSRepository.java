package com.xinthe.pmp.repository;

import com.xinthe.pmp.model.PmsCollection;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PMSRepository extends MongoRepository<PmsCollection, String> {

}
