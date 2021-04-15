package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import modele.ChoseAFaire;
import modele.PenseBete;
import vue.PenseBeteView;

public class Controleur {
    private int selection = -1;
    private final PenseBete chosesAfaires;
    private PenseBeteView editeur;
    public Controleur(PenseBete chosesAfaires, PenseBeteView editeurPenseBete) {
        this.chosesAfaires = chosesAfaires;
        this.editeur = editeurPenseBete;

        editeur.getBtnSuppr().setOnAction(evt -> supprimerSelection());
        editeur.getBtnModif().setOnAction(evt -> modifierSelection());
        editeur.getBtnAjout().setOnAction(evt -> ajoutNouveau());
        editeur.getTxtCur().setOnKeyTyped(evt -> possibiliteDeModifier());
        editeur.getTxtNew().setOnKeyTyped(evt -> possibiliteDAjouter());
        editeur.getListView().getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                changerSelection(newValue.intValue(), oldValue.intValue());
            }
        });

    }
    private void changerSelection(int newValue, int oldValue) {
        editeur.getEtiq1().setText("OLD Index: " + oldValue + ",  NEW Index: " + newValue);
        selection = newValue;
        if (selection < 0) {
            editeur.getTxtCur().setText("");
            editeur.getTxtCur().setDisable(true);
            editeur.getBtnModif().setDisable(true);
            editeur.getBtnSuppr().setDisable(true);
        } else {
            editeur.getBtnSuppr().setDisable(false);
            editeur.getTxtCur().setText(chosesAfaires.get(selection).getNom());
            editeur.getTxtCur().setDisable(false);
        }
    }
    private void possibiliteDAjouter() {
        editeur.getBtnAjout().setDisable(editeur.getTxtNew().getText().equals(""));
    }
    private void possibiliteDeModifier() {
        editeur.getBtnModif().setDisable(false);
    }
    private void ajoutNouveau() {
        chosesAfaires.add(new ChoseAFaire(editeur.getTxtNew().getText()));
        editeur.getTxtNew().setText("");
        editeur.getBtnAjout().setDisable(true);
        editeur.getBtnSuppr().setDisable(true);
    }
    private void modifierSelection() {
        chosesAfaires.get(selection).changerNom(editeur.getTxtCur().getText());
        editeur.getBtnModif().setDisable(true);
        editeur.getListView().refresh();
    }
    private void supprimerSelection() {
        chosesAfaires.remove(selection);
        if (selection < 0) {
            editeur.getTxtCur().setText("");
            editeur.getTxtCur().setDisable(true);
            editeur.getBtnModif().setDisable(true);
        } else {
            editeur.getTxtCur().setText(chosesAfaires.get(selection).getNom());
            editeur.getTxtCur().setDisable(false);
        }
    }
}