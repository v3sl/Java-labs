package studentInfo;

public final class StudentInfo {
    public StudentInfo(int id, String name, int term, String subject, int mark) {
        this.id = id;
        this.name = name;
        this.term = term;
        this.subject = subject;
        this.mark = mark;
    }

    private final int id;
    private final String name;
    private final int term;
    private final String subject;
    private final int mark;

    @Override
    public String toString() {
        return "StudentInfo [id=" + id + ", name=" + name + ", term=" + term + ", subject=" + subject + ", mark=" + mark
                + "]\n";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTerm() {
        return term;
    }

    public String getSubject() {
        return subject;
    }

    public int getMark() {
        return mark;
    }
}
