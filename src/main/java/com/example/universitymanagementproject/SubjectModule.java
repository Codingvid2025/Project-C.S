package com.example.universitymanagementproject;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.control.*;

public class SubjectModule extends UniversityManagementProject {

    public JButton AddSubject;
    public JButton DeleteSubject;
    public JButton EditSubject;
    public JButton ViewSubject;
    public JButton SubjectOvr;
    public JButton SubjectOvrStudent;

    public Scene AddingSubject;
    public Scene DeletingSubject;
    public Scene EditingSubject;
    public Scene ViewingSubject;

    public String[][] Subjects = new String[20][2];
    @Override
    public void showAdminDashboard(String username, String role){
        super.showAdminDashboard(username, role);
        SubjectOvr = new JButton("Subject Management");
        SubjectOvr.addActionListener((ActionListener) this);
    }
    @Override
    public void showStudentDashboard(String username, String role){
        super.showStudentDashboard(username, role);
        SubjectOvrStudent = new JButton("Student Management");
        SubjectOvrStudent.addActionListener((ActionListener) this);
    }
    public void actionPerformed (ActionEvent e) {
        ViewSubject = new JButton("Delete Subjects");
        ViewSubject.addActionListener((ActionListener) this);
    }
    public void actionPerformedOvr(ActionEvent e){
        AddSubject = new JButton("Add Subjects");
        AddSubject.addActionListener((ActionListener) this);

        DeleteSubject = new JButton("Delete Subjects");
        DeleteSubject.addActionListener((ActionListener) this);

        EditSubject = new JButton("Add Subjects");
        EditSubject.addActionListener((ActionListener) this);

        ViewSubject = new JButton("Delete Subjects");
        ViewSubject.addActionListener((ActionListener) this);

    }
    public void actionPerformedAdd(ActionEvent e){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);
        AddingSubject = new Scene(grid, 600, 450);

        Label SubjectLabel = new Label("Subject Name e.g Math");
        GridPane.setConstraints(SubjectLabel, 0, 0);
        TextField subjectInput = new TextField();
        subjectInput.setPromptText("Enter Subject Name");
        GridPane.setConstraints(subjectInput, 1, 0);

        Label codeLabel = new Label("Course code e.g MATH001:");
        GridPane.setConstraints(codeLabel, 0, 1);
        TextField codeInput = new TextField();
        codeInput.setPromptText("Enter Course Code");
        GridPane.setConstraints(codeInput, 1, 1);

        Button Enter = new Button("Enter");
        GridPane.setConstraints(Enter, 1, 2);
        Label displayLabel = new Label();
        GridPane.setConstraints(displayLabel, 1, 3);

        Enter.setOnAction(f -> {
            String code = codeInput.getText();
            String subject = subjectInput.getText();
            for (int i = 0; i < Subjects.length; i++) {
                if(code.equals(Subjects[i][0])){
                    displayLabel.setText("This code is already in use.");
                }
                if(Subjects[i][1].isEmpty() && Subjects[i][0].isEmpty()){
                    Subjects[i][0] = subject;
                    Subjects[i][1] = code;
                }
            }
        });
    }
    public void actionPerformedDelete(ActionEvent e){
        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(20, 20, 20, 20));
        grid2.setVgap(10);
        grid2.setHgap(10);
        DeletingSubject = new Scene(grid2, 600, 450);

        Label SubjectLabel = new Label("Subject Name e.g Math");
        GridPane.setConstraints(SubjectLabel, 0, 0);
        TextField subjectInput = new TextField();
        subjectInput.setPromptText("Enter Subject Name");
        GridPane.setConstraints(subjectInput, 1, 0);

        Label codeLabel = new Label("Course code e.g MATH001:");
        GridPane.setConstraints(codeLabel, 0, 1);
        TextField codeInput = new TextField();
        codeInput.setPromptText("Enter Course Code");
        GridPane.setConstraints(codeInput, 1, 1);

        Button Delete = new Button("Delete Subjects");
        GridPane.setConstraints(Delete, 1, 2);
        Delete.setOnAction(g -> {
            String code = codeInput.getText();
            String subject = subjectInput.getText();
            for (int i = 0; i < Subjects.length; i++) {
                if(code.equals(Subjects[i][1]) && subject.equals(Subjects[i][0])){
                    Subjects[i][0] = "";
                    Subjects[i][1] = "";
                }
                if(Subjects[i][1].isEmpty() && Subjects[i][0].isEmpty()){
                    break;
                }
            }
        });
    }
    public void actionPerformedEdit(ActionEvent e){
        GridPane grid3 = new GridPane();
        grid3.setPadding(new Insets(20, 20, 20, 20));
        grid3.setVgap(10);
        grid3.setHgap(10);
        EditingSubject = new Scene(grid3, 600, 450);

        Label SubjectLabel = new Label("Subject Name e.g Math");
        GridPane.setConstraints(SubjectLabel, 0, 0);
        TextField subjectInput = new TextField();
        subjectInput.setPromptText("Enter Subject Name");
        GridPane.setConstraints(subjectInput, 1, 0);

        Label codeLabel = new Label("Course code e.g MATH001:");
        GridPane.setConstraints(codeLabel, 0, 1);
        TextField codeInput = new TextField();
        codeInput.setPromptText("Enter Course Code");
        GridPane.setConstraints(codeInput, 1, 1);

        Button Check = new Button("Check");
        GridPane.setConstraints(Check, 1, 2);

        Check.setOnAction(g -> {
            String code = codeInput.getText();
            String subject = subjectInput.getText();

            for (int i = 0; i < Subjects.length; i++) {
                if(code.equals(Subjects[i][1]) && subject.equals(Subjects[i][0])){
                    Label newSubject = new Label("Subject name change e.g Physics");
                    GridPane.setConstraints(newSubject, 0,3);
                    TextField newSubjectInput = new TextField();
                    newSubjectInput.setPromptText("Enter new subject name");
                    GridPane.setConstraints(newSubjectInput, 0, 4);

                    Label newCodeLabel = new Label("New course code e.g PHYS005:");
                    GridPane.setConstraints(newCodeLabel, 1, 4);
                    TextField newCodeInput = new TextField();
                    newCodeInput.setPromptText("Enter new course code");
                    GridPane.setConstraints(newCodeInput, 1, 5);

                    Button Edit = new Button("Edit");
                    GridPane.setConstraints(Edit, 1, 6);
                    int finalI = i;
                    Edit.setOnAction(g1 -> {
                        String updatedSubjectInput = newSubject.getText();
                        String updatedCodeInput = newCodeInput.getText();
                        Subjects[finalI][0] = updatedCodeInput;
                        Subjects[finalI][1] = updatedSubjectInput;
                    });

                }
            }
        });
    }
    public void actionPerformedView(ActionEvent e){
        GridPane grid4 = new GridPane();
        grid4.setPadding(new Insets(20, 20, 20, 20));
        grid4.setVgap(10);
        grid4.setHgap(10);
        ViewingSubject = new Scene(grid4, 600, 450);

        for(int i = 0; i < Subjects.length; i++){
            Button SubjectNames = new Button(Subjects[i][0]);
            GridPane.setConstraints(SubjectNames, i, 0);
            Button SubjectCodes = new Button(Subjects[i][1]);
            GridPane.setConstraints(SubjectCodes, i, 1);

        }
    }
}



