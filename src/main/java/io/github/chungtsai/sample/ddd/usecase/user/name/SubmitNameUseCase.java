package io.github.chungtsai.sample.ddd.usecase.user.name;

import io.github.chungtsai.sample.ddd.entity.Event;
import io.github.chungtsai.sample.ddd.entity.user.IUserAggregateRepository;
import io.github.chungtsai.sample.ddd.entity.user.UserAggregate;
import io.github.chungtsai.sample.ddd.entity.user.event.VerifiedFailNameEvent;
import lombok.RequiredArgsConstructor;

/**
 * 已提交姓名變更案例
 * 
 * @author 6407
 *
 */
@RequiredArgsConstructor
public class SubmitNameUseCase {

	private final IUserAggregateRepository userAggregateRepository;

	Event submit(SubmitNameUseCommand command) {
		UserAggregate user = userAggregateRepository.findById(command.getId());
		if (user == null) {
			VerifiedFailNameEvent verifiedFailNameEvent = new VerifiedFailNameEvent();
			verifiedFailNameEvent.setMessage("帳號不存在:" + command.getId());
			return verifiedFailNameEvent;
		}
		return user.changeName(command);
	}

}
