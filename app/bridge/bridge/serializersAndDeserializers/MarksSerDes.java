package android.kalys.androidisaev.bridge.serializersAndDeserializers;

import android.kalys.androidisaev.entities.*;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by kalys on 26.05.17.
 */

public class MarksSerDes implements JsonSerializer<List<Mark>>, JsonDeserializer<List<Mark>> {
    @Override
    public JsonElement serialize(List<Mark> marks, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonArray jsonArray = new JsonArray();

        for(Mark mark : marks){
            jsonArray.add(jsonSerializationContext.serialize(mark));
        }

        return jsonArray;
    }

    @Override
    public List<Mark> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        List <Mark> marks = new LinkedList<>();
        JsonArray jsonArray = jsonElement.getAsJsonArray();

        for(JsonElement element : jsonArray){
            marks.add((Mark) jsonDeserializationContext.deserialize(element, Mark.class));
        }

        return marks;
    }
}
