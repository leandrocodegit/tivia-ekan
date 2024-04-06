package br.com.ekan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "TB_USERS")
public class User {

    @Id
    private String usuario;
    private String senha;

}
