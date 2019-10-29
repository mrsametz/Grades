package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This class contains tests for getValue.
 * 
 * @author Ashley Metz
 * @version 10/28/2019
 */
public class CompositeGradeTestGetValue {
	@Test
	public void testCompositeGradeGetValue() {
		CompositeGradeAverage average = new CompositeGradeAverage();
		CompositeGrade grade = new CompositeGrade(average);

		Grade g = new SimpleGrade(90);
		Grade g1 = new SimpleGrade(80);
		Grade g2 = new SimpleGrade(100);
		grade.add(g);
		grade.add(g1);
		grade.add(g2);

		assertEquals(grade.getValue(), 90, 0);
	}
	
	@Test
	public void testCompositeGradeGetValueFiveGrades() {
		CompositeGradeAverage average = new CompositeGradeAverage();
		CompositeGrade grade = new CompositeGrade(average);

		Grade g = new SimpleGrade(90);
		Grade g1 = new SimpleGrade(80);
		Grade g2 = new SimpleGrade(100);
		Grade g3 = new SimpleGrade(90);
		Grade g4 = new SimpleGrade(30);
		grade.add(g);
		grade.add(g1);
		grade.add(g2);
		grade.add(g3);
		grade.add(g4);

		assertEquals(grade.getValue(), 78.0, 0);
	}
}
