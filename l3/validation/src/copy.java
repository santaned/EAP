import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class copy {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("src/class.xml"));
            document.getDocumentElement().normalize();
            NodeList studentList = document.getElementsByTagName("student");
            for (int i = 0; i < studentList.getLength(); i++){
                Node student = studentList.item(i);

                if(student.getNodeType() == Node.ELEMENT_NODE){
                    Element studentElement = (Element) student;
                    NodeList studentDetails = student.getChildNodes();
                    String id = studentElement.getAttribute("id");
                    System.out.println("Student №" + id);

                    for (int j = 0; j < studentDetails.getLength(); j++){
                        Node detail = studentDetails.item(j);

                        if(detail.getNodeType() == Node.ELEMENT_NODE){
                            Element detailElement = (Element) detail;
                            System.out.println('\t' + detailElement.getTagName() + ": " + detailElement.getTextContent());
                        }
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
