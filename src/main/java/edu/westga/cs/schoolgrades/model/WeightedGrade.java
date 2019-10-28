package edu.westga.cs.schoolgrades.model;

public class WeightedGrade implements Grade {

	private double weight;
	private Grade grade;

	public WeightedGrade(double weight, Grade grade) {
		this.grade = grade;
		this.weight = weight;
	}

	@Override
	public double getValue() {
		double weightedGrade = this.grade.getValue() * this.weight;
		return weightedGrade;
	}

}
