package xml.readers;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import xml.xml_student_info.Info;
import xml.xml_student_info.XMLStudentInfo;

public class MyDOMReader {
    private static final String STUDENT_INFO = "studentInfo";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String TERM = "term";
    private static final String SUBJECT = "subject";
    private static final String MARK = "mark";
    private File file;
    private Info info;

    public MyDOMReader(File file) {
        this.file = file;
        info = new Info();
    }

    public Info getInfo() {
        info.setInfoList(new ArrayList<>());
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName(STUDENT_INFO);
            for (int i = 0; i < nodeList.getLength(); i++) {
                info.getInfoList().add(getStudentInfo(nodeList.item(i)));
            }
        } catch (Exception exc) {
        }
        return info;
    }

    private XMLStudentInfo getStudentInfo(Node node) {
        XMLStudentInfo info = new XMLStudentInfo();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            info.setId(getTagValue(ID, element));
            info.setName(getTagValue(NAME, element));
            info.setTerm(getTagValue(TERM, element));
            info.setSubject(getTagValue(SUBJECT, element));
            info.setMark(getTagValue(MARK, element));
        }
        return info;
    }

    private String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
}
