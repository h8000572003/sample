package io.github.chungtsai.sample.ddd.entity.user;

import org.apache.commons.lang3.StringUtils;

import io.github.chungtsai.sample.ddd.entity.Event;
import io.github.chungtsai.sample.ddd.entity.user.event.NamedEvent;
import io.github.chungtsai.sample.ddd.entity.user.event.VerifiedFailNameEvent;
import io.github.chungtsai.sample.ddd.usecase.user.name.SubmitNameUseCommand;
import io.github.h800572003.exception.ApBusinessException;

public class UserAggregate {

	private String id;// 統一編號
	private String name;
	private int changeNameCount = 0;// 姓名變更次數

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getChangeNameCount() {
		return changeNameCount;
	}

	public void setChangeNameCount(int changeNameCount) {
		this.changeNameCount = changeNameCount;
	}

	public Event changeName(SubmitNameUseCommand command) {
		try {
			this.checkchangeName(command);

			final NamedEvent namedEvent = new NamedEvent();
			namedEvent.setOldName(this.name);
			namedEvent.setNewName(command.getNewNmae());
			namedEvent.setId(id);
			namedEvent.setChangeNameCount(++changeNameCount);
			this.name = command.getNewNmae();
			return namedEvent;
		} catch (ApBusinessException e) {
			VerifiedFailNameEvent verifiedFailNameEvent = new VerifiedFailNameEvent();
			verifiedFailNameEvent.setMessage(e.getMessage());
			return verifiedFailNameEvent;
		}


	}

	private void checkchangeName(SubmitNameUseCommand command) {

		if (StringUtils.equals(command.getNewNmae(), this.name)) {
			throw new ApBusinessException("新舊姓名相同");
		}
		if (StringUtils.isBlank(command.getNewNmae())) {
			throw new ApBusinessException("新姓名空白");
		}
		if (changeNameCount >= 3) {
			throw new ApBusinessException("姓名變更超過三次");
		}
	}

}
