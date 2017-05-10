package android.kalys.androidisaev.test.collections;

import android.kalys.androidisaev.test.objects.Group;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kalys on 10.05.17.
 */

public class GroupsCollection implements GroupsCollectionInterface {

    private List <Group> groupsList;

    public GroupsCollection(){
        groupsList = new ArrayList<>();
    }

    @Override
    public void addGroup(Group group) {
        groupsList.add(group);
    }

    @Override
    public void updateGroup(Group group) {

    }

    @Override
    public void deleteGroup(Group group) {
        groupsList.remove(group);
    }

    @Override
    public ArrayList<Group> getGroupsCollection() {
        return (ArrayList<Group>) groupsList;
    }

    public void printGroups(){
        for(Group group : groupsList){
            System.out.println(group);
        }
    }
}
