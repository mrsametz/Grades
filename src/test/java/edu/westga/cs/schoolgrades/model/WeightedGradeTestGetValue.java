package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This class tests getValue for WeightedGrade.
 * 
 * @author Ashley Metz
 * @version 10/28/2019
 */
public class WeightedGradeTestGetValue {
	@Test
	public void testWeightedGradeGetValueTwoGrades() {
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
	
	@Test
	public void testWeightedGradeGetValueThreeGrades() {
		CompositeGradeSum summer = new CompositeGradeSum();
		CompositeGrade grade = new CompositeGrade(summer);

		Grade g = new SimpleGrade(100);
		Grade g1 = new SimpleGrade(60);
		Grade g2 = new SimpleGrade(100);

		WeightedGrade wg = new WeightedGrade(0.75, g);
		WeightedGrade wg1 = new WeightedGrade(0.20, g1);
		WeightedGrade wg2 = new WeightedGrade(0.05, g2);

		grade.add(wg);
		grade.add(wg1);
		grade.add(wg2);

		assertEquals(grade.getValue(), 92.0, 0);
	}
	
	@Test
	public void testWeightedGradeGetValueFourGrades() {
		CompositeGradeSum summer = new CompositeGradeSum();
		CompositeGrade grade = new CompositeGrade(summer);

		Grade g = new SimpleGrade(100);
		Grade g1 = new SimpleGrade(60);
		Grade g2 = new SimpleGrade(100);
		Grade g3 = new SimpleGrade(96.5);

		WeightedGrade wg = new WeightedGrade(0.75, g);
		WeightedGrade wg1 = new WeightedGrade(0.15, g1);
		WeightedGrade wg2 = new WeightedGrade(0.05, g2);
		WeightedGrade wg3 = new WeightedGrade(0.05, g3);

		grade.add(wg);
		grade.add(wg1);
		grade.add(wg2);
		grade.add(wg3);

		assertEquals(grade.getValue(), 93.825, 0);
	}
}
