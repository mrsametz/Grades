package edu.westga.cs.schoolgrades.controllers;

import java.net.URL;
import java.util.ResourceBundle;


import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.CompositeGradeSum;
import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
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
	 @FXML private ListView<SimpleGrade> quizListView;
	 @FXML private ListView<SimpleGrade> homeworkListView;
	 @FXML private ListView<SimpleGrade> examListView;
	 @FXML private TextField quizSubtotal;
	 @FXML private TextField homeworkSubtotal;
	 @FXML private TextField examSubtotal;
	 private ObservableList<SimpleGrade> observableList;

	
	 
	 
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		
		observableList = FXCollections.observableArrayList();
		quizListView.setItems(observableList);
		quizListView.setEditable(true);
		 
		quizListView.setCellFactory(TextFieldListCell.forListView(new StringConverter<SimpleGrade>(){
			
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
		
		for(Grade quiz : observableList) {
			compositeQuiz.add(quiz);
		}
		System.out.print("" + sumQuiz.formatDecimal(sumQuiz.applyStrategy(compositeQuiz.getAll())));
		//add code to update the text field for quizSubtotal and a try catch loop for null exception
	}
		
		
	
	@FXML
	public void addQuiz(ActionEvent event) {
		
		observableList.add(new SimpleGrade(10));
		
		//change to add user input
		
	
	}
	
	@FXML
	public void addHomework(ActionEvent event) {
		
	}
	
	@FXML
	public void addExam(ActionEvent event) {
		
	}
}
