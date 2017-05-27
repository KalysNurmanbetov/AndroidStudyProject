package android.kalys.androidisaev.bridge.serializersAndDeserializers;

import com.google.gson.*;
import android.kalys.androidisaev.entities.*;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by kalys on 26.05.17.
 */
public class GroupsSerDes implements JsonSerializer<List<Group>>, JsonDeserializer<List<Group>> {
    @Override
    public List<Group> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        List<Group> groups = new LinkedList<>();

        JsonArray jsonArray = jsonElement.getAsJsonArray();

        for(JsonElement element : jsonArray){
            groups.add((Group) jsonDeserializationContext.deserialize(element,Group.class));
        }

        return groups;
    }

    @Override
    public JsonElement serialize(List<Group> groups, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonArray jsonArray = new JsonArray();

        for(Group group : groups){
            jsonArray.add(jsonSerializationContext.serialize(group));
        }

        return jsonArray;
    }
}
