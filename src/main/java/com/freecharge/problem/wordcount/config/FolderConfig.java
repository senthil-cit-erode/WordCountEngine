package com.freecharge.problem.wordcount.config;

public class FolderConfig {
	private String folderName = null;
	private static FolderConfig folderConfig;

	static {
		folderConfig = new FolderConfig();
	}

	private FolderConfig() {

	}

	public static FolderConfig getInstance() {
		return folderConfig;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

}
