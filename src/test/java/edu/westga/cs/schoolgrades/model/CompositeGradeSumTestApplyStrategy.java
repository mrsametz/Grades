/**
 * 
 */
package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This class contains tests for applyStrategy.
 * 
 * @author Ashley Metz
 * @version 10/22/2019
 */
public class CompositeGradeSumTestApplyStrategy {
	@Test
	public void testCompositeGradeSumStrategy() {
		CompositeGradeSum sum = new CompositeGradeSum();
		CompositeGrade grade = new CompositeGrade(sum);

		Grade g = new SimpleGrade(50);
		Grade g1 = new SimpleGrade(50);
		grade.add(g);
		grade.add(g1);

		assertEquals(sum.applyStrategy(grade.getAll()), 100, 0);
	}

	@Test
	public void testCompositeGradeSumStrategyFourGrades() {
		CompositeGradeSum sum = new CompositeGradeSum();
		CompositeGrade grade = new CompositeGrade(sum);

		Grade g = new SimpleGrade(50);
		Grade g1 = new SimpleGrade(50);
		Grade g2 = new SimpleGrade(90.65);
		Grade g3 = new SimpleGrade(55.67);

		grade.add(g);
		grade.add(g1);
		grade.add(g2);
		grade.add(g3);

		assertEquals(sum.applyStrategy(grade.getAll()), 246.32, 0);
	}
}
