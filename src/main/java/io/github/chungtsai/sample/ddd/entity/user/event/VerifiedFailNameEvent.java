package io.github.chungtsai.sample.ddd.entity.user.event;

import io.github.chungtsai.sample.ddd.entity.Event;
import lombok.Data;

@Data
public class VerifiedFailNameEvent extends Event {

	private String message;
}
