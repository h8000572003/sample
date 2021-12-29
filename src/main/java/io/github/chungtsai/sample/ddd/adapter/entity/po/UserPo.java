package io.github.chungtsai.sample.ddd.adapter.entity.po;

public class UserPo {

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

}
