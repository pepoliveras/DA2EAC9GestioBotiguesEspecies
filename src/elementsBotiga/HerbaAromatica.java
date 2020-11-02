/*
 * Classe que defineix una herba aromàtica. Es defineixen pel seu codi, nom, característiques 
 * i preu.
 */
package elementsBotiga;

/**
 *
 * @author fta
 */
public class HerbaAromatica extends Ingredient {


    /*
     TODO CONSTRUCTOR
    
     Paràmetres: valors per tots els atributs de la classe.
    
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.    
     */
    public HerbaAromatica(String codi, String nom, String caracteristiques, double preu) {

        super(codi, nom, caracteristiques, preu);

    }

    /*
    TODO
    
     Paràmetres: cap
    
     Accions:
     - Demanar a l'usuari les dades per consola per crear una nova herba aromàtica. 
       Les dades a demanar són les que necessita el constructor.
     - També heu de tenir en compte que tant el nom com les característiques, poden ser frases, 
       per exemple, Fonoll Dolç.
    
     Nota important: no controlem que l'usuari introdueixi una opció de tipus numèric, ja que això ho farem amb la
     tècnica de les excepcions que veurem més endavant. Així doncs suposarem que sempre introdueix
     un número.
     
     Retorn: La nova herba aromàtica creada.
     */
    public static HerbaAromatica addHerbaAromatica() {
        String codi, nom, caracteristiques;
        double preu;

        System.out.println("\nCodi de l'herba aromàtica:");
        codi = DADES.next();
        DADES.nextLine(); //Neteja buffer
        System.out.println("\nNom de l'herba aromàtica:");
        nom = DADES.nextLine();
        System.out.println("\nCracterístiques de l'herba aromàtica:");
        caracteristiques = DADES.nextLine();
        System.out.println("\nPreu de l'herba aromàtica:");
        preu = DADES.nextDouble();

        return new HerbaAromatica(codi, nom, caracteristiques, preu);
    }

}
