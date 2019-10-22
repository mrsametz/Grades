/**
 * 
 */
package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author mrsas
 *
 */
public class CompositeGradeSumTestApplyStrategy {
	@Test
	public void testCompositeGradeSumStrategy() {
		CompositeGrade grade = new CompositeGrade();
		CompositeGradeSum sum  = new CompositeGradeSum();
		
		Grade g = new SimpleGrade(50);
		Grade g1 = new SimpleGrade(50);
		grade.add(g);
		grade.add(g1);
		sum.applyStrategy(grade.getAll());
		
		assertEquals(100, 100, 0);
	}
}
