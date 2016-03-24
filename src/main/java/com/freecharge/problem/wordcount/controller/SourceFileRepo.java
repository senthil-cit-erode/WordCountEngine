package com.freecharge.problem.wordcount.controller;

import java.util.ArrayList;
import java.util.List;

import com.freecharge.problem.wordcount.models.SourceFile;

public class SourceFileRepo {
	private List<SourceFile> sourceFileList = new ArrayList<SourceFile>();
	private static SourceFileRepo sourceFileRepo;

	static {
		sourceFileRepo = new SourceFileRepo();
	}

	private SourceFileRepo() {

	}

	public static SourceFileRepo getInstance() {
		return sourceFileRepo;
	}

	public void addSourceFile(String file) {
		if (file != null) {
			SourceFile sourceFile = new SourceFile();
			String fileName;
			String path;
			int index = 0;
			index = file.lastIndexOf('/') >= 0 ? file.lastIndexOf('/')
					: file.lastIndexOf('\\') >= 0 ? file.lastIndexOf('\\') : -1;

			if (index != -1) {
				path = file.substring(0, index);
				fileName = file.substring(index + 1, file.length());
				sourceFile.setFileName(fileName);
				sourceFile.setPath(path);
				sourceFileList.add(sourceFile);
			}
		}
	}

	public List<SourceFile> getSourceFileList() {
		return sourceFileList;
	}

}
