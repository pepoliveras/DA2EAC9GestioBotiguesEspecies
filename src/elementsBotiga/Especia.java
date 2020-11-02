/*
 * Classe que defineix una especia. Es defineixen pel seu codi, nom, característiques 
 * preu i grau de picantor.
 */
package elementsBotiga;

import principal.GestorBotiguesException;


/**
 *
 * @author fta
 */
public class Especia extends Ingredient {

    private String picantor;

    /*
     TODO CONSTRUCTOR
    
     Paràmetres: valors per tots els atributs de la classe.
    
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.    
     */
    public Especia(String codi, String nom, String caracteristiques, double preu, String picantor) {

        super(codi, nom, caracteristiques, preu);
        this.picantor = picantor;

    }

    /*
     TODO Mètodes accessors    
     */
    public String getPicantor() {
        return picantor;
    }

    public void setPicantor(String picantor) {
        this.picantor = picantor;
    }

    /*
    TODO
    
     Paràmetres: cap
    
     Accions:
     - Demanar a l'usuari les dades per consola per crear una nova espècia. 
       Les dades a demanar són les que necessita el constructor.
     - Abans que l'usuari introdueixi el grau de picantor, heu d'avisar-lo que els possibles
       graus a introduir, són "0", "1", "2", "3", "4" o "5", on "0" és no picant i "5" el màxim.
     - En aquesta EAC, de moment no controlarem que les dades introduïdes en la picantor
       siguin les correctes. Suposarem que les dades introduïdes per l'usuari són correctes.
     - També heu de tenir en compte que tant el nom com les característiques, poden ser frases, 
       per exemple, Pebrer de Jamaica.
     
     Retorn: La nova herba aromàtica creada.
    
     Si s'introdueix un número fora de l'interval permés o bé un caràter no numèric 
     llença una excepció "GestorBotigaException" amb codi 7
     */
    public static Especia addEspecia() throws GestorBotiguesException{
        String codi = null, nom = null, caracteristiques = null, picantor = null;
        double preu = 0;
        
        try {
            System.out.println("\nCodi de l'espècia:");
            codi = DADES.next();
            DADES.nextLine(); //Neteja buffer
            System.out.println("\nNom de l'espècia:");
            nom = DADES.nextLine();
            System.out.println("\nCracterístiques de l'espècia:");
            caracteristiques = DADES.nextLine();
            System.out.println("\nPreu de l'espècia:");
            preu = DADES.nextDouble();
            System.out.println("\nGrau de picantor de l'espècia (0, 1, 2, 3, 4 o 5, on 0 és no picant i 5 el màxim):");
            picantor = DADES.next();
            if (Integer.parseInt(picantor) < 0 || Integer.parseInt(picantor) > 5){
                throw new GestorBotiguesException(picantor);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return new Especia(codi, nom, caracteristiques, preu, picantor);
    }

    /*
     TODO
    
     Paràmetres: cap
    
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual i
       modificar els atributs corresponents d'aquest objecte.
     - Abans que l'usuari introdueixi el grau de picantor, heu d'avisar-lo que els possibles
       graus a introduir, són "0", "1", "2", "3", "4" o "5", on "0" és no picant i "5" el màxim.
     - En aquesta EAC, de moment no controlarem que les dades introduïdes en la picantor
       siguin les correctes. Suposarem que les dades introduïdes per l'usuari són correctes.
     - També heu de tenir en compte que tant el nom com les característiques, poden ser frases, 
       per exemple, Pebre de Jamaica.
     - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
    
     Nota important: no controlem que l'usuari introdueixi una opció de tipus numèric, ja que això ho farem amb la
     tècnica de les excepcions que veurem més endavant. Així doncs suposarem que sempre introdueix
     un número.
     
    Retorn: cap
     */
    public void updateComponent(){
        super.updateComponent();
        System.out.println("\nGrau de picantor de l'espècia (0, 1, 2, 3, 4 o 5, on 0 és no picant i 5 el màxim): " + picantor);
        System.out.println("\nEntra el nou grau de picantor:");
        picantor = DADES.next();
    }

    public void showComponent() {
        super.showComponent();
        System.out.println("\nPicantor: " + picantor);
    }
}
