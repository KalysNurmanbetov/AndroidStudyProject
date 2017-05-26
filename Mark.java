package android.kalys.androidisaev.entities;

/**

 */

public class Mark {
    private float markSubject;
    private long semester;
    private Subject subject;
    private User user;

    public Mark(){}

    public Mark(float markSubject, long semester, Subject subject, User user) {
        this.markSubject = markSubject;
        this.semester = semester;
        this.subject = subject;
        this.user = user;
    }

    public float getMarkSubject() {
        return markSubject;
    }

    public void setMarkSubject(float markSubject) {
        this.markSubject = markSubject;
    }

    public long getSemester() {
        return semester;
    }

    public void setSemester(long semester) {
        this.semester = semester;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString(){
        return "[" + markSubject + ", Semester: " + semester + ", Subject: " + subject.getSubjectName()
                + ", User: " + user.getFirsName() + " " + user.getLastName() + "]";
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mark mark = (Mark) o;

        if (Float.compare(mark.markSubject, markSubject) != 0) return false;
        if (semester != mark.semester) return false;
        if (subject != null ? !subject.equals(mark.subject) : mark.subject != null) return false;
        return user != null ? user.equals(mark.user) : mark.user == null;

    }

    @Override
    public int hashCode() {
        int result = (markSubject != +0.0f ? Float.floatToIntBits(markSubject) : 0);
        result = 31 * result + (int) (semester ^ (semester >>> 32));
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
