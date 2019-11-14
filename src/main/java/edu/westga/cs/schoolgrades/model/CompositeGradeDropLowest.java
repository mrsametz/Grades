package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is decorator for CompositeGrade strategy
 * 
 * @author Ashley Metz
 * @version 10/28/2019
 */
public class CompositeGradeDropLowest implements GradeStrategy {

	private GradeStrategy endStrategy;

	public CompositeGradeDropLowest(GradeStrategy endStrategy) {
		this.endStrategy = endStrategy;
	}

	@Override
	public double applyStrategy(List<Grade> list) {
		List<Grade> notSmallest = new ArrayList<Grade>();
		try {
		Grade lowest = list.get(0);
		
		for (int i = 0; i < list.size(); i++) {
			notSmallest.add(list.get(i));
			if (list.get(i).getValue() < lowest.getValue()) {
				lowest = list.get(i);
			}
		}
		notSmallest.remove(lowest);
		
		}
		catch (IndexOutOfBoundsException exception) {
			System.out.print("A grade must be entered to recalculate the grades");
		}
		return endStrategy.applyStrategy(notSmallest);
	}

}
