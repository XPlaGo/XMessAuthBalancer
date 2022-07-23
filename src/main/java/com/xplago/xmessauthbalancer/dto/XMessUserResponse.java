package com.xplago.xmessauthbalancer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xplago.xmessauthbalancer.model.XMessUserRole;
import lombok.Data;

import java.util.List;

@Data
public class XMessUserResponse {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String username;
    @JsonProperty
    private String email;
    @JsonProperty
    List<XMessUserRole> XMessUserRoles;
}
