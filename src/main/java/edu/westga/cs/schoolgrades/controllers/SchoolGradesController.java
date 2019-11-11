package edu.westga.cs.schoolgrades.controllers;

import java.net.URL;
import java.util.ResourceBundle;


import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.CompositeGradeSum;
import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.GradeStrategy;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ListView.EditEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class SchoolGradesController implements Initializable {
	 @FXML private ListView<Grade> quizListView;
	 @FXML private ListView<Grade> homeworkListView;
	 @FXML private ListView<Grade> examListView;
	 @FXML private TextField quizSubtotal;
	 @FXML private TextField homeworkSubtotal;
	 @FXML private TextField examSubtotal;
	 private ObservableList<Grade> observableList;

	
	 
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		quizListView = new ListView<>();
		
		observableList = FXCollections.observableArrayList();
		quizListView.setEditable(true);
        quizListView.setItems(observableList);
     
        quizListView.setCellFactory(lv -> new ListCell<Grade>() {
            
        	private TextField textField = new TextField() ;

            {
                textField.setOnAction(e -> {
                    commitEdit(getItem());
                   
                });
                textField.addEventFilter(KeyEvent.KEY_RELEASED, e -> {
                    if (e.getCode() == KeyCode.ESCAPE) {
                        cancelEdit();
                    }
                });
            }
       
	
             @Override
             protected void updateItem(Grade grade, boolean empty) {
                    super.updateItem(grade, empty);
                    if (empty) {
                        setText(null);
                        setGraphic(null);
                    } else if (isEditing()) {
                        textField.setText(String.format("%.2f", grade.getValue()));
                        setText(null);
                        setGraphic(textField);
                    } else {
                        setText(String.format("%.2f", grade.getValue()));
                        setGraphic(null);
                    }
                }
           @Override
             public void startEdit() {
                 super.startEdit();
                 textField.setText(String.format("%.2f", getItem().getValue()));
                 setText(null);
                 setGraphic(textField);
                 textField.selectAll();
                 textField.requestFocus();
             }

            

             @Override
             public void commitEdit(Grade grade) {
                 super.commitEdit(grade);
                 observableList.add(grade);
                 grade.getValue();
                 setText(String.format("%.2f", getItem().getValue()));
                 setGraphic(null);
                 
             }
             
             @Override
             public void cancelEdit() {
                 super.cancelEdit();
                 setText(String.format("%.2f", getItem().getValue()));
                 setGraphic(null);
             }
         });
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
		//observableList.add
		
		//change to add user input
		
	
	}
	
	@FXML
	public void addHomework(ActionEvent event) {
		
	}
	
	@FXML
	public void addExam(ActionEvent event) {
		
	}
}
