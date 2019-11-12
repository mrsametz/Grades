package edu.westga.cs.schoolgrades.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.CompositeGradeDropLowest;
import edu.westga.cs.schoolgrades.model.CompositeGradeSum;
import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import javafx.scene.control.TextField;
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
	private StringProperty quizScore;
	private double quizTotalScore; 

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		observableListQuiz = FXCollections.observableArrayList();
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
		CompositeGradeSum sumHomework = new CompositeGradeSum();
		CompositeGradeDropLowest lowest = new CompositeGradeDropLowest(sumHomework);
		CompositeGrade compositeHomework = new CompositeGrade(lowest);
		CompositeGradeSum sumExam = new CompositeGradeSum();
		CompositeGrade compositeExam = new CompositeGrade(sumExam);

		for (Grade quiz : observableListQuiz) {
			compositeQuiz.add(quiz);
		}
		
		//quizSubtotal.setText(String.format("%.2f", (compositeQuiz.getValue())));
	
		quizTotalScore = compositeQuiz.getValue();
		quizScore.set(String.format("%.2f", quizTotalScore));
		quizScore.bindBidirectional(quizSubtotal.textProperty());


		for (Grade homework : observableListHomework) {
			compositeHomework.add(homework);
			
			
		}
		homeworkSubtotal.setText(String.format("%.2f", (compositeHomework.getValue())));

		for (Grade exam : observableListExam) {
			compositeExam.add(exam);
		}
		examSubtotal.setText("" + sumExam.formatDecimal(sumExam.applyStrategy(compositeExam.getAll())));
		
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
