package edu.westga.cs.schoolgrades.model;



import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSumOfGradesStrategyCalculate {

	private static final double DELTA = 0.001;
	private Grade grade0;
	private Grade grade1;
	private Grade grade2;
	
	private List<Grade> grades;
	
	private SumOfGradesStrategy strategy;
	
	@BeforeEach
	public void setup() {
		grade0 = mock(Grade.class);
		grade1 = mock(Grade.class);
		grade2 = mock(Grade.class);
		
		grades = new ArrayList<Grade>();
		
		strategy = new SumOfGradesStrategy();
		
		when(grade0.getValue()).thenReturn(100.00);
		when(grade1.getValue()).thenReturn(100.00);
		when(grade2.getValue()).thenReturn(100.00);
	}
	
	@Test
	public  void shouldNotAllowNullGradesList() {
		assertThrows(IllegalArgumentException.class, () ->{ 
			strategy.calculate(null);
		});
	}
	
	@Test
	public void shouldGiveZeroIfNoGrades() {
		assertEquals(0, strategy.calculate(grades), DELTA);
	}
	
	@Test
	public void shouldCalculateSumOfOneGrades() {
		grades.add(grade0);
		assertEquals(grade0.getValue(), strategy.calculate(grades), DELTA);
	}

	@Test
	public void shouldCalculateSumOManyGrades() {
		grades.add(grade0);
		grades.add(grade1);
		grades.add(grade2);
		assertEquals(300, strategy.calculate(grades), DELTA);
	}
}