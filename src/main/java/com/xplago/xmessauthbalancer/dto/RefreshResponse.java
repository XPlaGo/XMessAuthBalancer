package com.xplago.xmessauthbalancer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshResponse {
    @JsonProperty
    private String token;
    @JsonProperty
    private String username;
}
