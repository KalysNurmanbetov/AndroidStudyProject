package android.kalys.androidisaev;

import android.graphics.drawable.GradientDrawable;
import android.kalys.androidisaev.service.handling.TestHandling;
import android.kalys.androidisaev.service.objects.Subject;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TestHandling testHandling = new TestHandling();

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        testHandling.fillTestData();

        GradientDrawable border = new GradientDrawable();
        border.setColor(0xFFFFFFFF);
        border.setStroke(1, 0xFF000000);

        TextView nameOfStudent = (TextView) findViewById(R.id.nameStudent);
        TextView nameOfGroup = (TextView) findViewById(R.id.groupStudent);

        nameOfStudent.setText(testHandling.getStudents().get(0).getName());
        nameOfGroup.setText(testHandling.getStudents().get(0).getGroup());

        TableRow.LayoutParams  tl = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);

        TableLayout tableLayout = (TableLayout) findViewById(R.id.table);
        int i = 0;
        for(Subject subject : testHandling.getStudents().get(0).getSubjects()){

            TextView numberOfSub = new TextView(this);
            tl.setMargins(5,5,5,5);
            numberOfSub.setLayoutParams(tl);

            TextView nameOfSub = new TextView(this);
            tl.weight = 10;
            nameOfSub.setLayoutParams(tl);

            TextView evalOfSub = new TextView(this);
            tl.weight = 0;
            evalOfSub.setLayoutParams(tl);

            numberOfSub.setTextSize(18);
            nameOfSub.setTextSize(18);
            evalOfSub.setTextSize(18);

            numberOfSub.setBackground(border);
            nameOfSub.setBackground(border);
            evalOfSub.setBackground(border);

            numberOfSub.setText(String.valueOf(i+1));
            nameOfSub.setText(subject.getName());
            evalOfSub.setText(subject.getEvaluation());

            TableRow row = new TableRow(this);

            row.addView(numberOfSub);
            row.addView(nameOfSub);
            row.addView(evalOfSub);

            tableLayout.addView(row);
            i++;
        }
        TextView gpaText = new TextView(this);
        gpaText.setLayoutParams(tl);
        TextView gpaView = new TextView(this);
        gpaView.setLayoutParams(tl);

        gpaText.setTextSize(18);
        gpaView.setTextSize(18);

        gpaText.setText("Общая оценка");
        gpaView.setText(testHandling.getStudents().get(0).getGpa());

        TableRow row = new TableRow(this);
        TableLayout.LayoutParams tableLP = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);
        tableLP.setMargins(5,100,5,0);
        row.setLayoutParams(tableLP);

        row.addView(gpaView);

        tableLayout.addView(row);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
