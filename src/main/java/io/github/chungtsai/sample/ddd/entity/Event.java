package io.github.chungtsai.sample.ddd.entity;

import io.github.h800572003.event.deiven.IMessage;

public class Event implements IMessage {

	@Override
	public final Class<? extends IMessage> getType() {
		return getClass();
	}

}
