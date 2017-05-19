package android.kalys.androidisaev.adapters;

import android.content.Context;
import android.kalys.androidisaev.R;
import android.kalys.androidisaev.test.objects.Student;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kalys on 20.05.17.
 */

public class StudentsAdapter extends BaseAdapter {

    Context context;
    ArrayList<Student> students;
    LayoutInflater layoutInflater;

    public StudentsAdapter(Context context, ArrayList<Student> students){
        this.context = context;
        this.students = students;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if(view == null){
            view = layoutInflater.inflate(R.layout.students_items, parent, false);
        }

        TextView numOfStudent = (TextView) view.findViewById(R.id.numOfStudent);
        TextView nameOfStudent = (TextView) view.findViewById(R.id.nameOfStudent);
        TextView gpaOfStudent = (TextView) view.findViewById(R.id.gpaOfStudent);

        Student student = (Student) getItem(position);

        numOfStudent.setText(Integer.toString(position+1));
        nameOfStudent.setText(student.getName());
        gpaOfStudent.setText(student.countGPA());

        return view;
    }
}
