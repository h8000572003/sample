package io.github.chungtsai.sample.ddd.adapter.entity.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import io.github.chungtsai.sample.ddd.adapter.entity.po.UserPo;
import io.github.chungtsai.sample.ddd.entity.user.UserAggregate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class UserMapperTest {

	@Test
	void test() {
		UserPo userPo = new UserPo();
		userPo.setName("A");
		userPo.setId("B");
		userPo.setChangeNameCount(0);
		UserAggregate userAggregate = UserMapper.INSTANCE.toAggregate(userPo);
		log.info("userAggregate:{}", userAggregate);
	}

}
