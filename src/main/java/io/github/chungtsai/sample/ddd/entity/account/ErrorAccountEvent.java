package io.github.chungtsai.sample.ddd.entity.account;

import io.github.chungtsai.sample.ddd.entity.Event;

public class ErrorAccountEvent extends Event{
	String code="E0001";

	public ErrorAccountEvent(String code) {
		super();
		this.code = code;
	}
	public ErrorAccountEvent() {
		
	}
}
