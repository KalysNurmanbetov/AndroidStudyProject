package android.kalys.androidisaev;

import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);



        /** GradientDrawable - служит для создания линий в таблице*/
        GradientDrawable border = new GradientDrawable();
        border.setColor(0xFFFFFFFF);
        border.setStroke(1, 0xFF000000);

        /** Компоненты интерфейса*/
        TextView nameOfStudent = (TextView) findViewById(R.id.nameStudent); //имя студента
        TextView nameOfGroup = (TextView) findViewById(R.id.groupStudent); //назавние группы
        TextView gpaValue = (TextView) findViewById(R.id.valueGPA); //общая оценка

        /** Вставляем текст в компонент TextView (имя, группа), которые берутся из коллекции или БД */
        //nameOfStudent.setText(studentsList.getStudents().get(0).getName());
        //nameOfGroup.setText(studentsList.getStudents().get(0).getGroup().getName());

        /** Создание таблицы. Так как заранее неизвестно количество предметов, необходимо создать компонеты интрефейса
         * программно. (строки 52-89 - создание таблицы с данными)*/
        TableLayout tableLayout = (TableLayout) findViewById(R.id.table);
        int i = 0;
        /*for(Subject subject : studentsList.getStudents().get(0).getSubjects()){

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
            nameOfSub.setText(subject.getName());
            evalOfSub.setText(subject.getEvaluation());

            TableRow row = new TableRow(this);

            row.addView(numberOfSub);
            row.addView(nameOfSub);
            row.addView(evalOfSub);

            tableLayout.addView(row);
            i++;
        }

        gpaValue.setText(studentsList.getStudents().get(0).getGpa()); // вставляем общую оценку

           */



    }



}
