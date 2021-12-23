package io.github.chungtsai.sample.ddd.entity.user;

import java.util.Map;

import com.google.common.collect.Maps;

public class UserAggregateRepository implements IUserAggregateRepository {

	private Map<String, UserAggregate> userAggregateMap = Maps.newConcurrentMap();

	@Override
	public UserAggregate findById(String id) {
		return userAggregateMap.getOrDefault(id, null);
	}

	@Override
	public UserAggregate createNew(String id) {
		UserAggregate userAggregate = new UserAggregate();
		userAggregate.setId(id);
		return userAggregate;
	}

}
