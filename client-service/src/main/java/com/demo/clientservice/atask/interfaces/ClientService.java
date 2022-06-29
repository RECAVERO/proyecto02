package com.demo.clientservice.atask.interfaces;

import com.demo.clientservice.domain.models.ClientDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Marco de trabajo de metodos funcionales para el crud.
 */

public interface ClientService {

  Flux<ClientDto> getListClient();

  Mono<ClientDto> searchClient(String id);

  Mono<ClientDto> addClient(Mono<ClientDto> clientDto);

  Mono<ClientDto> updateClient(Mono<ClientDto> clientDto, String id);

  Mono<Void> deleteClient(String id);

}
