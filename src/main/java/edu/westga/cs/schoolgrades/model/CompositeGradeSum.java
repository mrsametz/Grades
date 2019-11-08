package edu.westga.cs.schoolgrades.model;

import java.text.DecimalFormat;
import java.util.List;

/**
 * This class is a sum strategy for CompositeGrade
 * 
 * @author Ashley Metz
 * @version 10/22/2019
 */
public class CompositeGradeSum implements GradeStrategy {

	@Override
	public double applyStrategy(List<Grade> list) {
		double total = 0.0;
		for (Grade g : list) {
			total += g.getValue();
		}
		return total;
	}

	public String formatDecimal(double sum) {
		DecimalFormat df = new DecimalFormat("#.00");

		return df.format(sum);
	}
}