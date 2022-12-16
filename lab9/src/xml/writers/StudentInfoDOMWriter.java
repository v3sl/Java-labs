package xml.writers;

import java.io.File;
import java.util.ArrayList;
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
import studentInfo.StudentInfo;

public class StudentInfoDOMWriter {
    public static void write(File file, ArrayList<StudentInfo> info)
            throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("studentsInfo");
        doc.appendChild(rootElement);
        for (StudentInfo studentInfo : info) {
            Element staff = doc.createElement("studentsInfo");
            rootElement.appendChild(staff);
            Element id = doc.createElement("id");
            id.setTextContent("" + studentInfo.getId());
            staff.appendChild(id);
            Element name = doc.createElement("name");
            name.setTextContent("" + studentInfo.getName());
            staff.appendChild(name);
            Element term = doc.createElement("term");
            term.setTextContent("" + studentInfo.getTerm());
            staff.appendChild(term);
            Element subject = doc.createElement("subject");
            subject.setTextContent("" + studentInfo.getSubject());
            staff.appendChild(subject);
            Element mark = doc.createElement("mark");
            mark.setTextContent("" + studentInfo.getMark());
            staff.appendChild(mark);
        }
        writeXml(doc, file);
    }

    private static void writeXml(Document doc,
            File file)
            throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(file);
        transformer.transform(source, result);
    }
}
