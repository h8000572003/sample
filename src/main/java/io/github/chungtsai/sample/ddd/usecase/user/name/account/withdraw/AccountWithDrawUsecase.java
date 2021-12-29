package io.github.chungtsai.sample.ddd.usecase.user.name.account.withdraw;

import io.github.chungtsai.sample.ddd.entity.Event;
import io.github.chungtsai.sample.ddd.entity.account.Account;
import io.github.chungtsai.sample.ddd.entity.account.ErrorAccountEvent;
import io.github.chungtsai.sample.ddd.entity.account.IAccountRepository;
import io.github.chungtsai.sample.ddd.entity.account.WithDrawCommand;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountWithDrawUsecase {

	private final IAccountRepository accountRepository;

	public Event withDraw(WithDrawCommand withDrawCommand) {
		Account account = accountRepository.findById(withDrawCommand.getId());
		if (account == null) {
			return new ErrorAccountEvent();
		}
		return account.withDraw(withDrawCommand);
	}

}
