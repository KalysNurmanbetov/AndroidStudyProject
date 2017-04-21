package android.kalys.androidisaev.service.handling;

import android.kalys.androidisaev.service.objects.Student;

/**
 * Created by kalys on 19.04.17.
 */

public interface ListOfStudents {
    void addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(Student student);
}
