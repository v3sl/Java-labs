package strategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import studentInfo.StudentInfo;

public class StreamStrategy extends Strategy {
    public StreamStrategy(int term, String[] subjects, ArrayList<StudentInfo> info) {
        this.term = term;
        this.subjects = subjects;
        this.info = info;
    }

    @Override
    public void findNecessaryStudents() {
        for (String subject : subjects) {
            ArrayList<StudentInfo> passedStudents = new ArrayList<>(info.stream()
                    .filter(st -> st.getTerm() == term && st.getSubject().equals(subject) && st.getMark() >= 4)
                    .toList());
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
        info = new ArrayList<>(info.stream().sorted(new Comparator<StudentInfo>() {
            @Override
            public int compare(StudentInfo o1, StudentInfo o2) {
                if (o1.getSubject().equals(o2.getSubject())) {
                    return o1.getName().compareTo(o2.getName());
                }
                return o1.getSubject().compareTo(o2.getSubject());
            }
        }).toList());
    }

    private int term;
    private String[] subjects;
    private ArrayList<StudentInfo> info;
}
