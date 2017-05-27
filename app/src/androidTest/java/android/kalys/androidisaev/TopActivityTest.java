package android.kalys.androidisaev;

import static org.junit.Assert.*;

/**
 * Created by User on 27.05.2017.
 */
import android.annotation.SuppressLint;
import android.content.Intent;
import android.kalys.androidisaev.adapters.StudentsAdapter;
import android.kalys.androidisaev.test.objects.Group;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import android.widget.ListView;

import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;

import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

public class TopActivity extends AppCompatActivity {

    @SuppressLint("NewApi")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.top_activity);

        Intent intent = getIntent();

        final Group groupTest = (Group) intent.getSerializableExtra("group");


//        final Group groupTest = groupsCollection.getGroupsCollection().get(0);
//

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




        ListAdapter theAdapter = new MyAdapter(this, groupTest.getStudents());

        ListView theListView = (ListView) findViewById(R.id.theListView);

        theListView.setAdapter(theAdapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Intent intent = new Intent(view.getContext(), StudentActivity.class);
                intent.putExtra("student", groupTest.getStudents().get(position));
                startActivity(intent);

            }
        });

    }
}
