package persistencia;

import principal.Botiga;
import principal.GestorBotiguesException;

/**
 *
 * @author fta
 */
public class GestorPersistencia {
    private GestorXML gestor;

    public GestorXML getGestor() {
        return gestor;
    }

    public void setGestor(GestorXML pGestor) {
        gestor = pGestor;
    }

    public void desarBotiga(String tipusPersistencia, String nomFitxer, Botiga botiga) throws GestorBotiguesException{
        if (tipusPersistencia.equals("XML")) {
            gestor = new GestorXML();
            gestor.desarBotiga(nomFitxer,botiga);
        }
    }

    public void carregarBotiga(String tipusPersistencia, String nomFitxer) throws GestorBotiguesException{
       
        if (tipusPersistencia.equals("XML")) {
            gestor = new GestorXML();
            gestor.carregarBotiga(nomFitxer);
        }
    }
}
