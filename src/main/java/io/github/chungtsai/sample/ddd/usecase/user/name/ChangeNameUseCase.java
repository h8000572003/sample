package io.github.chungtsai.sample.ddd.usecase.user.name;

import io.github.chungtsai.sample.ddd.entity.user.event.NamedEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * 變更名稱案例
 * 
 * @author 6407
 *
 */
@Slf4j
public class ChangeNameUseCase {

	public void change(NamedEvent namedEvent) {
		log.info("update user table data...");
	}
}
