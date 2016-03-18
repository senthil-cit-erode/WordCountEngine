package com.freecharge.problem.wordcount.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import com.freecharge.problem.wordcount.config.FolderConfig;
import com.freecharge.problem.wordcount.models.WordCount;

public class WordSearch {
	private HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
	private static WordSearch wordSearch = null;

	static {
		try {
			wordSearch = new WordSearch();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private WordSearch() throws IOException {
		init();
	}

	public static WordSearch getInstance() {
		return wordSearch;
	}

	private void init() throws IOException {
		if (wordMap.isEmpty()) {
			listFilesFromFolder(new File(FolderConfig.getInstance().getFolderName()));
		}
	}

	public void listFilesFromFolder(final File folder) throws IOException {
		if (folder.isDirectory()) {
			for (final File fileEntry : folder.listFiles()) {
				if (fileEntry.isDirectory()) {
					listFilesFromFolder(fileEntry);
				} else {
					loadMap(fileEntry);
				}
			}
		} else {
			if(folder.getAbsolutePath().endsWith(".txt")){
				System.out.println("Adding file : "+folder.getAbsolutePath());
				loadMap(folder);
			} else {
				System.out.println("Skipping file : "+folder.getAbsolutePath());
			}
		}
	}

	private void loadMap(File fileToAdd) throws IOException {
		BufferedReader br = null;
		try {

			String line;

			br = new BufferedReader(new FileReader(fileToAdd));

			while ((line = br.readLine()) != null) {
				String str[] = line.split(" ");
				int length = str.length;
				while (length > 0) {
					setWord(str[length - 1]);
					length--;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

	private void setWord(String word) {
		word = word.toLowerCase();
		int count = 1;
		if (wordMap.containsKey(word)) {
			count = wordMap.get(word);
			count++;
		}
		wordMap.put(word, count);
	}

	public WordCount getCount(String word) {
		WordCount wordCount = new WordCount();
		if (wordMap.containsKey(word.toLowerCase())) {
			wordCount.setCount(wordMap.get(word.toLowerCase()));
		} else {
			wordCount.setCount(0);
		}
		wordCount.setWord(word);
		return wordCount;
	}

}
