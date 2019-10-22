package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCompositeGradeAverageApplyStrategy {
	@Test
	public void testCompositeGradeAverageStrategy() {
		CompositeGrade grade = new CompositeGrade();
		CompositeGradeAverage average  = new CompositeGradeAverage();
		
		Grade g = new SimpleGrade(50);
		Grade g1 = new SimpleGrade(75);
		Grade g2 = new SimpleGrade(100);
		grade.add(g);
		grade.add(g1);
		grade.add(g2);
		average.applyStrategy(grade.getAll());
		
		assertEquals(75, 75, 0);
	}
}
