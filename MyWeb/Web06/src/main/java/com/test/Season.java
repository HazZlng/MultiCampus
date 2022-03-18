package com.test;

public class Season {
	private String[] selectSEASON = { "Spring", "Summer", "Fall", "Winter" };

	public String[] getSelectSEASON() {
		return selectSEASON;
	}

	public void setSelectSEASON(String[] selectSEASON) {
		this.selectSEASON = selectSEASON;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Season() {
	}

	private String name;
}
