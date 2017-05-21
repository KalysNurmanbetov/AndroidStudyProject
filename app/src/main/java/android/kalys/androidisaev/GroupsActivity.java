package android.kalys.androidisaev;

import android.content.Intent;
import android.kalys.androidisaev.adapters.GroupsAdapter;
import android.kalys.androidisaev.test.objects.Group;
import android.kalys.androidisaev.test.objects.Student;
import android.kalys.androidisaev.test.objects.Subject;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class GroupsActivity extends AppCompatActivity {

    ListView groupsList;
    ArrayList<Group> groups = new ArrayList<>();
    GroupsAdapter groupsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);

        fillTestData();

        groupsAdapter = new GroupsAdapter(this, groups);

        groupsList = (ListView) findViewById(R.id.groupsList);
        groupsList.setAdapter(groupsAdapter);

        groupsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), TopActivity.class);
                intent.putExtra("group", groups.get(position));
                startActivity(intent);
            }
        });
    }

    public void fillTestData(){
        // Создание групп
        Group ig_1_14 = new Group("IG-1-14");
        Group ig_2_14 = new Group("IG-2-14");
        Group ig_2_16 = new Group("IG-2-16");

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

        groups.add(ig_1_14);
        groups.add(ig_2_14);
        groups.add(ig_2_16);
    }
}
