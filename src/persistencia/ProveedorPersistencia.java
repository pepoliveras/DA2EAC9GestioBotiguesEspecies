package persistencia;

import principal.Botiga;
import principal.GestorBotiguesException;

/**
 *
 * @author fta
 */
public interface ProveedorPersistencia {
    public void desarBotiga(String nomFitxer, Botiga botiga)throws GestorBotiguesException;
    public void carregarBotiga(String nomFitxer)throws GestorBotiguesException; 
}
