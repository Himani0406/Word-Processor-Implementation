package com.cs635.assignment4.wordprocessor;

import java.awt.Font;

//Class to test the bytes in case Flyweight is not used
public class UnsharedCharacter {

	private Character character;
	private Font font;
		
	public UnsharedCharacter(Character character, Font font){
		
		this.character = character;
		this.font = font;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}
}
