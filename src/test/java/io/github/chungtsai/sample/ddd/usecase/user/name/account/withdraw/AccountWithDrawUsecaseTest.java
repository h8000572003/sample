package io.github.chungtsai.sample.ddd.usecase.user.name.account.withdraw;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.github.chungtsai.sample.ddd.entity.Event;
import io.github.chungtsai.sample.ddd.entity.account.Account;
import io.github.chungtsai.sample.ddd.entity.account.ErrorAccountEvent;
import io.github.chungtsai.sample.ddd.entity.account.IAccountRepository;
import io.github.chungtsai.sample.ddd.entity.account.WithDrawCommand;
import io.github.chungtsai.sample.ddd.entity.account.WithDrawdEvent;

class AccountWithDrawUsecaseTest {

	private static final String ACCOUNT_ID = "AAA";

	/**
	 * 存款足夠提款成功
	 */
	@Test
	void testWithDrawWhenDollarEnoughThenWithdrawOk() {

		// WHEN
		Account account = new Account();
		account.setDollar(10);
		account.setId(ACCOUNT_ID);

		IAccountRepository accountRepository = Mockito.mock(IAccountRepository.class);
		Mockito.when(accountRepository.findById(ACCOUNT_ID)).thenReturn(account);

		// GIVE
		WithDrawCommand withDrawCommand = new WithDrawCommand();
		withDrawCommand.setId(ACCOUNT_ID);
		withDrawCommand.setWithdrawDollar(7);

		// THEN
		AccountWithDrawUsecase accountWithDrawUsecase = new AccountWithDrawUsecase(accountRepository);
		Event withDraw = accountWithDrawUsecase.withDraw(withDrawCommand);

		assertThat(withDraw).isExactlyInstanceOf(WithDrawdEvent.class);

		WithDrawdEvent withDrawdEvent = (WithDrawdEvent) withDraw;
		assertThat(withDrawdEvent.getBalance()).isEqualTo(3);
	}

	/**
	 * 存款不足夠提款失敗
	 */
	@Test
	void testWithFailWhenDollarNotEnough() {
		// WHEN
		Account account = new Account();
		account.setDollar(1);
		account.setId(ACCOUNT_ID);

		IAccountRepository accountRepository = Mockito.mock(IAccountRepository.class);
		Mockito.when(accountRepository.findById(ACCOUNT_ID)).thenReturn(account);

		// GIVE
		WithDrawCommand withDrawCommand = new WithDrawCommand();
		withDrawCommand.setId(ACCOUNT_ID);
		withDrawCommand.setWithdrawDollar(7);

		// THEN
		AccountWithDrawUsecase accountWithDrawUsecase = new AccountWithDrawUsecase(accountRepository);
		Event withDraw = accountWithDrawUsecase.withDraw(withDrawCommand);

		assertThat(withDraw).isExactlyInstanceOf(ErrorAccountEvent.class);
	}

}
