package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CompositeGradeDropLowestTestApplyStrategy {

	@Test
	public void testCompositeGradeAverageStrategy() {
		CompositeGradeAverage average = new CompositeGradeAverage();
		CompositeGradeDropLowest lowest  = new CompositeGradeDropLowest(average);
		CompositeGrade grade = new CompositeGrade(lowest);
		
		
		Grade g = new SimpleGrade(50);
		Grade g1 = new SimpleGrade(80);
		Grade g2 = new SimpleGrade(100);
		grade.add(g);
		grade.add(g1);
		grade.add(g2);
		
		
		assertEquals(grade.getValue(), 90, 0);
	}
}
