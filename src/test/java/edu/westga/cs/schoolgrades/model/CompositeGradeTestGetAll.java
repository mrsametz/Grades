package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * This class contains tests for getAll.
 * 
 * @author Ashley Metz
 * @version 10/28/2019
 */
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
	
	@Test
	public void testAddGradeThreeGrades() {
		CompositeGradeSum sum = new CompositeGradeSum();
		CompositeGrade grade = new CompositeGrade(sum);
		
		Grade g = new SimpleGrade(50);
		Grade g1 = new SimpleGrade(50);
		Grade g2 = new SimpleGrade(100);
		Grade g3 = new SimpleGrade(50.5);
		
		grade.add(g);
		grade.add(g1);
		grade.add(g2);
		grade.add(g3);
		
		List<Grade> list = Arrays.asList(g, g1, g2, g3);
		assertEquals(grade.getAll(), list);
	}
	
	@Test
	public void testAddGradeFiveGrades() {
		CompositeGradeSum sum = new CompositeGradeSum();
		CompositeGrade grade = new CompositeGrade(sum);
		
		Grade g = new SimpleGrade(50);
		Grade g1 = new SimpleGrade(50);
		Grade g2 = new SimpleGrade(100);
		Grade g3 = new SimpleGrade(50.5);
		Grade g4 = new SimpleGrade(100);
		Grade g5 = new SimpleGrade(50.5);
		
		grade.add(g);
		grade.add(g1);
		grade.add(g2);
		grade.add(g3);
		grade.add(g4);
		grade.add(g5);
		
		List<Grade> list = Arrays.asList(g, g1, g2, g3, g4, g5);
		assertEquals(grade.getAll(), list);
	}
}
