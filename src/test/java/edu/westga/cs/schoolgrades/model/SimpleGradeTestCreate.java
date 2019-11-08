package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class contains tests for creating a simple Grade.
 * 
 * @author Ashley Metz
 * @version 10/22/2019
 */
public class SimpleGradeTestCreate {

	@Test
	public void testCreateSimpleGrade() {
		SimpleGrade grade = new SimpleGrade(50.5);
		assertEquals(grade.toString(), "50.5");
	}
	
	@Test
	public void testCreateSimpleGradeTwo() {
		SimpleGrade grade = new SimpleGrade(55.5);
		assertEquals(grade.toString(), "55.5");
		
	}

}
