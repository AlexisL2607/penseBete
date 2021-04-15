package application;


import controller.Controleur;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import modele.PenseBete;
import vue.PenseBeteView;

import java.io.File;

//import javafx.scene.layout.HBox;

    public class Main extends Application {
        @Override
        public void start(Stage stage) {

            // Définir le modele
            PenseBete chosesAfaires = new PenseBete();
            // Définir le controller
            Controleur controller = new Controleur(chosesAfaires);
            // Définir la vue
            PenseBeteView editeurPenseBete = new PenseBeteView(controller, chosesAfaires);

            stage.setTitle("Pense bête Alexis");
            stage.setScene(new Scene(PenseBeteView.asParent(), 500, 350));
            stage.setMinWidth(400);
            stage.setMinHeight(270);
            stage.setOnCloseRequest(event -> System.exit(0));
            stage.show();

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Ouvrir un pense-bête");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Pense-bête", "*.pb"));
            File selectedFile = fileChooser.showOpenDialog(stage);
        }

        public static void main(String[] args) {
            launch(args);
        }

    }