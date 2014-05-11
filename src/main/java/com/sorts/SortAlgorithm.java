package com.sorts;


public abstract class SortAlgorithm <T extends Comparable<T>> {
	private static int	SPACE_FOR_NUM	= 5;

	boolean debug = false;
	
	public abstract T[] sort(T[] array);
	
	public void turnOnDebug(boolean turnOn) {
		debug = turnOn;
	}
	
	protected void draw(T[] array) {
		if(!debug)
			return;
		int length = array.length;
		int level = 0;
		int lastTreeLevel = (int) Math.floor(Math.log(length) / Math.log(2));
		int lastLevel = -1;
		@SuppressWarnings("unused")
		int pos;

		for (int i = 1; i <= length; i++) {

			level = (int) Math.floor(Math.log(i) / Math.log(2));
			if (lastLevel != level) {
				lastLevel = level;
				debug("\n");
			}
			pos = (int) (i % Math.pow(2, level));
			int spaces = (int) (SPACE_FOR_NUM * Math.pow(2, lastTreeLevel) / Math.pow(2, level + 1)) + SPACE_FOR_NUM;
			// System.out.println( i + "-"+ level + ":" + pos + ":"+ spaces);
			debug(repeat(" ", spaces) + array[i - 1]);

		}
		debug("\n");
	}
	protected void debug(String str){
		if(debug)
			System.out.print(str);
	}
	protected static String repeat(String str, int times){
		return new String(new char[times]).replace("\0", str);
	}
}
