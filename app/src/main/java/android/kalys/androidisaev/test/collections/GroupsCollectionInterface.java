package android.kalys.androidisaev.test.collections;

import android.kalys.androidisaev.test.objects.Group;

import java.sql.Array;
import java.util.ArrayList;

/**
 * Created by kalys on 10.05.17.
 */

public interface GroupsCollectionInterface {

    void addGroup(Group group);

    void updateGroup(Group group);

    void deleteGroup(Group group);

    ArrayList <Group> getGroupsCollection();
}
