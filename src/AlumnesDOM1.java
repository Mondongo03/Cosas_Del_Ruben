
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.RandomAccessFile;

public class AlumnesDOM1 {

    // Objecte Document que emmagatzema el DOM de l'XML seleccionat
    Document document;

    public int loadFileIntoDOM(File file) {
        try {
            document = null;
            // Es crea un objecte DocumentBuilderFactory
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            // Indica que el model DOM no ha de contemplar els comentaris que tingui el XML
            documentBuilderFactory.setIgnoringComments(true);
            // Ignora els espais en blanc que tingui el document
            // ATENCIÓ: Si no es fa això els espais en blanc apareixen com a nodes.
            documentBuilderFactory.setIgnoringElementContentWhitespace(true);
            // Es crea un objecte DocumentBuilder per carregar-hi l'estructura
            // d'arbre DOM a partir del XML seleccionat.
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            // Interpreta (parsea) el document XML (file) i genera el DOM equivalent
            document = documentBuilder.parse(file);
            // Ara document apunta a l'arbre DOM preparat per a ser recorregut
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int addBookToDOM(String id, String cognom, String departament, String sou) {

        try {


            RandomAccessFile randomAccessFile = new RandomAccessFile(new File("./booksInput.xml"), "rw");
            String lectura = "";
            String idd = "<Id>"+id+"</Id>";
            while ((lectura.equals(randomAccessFile.readLine()))) {
                try {

                    if (idd.equals(lectura)) {
                        randomAccessFile.seek(randomAccessFile.getFilePointer() - 1);
                        Node nodeId = document.replsElement("Id");
                        Node nodeIdText = document.createTextNode(id);
                        nodeId.appendChild(nodeIdText);
                        // Fem el mateix per a autor
                        Node nodeCognom = document.createElement("Cognom");
                        Node nodeCognomText = document.createTextNode(cognom);
                        nodeCognom.appendChild(nodeCognomText);

                        Node nodeDepartament = document.createElement("Departament");
                        Node nodeDepartamentText = document.createTextNode(cognom);
                        nodeDepartament.appendChild(nodeDepartamentText);

                        Node nodeSou = document.createElement("Sou");
                        Node nodeSouText = document.createTextNode(cognom);
                        nodeSou.appendChild(nodeSouText);
                        // Es crea un Node de tipus Element (<Llibre>)
                        Node nodeLlibre = document.createElement("Empleat");
                        // S'afegeix a llibre un Node de tipus Text amb un \n per a que en obrir-lo amb un
                        // editor de text cada node apareixi en un línia diferent
                        nodeLlibre.appendChild(document.createTextNode("\n"));
                        nodeLlibre.appendChild(nodeId);
                        nodeLlibre.appendChild(document.createTextNode("\n"));
                        nodeLlibre.appendChild(nodeCognom);
                        nodeLlibre.appendChild(document.createTextNode("\n"));
                        nodeLlibre.appendChild(nodeDepartament);
                        nodeLlibre.appendChild(document.createTextNode("\n"));
                        nodeLlibre.appendChild(nodeSou);
                        // Finalment s'obté el primer node del document i s'afegeix com a fill seu el node
                        // llibre que ja té penjant tots els seus fills i atributs creats abans
                        Node nodeArrel = document.getChildNodes().item(0);
                        // Una altra forma de cacular el node arrel.
                        // Node nodeArrel = document.getFirstChild();
                        nodeArrel.appendChild(nodeLlibre);
                    }


                    Node nodeId = document.createElement("Id");
                    Node nodeIdText = document.createTextNode(id);
                    nodeId.appendChild(nodeIdText);
                    // Fem el mateix per a autor
                    Node nodeCognom = document.createElement("Cognom");
                    Node nodeCognomText = document.createTextNode(cognom);
                    nodeCognom.appendChild(nodeCognomText);

                    Node nodeDepartament = document.createElement("Departament");
                    Node nodeDepartamentText = document.createTextNode(cognom);
                    nodeDepartament.appendChild(nodeDepartamentText);

                    Node nodeSou = document.createElement("Sou");
                    Node nodeSouText = document.createTextNode(cognom);
                    nodeSou.appendChild(nodeSouText);
                    // Es crea un Node de tipus Element (<Llibre>)
                    Node nodeLlibre = document.createElement("Empleat");
                    // S'afegeix a llibre un Node de tipus Text amb un \n per a que en obrir-lo amb un
                    // editor de text cada node apareixi en un línia diferent
                    nodeLlibre.appendChild(document.createTextNode("\n"));
                    nodeLlibre.appendChild(nodeId);
                    nodeLlibre.appendChild(document.createTextNode("\n"));
                    nodeLlibre.appendChild(nodeCognom);
                    nodeLlibre.appendChild(document.createTextNode("\n"));
                    nodeLlibre.appendChild(nodeDepartament);
                    nodeLlibre.appendChild(document.createTextNode("\n"));
                    nodeLlibre.appendChild(nodeSou);
                    // Finalment s'obté el primer node del document i s'afegeix com a fill seu el node
                    // llibre que ja té penjant tots els seus fills i atributs creats abans
                    Node nodeArrel = document.getChildNodes().item(0);
                    // Una altra forma de cacular el node arrel.
                    // Node nodeArrel = document.getFirstChild();
                    nodeArrel.appendChild(nodeLlibre);
                    return 0;
                } catch (Exception e) {
                    e.printStackTrace();
                    return -1;
                }
            }
        } catch (Exception e) {
            System.out.println("Error");
        }return -1;
    }

    public String getDOMInfo() {
        String[] nodeData = null;
        String result = "";
        Node node;
        // Obté el primer node del DOM
        Node rootNode = document.getFirstChild();
        // Obté una llista de nodes amb tots els nodes fill
        NodeList nodeList = rootNode.getChildNodes();
        // Processa els nodes fills
        for (int i = 0; i < nodeList.getLength(); i++) {
            node = nodeList.item(i);
            // En executar pas a pas aquest codi , s'observa com els nodes que
            // troba són de tipus 1 (ELEMENT_NODE) i de tipus 3 (TEXT_NODE).
            // Això és perquè en DOM tot element que té un node fill TEXT encara que estigui en BLANC
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                // És un Node llibre que cal processar si és de tipus ELEMENT
                nodeData = processBook(node);

                result += "\n" + "Id: " + nodeData[0];
                result += "\n" + "Cognom: " + nodeData[1];
                result += "\n" + "Departament: " + nodeData[2];
                result += "\n" + "Sou: " + nodeData[3];
                result += "\n" + "--------------------";
            }
        }
        return result;
    }

    protected String[] processBook(Node node) {
        String[] data = new String[4];
        Node tempNode = null;
        int counter = 1;
        // Obté el primer atribut de la llista d'atributs que té el node
        // (en el nostre exemple només hi ha un atribut)
        // Obté els fills del Llibre (títol i autor)
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            tempNode = nodeList.item(i);
            // S'ha de comprovar que el tipus de Node que es vol tractar per que és
            // possible que hi hagi nodes de tipus TEXT que continguin
            // retorns de carro en canviar de línia en XML
            // En aquest exemple, quan es detecta un node que no és de tipus ELEMENT_NODE
            // és perquè és de tipus TEXT_NODE i conté els retorns de carro \n que
            // s'inclouen en el fitxer de text en crear el XML
            if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
                // IMPORTANT: per a obtenir el text amb el títol i l'autor s'accedeix al
                // TEXT_NODE fill del nodeActual i s'agafa el seu valor
                counter++;
            }
        }
        return data;
    }

    public int saveDOMAsFile(File file) {

        // Write the content into an XML file
        try {
            // Prepare the transformation
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(file);
            // Execute the transform
            transformer.transform(domSource, streamResult);

            // Output to console (testing)
            System.out.println("\n## DOM saved as file in: "+file.getPath()+"\n");
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(domSource, consoleResult);

            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void main(String[] args) {
        File inputFile = new File("booksInput.xml");
        File outpuFile = new File("booksInput.xml");

        AlumnesDOM1 books = new AlumnesDOM1();

        books.loadFileIntoDOM(inputFile);
        books.addBookToDOM("002", "Julián", "Boss", "2000");

        System.out.println("## Printing DOM information:");
        System.out.println(books.getDOMInfo());

        books.saveDOMAsFile(outpuFile);
    }
}