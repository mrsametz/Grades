package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a Grade of the composite style.
 * 
 * @author Ashley Metz
 * @version 10/22/2019
 */
public class CompositeGrade implements Grade {

	private GradeStrategy strategy;
	private List<Grade> list;

	public CompositeGrade(GradeStrategy strategy) {
		list = new ArrayList<>();
		this.strategy = strategy;
	}

	@Override
	public double getValue() {

		return strategy.applyStrategy(list);
	}

	public void add(Grade grade) {
		list.add(grade);
	}

	public List<Grade> getAll() {
		return list;
	}

	@Override
	public String toString() {
		String output = "";
		for (Grade g : list) {
			if (output.length() > 0) {
				output += ", ";
			}
			output += g.toString();
		}
		return output;
	}
}