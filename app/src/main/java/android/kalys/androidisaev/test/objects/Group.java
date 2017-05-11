package android.kalys.androidisaev.test.objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Group implements Serializable{

    private String name;
    private List<Student> students;

    public Group(){

    }

    public Group(String name){
        this.name = name;
        students = new ArrayList<>();
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString(){
        return "Название Группы: " + name;
    }

}