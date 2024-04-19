import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LectorXML {
    public static void main(String[] args) {
        try {
            // Cargar el archivo XML
            File file = new File("parametros.xml");

            // Crear un constructor de documentos
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parsear el archivo XML
            Document document = builder.parse(file);

            // Obtener la raíz del documento
            Element root = document.getDocumentElement();

            // Obtener la dificultad deseada (en este caso, "Facil")
            Element dificultad = (Element) root.getElementsByTagName("Facil").item(0);

            // Crear una lista para almacenar los valores de los atributos de la dificultad
            List<String> valoresFacil = new ArrayList<>();

            // Obtener todos los elementos hijos de la dificultad "Facil"
            NodeList parametrosDificultad = dificultad.getChildNodes();

            // Recorrer los elementos hijos de la dificultad "Facil" y obtener los valores
            for (int j = 0; j < parametrosDificultad.getLength(); j++) {
                if (parametrosDificultad.item(j) instanceof Element) {
                    Element parametro = (Element) parametrosDificultad.item(j);

                    // Obtener y almacenar el valor del atributo
                    String valor = parametro.getTextContent();
                    valoresFacil.add(valor);
                }
            }

            // Imprimir los valores
            for (String valor : valoresFacil) {
                System.out.println(valor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}