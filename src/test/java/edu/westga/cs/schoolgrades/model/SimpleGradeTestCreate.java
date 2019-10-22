package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleGradeTestCreate {

	@Test
	public void testCreateSimpleGrade() {
		SimpleGrade grade = new SimpleGrade(50.5);
		assertEquals(grade.toString(), "50.5");
		
	}

}
