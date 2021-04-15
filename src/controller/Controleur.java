package controller;

import modele.ChoseAFaire;
import modele.PenseBete;

public class Controleur {
        private final PenseBete chosesAfaires;
        public Controleur(PenseBete chosesAfaires) {
            this.chosesAfaires = chosesAfaires;
        }

    public void add(String text) {
            chosesAfaires.add(new ChoseAFaire(text));
        }
        public void remove(int selection) {
            chosesAfaires.remove(selection);
        }
        public void get(int selection, String text) {
            chosesAfaires.get(selection).changerNom(text);
        }

    }

