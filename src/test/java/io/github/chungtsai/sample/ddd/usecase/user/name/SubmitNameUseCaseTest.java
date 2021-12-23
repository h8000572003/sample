package io.github.chungtsai.sample.ddd.usecase.user.name;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.github.chungtsai.sample.ddd.entity.Event;
import io.github.chungtsai.sample.ddd.entity.user.IUserAggregateRepository;
import io.github.chungtsai.sample.ddd.entity.user.UserAggregate;
import io.github.chungtsai.sample.ddd.entity.user.event.NamedEvent;
import io.github.chungtsai.sample.ddd.entity.user.event.VerifiedFailNameEvent;

class SubmitNameUseCaseTest {

	private static final String NEW_NAME = "大明";
	private static final String OLD_NAME = "小明";
	private static final String A123456789 = "A123456789";
	IUserAggregateRepository userAggregateRepository = Mockito.mock(IUserAggregateRepository.class);

	/**
	 * 輸入正確性名，變更次數小於等於3，取得變更成功事件
	 */
	@Test
	void testCurrentNameAndCountLess3ReturnNamedEvent() {

		// GIVE
		SubmitNameUseCommand submitNameUseCommand = new SubmitNameUseCommand();
		submitNameUseCommand.setId(A123456789);
		submitNameUseCommand.setNewNmae(NEW_NAME);

		// WHEN
		UserAggregate userAggregate = new UserAggregate();
		userAggregate.setId(A123456789);
		userAggregate.setName(A123456789);
		userAggregate.setName(OLD_NAME);
		userAggregate.setChangeNameCount(0);

		Mockito.when(userAggregateRepository.findById(A123456789)).thenReturn(userAggregate);

		// THEN
		SubmitNameUseCase submitNameUseCase = new SubmitNameUseCase(userAggregateRepository);
		Event event = submitNameUseCase.submit(submitNameUseCommand);
		assertThat(event).isExactlyInstanceOf(NamedEvent.class);

		NamedEvent namedEvent = (NamedEvent) event;
		assertThat(namedEvent.getId()).isEqualTo(A123456789);
		assertThat(namedEvent.getNewName()).isEqualTo(NEW_NAME);
		assertThat(namedEvent.getOldName()).isEqualTo(OLD_NAME);
		assertThat(namedEvent.getChangeNameCount()).isEqualTo(1);

	}

	/**
	 * 資料輸入正確，但變更次數超過3次 ，驗證不通過
	 */

	@Test
	void testNotCurrentNameReturnVerifiedFailNameEvent() {

		// GIVE
		SubmitNameUseCommand submitNameUseCommand = new SubmitNameUseCommand();
		submitNameUseCommand.setId(A123456789);
		submitNameUseCommand.setNewNmae(NEW_NAME);

		// WHEN
		UserAggregate userAggregate = new UserAggregate();
		userAggregate.setName(A123456789);
		userAggregate.setName(OLD_NAME);
		userAggregate.setChangeNameCount(3);

		Mockito.when(userAggregateRepository.findById(A123456789)).thenReturn(userAggregate);

		// THEN
		SubmitNameUseCase submitNameUseCase = new SubmitNameUseCase(userAggregateRepository);
		Event event = submitNameUseCase.submit(submitNameUseCommand);
		assertThat(event).isExactlyInstanceOf(VerifiedFailNameEvent.class);

	}

}
