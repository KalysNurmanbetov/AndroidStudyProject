package android.kalys.androidisaev;

import android.content.Context;
import android.kalys.androidisaev.test.objects.Group;
import android.kalys.androidisaev.test.objects.Student;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

class MyAdapter extends ArrayAdapter<Student> { //VOT TUT YA ZAPOTEL
    public MyAdapter(@NonNull Context context, List<Student> values) {
        super(context, R.layout.row_layout, values);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater theInflater = LayoutInflater.from(getContext());

        View theView = theInflater.inflate(R.layout.row_layout,
                parent, false);

        Student student = getItem(position);

        TextView theTextView = (TextView) theView.findViewById(R.id.textView1);

        theTextView.setText(Integer.toString(position+1));

        TextView theTextView2 = (TextView) theView.findViewById(R.id.textView2);

        theTextView2.setText(student.getName());

        TextView theTextView3 = (TextView) theView.findViewById(R.id.textView3);

        theTextView3.setText(student.countGPA());

        return theView;

    }
}