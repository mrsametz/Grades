package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
import java.util.List;

public class CompositeGrade implements Grade {

	private GradeStrategy strategy;
	private List<Grade> list;

	
	public CompositeGrade() {
		list = new ArrayList<>();
		
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
		for(Grade g : list) {
			if(output.length() > 0) {
				output += ", ";
			}
			output += g.toString();
		}
		return output;
		
	}
}