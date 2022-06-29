package com.demo.clientservice.atask.service;

import com.demo.clientservice.atask.interfaces.ClientService;
import com.demo.clientservice.domain.contracts.ClientRepository;
import com.demo.clientservice.domain.models.ClientDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase que implementa los servicio que interactu con el repository.
 */

@Service
public class ClientServiceImpl implements ClientService {

  private final ClientRepository clientRepository;

  public ClientServiceImpl(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @Override
  public Flux<ClientDto> getListClient() {
    return this.clientRepository.getListClient();
  }

  @Override
  public Mono<ClientDto> searchClient(String id) {
    return this.clientRepository.searchClient(id);
  }

  @Override
  public Mono<ClientDto> addClient(Mono<ClientDto> clientDto) {
    return this.clientRepository.addClient(clientDto);
  }

  @Override
  public Mono<ClientDto> updateClient(Mono<ClientDto> clientDto, String id) {
    return this.clientRepository.updateClient(clientDto, id);
  }

  @Override
  public Mono<Void> deleteClient(String id) {
    return this.clientRepository.deleteClient(id);
  }
}
