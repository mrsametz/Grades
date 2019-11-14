package edu.westga.cs.schoolgrades.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.CompositeGradeAverage;
import edu.westga.cs.schoolgrades.model.CompositeGradeDropLowest;
import edu.westga.cs.schoolgrades.model.CompositeGradeSum;
import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.WeightedGrade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.StringConverter;

public class SchoolGradesController implements Initializable {
	@FXML
	private ListView<SimpleGrade> quizListView;
	@FXML
	private ListView<SimpleGrade> homeworkListView;
	@FXML
	private ListView<SimpleGrade> examListView;
	@FXML
	private TextField quizSubtotal;
	@FXML
	private TextField homeworkSubtotal;
	@FXML
	private TextField examSubtotal;
	@FXML
	private TextField finalGrade;
	private ObservableList<SimpleGrade> observableListQuiz;
	private ObservableList<SimpleGrade> observableListHomework;
	private ObservableList<SimpleGrade> observableListExam;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		observableListQuiz = FXCollections.observableArrayList();
		quizListView.setTooltip(new Tooltip("Select Data Menu then add quiz. Edit the default grade"));
		quizListView.setItems(observableListQuiz);
		quizListView.setEditable(true);
		quizListView.setCellFactory(TextFieldListCell.forListView(new StringConverter<SimpleGrade>() {

			@Override
			public String toString(SimpleGrade simpleGrade) {
				return simpleGrade.toString();
			}

			@Override
			public SimpleGrade fromString(String string) {

				return new SimpleGrade(Double.valueOf(string));
			}

		}));

		observableListHomework = FXCollections.observableArrayList();
		homeworkListView.setTooltip(new Tooltip("Select Data Menu then add homework. Edit the default grade"));
		homeworkListView.setItems(observableListHomework);
		homeworkListView.setEditable(true);
		homeworkListView.setCellFactory(TextFieldListCell.forListView(new StringConverter<SimpleGrade>() {

			@Override
			public String toString(SimpleGrade simpleGrade) {
				return simpleGrade.toString();
			}

			@Override
			public SimpleGrade fromString(String string) {

				return new SimpleGrade(Double.valueOf(string));
			}

		}));

		observableListExam = FXCollections.observableArrayList();
		examListView.setTooltip(new Tooltip("Select Data Menu then add exam. Edit the default grade"));
		examListView.setItems(observableListExam);
		examListView.setEditable(true);

		examListView.setCellFactory(TextFieldListCell.forListView(new StringConverter<SimpleGrade>() {

			@Override
			public String toString(SimpleGrade simpleGrade) {
				return simpleGrade.toString();
			}

			@Override
			public SimpleGrade fromString(String string) {

				return new SimpleGrade(Double.valueOf(string));
			}

		}));

	}

	@FXML
	public void clickRecalculate(ActionEvent event) {
		CompositeGradeSum sumQuiz = new CompositeGradeSum();
		CompositeGrade compositeQuiz = new CompositeGrade(sumQuiz);
		WeightedGrade quizWeighted = new WeightedGrade(0.2, compositeQuiz);
		CompositeGradeSum sumHomework = new CompositeGradeSum();
		CompositeGradeDropLowest lowest = new CompositeGradeDropLowest(sumHomework);
		CompositeGrade compositeHomework = new CompositeGrade(lowest);
		WeightedGrade homeworkWeighted = new WeightedGrade(0.3, compositeHomework);
		CompositeGradeAverage averageExam = new CompositeGradeAverage();
		CompositeGrade compositeExam = new CompositeGrade(averageExam);
		WeightedGrade examWeighted = new WeightedGrade(0.5, compositeExam);
		CompositeGradeSum finalGradeSum = new CompositeGradeSum();
		CompositeGrade compositeFinal = new CompositeGrade(finalGradeSum);

		quizSubtotal.setTooltip(new Tooltip("Displays sum of all of the quiz grades"));
		homeworkSubtotal.setTooltip(new Tooltip("Displays sum of all of the homework grades after dropping the lowest grade"));
		examSubtotal.setTooltip(new Tooltip("Displays average of all of the exam grades"));
		finalGrade.setTooltip(new Tooltip("Displays sum of weighted quiz, homework, and exam grades"));
		
	
		for (Grade quiz : observableListQuiz) {
			compositeQuiz.add(quiz);
		}
		
		int sizeQuiz = compositeQuiz.getAll().size();
		
		if (sizeQuiz == 0) {
			quizSubtotal.setText("0");
		} else {
			quizSubtotal.setText(String.format("%.2f", (compositeQuiz.getValue())));
		}
		

		for (Grade homework : observableListHomework) {
			compositeHomework.add(homework);

		}
		
		int size = compositeHomework.getAll().size();
		
		if (size == 0) {
			homeworkSubtotal.setText("0");
		} else {
			homeworkSubtotal.setText(String.format("%.2f", (compositeHomework.getValue())));
		}

		
		for (Grade exam : observableListExam) {
			compositeExam.add(exam);
			
		}
		int sizeExam = compositeExam.getAll().size();
		
		if (sizeExam == 0) {
			examSubtotal.setText("0");
		} else {
		examSubtotal.setText(String.format("%.2f", (compositeExam.getValue())));
		}
		
		if (sizeQuiz == 0 & size == 0 & sizeExam ==0) {
			finalGrade.setText("No Grades Entered");
		} else {
		compositeFinal.add(quizWeighted);
		compositeFinal.add(homeworkWeighted);
		compositeFinal.add(examWeighted);
		finalGrade.setText(String.format("%.2f", compositeFinal.getValue()));
		}
	}

	@FXML
	public void addQuiz(ActionEvent event) {
		observableListQuiz.add(new SimpleGrade(0));

	}

	@FXML
	public void addHomework(ActionEvent event) {
		observableListHomework.add(new SimpleGrade(0));
	}

	@FXML
	public void addExam(ActionEvent event) {
		observableListExam.add(new SimpleGrade(0));
	}
}
