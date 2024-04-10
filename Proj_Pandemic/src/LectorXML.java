import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LectorXML {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filePath = "parametros.xml";
        try {
            // Creo una instancia de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Creo un documentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Obtengo el documento, a partir del XML
            Document documento = builder.parse(new File(filePath));

            // Cojo todas las etiquetas coche del documento
            NodeList lista = documento.getElementsByTagName("parametros");

            // Recorro las etiquetas
            for (int i = 0; i < lista.getLength(); i++) {
                // Cojo el nodo actual
                Node nodo = lista.item(i);
                // Compruebo si el nodo es un elemento
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    // Lo transformo a Element
                    Element e = (Element) nodo;
                    // Obtengo sus hijos
                    NodeList hijos = e.getChildNodes();
                    // Recorro sus hijos
                    for (int j = 0; j < hijos.getLength(); j++) {
                        // Obtengo al hijo actual
                        Node hijo = hijos.item(j);
                        // Compruebo si es un nodo
                        if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                            // Muestro el contenido
                            System.out.println(hijo.getNodeName() + " Valor: " + hijo.getTextContent());
                            System.out.println("¿Quieres cambiar el parámetro de este elemento? (si/no)");
                            String opcion = sc.next().toLowerCase();
                            if (opcion.equals("si")){
                                System.out.println("¿Qué valor le quieres poner?");
                                String valor = sc.next();
                                // Cambiar el contenido según el nombre del elemento
                                if (hijo.getNodeName().equals("numCiudadesInfectadasInicio") || hijo.getNodeName().equals("numCuidadesInfectadasRonda") ||
                                        hijo.getNodeName().equals("numEnfermedadesActivasDerrota") || hijo.getNodeName().equals("numBrotesDerrota")) {
                                    hijo.setTextContent(valor);
                                }
                            }
                        }
                    }
                    System.out.println("");
                }
            }

            // Escribir los cambios en el archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(documento);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);

            System.out.println("Archivo XML modificado con éxito.");

        } catch (ParserConfigurationException | SAXException | IOException | TransformerException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
