package strategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import studentInfo.StudentInfo;

public class DefaultStrategy extends Strategy {
    public DefaultStrategy(int term, String[] subjects, ArrayList<StudentInfo> info) {
        this.term = term;
        this.subjects = subjects;
        this.info = info;
    }

    @Override
    public void findNecessaryStudents() {
        for (String subject : subjects) {
            ArrayList<StudentInfo> passedStudents = new ArrayList<>();
            for (StudentInfo i : info) {
                if (i.getTerm() == term && i.getSubject().equals(subject) && i.getMark() >= 4) {
                    passedStudents.add(i);
                }
            }
            info.removeAll(passedStudents);
            Set<Integer> ids = new HashSet<>();
            passedStudents.forEach(st -> ids.add(st.getId()));
            passedStudents.clear();
            info.forEach(st -> {
                if (ids.contains(st.getId())) {
                    passedStudents.add(st);
                }
            });
            info.removeAll(passedStudents);
        }
        info.sort(new Comparator<StudentInfo>() {
            @Override
            public int compare(StudentInfo o1, StudentInfo o2) {
                if (o1.getSubject().equals(o2.getSubject())) {
                    return o1.getName().compareTo(o2.getName());
                }
                return o1.getSubject().compareTo(o2.getSubject());
            }
        });
    }

    private int term;
    private String[] subjects;
    private ArrayList<StudentInfo> info;
}
