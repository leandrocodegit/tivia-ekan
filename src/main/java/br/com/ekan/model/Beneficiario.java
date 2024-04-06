package br.com.ekan.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "TB_BENEFICIARIOS")
public class Beneficiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String telefone;
    @JsonProperty("data-nascimento")
    private LocalDate dataNascimento;
    @JsonProperty("data-inclusao")
    private LocalDate dataInclusao;
    @JsonProperty("data-atualizacao")
    private LocalDate dataAtualizacao;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Documento> documentos;

}
