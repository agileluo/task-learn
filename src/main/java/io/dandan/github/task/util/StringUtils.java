package io.dandan.github.task.util;

public class StringUtils {
	public static boolean isEmpty(String s) {
		if(s == null) {
			return true;
		}
		if(s.length() == 0 && s.trim().length() == 0) {
			return true;
		}
		return false;
	}
}
