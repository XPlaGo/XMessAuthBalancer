package com.xplago.xmessauthbalancer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SigninRequest {

    @JsonProperty
    private String username;

    @JsonProperty
    private String password;
}
