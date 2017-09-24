package com.github.xetorthio.jedisque;

import com.github.xetorthio.redis.clients.util.SafeEncoder;


enum Keyword {
		FROM, REPLICATE, DELAY, RETRY, TTL, MAXLEN, ASYNC, TIMEOUT, COUNT;
		final byte[] raw;

		Keyword() {
			raw = SafeEncoder.encode(this.name());
		}

}