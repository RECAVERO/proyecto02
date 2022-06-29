package com.demo.clientservice.infraestructure.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Documento que interactua con la base de datos mongo db.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("Clients")
public class Client {
  @Id
  private String id;
  private String names;
  private String email;
}
