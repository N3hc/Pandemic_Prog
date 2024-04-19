package Func_Partida;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class control_de_datos {
	private String url;
	
	private String user;
	
	private String password;
	
	private String ficheroTxt;
	
	private String ficheroBin;
	
	private String ficheroXML;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFicheroBin() {
		return ficheroBin;
	}
	public void setFicheroBin(String ficheroBin) {
		this.ficheroBin = ficheroBin;
	}
	public String getFicheroTxt() {
		return ficheroTxt;
	}
	public void setFicheroTxt(String ficheroTxt) {
		this.ficheroTxt = ficheroTxt;
	}
	public String getFicheroXML() {
		return ficheroXML;
	}
	public void setFicheroXML(String ficheroXML) {
		this.ficheroXML = ficheroXML;
	}
	
	public static String [] Leer_Xml () {
		String filePath = "parametros.xml";
		String [] val = new String [4];
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
                           val [i] = hijo.getTextContent();
                        }
                    }
                    System.out.println("");
                }
            } }catch (ParserConfigurationException | SAXException | IOException e) {
                System.out.println(e.getMessage());
            }
		return val;

	}
	
	public static ArrayList<Ciudad> cargarCiudades() {
		        String Fit = "ciudades.txt";
		        String s = "";
		        ArrayList<Ciudad> ciudades =  new ArrayList<>();
		        try {
		            FileReader fr = new FileReader(Fit);
		            BufferedReader br = new BufferedReader(fr);
		            while ((s = br.readLine()) != null) {
		                ArrayList<String> infoCol = new ArrayList<String>();
		                String[] Desglose = s.split("[,;]");
				        int[] coordenadas = new int[2];
		                coordenadas[0] = Integer.parseInt(Desglose[2]);
		                coordenadas[1] = Integer.parseInt(Desglose[3]);
		                for (int i = 4; i < Desglose.length; i++) {
		                    infoCol.add(Desglose[i]);
		                }
		                if (Desglose [1].equals("0")) {
		                	Desglose[1] = "Tritones";
		                } else if (Desglose [1].equals("1")) {
		                	Desglose [1] = "Antárboles";
		                } else if (Desglose [1].equals("2")) {
		                	Desglose [1] = "Goblos";
		                } else if (Desglose [1].equals("3")) {
		                	Desglose [1] = "Momias";
		                }
		                String [] cidCol = new String [infoCol.size()];
		                for (int i = 0; i < cidCol.length; i++) {
		                	cidCol[i] = infoCol.get(i);
		                }
		                Ciudad ciudad = new Ciudad (Desglose[0], coordenadas, Desglose [1], cidCol );
		                infoCol.clear();
		                ciudades.add(ciudad);
		            }
		            fr.close();
		            br.close();
		        } catch (IOException e) {
		            System.out.println("Error E/S: " + e);
		        }
				return ciudades;   
		    }
	public static ArrayList<Vacuna> cargarVacunas() {
		String [] Enf_y_Col = {"Azul","Corazón de Vell","Verde","Dandelion","Rojo","Kzarka","Negro","Kutum"};
		ArrayList<Vacuna> Vacunas = new ArrayList<>();
		for (int i = 0; i < 8; i+=2) {
			Vacuna vacuna = new Vacuna(Enf_y_Col[i], Enf_y_Col[i+1]);
			Vacunas.add(vacuna);
		}
		return Vacunas;	
	}
	public static ArrayList<Virus> cargarVirus() {
		ArrayList<Virus>Viruses = new ArrayList<>();
		String [] Idn_Nom_Col = {"0","Tritones","Azul","1","Antárboles","Verde","2","Goblos","Rojo","3","Momias","Negro"};
		for (int i = 0; i < 12; i+=3) {
			Virus virus= new Virus(Idn_Nom_Col[i], Idn_Nom_Col[i+1], Idn_Nom_Col[i+2]);
			Viruses.add(virus);
		}
		return Viruses;
	}
	
	public static void cargarPartida() {
		
	}
	public static void guardarPartida() {
		
	}
	public static void cargarRecord() {
		
	}
	public static void guardarRecord() {
		
	}
}
