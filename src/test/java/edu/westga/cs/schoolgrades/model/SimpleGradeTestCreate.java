package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleGradeTestCreate {

	@Test
	public void testCreateSimpleGrade() {
		SimpleGrade one = new SimpleGrade(50.5);
		one.toString();
		assertEquals(one.toString(), "50.5");
		
	}

}
