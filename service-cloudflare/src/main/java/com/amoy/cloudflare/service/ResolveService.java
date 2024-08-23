package com.amoy.cloudflare.service;

public interface ResolveService {

    void addDomain(String domain);

    void resolve();
}
