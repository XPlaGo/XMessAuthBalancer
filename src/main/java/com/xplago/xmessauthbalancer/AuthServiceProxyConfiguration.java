package com.xplago.xmessauthbalancer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Flux;

import java.util.List;

public class AuthServiceProxyConfiguration {

    @Bean
    @Primary
    ServiceInstanceListSupplier serviceInstanceListSupplier() {
        return new AuthServiceInstanceListSuppler("xmess-auth-service");
    }
}

class AuthServiceInstanceListSuppler implements ServiceInstanceListSupplier {

    private final String serviceId;

    @Autowired
    private DiscoveryClient discoveryClient;

    AuthServiceInstanceListSuppler(String serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String getServiceId() {
        return serviceId;
    }

    @Override
    public Flux<List<ServiceInstance>> get() {

        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);

        return Flux.just(instances);
    }
}
