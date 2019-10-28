package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
import java.util.List;

public class CompositeGradeDropLowest implements GradeStrategy{

	private GradeStrategy endStrategy;
	public CompositeGradeDropLowest(GradeStrategy endStrategy) {
		this.endStrategy = endStrategy;
	}
	
	@Override
	public double applyStrategy(List<Grade> list) {
		List<Grade> notSmallest = new ArrayList<Grade>();
		Grade lowest = list.get(0);
		for(int i=0;i<list.size();i++) {
			notSmallest.add(list.get(i));
			if(list.get(i).getValue() < lowest.getValue()) {
				lowest = list.get(i);
			}
		}
		notSmallest.remove(lowest);
		return endStrategy.applyStrategy(notSmallest);
		
	
	}
	

}
