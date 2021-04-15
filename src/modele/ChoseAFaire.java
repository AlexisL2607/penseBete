package modele;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ChoseAFaire {
    private String libelle;
    /**
     * initialise une chose à faire par défaut
     */
    public ChoseAFaire() {
        libelle = null;
    }
    /**
     * initialise une chose à faire avec son libellé.
     * @param nom une chaîne de caractères qui est le libellé
     */
    public ChoseAFaire(String nom) {
        libelle = nom;
    }
    /**
     * renvoie un texte décrivant la chose à faire
     * @return une chaîne de caractères
     */
    public String toString() {
        return libelle;
    }
    /**
     * renvoie le nom de la chose à faire
     * @return une chaîne de caractères
     */
    public String getNom() {
        return libelle;
    }
    /**
     * change le nom de la chose à faire
     * @param nouveau une chaîne de carctères qui est le nouveau nom
     */
    public void changerNom(String nouveau) {
        libelle = nouveau;
    }
    /**
     * enregistre la chose à faire dans le flux en écriture
     * @param stream une instance de la classe DataOutputStream
     */
    public void enregistrerDans(DataOutputStream stream) throws Exception {
        stream.writeUTF(libelle);
    }
    /**
     * lit dans le flux les valeurs des variables de la chose à faire
     * @param stream une instance de la classe DataInputStream
     */
    public void chargerDepuis(DataInputStream stream) throws Exception {
        libelle = stream.readUTF();
    }
}
