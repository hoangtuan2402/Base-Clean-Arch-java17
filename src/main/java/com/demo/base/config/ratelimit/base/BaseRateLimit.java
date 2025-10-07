package com.demo.base.config.ratelimit.base;



import io.github.bucket4j.Bandwidth;

public abstract class BaseRateLimit {
    public abstract String getName();

    public abstract Bandwidth getLimit();
}
