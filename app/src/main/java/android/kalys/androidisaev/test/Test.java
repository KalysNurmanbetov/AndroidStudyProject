package android.kalys.androidisaev.test;

import android.kalys.androidisaev.test.collections.GroupsCollection;
import android.kalys.androidisaev.test.objects.Group;
import android.kalys.androidisaev.test.objects.Student;
import android.kalys.androidisaev.test.objects.Subject;

/**
 * Created by kalys on 10.05.17.
 */

public class Test {

    private void printAllStudents(GroupsCollection groupsCollection){
        // Все группы
        System.out.println("Все Группы: ");

        for(Group group : groupsCollection.getGroupsCollection()){
            // Выводим группы
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("Студенты Группы: " + group.getName());

            // Выводим студентов группы
            for(Student student : group.getStudents()){
                System.out.println("--------------------------");
                student.printMarks();
            }
        }
    }

    public void test(){
        // Создание групп
        Group ig_1_14 = new Group("IG-1-14");
        Group ig_2_14 = new Group("IG-2-14");

        // Создание студентов
        Student student1 = new Student("Baish Toktosunov", ig_1_14);
        Student student2 = new Student("Salavat Islamov", ig_2_14);
        Student student3 = new Student("Kanat Kashkarlykov", ig_2_14);

        // Привязка студентов к группам
        ig_1_14.getStudents().add(student1);
        ig_2_14.getStudents().add(student2);
        ig_2_14.getStudents().add(student3);

        // Оценки первого студента
        student1.getSubjectsMarks().put(new Subject("Math"),"4.8");
        student1.getSubjectsMarks().put(new Subject("Deutsch"), "5.0");
        student1.getSubjectsMarks().put(new Subject("OOP"),"5.0");

        // Оценки второго студента
        student2.getSubjectsMarks().put(new Subject("Math"), "4.8");
        student2.getSubjectsMarks().put(new Subject("Deutsch"), "5.0");
        student2.getSubjectsMarks().put(new Subject("History"), "5.0");

        // Оценки третьего студента
        student3.getSubjectsMarks().put(new Subject("Math"), "3.6");
        student3.getSubjectsMarks().put(new Subject("Deutsch"), null);
        student3.getSubjectsMarks().put(new Subject("OPP"), "4.7");

        // Создаем коллекцию групп
        GroupsCollection groupsCollection = new GroupsCollection();
        groupsCollection.addGroup(ig_1_14);
        groupsCollection.addGroup(ig_2_14);

        printAllStudents(groupsCollection);
    }


    public static void main(String[] args) {

        Test test = new Test();
        test.test();

    }
}
