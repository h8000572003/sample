package io.github.chungtsai.sample.mvn;

import io.github.chungtsai.sample.ddd.adapter.entity.po.AccountDollerPo;
import io.github.h800572003.exception.ApBusinessException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountService {

	private final AccouintTableMode accouintTableMode;

	void withDraw(WithDrawDTO withDrawDTO) {
		AccountDollerPo accountDollerPo = accouintTableMode.selectById(withDrawDTO.getId());
		if (accountDollerPo == null) {
			throw new ApBusinessException("帳號不存在");
		}
		if (accountDollerPo.getDollar() >= withDrawDTO.getWithdrawDollar()) {
			accountDollerPo.setDollar(accountDollerPo.getDollar() - withDrawDTO.getWithdrawDollar());
			accouintTableMode.update(accountDollerPo);
		}
		throw new ApBusinessException("餘額不足");
	}

}
