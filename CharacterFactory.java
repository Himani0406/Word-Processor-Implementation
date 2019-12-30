package com.cs635.assignment4.wordprocessor;

import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {

	private static Map<java.lang.Character, Character> charList = new HashMap<>();
	
	private CharacterFactory() {}
	
	private static class SingletonHolder {
		 private final static CharacterFactory INSTANCE = new CharacterFactory();
	}
	
	public static CharacterFactory instance() {
		return SingletonHolder.INSTANCE;
	}
	
	public Character getCharacter(char word) {
		Character character = null;
		
		if(charList.containsKey(word)) {
			character = charList.get(word);
		}else {
			character = new Character(word);
			charList.put(word, character);
		}
		return character;
	}
}
