package com.maryor.todolist;

import com.maryor.todolist.datamodel.TodoData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("mainwindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        stage.setTitle("ToDo List");
        stage.setScene(scene);
        stage.show();
//        Parent root = FXMLLoader.load(getClass().getResource("mainwindow.fxml"));
//        primaryStage.setTitle("Todo List");
//        primaryStage.setScene(new Scene(root, 900, 500));
//        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void stop() throws Exception {
         try {
             TodoData.getInstance().storeTodoItems();
         } catch(IOException e) {
             System.out.println(e.getMessage());
         }
    }

    @Override
    public void init() throws Exception {
        try {
            TodoData.getInstance().loadTodoItems();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}