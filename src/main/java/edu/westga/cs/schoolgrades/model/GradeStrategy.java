package edu.westga.cs.schoolgrades.model;

import java.util.List;

public interface GradeStrategy {
	
	public double applyStrategy(List<Grade> list);
}
