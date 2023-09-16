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

public class Main {
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
                    System.out.println("Student №" + (i + 1));

                    System.out.println('\t' + studentElement.getTagName() + ": " + studentElement.getAttribute("firstname"));
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
