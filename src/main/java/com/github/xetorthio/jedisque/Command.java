package com.github.xetorthio.jedisque;

import com.github.xetorthio.redis.clients.jedis.ProtocolCommand;
import com.github.xetorthio.redis.clients.util.SafeEncoder;

public enum Command implements ProtocolCommand {
	ADDJOB, GETJOB, ACKJOB, INFO, QLEN, QPEEK, DELJOB, DEQUEUE, ENQUEUE, FASTACK, SHOW, PING, WORKING;
	private final byte[] raw;

	Command() {
		raw = SafeEncoder.encode(this.name());
	}

	@Override
	public byte[] getRaw() {
		return raw;
	}

}
