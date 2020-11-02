/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementsBotiga;

import principal.Component;

/**
 *
 * @author fta
 */
public abstract class Ingredient implements Component {

    private String codi;
    private String nom;
    private String caracteristiques;
    private double preu;

    public Ingredient(String codi, String nom, String caracteristiques, double preu) {
        this.codi = codi;
        this.nom = nom;
        this.caracteristiques = caracteristiques;
        this.preu = preu;
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCaracteristiques() {
        return caracteristiques;
    }

    public void setCaracteristiques(String caracteristiques) {
        this.caracteristiques = caracteristiques;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public void updateComponent(){
        System.out.println("\nCodi de l'ingredient: " + codi);
        System.out.println("\nEntra el nou codi:");
        codi = DADES.next();
        DADES.nextLine(); //Neteja buffer
        System.out.println("\nNom de l'ingredient: " + nom);
        System.out.println("\nEntra el nou nom:");
        nom = DADES.nextLine();
        System.out.println("\nCaracterístiques de l'ingredient: " + caracteristiques);
        System.out.println("\nEntra les noves característiques:");
        caracteristiques = DADES.nextLine();
        System.out.println("\nPreu de l'ingredient: " + preu);
        System.out.println("\nEntra el nou preu:");
        preu = DADES.nextDouble();
    }

    public void showComponent() {
        System.out.println("\nLes dades de l'ingredient amb codi " + codi + " són:");
        System.out.println("\nNom: " + nom);
        System.out.println("\nCracterístiques: " + caracteristiques);
        System.out.println("\nPreu: " + preu);
    }
}
