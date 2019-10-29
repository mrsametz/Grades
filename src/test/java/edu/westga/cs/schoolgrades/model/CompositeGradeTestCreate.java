package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This class contains tests for creating a composite grade.
 * 
 * @author Ashley Metz
 * @version 10/22/2019
 */
public class CompositeGradeTestCreate {

	@Test
	public void testCreateCompositeGrade() {
		CompositeGradeAverage average = new CompositeGradeAverage();
		CompositeGrade grade = new CompositeGrade(average);
		assertEquals(grade.toString(), "");
	}
}
