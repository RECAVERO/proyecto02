package com.demo.clientservice.application.rest;

import com.demo.clientservice.atask.interfaces.ClientService;
import com.demo.clientservice.domain.models.ClientDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * clase que tiene los endpoints con las funcionalidades.
 */

@RestController
@RequestMapping("/client")
public class ClientController {

  private final ClientService clientService;

  public ClientController(ClientService clientService) {
    this.clientService = clientService;
  }

  @GetMapping
  public Flux<ClientDto> getListClient() {
    return this.clientService.getListClient();
  }

  @GetMapping("/{id}")
  public Mono<ClientDto> searchClient(@PathVariable String id) {
    return this.clientService.searchClient(id);
  }

  @PostMapping
  public Mono<ClientDto> addClient(@RequestBody Mono<ClientDto> client) {
    return this.clientService.addClient(client);
  }

  @PutMapping("/{id}")
  public Mono<ClientDto> updateClient(@RequestBody Mono<ClientDto> client,
                                      @PathVariable String id) {
    return this.clientService.updateClient(client, id);
  }

  @DeleteMapping("/{id}")
  public Mono<Void> deleteClient(@PathVariable String id) {
    return this.clientService.deleteClient(id);
  }

}
