package io.github.chungtsai.sample.ddd.entity.account;

import io.github.chungtsai.sample.ddd.entity.Event;

public class Account {
	private String id;
	private int dollar;

	public Event withDraw(WithDrawCommand cmd) {
		if (this.dollar >= cmd.getWithdrawDollar()) {
			this.dollar = this.dollar - cmd.getWithdrawDollar();
			return createWithDrawdEvent(cmd);
		}
		return new ErrorAccountEvent("E0001");
	}

	/**
	 * 已提款事件
	 * 
	 * @param cmd
	 * @return
	 */
	private Event createWithDrawdEvent(WithDrawCommand cmd) {
		WithDrawdEvent withDrawdEvent = new WithDrawdEvent();
		withDrawdEvent.setBalance(dollar);
		withDrawdEvent.setId(cmd.getId());
		withDrawdEvent.setWithdrawDollar(dollar);
		return withDrawdEvent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getDollar() {
		return dollar;
	}

	public void setDollar(int dollar) {
		this.dollar = dollar;
	}

}
