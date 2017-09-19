package io.dandan.github.task.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilsTest {
	
	@Test
	public void test_null() {
		assertTrue(StringUtils.isEmpty(null));
	}
	
	@Test
	public void test_empty() {
		assertTrue(StringUtils.isEmpty(""));
	}
	
	@Test
	public void test_blank() {
		assertTrue(StringUtils.isEmpty("  "));
	}
}
