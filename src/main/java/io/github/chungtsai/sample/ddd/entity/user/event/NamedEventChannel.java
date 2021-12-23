package io.github.chungtsai.sample.ddd.entity.user.event;

import org.apache.commons.lang3.builder.ToStringBuilder;

import io.github.chungtsai.sample.ddd.usecase.user.name.ChangeNameUseCase;
import io.github.h800572003.event.deiven.IChannel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class NamedEventChannel implements IChannel<NamedEvent> {

	private final ChangeNameUseCase changeNameUseCase;

	@Override
	public void dispatch(NamedEvent message) {
		changeNameUseCase.change(message);
	}

}
