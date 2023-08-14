package com.myserv.api.rh.repository;

import com.myserv.api.rh.model.Infocandidate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfocandidateRepository extends MongoRepository<Infocandidate,String> {
}
