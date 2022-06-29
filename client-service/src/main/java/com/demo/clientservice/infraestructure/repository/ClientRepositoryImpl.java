package com.demo.clientservice.infraestructure.repository;

import com.demo.clientservice.domain.contracts.ClientRepository;
import com.demo.clientservice.domain.models.ClientDto;
import com.demo.clientservice.infraestructure.mongodb.ClientRepositoryMongo;
import com.demo.clientservice.utils.convert.Convert;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Implemtacion de la capa repository y la capa que interactua con la base de datos.
 */

@Repository
public class ClientRepositoryImpl implements ClientRepository {

  private final ClientRepositoryMongo clientRepositoryMongo;

  public ClientRepositoryImpl(ClientRepositoryMongo clientRepositoryMongo) {
    this.clientRepositoryMongo = clientRepositoryMongo;
  }


  @Override
  public Flux<ClientDto> getListClient() {
    return this.clientRepositoryMongo.findAll().map(Convert::entityToDto);
  }

  @Override
  public Mono<ClientDto> searchClient(String id) {
    return this.clientRepositoryMongo.findById(id).map(Convert::entityToDto);
  }

  @Override
  public Mono<ClientDto> addClient(Mono<ClientDto> clientDto) {
    return clientDto.map(Convert::dtoToEntity)
        .flatMap(this.clientRepositoryMongo::insert)
        .map(Convert::entityToDto);
  }

  @Override
  public Mono<ClientDto> updateClient(Mono<ClientDto> clientDto, String id) {
    return  this.clientRepositoryMongo.findById(id)
        .flatMap(p -> clientDto.map(Convert::dtoToEntity)
            .doOnNext(e -> e.setId(id)))
        .flatMap(this.clientRepositoryMongo::save)
        .map(Convert::entityToDto);
  }

  @Override
  public Mono<Void> deleteClient(String id) {
    return this.clientRepositoryMongo.deleteById(id);
  }
}
