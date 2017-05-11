package android.kalys.androidisaev;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.kalys.androidisaev.test.collections.GroupsCollection;
import android.kalys.androidisaev.test.objects.Group;
import android.kalys.androidisaev.test.objects.Student;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

public class TopActivity extends AppCompatActivity {

    GroupsCollection groupsCollection = new GroupsCollection();

    @SuppressLint("NewApi")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.top_activity);

        /** GradientDrawable - служит для создания линий в таблице*/
        GradientDrawable border = new GradientDrawable();
        border.setColor(0xFFFFFFFF);
        border.setStroke(1, 0xFF000000);

        groupsCollection.fillTestData();

        final Group groupTest = groupsCollection.getGroupsCollection().get(0);

        TextView groupName = (TextView) findViewById(R.id.groupName);

        groupName.setText(groupTest.getName());

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
