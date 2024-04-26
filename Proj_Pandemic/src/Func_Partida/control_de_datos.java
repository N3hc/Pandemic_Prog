package Func_Partida;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	
	public static String [] Leer_Xml (String dific) {
		String filePath = "parametros.xml";
		String [] val = new String [5];
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
            Element dificultad = (Element) root.getElementsByTagName(dific).item(0);

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
            for (int i = 0; i < valoresFacil.size(); i++) {
                val[i] = valoresFacil.get(i);
            	System.out.println(val[i]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
		return val;

	}
	
	public static ArrayList<Personaje> cargarPersonajes(){
		ArrayList<Personaje> personajes = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Personaje personaje = new Personaje();
			personajes.add(personaje);
		}		
		return personajes;
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
		                	Desglose [1] = "Antarboles";
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
		String [] Enf_y_Col = {"Azul","Corazon de Vell","Verde","Dandelion","Rojo","Kzarka","Negro","Kutum"};
		ArrayList<Vacuna> Vacunas = new ArrayList<>();
		for (int i = 0; i < 8; i+=2) {
			Vacuna vacuna = new Vacuna(Enf_y_Col[i], Enf_y_Col[i+1]);
			Vacunas.add(vacuna);
		}
		return Vacunas;	
	}
	public static ArrayList<Virus> cargarVirus() {
		ArrayList<Virus>Viruses = new ArrayList<>();
		String [] Idn_Nom_Col = {"0","Tritones","Azul","1","Antarboles","Verde","2","Goblos","Rojo","3","Momias","Negro"};
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
