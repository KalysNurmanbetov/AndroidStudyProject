package android.kalys.androidisaev.service.objects;


import android.kalys.androidisaev.service.handling.StudentsList;


public class Group {

    private String name;
    private StudentsList studentsList = new StudentsList();

    public Group(){

    }

    public Group(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentsList getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(StudentsList studentsList) {
        this.studentsList = studentsList;
    }
}
