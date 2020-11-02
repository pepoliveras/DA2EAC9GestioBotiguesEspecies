package principal;

/**
 *
 * @author FTA
 */
public class GestorBotiguesException extends Exception {
    private String codiCausa = "desconegut";
    private String missatge;

    public GestorBotiguesException(String codiCausa) {
        this.codiCausa = codiCausa;
        switch (codiCausa) {
            case "1":
                missatge = "L'opció introduïda no és numèrica";
                break;
            case "2":
                missatge = "Ja hem afegit l'ingredient";
                break;
            case "3":
                missatge = "L'espècia ja existeix";
                break;
            case "4":
                missatge = "L'herba haromàtica ja existeix";
                break;
            case "5":
                missatge = "El mestre o mestra ja existeix";
                break;
            case "6":
                missatge = "La mescla ja existeix";
                break;
            case "7":
                missatge = "La dada introduida no és correcta";
                break;
            case "8":
                missatge = "Ja no hi caben més components";
                break;
            case "GestorXML.model":
                missatge = "No s'ha pogut crear el model XML per desar la botiga";
                break;
            case "GestorXML.desar":
                missatge = "No s'ha pogut desar la botiga a causa d'error d'entrada/sortida";
                break;
            case "GestorXML.carrega":
                missatge = "No s'ha pogut carregar la botiga a causa d'error d'entrada/sortida";
                break;
            default:
                missatge = "Error desconegut";
                break;
        }
    }

    /*És un mètode heretat de la classe Exception que heu de reescriure.
      mostra el codi de causa del missatge i el text del missatge.
    */
    public String getMessage() {
        return this.codiCausa.concat(": " + this.missatge);
    }
}
