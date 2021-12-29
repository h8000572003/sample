package io.github.chungtsai.sample.ddd.adapter.entity.mapper;

import io.github.chungtsai.sample.ddd.adapter.entity.po.UserPo;
import io.github.chungtsai.sample.ddd.entity.user.UserAggregate;

public class Test {


	public static void main(String[] args) {
		UserPo userPo = new UserPo();
		userPo.setName("A");
		userPo.setId("B");
		userPo.setChangeNameCount(0);
		UserAggregate userAggregate = UserMapper.INSTANCE.toAggregate(userPo);
	}
}
