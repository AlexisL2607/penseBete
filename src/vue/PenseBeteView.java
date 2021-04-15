package vue;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import modele.ChoseAFaire;
import modele.PenseBete;

public class PenseBeteView {
        private int selection = -1;
        static BorderPane root;
        VBox tools;
        Button btnSuppr;
        Button btnModif;
        Button btnAjout;
        Label etiq1;
        TextField txtCur;
        TextField txtNew;
        ListView<ChoseAFaire> listView;

        public PenseBeteView(PenseBete chosesAfaires) {
            root = new BorderPane();
            tools = new VBox();
            btnSuppr = new Button("Terminer");
            btnModif = new Button("Modifier");
            btnAjout = new Button("Ajouter");
            etiq1 = new Label();
            txtCur = new TextField();
            txtNew = new TextField();

            btnSuppr.setDisable(true);
            btnAjout.setDisable(true);
            btnModif.setDisable(true);
            txtCur.setDisable(true);

            listView = new ListView<ChoseAFaire>(chosesAfaires);

            listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            listView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    etiq1.setText("OLD Index: " + oldValue + ",  NEW Index: " + newValue);
                    selection = newValue.intValue();
                    if (selection < 0) {
                        txtCur.setText("");
                        txtCur.setDisable(true);
                        btnModif.setDisable(true);
                        btnSuppr.setDisable(true);
                    } else {
                        btnSuppr.setDisable(false);
                        txtCur.setText(chosesAfaires.get(selection).getNom());
                        txtCur.setDisable(false);
                    }
                }
            });

            tools.setPadding(new Insets(15, 12, 15, 12));
            tools.getChildren().addAll(btnSuppr, new Label("\nChose à faire sélectionnée :"), txtCur, btnModif, new Label("\nNouvelle chose à faire :"), txtNew, btnAjout);
            root.setCenter(listView);
            root.setRight(tools);
        }

        public static BorderPane asParent() {
            return root;
        }
        public Button getBtnSuppr() {
            return btnSuppr;
        }
        public void setBtnSuppr(Button btnSuppr) {
            this.btnSuppr = btnSuppr;
        }
        public Button getBtnModif() {
            return btnModif;
        }
        public void setBtnModif(Button btnModif) {
            this.btnModif = btnModif;
        }
        public Button getBtnAjout() {
            return btnAjout;
        }
        public void setBtnAjout(Button btnAjout) {
            this.btnAjout = btnAjout;
        }
        public BorderPane getRoot() {
            return root;
        }
        public void setRoot(BorderPane root) {
            this.root = root;
        }
        public VBox getTools() {
            return tools;
        }
        public void setTools(VBox tools) {
            this.tools = tools;
        }
        public Label getEtiq1() {
            return etiq1;
        }
        public void setEtiq1(Label etiq1) {
            this.etiq1 = etiq1;
        }
        public TextField getTxtCur() {
            return txtCur;
        }
        public void setTxtCur(TextField txtCur) {
            this.txtCur = txtCur;
        }
        public TextField getTxtNew() {
            return txtNew;
        }
        public void setTxtNew(TextField txtNew) {
            this.txtNew = txtNew;
        }
        public ListView<ChoseAFaire> getListView() {
            return listView;
        }
        public void setListView(ListView<ChoseAFaire> listView) {
            this.listView = listView;
        }
        public int getSelection() {
            return selection;
        }

    }
