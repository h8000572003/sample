package io.github.chungtsai.sample.ddd.entity.account;

import io.github.chungtsai.sample.ddd.entity.Event;
import lombok.Data;

@Data
public class WithDrawdEvent extends Event {

	private int balance;// 餘額
	private String id;
	private int withdrawDollar;// 提款;
}
