package android.kalys.androidisaev.test.objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Group implements Serializable{

    public String name;
    private ArrayList<Student> students;

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

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public String toString(){
        return "Название Группы: " + name;
    }

}
