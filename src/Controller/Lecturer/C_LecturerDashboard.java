package Controller.Lecturer;

import Constants.Screens;
import Model.Authentication.CurrentUserModel;
import Model.Database.TestService;
import Model.Entities.Lecturer;
import Model.Entities.Test;
import Utils.UI;
import com.jfoenix.controls.*;
import com.jfoenix.transitions.hamburger.HamburgerBasicCloseTransition;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static Model.Authentication.CurrentUserModel.student;

public class C_LecturerDashboard {
    public JFXTreeTableView tableView_TestTable;
    public JFXSpinner spinner_TestEnrollement;
    public JFXNodesList nodeList_optionNodes;
    public JFXHamburger hamburger_Drawer;
    public JFXButton btn_Insert;
    public JFXButton btn_Delete;
    public JFXButton btn_GenerateReport;
    public JFXButton btn_Option;
    public Label lbl_DateTime;
    public JFXDrawer Drawer_leftDrawer;
    public Label lbl_Name;
    public Circle circle_Avatar;
    public JFXButton btn_Logout;
    public AnchorPane rootPane;

    public void initialize(){

        crateAndLoadMyTestTable();
        UI.progressBarAnimation(spinner_TestEnrollement , 0.25);
        setNodebtnList();
        handleDrawer();
        setPersonalDetails();
    }

    public void btn_LogoutOnAction(ActionEvent actionEvent) {

        try {
            new UI().closeUIButton(btn_Logout);
            CurrentUserModel.lecturer = null;
            CurrentUserModel.isLoggedIn = false;
            new UI().setUI(Screens.login);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setNodebtnList(){

        nodeList_optionNodes.setRotate(270);
        nodeList_optionNodes.setSpacing(80d);
        nodeList_optionNodes.addAnimatedNode(btn_Option);
        nodeList_optionNodes.addAnimatedNode(btn_Insert);
        nodeList_optionNodes.addAnimatedNode(btn_Delete);
        nodeList_optionNodes.addAnimatedNode(btn_GenerateReport);
    }

    public void setCurrentDateTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy 'at' hh:mm a ");
        ZonedDateTime zdt = ZonedDateTime.now();
        String zdtString = formatter.format(zdt);
        lbl_DateTime.setText(zdtString);
    }

    public void hamburger_ToggleDrawerOnActionPerformed(MouseEvent mouseEvent) {
        if(!Drawer_leftDrawer.isShowing()){
            Drawer_leftDrawer.open();
        }else{
            Drawer_leftDrawer.close();
        }
    }

    public void btn_InsertOnAction(ActionEvent actionEvent) {

        try {
            new UI().closeUIButton(btn_Insert);
            new UI().setUI(Screens.addTest);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPersonalDetails(){
        Lecturer lecturer = CurrentUserModel.lecturer;
        lbl_Name.setText(lecturer.getFirst_name() + " "+ CurrentUserModel.lecturer.getLast_name());
        circle_Avatar.setFill(UI.pattern(new Image(lecturer.getAvatar().toURI().toString()),20));
    }

    public void handleDrawer(){
        StackPane stackPane = new StackPane();
        Drawer_leftDrawer.setSidePane(stackPane);
        Drawer_leftDrawer.setDefaultDrawerSize(150);
        Drawer_leftDrawer.setResizeContent(true);
        Drawer_leftDrawer.setOverLayVisible(false);
        Drawer_leftDrawer.setResizableOnDrag(true);
        Drawer_leftDrawer.setContent(new Label("Hello"));

        HamburgerBasicCloseTransition burgerTask = new HamburgerBasicCloseTransition(hamburger_Drawer);
        burgerTask.setRate(-1);
        hamburger_Drawer.addEventHandler(MouseEvent.MOUSE_PRESSED, (e)->{
            burgerTask.setRate(burgerTask.getRate()*-1);
            burgerTask.play();

            if(Drawer_leftDrawer.isShowing()){
                Drawer_leftDrawer.close();
                System.out.println("Opened");
            }else{
                Drawer_leftDrawer.open();
                System.out.println("Closed");
            }
        });
    }

    public void crateAndLoadMyTestTable(){
        try {
            DashBoardTableController.createTable(tableView_TestTable,TestService.getTests());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void loadStudentLeadBoard(){

    }

}
