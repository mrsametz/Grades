package edu.westga.cs.schoolgrades.model;

import java.util.List;

/**
 * This class is an interface for the grading strategy.
 * 
 * @author Ashley Metz
 * @version 10/22/2019
 */
public interface GradeStrategy {
	
	public double applyStrategy(List<Grade> list);
}
