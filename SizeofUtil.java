package com.cs635.assignment4.wordprocessor;

public abstract class SizeofUtil {

	public double averageBytes() {
		double size;
		final Runtime runtime = Runtime.getRuntime();		    
		Thread.yield();
		long used1 = memoryUsed(runtime);
		create();
		long used2 = memoryUsed(runtime);
		double avgSize = (double) (used2 - used1);
		if (avgSize == 0) {
		    throw new RuntimeException("Object is not large enough to register, try turning off the TLAB with -XX:-UseTLAB");
		} else {
		    size = avgSize;
		}
		return size;
	}

	protected long memoryUsed(Runtime runtime) {
		return runtime.totalMemory() - runtime.freeMemory();
	}
		  
	protected abstract void create();
}
