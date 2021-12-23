package io.github.chungtsai.sample.ddd.entity.user.event;

import io.github.chungtsai.sample.ddd.entity.Event;
import lombok.Data;

/**
 * 已變更姓名
 * 
 * @author 6407
 *
 */
@Data
public class NamedEvent extends Event {

	private String id;
	private String newName;
	private String oldName;
	private int changeNameCount;
}
