package com.github.xetorthio.jedisque;

import org.junit.*;

import java.util.UUID;

import static org.junit.Assert.assertNotNull;

public class BinaryJedisqueTest {
	private static byte[] getQueueName() {
		return UUID.randomUUID().toString().getBytes();
	}
	byte[] binaryValue;
	static Jedisque q;

	@Before
	public void setUp() throws Exception {
		q = new Jedisque();
		StringBuilder sb = new StringBuilder();

		for (int n = 0; n < 1000; n++) {
			sb.append("A");
		}

		binaryValue = sb.toString().getBytes();
	}

	@After
	public void tearDown() throws Exception {
		q.close();
	}

	@Test
	public void addJob() {
		String jobId = q.addJob(getQueueName(), binaryValue, 10);
		assertNotNull(jobId);
	}

	@Test
	public void addJobWithParams() {
		JobParams params = new JobParams().setReplicate(1).setRetry(10).setTTL(10).setMaxlen(10).setDelay(5)
				.setAsync(true);
		String jobId = q.addJob(getQueueName(), binaryValue, 10, params);
		assertNotNull(jobId);
	}
}
