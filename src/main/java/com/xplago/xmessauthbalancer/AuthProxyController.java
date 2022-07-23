package com.xplago.xmessauthbalancer;

import com.xplago.xmessauthbalancer.dto.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ClientHttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClientRequest;

@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
public class AuthProxyController {

    private final WebClient.Builder loadBalancedWebClientBuilder;

    public AuthProxyController(WebClient.Builder loadBalancedWebClientBuilder) {
        this.loadBalancedWebClientBuilder = loadBalancedWebClientBuilder;
    }

    @PostMapping("/signin")
    public Mono<TokenResponse> signin(@RequestBody SigninRequest request) {
        return loadBalancedWebClientBuilder.build()
                .post()
                .uri("http://xmess-auth-service/auth/signin")
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(request), SigninRequest.class)
                .retrieve()
                .bodyToMono(TokenResponse.class);
    }

    @PostMapping("/signup")
    public Mono<TokenResponse> signup(@RequestBody SignupRequest request) {
        return loadBalancedWebClientBuilder.build()
                .post()
                .uri("http://xmess-auth-service/auth/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(request), SignupRequest.class)
                .retrieve()
                .bodyToMono(TokenResponse.class);
    }

    @PostMapping("/refresh")
    public Mono<RefreshResponse> refresh(@RequestBody RefreshRequest request) {
        return loadBalancedWebClientBuilder.build()
                .post()
                .uri("http://xmess-auth-service/auth/refresh")
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(request), RefreshRequest.class)
                .retrieve()
                .bodyToMono(RefreshResponse.class);
    }
}
