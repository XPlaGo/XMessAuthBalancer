package com.xplago.xmessauthbalancer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {

    @JsonProperty
    private String username;

    @JsonProperty
    private String email;

    @JsonProperty
    private String password;
}
