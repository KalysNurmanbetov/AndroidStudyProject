package android.kalys.androidisaev.service.handling;

import android.kalys.androidisaev.service.objects.Student;
import android.kalys.androidisaev.service.objects.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kalys on 19.04.17.
 */

public class TestHandling implements ListOfStudents{

    private List <Student> students = new ArrayList<>();

    public TestHandling(){
        fillTestData();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void deleteStudent(Student student) {
        students.remove(student);
    }

    public void printTestData(){
        for (Student student: students){
            System.out.println(student);
            for(Subject subject: student.getSubjects()){
                System.out.println(subject);
            }
            System.out.println("Общая оценка: " + student.getGpa());
        }
    }

    public void fillTestData(){
        Subject math = new Subject("Математика", "4.7");
        Subject programming = new Subject("Программирование", "5.0");
        Subject deutsch = new Subject("Немецкий", "5.0");
        Subject economic = new Subject("Экономика", "4.7");

        Student student = new Student("Баиш Токтосунов", "ИГ-1-14");

        student.getSubjects().add(math);
        student.getSubjects().add(programming);
        student.getSubjects().add(deutsch);
        student.getSubjects().add(economic);

        student.countGPA();

        students.add(student);
    }

}
