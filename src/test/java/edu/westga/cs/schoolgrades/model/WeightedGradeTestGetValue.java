package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WeightedGradeTestGetValue {
	@Test
	public void testWeightedGradeGetValue() {
		CompositeGradeSum summer = new CompositeGradeSum();
		CompositeGrade grade = new CompositeGrade(summer);

		Grade g = new SimpleGrade(100);
		Grade g1 = new SimpleGrade(60);

		WeightedGrade wg = new WeightedGrade(0.75, g);
		WeightedGrade wg1 = new WeightedGrade(0.25, g1);

		grade.add(wg);
		grade.add(wg1);

		assertEquals(grade.getValue(), 90, 0);
	}
}
