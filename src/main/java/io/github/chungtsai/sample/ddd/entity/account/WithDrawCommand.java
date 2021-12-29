package io.github.chungtsai.sample.ddd.entity.account;

import lombok.Data;

@Data
public class WithDrawCommand {

	String id;
	int withdrawDollar;//提款
}
