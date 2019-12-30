package com.cs635.assignment4.wordprocessor.test;

import java.awt.Font;
import org.junit.Test;
import com.cs635.assignment4.wordprocessor.Character;
import com.cs635.assignment4.wordprocessor.FontFactory;
import com.cs635.assignment4.wordprocessor.RunArray;
import com.cs635.assignment4.wordprocessor.SizeofUtil;
import com.cs635.assignment4.wordprocessor.UnsharedCharacter;
import com.cs635.assignment4.wordprocessor.CharacterFactory;

public class WordProcessorTest {

	@Test
	public void testFlyweight(){

		System.out.printf("The average size using Flyweight is %.1f bytes%n", new SizeofUtil() {
			
			@Override
			protected void create() {
			
				CharacterFactory charfactory = CharacterFactory.instance();
				FontFactory fontfactory = FontFactory.instance();
					    
				String input = "CS 635 Advanced Object-Oriented Design & Programming\n" + 
								"Fall Semester, 2018\n" + 
								"Doc 17 Mediator, Flyweight, Facade, Demeter, Active Object\n" + 
								"Nov 19, 2019\n" + 
								"Copyright ©, All rights reserved. 2019 SDSU & Roger Whitney, 5500 Campanile Drive, San" + 
								"Diego, CA 92182-7700 USA. OpenContent (http://www.opencontent.org/opl.shtml) license defines the copyright on this document.";
						
				Character [] chArray = new Character[input.length()];
				
				for(int i=0; i < input.length(); i++){
					chArray[i] = charfactory.getCharacter(input.charAt(i));
				}
					    	      
				RunArray runArray = new RunArray();
				runArray.add(0, 144, fontfactory.getFont("Verdana", Font.BOLD, 13));
				runArray.add(140, 4, fontfactory.getFont("Verdana", Font.ITALIC, 13));
				runArray.append(212, fontfactory.getFont("Verdana", Font.ITALIC, 12));
					    
			}
		}.averageBytes());
	}
	
	@Test
	  public void testWithoutFlyweight() {	
		
	    System.out.printf("The average size without Flyweight is %.1f bytes%n", new SizeofUtil() {
	    	 
		    @Override
		    protected void create() {
	
		    	String input = "CS 635 Advanced Object-Oriented Design & Programming\n" + 
						"Fall Semester, 2018\n" + 
						"Doc 17 Mediator, Flyweight, Facade, Demeter, Active Object\n" + 
						"Nov 19, 2019\n" + 
						"Copyright ©, All rights reserved. 2019 SDSU & Roger Whitney, 5500 Campanile Drive, San" + 
						"Diego, CA 92182-7700 USA. OpenContent (http://www.opencontent.org/opl.shtml) license defines the copyright on this document.";
				
			    UnsharedCharacter[] chArray = new UnsharedCharacter[input.length()];
			    
			    for(int i=0 ; i < 143; i++){
			    	chArray[i] = (new UnsharedCharacter(new Character(input.charAt(i)),new Font("Verdana", Font.BOLD, 13)));
				}
				    	      
				for(int i=144 ; i < input.length(); i++){
					chArray[i] = (new UnsharedCharacter(new Character(input.charAt(i)),new Font("Verdana", Font.ITALIC, 12)));   	    	 
				}
		    }
		 }.averageBytes());
	}
}
