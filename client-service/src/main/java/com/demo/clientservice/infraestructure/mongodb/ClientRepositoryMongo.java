package com.demo.clientservice.infraestructure.mongodb;

import com.demo.clientservice.infraestructure.document.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ClientRepositoryMongo extends ReactiveMongoRepository<Client,String> {
}
