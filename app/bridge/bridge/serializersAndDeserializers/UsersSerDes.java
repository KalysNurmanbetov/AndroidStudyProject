package android.kalys.androidisaev.bridge.serializersAndDeserializers;

import android.kalys.androidisaev.entities.User;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by kalys on 26.05.17.
 */

public class UsersSerDes implements JsonSerializer<List<User>>, JsonDeserializer<List<User>> {
    @Override
    public List<User> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        List <User> users = new LinkedList<>();
        JsonArray jsonArray = json.getAsJsonArray();

        for(JsonElement element : jsonArray){
            users.add((User) context.deserialize(element, User.class));
        }

        return users;
    }

    @Override
    public JsonElement serialize(List<User> src, Type typeOfSrc, JsonSerializationContext context) {

        JsonArray jsonArray = new JsonArray();

        for(User user : src){
            jsonArray.add(context.serialize(user));
        }

        return jsonArray;
    }
}
