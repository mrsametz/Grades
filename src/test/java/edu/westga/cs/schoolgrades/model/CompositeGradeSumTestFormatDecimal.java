package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This class contains tests for Format Decimal.
 * 
 * @author Ashley Metz
 * @version 10/29/2019
 */
public class CompositeGradeSumTestFormatDecimal {
	@Test
	public void CompositeGradeTestSumFormatDecimalThreeGrades() {
		CompositeGradeSum sum = new CompositeGradeSum();
		CompositeGrade grade = new CompositeGrade(sum);

		Grade g = new SimpleGrade(50);
		Grade g1 = new SimpleGrade(75);
		Grade g2 = new SimpleGrade(100);
		grade.add(g);
		grade.add(g1);
		grade.add(g2);

		assertEquals(sum.formatDecimal(sum.applyStrategy(grade.getAll())), "225.00");
	}
	
	@Test
	public void CompositeGradeTestAverageFormatDecimalSixGrades() {
		CompositeGradeSum sum = new CompositeGradeSum();
		CompositeGrade grade = new CompositeGrade(sum);

		Grade g = new SimpleGrade(50.45);
		Grade g1 = new SimpleGrade(75.6);
		Grade g2 = new SimpleGrade(100);
		Grade g3 = new SimpleGrade(50);
		Grade g4 = new SimpleGrade(100);
		Grade g5 = new SimpleGrade(100);
		grade.add(g);
		grade.add(g1);
		grade.add(g2);
		grade.add(g3);
		grade.add(g4);
		grade.add(g5);
		
		assertEquals(sum.formatDecimal(sum.applyStrategy(grade.getAll())), "476.05");
	}
	
	@Test
	public void CompositeGradeTestAverageDecimalFormatTenGrades() {
		CompositeGradeSum sum = new CompositeGradeSum();
		CompositeGrade grade = new CompositeGrade(sum);

		Grade g = new SimpleGrade(50);
		Grade g1 = new SimpleGrade(75.25);
		Grade g2 = new SimpleGrade(100);
		Grade g3 = new SimpleGrade(50);
		Grade g4 = new SimpleGrade(100);
		Grade g5 = new SimpleGrade(100);
		Grade g6 = new SimpleGrade(100);
		Grade g7 = new SimpleGrade(50.25);
		Grade g8 = new SimpleGrade(100);
		Grade g9 = new SimpleGrade(100);
		grade.add(g);
		grade.add(g1);
		grade.add(g2);
		grade.add(g3);
		grade.add(g4);
		grade.add(g5);
		grade.add(g6);
		grade.add(g7);
		grade.add(g8);
		grade.add(g9);


		assertEquals(sum.formatDecimal(sum.applyStrategy(grade.getAll())), "825.50");
	}
}
