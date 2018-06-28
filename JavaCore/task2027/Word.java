package com.javarush.task.task20.task2027;

public class Word {
	private String text;
	private int startX;
	private int startY;
	private int endX;
	private int endY;
	
	public Word(String text){
		this.text = text;
	}
	
	public void setStartPoint(int i, int j){
		startY = i;
		startX = j;
	}
	
	public void setEndPoint(int i, int j){
		endY = i;
		endX = j;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Word){
			Word word = (Word) obj;
			if(text.equals((word).text) && startX == word.startX && 
					startY == word.startY && endX == word.endX && endY == word.endY)
				return true;
		}
		
		return false;		
		
	}
	
	@Override
	public String toString() {
		return String.format("%s - (%d,  %d) - (%d, %d)", text, startX, startY, endX, endY);
	}
}
