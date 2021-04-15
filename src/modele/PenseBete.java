package modele;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class PenseBete implements ObservableList<ChoseAFaire> {
    private ObservableList<ChoseAFaire> contenu;
    public PenseBete() {
        contenu = FXCollections.observableArrayList();
    }
    public int nombreDElements() {
        return contenu.size();
    }
    public void ajoute(ChoseAFaire c) { /* version PenseBete agrège des choses à faire */
        contenu.add(c);
    }
    public void ajoute(String nom) { /* version PenseBete compose des choses à faire */
        contenu.add(new ChoseAFaire(nom));
    }
    public void supprimer(String nom) {
        Iterator<ChoseAFaire> li = contenu.iterator();
        while (li.hasNext()) {
            ChoseAFaire c = li.next();
            if (c.getNom() == nom) {
                li.remove();
                return;
            }
        }
    }
    public void supprimer(int num) {
        contenu.remove(num);
    }
    public ChoseAFaire element(int num) {
        return contenu.get(num);
    }
    public void afficherV1() {
        Iterator<ChoseAFaire> li = contenu.iterator();
        while (li.hasNext()) {
            ChoseAFaire c = li.next();
            System.out.println(" - " + c);
        }
        System.out.println();
    }
    public void afficherV2() {
        for(ChoseAFaire c : contenu) {
            System.out.println(" - " + c);
        }
        System.out.println();
    }
    public void enregistrerDans(DataOutputStream stream) throws Exception {
        stream.writeByte(1);
        stream.writeInt(nombreDElements());
        for(ChoseAFaire chose : contenu)
            chose.enregistrerDans(stream);
    }
    public boolean chargerDepuis(DataInputStream stream) throws Exception {
        if (stream.readByte() != 1) return false;
        int n = stream.readInt();
        ChoseAFaire chose;
        for(int i = 0; i < n; i++) {
            chose = new ChoseAFaire();
            chose.chargerDepuis(stream);
            contenu.add(chose);
        }
        return true;
    }
    public boolean enregistrerSous(String nomFichier) {
        boolean reussi = true;
        try (DataOutputStream stream = new DataOutputStream(new FileOutputStream(nomFichier + ".pb"))) {
            enregistrerDans(stream);
        } catch(Exception e) {
            reussi = false;
        }
        return reussi;
    }
    public boolean charger(String nomFichier) {
        boolean reussi = true;
        try (DataInputStream stream = new DataInputStream(new FileInputStream(nomFichier + ".pb"))) {
            reussi = chargerDepuis(stream);
        } catch(Exception e) {
            reussi = false;
        }
        return reussi;
    }
    public void addListener(ListChangeListener<? super ChoseAFaire> listener) {
        contenu.addListener(listener);
    }
    @Override
    public int size() {
        return contenu.size();
    }
    @Override
    public boolean isEmpty() {
        return contenu.isEmpty();
    }
    @Override
    public boolean contains(Object o) {
        return contenu.contains(o);
    }
    @Override
    public Iterator<ChoseAFaire> iterator() {
        return contenu.iterator();
    }
    @Override
    public Object[] toArray() {
        return contenu.toArray();
    }
    @Override
    public <T> T[] toArray(T[] a) {
        return contenu.toArray(a);
    }
    @Override
    public boolean add(ChoseAFaire e) {
        return contenu.add(e);
    }
    @Override
    public boolean remove(Object o) {
        return contenu.remove(o);
    }
    @Override
    public boolean containsAll(Collection<?> c) {
        return contenu.contains(c);
    }
    @Override
    public boolean addAll(Collection<? extends ChoseAFaire> c) {
        return contenu.addAll(c);
    }
    @Override
    public boolean addAll(int index, Collection<? extends ChoseAFaire> c) {
        return contenu.addAll(index, c);
    }
    @Override
    public boolean removeAll(Collection<?> c) {
        return contenu.removeAll(c);
    }
    @Override
    public boolean retainAll(Collection<?> c) {
        return contenu.retainAll(c);
    }
    @Override
    public void clear() {
        contenu.clear();
    }
    @Override
    public ChoseAFaire get(int index) {
        return contenu.get(index);
    }
    @Override
    public ChoseAFaire set(int index, ChoseAFaire element) {
        return contenu.set(index, element);
    }
    @Override
    public void add(int index, ChoseAFaire element) {
        contenu.add(index, element);
    }
    @Override
    public ChoseAFaire remove(int index) {
        return contenu.remove(index);
    }
    @Override
    public int indexOf(Object o) {
        return contenu.indexOf(o);
    }
    @Override
    public int lastIndexOf(Object o) {
        return contenu.lastIndexOf(o);
    }
    @Override
    public ListIterator<ChoseAFaire> listIterator() {
        return contenu.listIterator();
    }
    @Override
    public ListIterator<ChoseAFaire> listIterator(int index) {
        return contenu.listIterator(index);
    }
    @Override
    public List<ChoseAFaire> subList(int fromIndex, int toIndex) {
        return contenu.subList(fromIndex, toIndex);
    }
    @Override
    public void addListener(InvalidationListener arg0) {
        contenu.addListener(arg0);
    }
    @Override
    public boolean addAll(ChoseAFaire... arg0) {
        return contenu.addAll(arg0);
    }
    @Override
    public void remove(int arg0, int arg1) {
        contenu.remove(arg0, arg1);
    }
    @Override
    public boolean removeAll(ChoseAFaire... arg0) {
        return contenu.removeAll(arg0);
    }
    @Override
    public void removeListener(ListChangeListener<? super ChoseAFaire> arg0) {
        contenu.removeListener(arg0);
    }
    @Override
    public boolean retainAll(ChoseAFaire... arg0) {
        return contenu.retainAll(arg0);
    }
    @Override
    public boolean setAll(ChoseAFaire... arg0) {
        return contenu.setAll(arg0);
    }
    @Override
    public boolean setAll(Collection<? extends ChoseAFaire> arg0) {
        return contenu.setAll(arg0);
    }
    @Override
    public void removeListener(InvalidationListener arg0) {
        contenu.removeListener(arg0);
    }
}
