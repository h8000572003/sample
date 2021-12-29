package io.github.chungtsai.sample.mvn;

import io.github.chungtsai.sample.ddd.adapter.entity.po.AccountDollerPo;

public interface AccouintTableMode {

	AccountDollerPo selectById(String id);

	void update(AccountDollerPo accountDollerPo);

	
	

}
