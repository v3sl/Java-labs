package xml.strategy;

import java.io.File;

import xml.readers.MyDOMReader;
import xml.xml_student_info.Info;

public class DOMStrategy implements XMLStrategy{
    public DOMStrategy(File file) {
        this.file = file;
    }

    @Override
    public Info getInfo() {
        MyDOMReader reader = new MyDOMReader(file);
        return reader.getInfo();
    }
    
    private File file;
}
