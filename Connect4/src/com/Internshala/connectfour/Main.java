package com.Internshala.connectfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {
	private  Controller controller;




	@Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane = loader.load();
        controller = loader.getController();
        controller.createPlayground();

		MenuBar menuBar =createMenu();
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
		menuPane.getChildren().add(menuBar);

		Scene scene = new Scene(rootGridPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
	private javafx.scene.control.MenuBar createMenu(){
    	// file  menu


		javafx.scene.control.Menu fileMenu = new javafx.scene.control.Menu("File");
		javafx.scene.control.MenuItem newGame= new javafx.scene.control.MenuItem("New game");
		newGame.setOnAction(event -> resetGame());
		javafx.scene.control.MenuItem resetGame = new javafx.scene.control.MenuItem("reset game");
		resetGame.setOnAction(event -> resetGame());

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		javafx.scene.control.MenuItem exitGame = new javafx.scene.control.MenuItem("exit game");
		exitGame.setOnAction(event -> exitGame());

		fileMenu.getItems().addAll(newGame, resetGame,separatorMenuItem,exitGame);

		//Help Menu

		javafx.scene.control.Menu helpMenu = new javafx.scene.control.Menu("Help");

		javafx.scene.control.MenuItem aboutGame = new javafx.scene.control.MenuItem("About Connect4");
		aboutGame.setOnAction(event -> aboutGame());
		SeparatorMenuItem separator= new SeparatorMenuItem();
		javafx.scene.control.MenuItem  aboutMe = new javafx.scene.control.MenuItem("About Me");
		aboutMe.setOnAction(event -> aboutMe());

		helpMenu.getItems().addAll(aboutGame,separator,aboutMe);



		javafx.scene.control.MenuBar menuBar= new javafx.scene.control.MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);


		return menuBar;

	}

	private void aboutMe() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About The Developer");
		alert.setHeaderText("Dushyant Kumar Singh");
		alert.setContentText(" I love to play with code and develop games as well");
		alert.show();
	}

	private void aboutGame() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About Connect Four");
		alert.setHeaderText("How to Play");
		alert.setContentText("Connect Four is two player connection game in which the player first choose a color then take turn dropping colored discs from top into a seven-column , six-row vertically suspended grid . The pieces  fall straight down, occupying the next available space within the column . The objective of the game is to be  the first to form the horizontal, vertical, or diagonal line of four of one's own discs. Connect Four is solved game. ");
		alert.show();
	}

	private void exitGame() {
		Platform.exit();
		System.exit(0);
	}

	private void resetGame() {
		/* Todo */
	}

	public static void main(String[] args) {
        launch(args);
    }
}
