package edu.westga.cs.schoolgrades.model;

import java.util.List;

/**
 * This class is a sum strategy for CompositeGrade
 * 
 * @author Ashley Metz
 * @version 10/22/2019
 */
public class CompositeGradeSum implements GradeStrategy{
	
	@Override
	public double applyStrategy(List<Grade> list) {
		double total = 0.0;
		for(Grade g : list) {
			total += g.getValue();
		}
		return total;
	}
}
