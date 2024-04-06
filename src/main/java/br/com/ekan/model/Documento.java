package br.com.ekan.model;

import br.com.ekan.util.TipoDocumento;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "TB_DOCUMENTOS")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    @JsonProperty("tipo-documento")
    private TipoDocumento tipoDocumento;
    @JsonProperty("data-inclusao")
    private LocalDate dataInclusao;
    @JsonProperty("data-atualizacao")
    private LocalDate dataAtualizacao;

}
