package principal;

import elementsBotiga.Especia;
import elementsBotiga.HerbaAromatica;
import elementsBotiga.Mestre;
import java.util.Scanner;
import persistencia.GestorPersistencia;

/**
 *
 * @author fta
 */
public class Application {

    private final static Scanner DADES = new Scanner(System.in);

    static private Botiga[] botigues = new Botiga[10];
    static private int posicioBotigues = 0;
    static private Botiga botigaActual = null;
    static private String FITXER = "botiga";
    static private GestorPersistencia gp = new GestorPersistencia();

    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Gestió de botigues");
            System.out.println("\n2. Gestió de mescles");
            System.out.println("\n3. Gestió de mestres");
            System.out.println("\n4. Gestió d'espècies");
            System.out.println("\n5. Gestió d'herbes aromàtiques");
            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    menuBotigues();
                    break;
                case 2:
                    if (botigaActual != null) {
                        menuMescles();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la botiga al menú Gestió de botigues");
                    }
                    break;
                case 3:
                    if (botigaActual != null) {
                        menuComponents(1);
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la botiga al menú Gestió de botigues");
                    }
                    break;
                case 4:
                    if (botigaActual != null) {
                        menuComponents(2);
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la botiga al menú Gestió de botigues");
                    }
                    break;
                case 5:
                    if (botigaActual != null) {
                        menuComponents(3);
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la botiga al menú Gestió de botigues");
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuBotigues() {
        int opcio = 0;

        do {
            int indexSel = -1;
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Seleccionar botiga");
            System.out.println("\n3. Modificar");
            System.out.println("\n4. Llista de botigues");            
            System.out.println("\n5. Carregar botiga");
            System.out.println("\n6. Desar botiga");
            opcio = DADES.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    botigues[posicioBotigues] = Botiga.addBotiga();
                    posicioBotigues++;
                    break;
                case 2:
                    indexSel = selectBotiga();
                    if (indexSel >= 0) {
                        botigaActual = botigues[indexSel];
                    } else {
                        System.out.println("\nNo existeix aquesta botiga");
                    }
                    break;
                case 3:
                    indexSel = selectBotiga();
                    if (indexSel >= 0) {
                        botigues[indexSel].updateComponent();
                    } else {
                        System.out.println("\nNo existeix aquesta botiga");
                    }
                    break;
                case 4:
                    for (int i = 0; i < posicioBotigues; i++) {
                        botigues[i].showComponent();
                    }
                    break;
                case 5: //Carregar botiga
                    posicioBotigues = 0;
                    botigues = new Botiga[1]; //Només podem carregar una botiga
                    gp.carregarBotiga("XML", FITXER);
                    botigues[posicioBotigues] = gp.getGestor().getBotiga();
                    posicioBotigues++;
                    break;
                case 6: //Desar botiga
                    int pos = selectBotiga();
                    if (pos >= 0) {
                        gp.desarBotiga("XML", FITXER, botigues[pos]);
                    } else {
                        System.out.println("\nNo existeix aquesta botiga");
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }
    
    public static void menuComponents(int tipus) {
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llistat");
            opcio = DADES.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    switch (tipus) {
                        case 1:
                            botigaActual.addMestre();
                            break;
                        case 2:
                            botigaActual.addEspecia();
                            break;
                        case 3:
                            botigaActual.addHerbaAromatica();
                            break;
                    }
                    break;
                case 2:
                    int indexSel = botigaActual.selectComponent(tipus,null);
                    if (indexSel >= 0) {
                        botigaActual.getComponents()[indexSel].updateComponent();
                    } else {
                        System.out.println("\nNo existeix aquest component");
                    }
                    break;
                case 3:
                    for (int i = 0; i < botigaActual.getPosicioComponents(); i++) {
                            if (botigaActual.getComponents()[i] instanceof Mestre && tipus == 1) {
                                botigaActual.getComponents()[i].showComponent();
                            } else if (botigaActual.getComponents()[i] instanceof Especia && tipus == 2) {
                                botigaActual.getComponents()[i].showComponent();
                            } else if (botigaActual.getComponents()[i] instanceof HerbaAromatica && tipus == 3) {
                                botigaActual.getComponents()[i].showComponent();
                            }
                        }
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }


    /*
     TODO Heu de desenvolupar el menuMescles amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, l'atribut botigaActual no és null
     
     Opció 0. Sortir -->       Surt del menú i retorna al menú principal
     Opció 1. Alta -->         Crea una mescla en la botiga actual. Penseu que Botiga sap crear mescles      
     Opció 2. Modificar ->     Permet modificar una mescla que existeix a la botiga actual
     (per comprovar l'existència de la mescla tenim un mètode en la classe Botiga que ens ajuda)
     Opció 3. Afegir espècia ->   Afegeix una espècia i la seva quantitat a una mescla, però penseu que Botiga sap com fer-ho.
     Opció 4. Afegir herba aromàtica ->   Afegeix una herba aromàtica i la seva quantitat a una mescla, però penseu que Botiga sap com fer-ho.
     Opció 5. Afegir mestre o mestra ->   Afegeix un mestre o una mestra a una mescla, però penseu que Botiga sap com fer-ho.
     Opció 6. Llista de mescles-> Imprimeix les dades de les mescles de la botiga actual.
        
     A més, heu de fer una estructura iterativa per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch-case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable opcio de tipus enter
     
    Nota important: no controlem que l'usuari introdueixi una opció de tipus numèric, ja que això ho farem amb la
     tècnica de les excepcions que veurem més endavant. Així doncs suposarem que sempre introdueix
     un número.
     */
    public static void menuMescles() {
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Afegir espècia");
            System.out.println("\n4. Afegir herba aromàtica");
            System.out.println("\n5. Afegir mestre o mestra");
            System.out.println("\n6. Llista de mescles");
            opcio = DADES.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    botigaActual.addMescla();
                    break;
                case 2:
                    int indexSel = botigaActual.selectComponent(4, null);
                    if (indexSel >= 0) {
                        botigaActual.getComponents()[indexSel].updateComponent();
                    } else {
                        System.out.println("\nNo existeix aquesta mescla");
                    }
                    break;
                case 3:
                    botigaActual.addEspeciaMescla();
                    break;
                case 4:
                    botigaActual.addHerbaMescla();
                    break;
                case 5:
                    botigaActual.addMestreMescla();
                    break;
                case 6:
                    for (int i = 0; i < botigaActual.getPosicioComponents(); i++) {
                        botigaActual.getComponents()[i].showComponent();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static Integer selectBotiga() {

        System.out.println("\nCodi de la botiga?:");
        int codi = DADES.nextInt();

        for (int i = 0; i < posicioBotigues; i++) {
            if (botigues[i].getCodi() == codi) {
                return i;
            }
        }
        return -1;
    }
}
