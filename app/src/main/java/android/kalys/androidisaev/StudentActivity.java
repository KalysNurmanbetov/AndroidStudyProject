package android.kalys.androidisaev;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.kalys.androidisaev.test.objects.Student;
import android.kalys.androidisaev.test.objects.Subject;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Map;

public class StudentActivity extends AppCompatActivity {


    @SuppressLint("NewApi")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        Intent intent = getIntent();
        Student student = (Student) intent.getSerializableExtra("student");



        /** GradientDrawable - служит для создания линий в таблице*/
        GradientDrawable border = new GradientDrawable();
        border.setColor(0xFFFFFFFF);
        border.setStroke(1, 0xFF000000);

        /** Компоненты интерфейса*/
        TextView nameOfStudent = (TextView) findViewById(R.id.nameStudent); //имя студента
        TextView nameOfGroup = (TextView) findViewById(R.id.groupStudent); //назавние группы
        TextView gpaValue = (TextView) findViewById(R.id.valueGPA); //общая оценка

        /** Вставляем текст в компонент TextView (имя, группа), которые берутся из коллекции или БД */
        nameOfStudent.setText(student.getName());
        nameOfGroup.setText(student.getGroup().getName());

        /** Создание таблицы. Так как заранее неизвестно количество предметов, необходимо создать компонеты интрефейса
         * программно. (строки 52-89 - создание таблицы с данными)*/
        TableLayout tableLayout = (TableLayout) findViewById(R.id.table);
        int i = 0;
        for(Map.Entry<Subject, String> entry : student.getSubjectsMarks().entrySet() ){

            TextView numberOfSub = new TextView(this);
            numberOfSub.setPadding(5,5,5,5);
            numberOfSub.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 2f));

            TextView nameOfSub = new TextView(this);
            nameOfSub.setPadding(5,5,5,5);
            nameOfSub.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 5f));

            TextView evalOfSub = new TextView(this);
            evalOfSub.setPadding(5,5,5,5);
            evalOfSub.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 2f));

            numberOfSub.setTextSize(18);
            nameOfSub.setTextSize(18);
            evalOfSub.setTextSize(18);

            numberOfSub.setBackground(border);
            nameOfSub.setBackground(border);
            evalOfSub.setBackground(border);

            numberOfSub.setText(String.valueOf(i+1));
            nameOfSub.setText(entry.getKey().getName());
            evalOfSub.setText(entry.getValue());

            TableRow row = new TableRow(this);

            row.addView(numberOfSub);
            row.addView(nameOfSub);
            row.addView(evalOfSub);

            tableLayout.addView(row);
            i++;
        }

        gpaValue.setText(student.countGPA()); // вставляем общую оценку





    }



}
