package io.github.chungtsai.sample.ddd.entity.user;

public interface IUserAggregateRepository {
	UserAggregate findById(String id);

	UserAggregate createNew(String id);
}
