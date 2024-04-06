package br.com.ekan.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Token {

    private String subject;
    private Date issuedAt;
    private Date expiration;
    private List<String> roles;
    private String type;
    @JsonProperty("access_token")
    private String accessToken;

}
