package android.kalys.androidisaev;

import android.graphics.drawable.GradientDrawable;
import android.kalys.androidisaev.test.collections.GroupsCollection;
import android.kalys.androidisaev.test.objects.Group;
import android.kalys.androidisaev.test.objects.Student;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class TopActivity extends AppCompatActivity {

    GroupsCollection groupsCollection = new GroupsCollection();

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        /** GradientDrawable - служит для создания линий в таблице*/
        GradientDrawable border = new GradientDrawable();
        border.setColor(0xFFFFFFFF);
        border.setStroke(1, 0xFF000000);

        groupsCollection.fillTestData();

        Group groupTest = groupsCollection.getGroupsCollection().get(1);

        TextView groupName = (TextView) findViewById(R.id.groupName);

        groupName.setText(groupTest.getName());

        TableLayout topTable = (TableLayout) findViewById(R.id.topStudenstTable);
        int i = 0;

        for(Student student : groupTest.getStudents()){
            TextView numberOfStudent = new TextView(this);
            numberOfStudent.setPadding(5,5,5,5);
            numberOfStudent.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 2f));

            TextView nameOfStudent = new TextView(this);
            nameOfStudent.setPadding(5,5,5,5);
            nameOfStudent.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 5f));

            TextView markGPAOfStudent = new TextView(this);
            markGPAOfStudent.setPadding(5,5,5,5);
            markGPAOfStudent.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 2f));

            numberOfStudent.setTextSize(18);
            nameOfStudent.setTextSize(18);
            markGPAOfStudent.setTextSize(18);

            numberOfStudent.setBackground(border);
            nameOfStudent.setBackground(border);
            markGPAOfStudent.setBackground(border);

            numberOfStudent.setText(String.valueOf(i+1));
            nameOfStudent.setText(student.getName());
            markGPAOfStudent.setText(student.countGPA());

            TableRow row = new TableRow(this);

            row.addView(numberOfStudent);
            row.addView(nameOfStudent);
            row.addView(markGPAOfStudent);

            topTable.addView(row);
            i++;
        }
    }
}
