package br.com.ekan.controller;

import br.com.ekan.controller.request.BeneficiarioRequest;
import br.com.ekan.model.Beneficiario;
import br.com.ekan.repository.BeneficiarioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("beneficiario")
@Tag(name = "Beneficiário controller", description = "Serviço para manipulação de beneficiários.")
public class BeneficiarioController {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @Operation(summary = "Lista beneficiarios", description = "Retorna todos beneficiários")
    @GetMapping
    public ResponseEntity<List<Beneficiario>> listaBeneficiarios() {
        return ResponseEntity.ok(beneficiarioRepository.findAll());
    }

    @Operation(summary = "Buscar beneficiario por id", description = "Retorna beneficiário por id")
    @GetMapping("/{id}")
    public ResponseEntity<Beneficiario> buscarBeneficiario(
            @PathVariable Long id,
            @RequestHeader(required = true) String Authorization) {
        try {
            if(beneficiarioRepository.existsById(id)){
                return ResponseEntity.ok(beneficiarioRepository.findById(id).get());
            }
        } catch (Exception err) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Criar novo beneficiario", description = "Cria novo beneficiário")
    @PostMapping
    public ResponseEntity<?> novoBeneficiario(@RequestBody @Valid BeneficiarioRequest request) {
        try {
            request.setId(null);
            beneficiarioRepository.save(
                    Beneficiario.builder()
                    .nome(request.getNome())
                            .telefone(request.getTelefone())
                            .dataNascimento(request.getDataNascimento())
                            .dataInclusao(LocalDate.now())
                            .dataAtualizacao(LocalDate.now())
                            .build());
        } catch (Exception err) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Atualizar beneficiario")
    @PutMapping
    public ResponseEntity<?> atualizaBeneficiario(@RequestBody @Valid BeneficiarioRequest request) {
        try {
            if(beneficiarioRepository.existsById(request.getId())){
                beneficiarioRepository.save(
                        Beneficiario.builder()
                        .nome(request.getNome())
                        .telefone(request.getTelefone())
                        .dataNascimento(request.getDataNascimento())
                        .dataAtualizacao(LocalDate.now())
                        .build());
            }else{
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception err) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Remover beneficiario")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBeneficiario(@PathVariable Long id) {
        try {
            if(beneficiarioRepository.existsById(id)){
                beneficiarioRepository.deleteById(id);
            }else{
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception err) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }


}
