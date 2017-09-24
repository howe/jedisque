package com.github.xetorthio.jedisque;

import java.net.URI;
import java.net.URISyntaxException;

import com.github.xetorthio.redis.clients.jedis.exceptions.JedisConnectionException;
import org.junit.Test;

public class ConnectionTest {

	@Test
	public void iterateOverHosts() throws URISyntaxException {
		Jedisque q = new Jedisque(new URI("disque://localhost:55665"), new URI("disque://localhost:7711"));
		q.info();
		q.close();
	}

	@Test(expected = JedisConnectionException.class)
	public void throwExceptionWhenNodesAreUnavailbale() throws URISyntaxException {
		Jedisque q = new Jedisque(new URI("disque://localhost:55665"), new URI("disque://localhost:55666"));
		q.info();
		q.close();
	}
}
