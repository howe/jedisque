package com.github.xetorthio.redis.clients.jedis;

public abstract class Builder<T> {
  public abstract T build(Object data);
}
