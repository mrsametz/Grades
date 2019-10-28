package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

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
}
