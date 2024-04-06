package br.com.ekan.controller.request;

import br.com.ekan.model.Documento;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BeneficiarioRequest {

    private Long id;
    private String nome;
    @NotNull(message = "Telefone não pode ser vazio")
    private String telefone;
    @JsonProperty("data-nascimento")
    @NotNull(message = "Data de nascimento não pode ser vazio")
    private LocalDate dataNascimento;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Documento> documentos;
}
