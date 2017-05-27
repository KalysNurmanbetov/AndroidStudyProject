package android.kalys.androidisaev.bridge.serializersAndDeserializers;

import android.kalys.androidisaev.entities.*;

import android.kalys.androidisaev.entities.*;

import com.google.gson.*;


import java.lang.reflect.Type;


public class GroupSerDes implements JsonSerializer<Group>, JsonDeserializer<Group>{
    @Override
    public JsonElement serialize(Group group, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject result = new JsonObject();

        result.addProperty("groupname",group.getGroupName());
        result.addProperty("course", group.getCourse());

        if(group.getUsers().size() != 0) {
            JsonArray users = new JsonArray();
            result.add("users", users);
            for (User user : group.getUsers()) {
                users.add(jsonSerializationContext.serialize(user));
            }
        }



        return result;
    }

    @Override
    public Group deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Group group = new Group();

        JsonObject jsonObject = jsonElement.getAsJsonObject();

        group.setGroupName(jsonObject.get("groupname").getAsString());
        group.setCourse(jsonObject.get("course").getAsString());

        JsonArray users = jsonObject.getAsJsonArray("users");

        if(users != null) {
            if (users.size() != 0) {
                for (JsonElement user : users) {
                    group.getUsers().add((User) jsonDeserializationContext.deserialize(user, User.class));
                }
            }
        }

        return group;
    }
}
