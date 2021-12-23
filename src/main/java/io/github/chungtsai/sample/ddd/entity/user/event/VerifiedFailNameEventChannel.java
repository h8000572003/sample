package io.github.chungtsai.sample.ddd.entity.user.event;

import org.apache.commons.lang3.builder.ToStringBuilder;

import io.github.h800572003.event.deiven.IChannel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VerifiedFailNameEventChannel implements IChannel<VerifiedFailNameEvent> {

	@Override
	public void dispatch(VerifiedFailNameEvent message) {
		log.info("GET {}", ToStringBuilder.reflectionToString(message));

	}

}
