package android.kalys.androidisaev.service.objects;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by kalys on 19.04.17.
 */

public class Student {
    private String name;
    private String group;
    private String gpa;

    private List <Subject> subjects = new ArrayList<>();

    public Student(String name, String group){
        this.name = name;
        this.group = group;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void countGPA(){
        double valueOfgpa = 0;
        String gpa;

        for(Subject subject: subjects){
            valueOfgpa = valueOfgpa + Double.parseDouble(subject.getEvaluation());
        }

        valueOfgpa = valueOfgpa / subjects.size();
        gpa = String.valueOf(valueOfgpa);

        this.gpa = gpa;
    }

    @Override
    public String toString(){
        return "Имя: " + name + ". Группа: " + group;
    }


}
