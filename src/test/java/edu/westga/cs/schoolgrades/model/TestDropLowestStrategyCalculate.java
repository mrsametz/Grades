package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

public class TestDropLowestStrategyCalculate {

	private DropLowestStrategy dropLowestStrategy;
	private GradeCalculationStrategy childStrategy;

//	private static final double DELTA = 0.001;
	private Grade grade0;
	private Grade grade1;
	private Grade grade2;

	private List<Grade> grades;
	private List<Grade> gradesMinusLowest;

	@BeforeEach
	public void setUp() throws Exception {
		grade0 = mock(Grade.class);
		grade1 = mock(Grade.class);
		grade2 = mock(Grade.class);

		grades = new ArrayList<Grade>();
		gradesMinusLowest = new ArrayList<Grade>();
		childStrategy = mock(GradeCalculationStrategy.class);
		dropLowestStrategy = new DropLowestStrategy(childStrategy);
		when(grade0.getValue()).thenReturn(10.00);
		when(grade1.getValue()).thenReturn(20.00);
		when(grade2.getValue()).thenReturn(30.00);
	}

	
	@Test
	public void shouldNotAllowNullGradesList() {
		
		assertThrows(IllegalArgumentException.class, () -> {
		
			dropLowestStrategy.calculate(null);
		});
	}

	@Test
	public void shouldNotDropLowestIfGradesListIsEmpty() {
		//assertEquals(0, dropLowestStrategy.calculate(grades), DELTA);
		dropLowestStrategy.calculate(grades);
		Mockito.verify(childStrategy).calculate(grades);
	}

	public void shouldNotDropLowestIfGradesListHasOneElement() {
		grades.add(grade0);
		dropLowestStrategy.calculate(grades);
		gradesMinusLowest.add(grade0);
		Mockito.verify(childStrategy).calculate(gradesMinusLowest);
	}

	@Test
	public void canDropWhenLowestIsFirst() {
		grades.add(grade0);
		grades.add(grade1);
		grades.add(grade2);
		dropLowestStrategy.calculate(grades);
		gradesMinusLowest.add(grade1);
		gradesMinusLowest.add(grade2);
		Mockito.verify(childStrategy).calculate(gradesMinusLowest);

	}

	@Test
	public void canDropWhenLowestIsLast() {
		grades.add(grade1);
		grades.add(grade2);
		grades.add(grade0);
		dropLowestStrategy.calculate(grades);
		gradesMinusLowest.add(grade1);
		gradesMinusLowest.add(grade2);
		Mockito.verify(childStrategy).calculate(gradesMinusLowest);
	}

	@Test
	public void canDropWhenLowestIsInMiddle() {
		grades.add(grade1);
		grades.add(grade0);
		grades.add(grade2);
		dropLowestStrategy.calculate(grades);
		gradesMinusLowest.add(grade1);
		gradesMinusLowest.add(grade2);
		Mockito.verify(childStrategy).calculate(gradesMinusLowest);
	}

	@Test
	public void dropsOnlyOneIfThereAreMultipleLowestGrades() {
		grades.add(grade1);
		grades.add(grade0);
		grades.add(grade2);
		grades.add(grade0);
		dropLowestStrategy.calculate(grades);
		gradesMinusLowest.add(grade1);
		gradesMinusLowest.add(grade2);
		gradesMinusLowest.add(grade0);
		Mockito.verify(childStrategy).calculate(gradesMinusLowest);
	}

}
