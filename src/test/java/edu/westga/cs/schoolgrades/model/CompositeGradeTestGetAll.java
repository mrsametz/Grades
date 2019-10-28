package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CompositeGradeTestGetAll {
	@Test
	public void testAddGrade() {
		CompositeGradeSum sum = new CompositeGradeSum();
		CompositeGrade grade = new CompositeGrade(sum);
		
		Grade g = new SimpleGrade(50);
		grade.add(g);
		Grade g1 = new SimpleGrade(50);
		grade.add(g1);
		List<Grade> list = Arrays.asList(g, g1);
		assertEquals(grade.getAll(), list);
	}
}
