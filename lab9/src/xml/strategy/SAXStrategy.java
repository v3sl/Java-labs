package xml.strategy;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import xml.readers.MyHandler;
import xml.xml_student_info.Info;

public class SAXStrategy implements XMLStrategy {

    public SAXStrategy(File file) {
        this.file = file;
    }

    @Override
    public Info getInfo() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            saxParser.parse(file.getName(), handler);
            return handler.getInfo();
        } catch (Exception ex) {
            return null;
        }
    }

    private File file;
}
