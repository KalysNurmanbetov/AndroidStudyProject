package android.kalys.androidisaev.bridge.serializersAndDeserializers;

import android.kalys.androidisaev.entities.*;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Created by kalys on 26.05.17.
 */

public class UserSerDes implements JsonSerializer<User>, JsonDeserializer<User> {
    @Override
    public JsonElement serialize(User user, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject result = new JsonObject();
        result.addProperty("email", user.getEmail());
        result.addProperty("firstName", user.getFirsName());
        result.addProperty("lastName", user.getLastName());
        JsonObject group = new JsonObject();

        group.addProperty("groupname",user.getGroup().getGroupName());
        group.addProperty("course",user.getGroup().getCourse());

        result.add("group", group);

        return result;
    }

    @Override
    public User deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        User user = new User();

        JsonObject jsonObject = jsonElement.getAsJsonObject();

        user.setFirsName(jsonObject.get("firstName").getAsString());
        user.setLastName(jsonObject.get("lastName").getAsString());
        user.setEmail(jsonObject.get("email").getAsString());

        JsonObject groupFromJson = jsonObject.getAsJsonObject("group");
        Group group = new Group();
        group.setGroupName(groupFromJson.get("groupname").getAsString());
        group.setCourse(groupFromJson.get("course").getAsString());

        user.setGroup(group);


        return user;
    }
}
