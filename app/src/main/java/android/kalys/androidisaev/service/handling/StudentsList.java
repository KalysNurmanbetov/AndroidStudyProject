package android.kalys.androidisaev.service.handling;

import android.kalys.androidisaev.service.objects.Group;
import android.kalys.androidisaev.service.objects.Student;
import android.kalys.androidisaev.service.objects.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kalys on 19.04.17.
 */

public class StudentsList implements ListOfStudents{

    private List <Student> students = new ArrayList<>();

    public StudentsList(){
//        fillTestData();
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

        Group ig_1_14 = new Group("ИГ-1-14");
        Group ig_2_14 = new Group("ИГ-2-14");
        Group ig_1_15 = new Group("ИГ-1-15");

        Student student = new Student("Баиш Токтосунов", ig_1_14);
        Student student2 = new Student("Азамат Балабанов", ig_1_15);
        Student student3 = new Student("Жаныш Токтосунов", ig_1_14);
        Student student4 = new Student("Мээрим Суймункулова", ig_2_14);

        student.getSubjects().add(math);
        student.getSubjects().add(programming);
        student.getSubjects().add(deutsch);
        student.getSubjects().add(economic);

        student2.getSubjects().add(new Subject("База данных", "3.8"));
        student2.getSubjects().add(new Subject("Английский язык", "4.8"));
        student2.getSubjects().add(new Subject("Операционные системы", "5.0"));

        student3.getSubjects().add(math);
        student3.getSubjects().add(programming);
        student3.getSubjects().add(deutsch);
        student3.getSubjects().add(economic);

        student4.getSubjects().add(math);
        student4.getSubjects().add(programming);
        student4.getSubjects().add(deutsch);

        student.countGPA();
        student2.countGPA();
        student3.countGPA();
        student4.countGPA();

        students.add(student);
        students.add(student2);
        students.add(student3);
        students.add(student4);
    }

}
