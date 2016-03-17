package com.freecharge.problem.wordcount.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WordCount {
	int count;
	String word;
	
	@XmlElement
	public void setCount(int count){
		this.count = count;
	}
	
	@XmlElement
	public void setWord(String word){
		this.word = word;
	}
	
	public int getCount(){
		return count;
	}
	
	public String getWord(){
		return word;
	}

}
