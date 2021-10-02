/**
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package com.nullpointerworks.audio;

/**
 * 
 * @author Michiel Drost - Nullpointer Works
 */
public interface AudioSample 
{
	/**
	 * 
	 */
	void play();
	
	/**
	 * 
	 */
	void pause();
	
	/**
	 * 
	 */
	void resume();
	
	/**
	 * 
	 */
	void stop();
	
	/**
	 * 
	 */
	void jump(long ms);
	
	/**
	 * 
	 */
	void restart();
	
}
