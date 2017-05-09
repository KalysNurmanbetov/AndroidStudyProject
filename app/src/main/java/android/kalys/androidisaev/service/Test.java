package android.kalys.androidisaev.service;

import android.kalys.androidisaev.service.handling.TestHandling;

/**
 * Created by kalys on 19.04.17.
 */

public class Test {
    public static void main(String[] args) {
        TestHandling testHandling = new TestHandling();

        testHandling.fillTestData();

        testHandling.printTestData();
    }
}
