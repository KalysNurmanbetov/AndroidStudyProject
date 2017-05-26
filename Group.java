package android.kalys.androidisaev.entities;

import java.util.ArrayList;
import java.util.List;

/**

 */

public class Group {
    private String groupName;
    private String course;
    private List<User> users;

    public Group(){
        users = new ArrayList<>();
    }

    public Group(String groupName, String course) {
        this.groupName = groupName;
        this.course = course;
        users = new ArrayList<>();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
