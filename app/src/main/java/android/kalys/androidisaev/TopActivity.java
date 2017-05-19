package android.kalys.androidisaev;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.kalys.androidisaev.adapters.StudentsAdapter;
import android.kalys.androidisaev.test.objects.Group;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONObject;

public class TopActivity extends AppCompatActivity {

    @SuppressLint("NewApi")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        Intent intent = getIntent();

        final Group groupTest = (Group) intent.getSerializableExtra("group");


        TextView groupName = (TextView) findViewById(R.id.groupName);

        groupName.setText(groupTest.getName());

        ListView listOfStudents = (ListView) findViewById(R.id.listOfStudents);

        StudentsAdapter studentsAdapter = new StudentsAdapter(this, groupTest.getStudents());

        listOfStudents.setAdapter(studentsAdapter);

        listOfStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), StudentActivity.class);
                intent.putExtra("student", groupTest.getStudents().get(position));
                startActivity(intent);
            }
        });



    }
}
