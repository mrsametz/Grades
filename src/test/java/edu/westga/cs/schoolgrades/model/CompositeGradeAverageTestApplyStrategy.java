package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CompositeGradeAverageTestApplyStrategy {
	@Test
	public void CompositeGradeTestAverageApplyStrategy() {
		CompositeGradeAverage average = new CompositeGradeAverage();
		CompositeGrade grade = new CompositeGrade(average);

		Grade g = new SimpleGrade(50);
		Grade g1 = new SimpleGrade(75);
		Grade g2 = new SimpleGrade(100);
		grade.add(g);
		grade.add(g1);
		grade.add(g2);

		assertEquals(average.applyStrategy(grade.getAll()), 75, 0);
	}
}
