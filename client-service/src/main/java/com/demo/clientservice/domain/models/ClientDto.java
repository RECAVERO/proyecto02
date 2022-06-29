package com.demo.clientservice.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Metodo auxiliar de un documento.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
  private String id;
  private String names;
  private String email;
}
