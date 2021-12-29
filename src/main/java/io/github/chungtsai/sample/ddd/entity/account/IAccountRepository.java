package io.github.chungtsai.sample.ddd.entity.account;

public interface IAccountRepository {

	Account findById(String id);
}
