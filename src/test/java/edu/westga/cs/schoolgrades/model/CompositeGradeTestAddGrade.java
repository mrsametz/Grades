package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This class contains tests for addGrade.
 * 
 * @author Ashley Metz
 * @version 10/22/2019
 */
public class CompositeGradeTestAddGrade {

	@Test
	public void testAddGrade() {
		CompositeGradeSum sum = new CompositeGradeSum();
		CompositeGrade grade = new CompositeGrade(sum);
		Grade g = new SimpleGrade(50);
		grade.add(g);
		assertEquals(grade.toString(), "50.0");
	}
	
	@Test
	public void testAddGradeTwoGrades() {
		CompositeGradeSum sum = new CompositeGradeSum();
		CompositeGrade grade = new CompositeGrade(sum);
		Grade g = new SimpleGrade(50);
		Grade g1 = new SimpleGrade(50);
		grade.add(g);
		grade.add(g1);
		assertEquals(grade.toString(), "50.0, 50.0");
	}
	
	@Test
	public void testAddGradeThreeGrades() {
		CompositeGradeSum sum = new CompositeGradeSum();
		CompositeGrade grade = new CompositeGrade(sum);
		Grade g = new SimpleGrade(50);
		Grade g1 = new SimpleGrade(50);
		Grade g2 = new SimpleGrade(80.5);
		grade.add(g);
		grade.add(g1);
		grade.add(g2);
		assertEquals(grade.toString(), "50.0, 50.0, 80.5");
	}
}
