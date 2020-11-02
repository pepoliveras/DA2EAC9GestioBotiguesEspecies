package persistencia;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import principal.Botiga;
import principal.GestorBotiguesException;

/**
 *
 * @author fta
 */
public class GestorXML {
    private Document doc;
    private Botiga botiga;

    public Document getDoc() {
        return doc;
    }

    public Botiga getBotiga() {
        return botiga;
    }    

    public void desarBotiga(String nomFitxer, Botiga botiga) throws GestorBotiguesException {
        construeixModel(botiga);
        desarModel(nomFitxer);
    }

    public void carregarBotiga(String nomFitxer) throws GestorBotiguesException {
        carregarFitxer(nomFitxer);
        llegirFitxerBotiga();;
    }

    /*Paràmetres: Botiga a partir de la qual volem construir el model
     *
     *Acció: 
     * - Llegir els atributs de l'objecte botiga passat per paràmetre 
     *   per construir un model (document XML) sobre el Document doc (atribut de GestorXML).
     *
     * - L'arrel del document XML és "botiga". Aquesta arrel, l'heu d'afegir 
     *   a doc. Un cop fet això, heu de recórrer l'ArrayList components de botiga
     *   i per a cada component, afegir un fill a doc. Cada fill 
     *   tindrà com atributs els atributs de l'objecte (codi, nom, …).
     *
     * - Si es tracta d'una mescla, a més, heu d'afegir fills addicionals amb 
     *   el mestre o mestra que fa la mescla i els ingredients de la mescla amb 
     *   les seves quantitats. Les quantitats s'han d'afegir com a atributs dels 
     *   ingredients als quals estan associades.
     *
     *Retorn: cap
     */
    public void construeixModel(Botiga botiga) throws GestorBotiguesException {
       
    }

    public void desarModel(String nomFitxer) throws GestorBotiguesException {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            File f = new File(nomFitxer + ".xml");
            StreamResult result = new StreamResult(f);
            transformer.transform(source, result);
        } catch (Exception ex) {
            throw new GestorBotiguesException("GestorXML.desar");
        }
    }

    public void carregarFitxer(String nomFitxer) throws GestorBotiguesException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            File f = new File(nomFitxer + ".xml");
            doc = builder.parse(f);
        } catch (Exception ex) {
            throw new GestorBotiguesException("GestorXML.carrega");
        }
    }

    /*Paràmetres: cap
     *
     *Acció: 
     * - Llegir el fitxer del vostre sistema i carregar-lo sobre l'atribut doc, 
     *   per assignar valors als atributs dde botiga i la resta d'objectes que formen 
     *   els components de botiga.
     *    
     * - Primer heu de crear l'objecte botiga a partir de l'arrel del document XML
     *   per després recórrer el doc i per cada fill, afegir un objecte a l'atribut 
     *   components de botiga mitjançant el mètode escaient de la classe Botiga.
     *
     * - Si l'element del document XML que s'ha llegit és una mescla, recordeu 
     *   que a més d'afegir-lo a components, també haureu d'assignar-li
     *   el mestre o mestra i ingredients corresponents amb les seves quantitats.
     *
     *Retorn: cap
     */
    private void llegirFitxerBotiga()throws GestorBotiguesException {

    }
}
