package android.kalys.androidisaev.entities;

/**
 * Created by kalys on 26.05.17.
 */

public class Subject {
    private String subjectName;

    public Subject(){}

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
