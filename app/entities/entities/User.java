package android.kalys.androidisaev.entities;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by kalys on 26.05.17.
 */

public class User {
    private String firsName;
    private String lastName;
    private Group group;
    private String email;
    private List<Float> marks;

    public User(){
        marks = new LinkedList<>();
    }

    public User(String firsName, String lastName, Group group, String email) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.group = group;
        this.email = email;
        marks = new LinkedList<>();
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Float> getMarks() {
        return marks;
    }

    public void setMarks(List<Float> marks) {
        this.marks = marks;
    }

    public float countGPA(){
        float gpa = 0;
        for(float temp : marks){
            gpa += temp;
        }
        gpa = gpa/marks.size();

        return gpa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (firsName != null ? !firsName.equals(user.firsName) : user.firsName != null)
            return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null)
            return false;
        if (group != null ? !group.equals(user.group) : user.group != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        return marks != null ? marks.equals(user.marks) : user.marks == null;

    }

    @Override
    public int hashCode() {
        int result = firsName != null ? firsName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (marks != null ? marks.hashCode() : 0);
        return result;
    }
}
