/*
 * Classe que defineix una mescla d'espècies i/o herbes aromàtiques. Es defineixen pel seu codi, nom, mestre especier o 
 * mestra especiera que ha creat la mescla, preu, un vector amb les espècies que porta la mescla, un vector amb les
 * les quantitats de cadascuna de les espècies que porta la mescla, un vector amb les herbes aromàtiques
 * que porta la mescla i un vector amb les quantitats de cadascuna de les herbes aromàtiques que porta 
 * la mescla.
 */
package elementsBotiga;

import principal.Component;

/**
 *
 * @author fta
 */
public class Mescla implements Component {

    private String codi;
    private String nom;
    private Mestre mestre;
    private double preu;
    private Ingredient[] ingredients = new Ingredient[100];
    private int posicioIngredients = 0; //Priemra posició buida del vector ingredients
    private double[] quantitatIngredients = new double[50];
    private int posicioQuantitatIngredients = 0; //Priemra posició buida del vector quantitatIngredients

    /*
     TODO CONSTRUCTOR
    
     Paràmetres: valors per tots els atributs de la classe menys els vectors i el mestre especier
     o mestra especiera.
    
     Accions:
     - Assignar als atributs corresponents els valors passats com a paràmetres
     - Quan es crea una mescla no té cap mestre especier o mestra especiera assignat. Penseu
       amb quin valor heu d'inicialitzar aquest atribut en el constructor.
     */
    public Mescla(String codi, String nom, Double preu) {
        this.codi = codi;
        this.nom = nom;
        this.mestre = null;
        this.preu = preu;
    }

    /*
     TODO Mètodes accessors    
     */
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

    public Mestre getMestre() {
        return mestre;
    }

    public void setMestre(Mestre mestre) {
        this.mestre = mestre;
    }

    public Double getPreu() {
        return preu;
    }

    public void setPreu(Double preu) {
        this.preu = preu;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public void setEspecies(Ingredient[] ingredients) {
        this.ingredients = ingredients;
    }

    public int getPosicioIngredients() {
        return posicioIngredients;
    }

    public void setPosicioIngredients(int posicioIngredients) {
        this.posicioIngredients = posicioIngredients;
    }

    public double[] getQuantitatIngredients() {
        return quantitatIngredients;
    }

    public void setQuantitatIngredients(double[] quantitatIngredients) {
        this.quantitatIngredients = quantitatIngredients;
    }

    public int getPosicioQuantitatIngredients() {
        return posicioQuantitatIngredients;
    }

    public void setPosicioQuantitatIngredients(int posicioQuantitatIngredients) {
        this.posicioQuantitatIngredients = posicioQuantitatIngredients;
    }


    /*
     TODO
    
     Paràmetres: cap
    
     Accions:
     - Demanar a l'usuari les dades per consola per crear una nova mescla. Les dades
     a demanar són les que passem per paràmetre en el constructor.
     - També heu de tenir en compte que el nom, pot ser una frases, per exemple, Garam Masala.
    
     Nota important: no controlem que l'usuari introdueixi una opció de tipus numèric, ja que això ho farem amb la
     tècnica de les excepcions que veurem més endavant. Així doncs suposarem que sempre introdueix
     un número.
    
     Retorn: La nova mescla creada.
     */
    public static Mescla addMescla() {

        String codi, nom;
        double preu;

        System.out.println("\nCodi de la mescla:");
        codi = DADES.next();
        DADES.nextLine(); //Neteja buffer
        System.out.println("\nNom de la mescla:");
        nom = DADES.nextLine();
        System.out.println("\nPreu de la mescla:");
        preu = DADES.nextDouble();

        return new Mescla(codi, nom, preu);
    }

    /*
     TODO
    
     Paràmetres: cap
    
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual i
       modificar els atributs corresponents d'aquest objecte. Els únics atributs que
       modificarem són els que hem inicialitzat en el constructor amb els paràmetres passats.
     - També heu de tenir en compte que el nom, pot ser una frase, per exemple, Garam Masala.
     - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     
    Retorn: cap
     */
    public void updateComponent() {
        System.out.println("\nCodi de la mescla: " + codi);
        System.out.println("\nEntra el nou codi:");
        codi = DADES.next();
        DADES.nextLine(); //Neteja buffer
        System.out.println("\nNom de la mescla: " + nom);
        System.out.println("\nEntra el nou nom:");
        nom = DADES.nextLine();
        System.out.println("\nPreu de la mescla: " + preu);
        System.out.println("\nEntra el nou preu:");
        preu = DADES.nextDouble();
    }

    public void addIngredient(Ingredient ingredient, double quantitat) {

        int i;
        boolean afegit = false;

        for (i = 0; i < posicioIngredients && !afegit; i++) {
            if (ingredients[i].getCodi().equals(ingredient.getCodi())) {
                ingredients[i] = ingredient;
                quantitatIngredients[i] = quantitat;
                afegit = true;
            }
        }

        if (afegit == false) {
            ingredients[posicioIngredients] = ingredient;
            posicioIngredients++;
            quantitatIngredients[posicioQuantitatIngredients] = quantitat;
            posicioQuantitatIngredients++;
        }
    }

    public void showComponent() {
        System.out.println("\nLes dades de la mescla amb codi " + codi + " són:");
        System.out.println("\nNom: " + nom);
        System.out.println("\nPreu: " + preu);

        if (mestre != null) {
            mestre.showComponent();
        } else {
            System.out.println("\nEncara no s'ha assignat el mestre o mestra.");
        }

        for (int i = 0; i < posicioIngredients; i++) {
            ingredients[i].showComponent();
            System.out.println("\nquantitat: " + quantitatIngredients[i]);
        }

    }

}
