package edu.westga.cs.schoolgrades.model;

import java.text.DecimalFormat;
import java.util.List;

/**
 * This class is an average strategy for CompositeGrade
 * 
 * @author Ashley Metz
 * @version 10/22/2019
 */
public class CompositeGradeAverage implements GradeStrategy {


	@Override
	public double applyStrategy(List<Grade> list) {
		double total = 0.0;
		
		for(Grade g : list) {
			total += g.getValue();
		}
		return total/list.size();
	}
	

	public String formatDecimal(double average) {
		DecimalFormat df = new DecimalFormat("#.00");
	
		return df.format(average);
	}
	
}