package xml.readers;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import xml.xml_student_info.Info;
import xml.xml_student_info.XMLStudentInfo;

public class MyHandler extends DefaultHandler {
    private static final String STUDENTS_INFO = "studentsInfo";
    private static final String STUDENT_INFO = "studentInfo";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String TERM = "term";
    private static final String SUBJECT = "subject";
    private static final String MARK = "mark";
    private Info info;
    private StringBuilder elementValue;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (elementValue == null) {
            elementValue = new StringBuilder();
        } else {
            elementValue.append(ch, start, length);
        }
    }

    @Override
    public void startDocument() throws SAXException {
        info = new Info();
    }

    @Override
    public void startElement(String uri, String lName, String qName, Attributes attr) throws SAXException {
        switch (qName) {
            case STUDENTS_INFO:
                info.setInfoList(new ArrayList<>());
                break;
            case STUDENT_INFO:
                info.getInfoList().add(new XMLStudentInfo());
                break;
            case ID:
                elementValue = new StringBuilder();
                break;
            case NAME:
                elementValue = new StringBuilder();
                break;
            case TERM:
                elementValue = new StringBuilder();
                break;
            case SUBJECT:
                elementValue = new StringBuilder();
                break;
            case MARK:
                elementValue = new StringBuilder();
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case ID:
                latestArticle().setId(elementValue.toString());
                break;
            case NAME:
                latestArticle().setName(elementValue.toString());
                break;
            case TERM:
                latestArticle().setTerm(elementValue.toString());
                break;
            case SUBJECT:
                latestArticle().setSubject(elementValue.toString());
                break;
            case MARK:
                latestArticle().setMark(elementValue.toString());
                break;
        }
    }

    private XMLStudentInfo latestArticle() {
        List<XMLStudentInfo> articleList = info.getInfoList();
        int latestArticleIndex = articleList.size() - 1;
        return articleList.get(latestArticleIndex);
    }

    public Info getInfo() {
        return info;
    }
}