package com.cs635.assignment4.wordprocessor;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

public class FontFactory {

	private List<Font> fontArray = new  ArrayList<Font>();
	
	private FontFactory() {}
	
	private static class SingletonHolder {
		 private final static FontFactory INSTANCE = new FontFactory();
	}
	
	public static FontFactory instance() {
		return SingletonHolder.INSTANCE;
	}
	
	public Font getFont(String name, int style, int size ){
    	
		for(Font font : fontArray ){
			if(font.getName().equals(name) && style == font.getStyle() && size == font.getSize()){
				return font;
			}
		}
		
		Font font = new Font(name, style, size);
		fontArray.add(font);
		return font;
		
	}
}
