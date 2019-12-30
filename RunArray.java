package com.cs635.assignment4.wordprocessor;

import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RunArray {

	private Map<Font, List<int[]>> fonts;
	private int index;
	
	public RunArray() {
		fonts = new HashMap<>();
		index = 0;
	}
	
	public void add(int startIndex, int count, Font font) {
		int endIndex = startIndex + count;
		deleteExisting(startIndex, endIndex, font);
		addIndex(startIndex, endIndex, font);
		if(index < endIndex) {
			index = endIndex;
		}
	}
	
	private void addIndex(int startIndex, int endIndex, Font font) {
		if(!fonts.containsKey(font)) {
			List<int[]> pair = new ArrayList<>();
			pair.add(new int[]{startIndex, endIndex});
			fonts.put(font, pair);
		}else {
			fonts.get(font).add(new int[] {startIndex, endIndex});
		}
	}

	private void deleteExisting(int startIndex, int endIndex, Font font) {
		int count = 0;
		for(Map.Entry<Font, List<int[]>> entry : fonts.entrySet()) {
			if(font != entry.getKey()) {
				for(var indices : entry.getValue()) {
					if(indices[0] <= startIndex || indices[1] >= endIndex) {
						if(indices[1] < endIndex) {
							count = startIndex - indices[0];
							if(count > 0) {
								addIndex(indices[0], startIndex - 1, entry.getKey());
							}
						}else if(indices[0] > startIndex) {
							count = indices[1] - endIndex;
							if(count > 0) {
								addIndex(endIndex+1, indices[1], entry.getKey());
							}
						}else {
							count = startIndex - indices[0];
							if(count > 0) {
								addIndex(indices[0], startIndex - 1, entry.getKey());
							}
							count = indices[1] - endIndex;
							if(count > 0) {
								addIndex(endIndex+1, indices[1], entry.getKey());
							}
						}
						entry.getValue().remove(indices);
					}
				}
			}
		}
	}

	public void append(int count, Font font) {
		addIndex(index, index + count, font);
		index += count;
	}

	public Font getFont(int index) {
		for(Map.Entry<Font, List<int[]>> entry : fonts.entrySet()) {
			for(var v : entry.getValue()) {
				if(v[0] <= index && v[1] >= index) {
					return entry.getKey();
				}
			}
		}
		return null;
	}

}
