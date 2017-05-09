package android.kalys.androidisaev.service;

import android.kalys.androidisaev.service.handling.StudentsList;

/**
 * Created by kalys on 19.04.17.
 */

public class Test {
    public static void main(String[] args) {
        StudentsList studentsList = new StudentsList();

        studentsList.fillTestData();

        studentsList.printTestData();
    }
}
