package com.xplago.xmessauthbalancer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenResponse {
    @JsonProperty
    private String refreshToken;
    @JsonProperty
    private String jwtToken;
    @JsonProperty
    private String username;
}
