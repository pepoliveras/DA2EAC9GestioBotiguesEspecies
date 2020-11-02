/*
 * Classe que defineix un mestre especier o una mestra especiera. Es defineixen pel seu nif, nom, sexe 
 * i talla de l'uniforme.
 */
package elementsBotiga;

import principal.Component;

/**
 *
 * @author fta
 */
public class Mestre implements Component {

    private String nif;
    private String nom;
    private String sexe;
    private String talla;

    /*
     TODO CONSTRUCTOR
    
     Paràmetres: valors per tots els atributs de la classe.
    
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.    
     */
    public Mestre(String nif, String nom, String sexe, String talla) {
        this.nif = nif;
        this.nom = nom;
        this.sexe = sexe;
        this.talla = talla;
    }

    /*
     TODO Mètodes accessors    
     */
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    /*
    TODO
    
     Paràmetres: cap
    
     Accions:
     - Demanar a l'usuari les dades per consola per crear un nou mestre especier o nova 
       mestra especiera. Les dades a demanar són les que necessita el constructor.
     - Abans que l'usuari introdueixi el sexe, heu d'avisar-lo que ha d'introduir una "H" si es
       tracta d'un home o una "D" si es tracta d'una dona.
     - Abans que l'usuari introdueixi la talla de l'uniforme, heu d'avisar-lo que les possibles
       talles a introduir, són "S", "M", "L" o "XL".
     - En aquesta EAC, de moment no controlarem que les dades introduïdes tant en el sexe com
       en la talla siguin les correctes. Suposarem que les dades introduïdes per l'usuari són
       correctes.
     - També heu de tenir en compte que el nom, poden ser frases, per exemple, Francesc Xavier.
     
     Retorn: El nou mestre especier creat o nova mestra especiera creada.
     */
    public static Mestre addMestre() {

        String nif, nom, sexe, talla;

        System.out.println("\nNIF del mestre especier o mestra especiera:");
        nif = DADES.next();
        DADES.nextLine(); //Neteja buffer
        System.out.println("\nNom del mestre especier o mestra especiera:");
        nom = DADES.nextLine();
        System.out.println("\nSexe del mestre especier o mestra especiera (H per home o D per dona):");
        sexe = DADES.next();
        System.out.println("\nTalla del mestre especier o mestra especiera (S, M, L o XL):");
        talla = DADES.next();

        return new Mestre(nif, nom, sexe, talla);
    }

    /*
     TODO
    
     Paràmetres: cap
    
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual i
       modificar els atributs corresponents d'aquest objecte.
     - En el cas de l'atribut sexe, li heu de demanar que ha d'introduir una "H" si es
       tracta d'un home o una "D" si es tracta d'una dona.
     - En el cas de l'atribut talla, l'heu d'avisar que les possibles talles a introduir, 
       són "S", "M", "L" o "XL".
     - En aquesta EAC, de moment no controlarem que les dades introduïdes tant en el sexe com
       en la talla siguin les correctes. Suposarem que les dades introduïdes per l'usuari són
       correctes.
     - També heu de tenir en compte que el nom, poden ser frases, per exemple, Francesc Xavier.
     - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     
    Retorn: cap
     */
    public void updateComponent() {
        System.out.println("\nNIF del mestre especier o mestra especiera: " + nif);
        System.out.println("\nEntra el nou nif:");
        nif = DADES.next();
        DADES.nextLine(); //Neteja buffer
        System.out.println("\nNom del mestre especier o mestra especiera: " + nom);
        System.out.println("\nEntra el nou nom:");
        nom = DADES.nextLine();
        System.out.println("\nSexe del mestre especier o mestra especiera: " + sexe);
        System.out.println("\nEntra el nou sexe (H per home o D per dona):");
        sexe = DADES.next();
        System.out.println("\nTalla del mestre especier o mestra especiera (S, M, L o XL): " + talla);
        System.out.println("\nEntra la nova talla:");
        talla = DADES.next();
    }

    public void showComponent() {
        System.out.println("\nLes dades del mestre especier o mestra especiera amb nif " + nif + " són:");
        System.out.println("\nNom: " + nom);
        System.out.println("\nSexe: " + sexe);
        System.out.println("\nTalla: " + talla);
    }
}
