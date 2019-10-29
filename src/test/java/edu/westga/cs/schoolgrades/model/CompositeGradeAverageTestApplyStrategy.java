package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This class contains tests for applyStrategy.
 * 
 * @author Ashley Metz
 * @version 10/28/2019
 */
public class CompositeGradeAverageTestApplyStrategy {
	@Test
	public void CompositeGradeTestAverageApplyStrategyThreeGrades() {
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

	@Test
	public void CompositeGradeTestAverageApplyStrategySixGrades() {
		CompositeGradeAverage average = new CompositeGradeAverage();
		CompositeGrade grade = new CompositeGrade(average);

		Grade g = new SimpleGrade(50);
		Grade g1 = new SimpleGrade(75);
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

		assertEquals(average.applyStrategy(grade.getAll()), 79.16, 2);
	}

	@Test
	public void CompositeGradeTestAverageApplyStrategyTenGrades() {
		CompositeGradeAverage average = new CompositeGradeAverage();
		CompositeGrade grade = new CompositeGrade(average);

		Grade g = new SimpleGrade(50);
		Grade g1 = new SimpleGrade(75);
		Grade g2 = new SimpleGrade(100);
		Grade g3 = new SimpleGrade(50);
		Grade g4 = new SimpleGrade(100);
		Grade g5 = new SimpleGrade(100);
		Grade g6 = new SimpleGrade(100);
		Grade g7 = new SimpleGrade(50);
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

		assertEquals(average.applyStrategy(grade.getAll()), 82.15, 2);
	}
}
