/*
 * Classe que defineix una botiga d'espècies. Es defineixen pel seu codi, adreça, un vector 
 * d'espècies, un vector d'herbes aromàtiques, un vector de mestres especiers i un vector de mescles.
 */
package principal;

import elementsBotiga.Especia;
import elementsBotiga.HerbaAromatica;
import elementsBotiga.Mescla;
import elementsBotiga.Mestre;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fta
 */
public class Botiga implements Component {

    private int codi;
    private static int properCodi = 1; //El proper codi a assignar
    private String adreca;
    private Component[] components = new Component[715];
    private int posicioComponents = 0; //Priemra posició buida del vector components
    
    /*
     TODO CONSTRUCTOR
    
     Paràmetres: valors per tots els atributs de la classe menys els vectors i el codi.
    
     Accions:
     - Assignar als atributs corresponents els valors passats com a paràmetres.
     - Assignar a l'atribut codi el valor de l'atribut properCodi i actualitzar
     properCodi amb el següent codi a assignar.
     */
    public Botiga(String adreca) {
        codi = properCodi;
        properCodi++;
        this.adreca = adreca;
    }
    
    /*Nou constructor per crear una botiga a partir de les dades guardades en un
      document XML
     */
    public Botiga(int codi, String adreca) {
        this.codi = codi;
        this.adreca = adreca;
    }
    
    /*
     TODO Mètodes accessors    
     */

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public static int getProperCodi() {
        return properCodi;
    }

    public static void setProperCodi(int properCodi) {
        Botiga.properCodi = properCodi;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public Component[] getComponents() {
        return components;
    }

    public void setComponents(Component[] component) {
        this.components = component;
    }

    public int getPosicioComponents() {
        return posicioComponents;
    }

    public void setPosicioComponents(int posicioComponents) {
        this.posicioComponents = posicioComponents;
    }
    
    /*
     TODO
    
     Paràmetres: cap
    
     Accions:
     - Demanar a l'usuari les dades per consola per crear una nova botiga. Les dades
     a demanar són les que passem per paràmetre en el constructor.
     - També heu de tenir en compte que l'adreça, pot ser una frases, per exemple, C/De la font, 1.
    
     Retorn: La nova botiga creada.
     */
    public static Botiga addBotiga() {

        System.out.println("\nAdreça de la botiga:");

        return new Botiga(DADES.nextLine());
    }
    
    /*
     TODO
    
     Paràmetres: cap
    
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual i
       modificar els atributs corresponents d'aquest objecte. Els únics atributs que
       modificarem són els que hem inicialitzat en el constructor amb els paràmetres passats.
     - També heu de tenir en compte que l'adreça, pot ser una frases, per exemple, C/De la font, 1.
     - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     
    Retorn: cap
     */
    public void updateComponent() {
        System.out.println("\nAdreça de la botiga: " + adreca);
        System.out.println("\nEntra la nova adreça:");
        adreca = DADES.nextLine();
    }
    
    public void showComponent() {
        System.out.println("\nL'adreça de la botiga amb codi " + codi + " és:");
        System.out.println("\nAdreça: " + adreca);
    }
    

    public void addEspecia() {

        Especia novaEspecia = null;
        
        try {
            novaEspecia = Especia.addEspecia();
        } catch (GestorBotiguesException ex) {
            //gestionem la excepció
        }

        if (selectComponent(2, novaEspecia.getCodi()) == -1) {
            components[posicioComponents] = novaEspecia;
            posicioComponents++;
        } else {
            System.out.println("\nL'espècia ja existeix");
        }
    }

    
    public void addHerbaAromatica() {

        HerbaAromatica novaHerba = HerbaAromatica.addHerbaAromatica();

        if (selectComponent(3, novaHerba.getCodi()) == -1) {
            components[posicioComponents] = novaHerba;
            posicioComponents++;
        } else {
            System.out.println("\nL'herba aromàtica ja existeix");
        }
    }
    

    public void addMestre() {

        Mestre nouMestre = Mestre.addMestre();

        if (selectComponent(1, nouMestre.getNif()) == -1) {
            components[posicioComponents] = nouMestre;
            posicioComponents++;
        } else {
            System.out.println("\nEl mestre o la mestra ja existeix");
        }
    }


    public void addMescla() {

        Mescla novaMescla = Mescla.addMescla();

        if (selectComponent(4, novaMescla.getCodi()) == -1) {
            components[posicioComponents] = novaMescla;
            posicioComponents++;
        } else {
            System.out.println("\nLa mescla ja existeix");
        }
    }

    
    public int selectComponent(int tipusComponent, String id) {

        if (id == null) {
            //Demanem quin tipus de component vol seleccionar i el seu identificador (id)
            switch (tipusComponent) {
                case 1:
                    System.out.println("NIF del mestre/a?:");
                    break;
                case 2:
                    System.out.println("Codi de l'espècia?:");
                    break;
                case 3:
                    System.out.println("Codi de l'herba aromàtica?:");
                    break;
                case 4:
                    System.out.println("Codi de la mescla?:");
                    break;
            }

            id = DADES.next();
        }

        int posElement = -1; //Posició que ocupa el component seleccionat dins el vector de components de l'estudi

        //Seleccionem la posició que ocupa el component dins el vector de components
        // de l'estudi
        for (int i = 0; i < posicioComponents; i++) {
            if (components[i] instanceof Mestre && tipusComponent == 1) {
                if (((Mestre) components[i]).getNif().equals(id)) {
                    return i;
                }
            } else if (components[i] instanceof Especia && tipusComponent == 2) {
                if (((Especia) components[i]).getCodi().equals(id)) {
                    return i;
                }
            } else if (components[i] instanceof HerbaAromatica && tipusComponent == 3) {
                if (((HerbaAromatica) components[i]).getCodi().equals(id)) {
                    return i;
                }
            } else if (components[i] instanceof Mescla && tipusComponent == 4) {
                if (((Mescla) components[i]).getCodi().equals(id)) {
                    return i;
                }
            }
        }

        return posElement;
    }
    
    public void addEspeciaMescla() {
        
        Mescla mesclaSel = null;
        int pos = selectComponent(4,null);

        if (pos >= 0) {

            mesclaSel = (Mescla)this.getComponents()[pos];

            pos = selectComponent(2,null);

            if (pos >= 0) {
                System.out.println("\nQuina quantitat s'ha d'afegir de l'espècia?");
                mesclaSel.addIngredient((Especia)this.getComponents()[pos], DADES.nextDouble());
            } else {
                System.out.println("\nNo existeix aquesta espècia");
            }

        } else {
            System.out.println("\nNo existeix aquesta mescla");
        }

    }
    
    public void addHerbaMescla() {
        
        Mescla mesclaSel = null;
        int pos = selectComponent(4,null);

        if (pos >= 0) {

            mesclaSel = (Mescla)this.getComponents()[pos];

            pos = selectComponent(3,null);

            if (pos >= 0) {
                System.out.println("\nQuina quantitat s'ha d'afegir de l'herba aromàtica?");
                mesclaSel.addIngredient((HerbaAromatica)this.getComponents()[pos], DADES.nextDouble());
            } else {
                System.out.println("\nNo existeix aquesta herba aromàtica");
            }

        } else {
            System.out.println("\nNo existeix aquesta mescla");
        }

    }
    
    public void addMestreMescla() {
        
        Mescla mesclaSel = null;
        int pos = selectComponent(4,null);

        if (pos >= 0) {

            mesclaSel = (Mescla)this.getComponents()[pos];

            pos = selectComponent(1,null);

            if (pos >= 0) {
                mesclaSel.setMestre((Mestre)this.getComponents()[pos]);
            } else {
                System.out.println("\nNo existeix aquest mestre o mestra");
            }

        } else {
            System.out.println("\nNo existeix aquesta mescla");
        }

    }
}
