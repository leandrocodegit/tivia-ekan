package br.com.ekan.config;

import br.com.ekan.model.Beneficiario;
import br.com.ekan.model.Documento;
import br.com.ekan.model.User;
import br.com.ekan.repository.BeneficiarioRepository;
import br.com.ekan.repository.DocumentoRepository;
import br.com.ekan.repository.UsuarioRepository;
import br.com.ekan.util.TipoDocumento;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;


@Configuration
@Component
public class Setup {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private BeneficiarioRepository beneficiarioRepository;
    @Autowired
    private DocumentoRepository documentoRepository;

    @PostConstruct
    public void init() {
        usuarioRepository.save(new User("admin", "$2a$10$5CuiTBFByXDrOCZFYZ3pu.cuNvS2CuUUocvDtp/YTxslkMYw3BRBm"));

        beneficiarioRepository.saveAll(
                new ArrayList<Beneficiario>() {{
                    add(new Beneficiario(1L, "Beneficiario 01", "121545454", LocalDate.now(), LocalDate.now(), LocalDate.now(),
                            new ArrayList<Documento>() {{
                                add(new Documento(4L, "Documento 01", TipoDocumento.FICHA_CADASTRAL, LocalDate.now(), LocalDate.now()));
                                add(new Documento(5L, "Documento 02", TipoDocumento.RECIBO_PAGAMENTO, LocalDate.now(), LocalDate.now()));
                                add(new Documento(6L, "Documento 03", TipoDocumento.REEBOLSO, LocalDate.now(), LocalDate.now()));
                            }}));
                    add(new Beneficiario(2L, "Beneficiario 02", "121545454", LocalDate.now(), LocalDate.now(), LocalDate.now(),
                            new ArrayList<Documento>() {{
                                add(new Documento(4L, "Documento 04", TipoDocumento.FICHA_CADASTRAL, LocalDate.now(), LocalDate.now()));
                                add(new Documento(5L, "Documento 05", TipoDocumento.RECIBO_PAGAMENTO, LocalDate.now(), LocalDate.now()));
                                add(new Documento(6L, "Documento 06", TipoDocumento.REEBOLSO, LocalDate.now(), LocalDate.now()));
                            }}));
                    add(new Beneficiario(3L, "Beneficiario 03", "121545454", LocalDate.now(), LocalDate.now(), LocalDate.now(),
                            new ArrayList<Documento>() {{
                                add(new Documento(7L, "Documento 07", TipoDocumento.FICHA_CADASTRAL, LocalDate.now(), LocalDate.now()));
                                add(new Documento(8L, "Documento 08", TipoDocumento.RECIBO_PAGAMENTO, LocalDate.now(), LocalDate.now()));
                                add(new Documento(9L, "Documento 09", TipoDocumento.REEBOLSO, LocalDate.now(), LocalDate.now()));
                            }}));
                    add(new Beneficiario(4L, "Beneficiario 04", "121545454", LocalDate.now(), LocalDate.now(), LocalDate.now(),
                            new ArrayList<Documento>() {{
                                add(new Documento(10L, "Documento 10", TipoDocumento.FICHA_CADASTRAL, LocalDate.now(), LocalDate.now()));
                                add(new Documento(11L, "Documento 11", TipoDocumento.RECIBO_PAGAMENTO, LocalDate.now(), LocalDate.now()));
                                add(new Documento(12L, "Documento 12", TipoDocumento.REEBOLSO, LocalDate.now(), LocalDate.now()));
                            }}));
                    add(new Beneficiario(5L, "Beneficiario 05", "121545454", LocalDate.now(), LocalDate.now(), LocalDate.now(),
                            new ArrayList<Documento>() {{
                                add(new Documento(13L, "Documento 13", TipoDocumento.FICHA_CADASTRAL, LocalDate.now(), LocalDate.now()));
                                add(new Documento(14L, "Documento 14", TipoDocumento.RECIBO_PAGAMENTO, LocalDate.now(), LocalDate.now()));
                                add(new Documento(15L, "Documento 15", TipoDocumento.REEBOLSO, LocalDate.now(), LocalDate.now()));
                            }}));
                }}
        );
    }
}