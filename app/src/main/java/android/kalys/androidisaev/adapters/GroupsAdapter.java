package android.kalys.androidisaev.adapters;

import android.content.Context;
import android.kalys.androidisaev.R;
import android.kalys.androidisaev.test.objects.Group;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kalys on 19.05.17.
 */

public class GroupsAdapter extends BaseAdapter{

    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Group> groupArrayList;

    public GroupsAdapter(Context context, ArrayList<Group> groups){
        this.context = context;
        groupArrayList = groups;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return groupArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return groupArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = layoutInflater.inflate(R.layout.groups_items, parent, false);
        }

        Group group = (Group) getItem(position);

        TextView groupsName = (TextView) view.findViewById(R.id.nameOfGroup);

       groupsName.setText(group.name);

        return view;
    }
}
