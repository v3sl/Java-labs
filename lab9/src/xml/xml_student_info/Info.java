package xml.xml_student_info;
import java.util.List;

public class Info {
    public List<XMLStudentInfo> getInfoList() {
        return infoList;
    }

    public void setInfoList(List<XMLStudentInfo> infoList) {
        this.infoList = infoList;
    }

    private List<XMLStudentInfo> infoList;
}