package com.freecharge.problem.wordcount.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SourceFile {
	private String fileName = null;
	private String path = null;

	@XmlElement
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@XmlElement
	public void setPath(String fileName) {
		this.path = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public String getPath() {
		return path;
	}

}
