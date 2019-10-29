package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This class contains tests for applyStrategy.
 * 
 * @author Ashley Metz
 * @version 10/28/2019
 */
public class CompositeGradeDropLowestTestApplyStrategy {

	@Test
	public void testCompositeGradeDropLowestWithAverageStrategy() {
		CompositeGradeAverage average = new CompositeGradeAverage();
		CompositeGradeDropLowest lowest = new CompositeGradeDropLowest(average);
		CompositeGrade grade = new CompositeGrade(lowest);

		Grade g = new SimpleGrade(50);
		Grade g1 = new SimpleGrade(80);
		Grade g2 = new SimpleGrade(100);
		grade.add(g);
		grade.add(g1);
		grade.add(g2);

		assertEquals(grade.getValue(), 90, 0);
	}

	@Test
	public void testCompositeGradeDropLowestWithSumStrategy() {
		CompositeGradeSum sum = new CompositeGradeSum();
		CompositeGradeDropLowest lowest = new CompositeGradeDropLowest(sum);
		CompositeGrade grade = new CompositeGrade(lowest);

		Grade g = new SimpleGrade(50);
		Grade g1 = new SimpleGrade(80);
		Grade g2 = new SimpleGrade(100);
		grade.add(g);
		grade.add(g1);
		grade.add(g2);

		assertEquals(grade.getValue(), 180, 0);
	}
}
