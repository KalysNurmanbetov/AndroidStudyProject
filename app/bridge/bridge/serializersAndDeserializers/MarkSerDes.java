package android.kalys.androidisaev.bridge.serializersAndDeserializers;

import android.kalys.androidisaev.entities.*;

import com.google.gson.*;

import java.lang.reflect.Type;


/**
 * Created by kalys on 26.05.17.
 */

public class MarkSerDes implements JsonSerializer<Mark>, JsonDeserializer<Mark> {
    @Override
    public JsonElement serialize(Mark mark, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject result = new JsonObject();

        result.addProperty("markSubject",mark.getMarkSubject());
        result.addProperty("semester",mark.getSemester());
        result.add("subject",jsonSerializationContext.serialize(mark.getSubject()));
        result.add("user",jsonSerializationContext.serialize(mark.getUser()));

        return result;
    }

    @Override
    public Mark deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Mark mark = new Mark();

        JsonObject jsonObject = jsonElement.getAsJsonObject();

        mark.setMarkSubject(jsonObject.get("markSubject").getAsFloat());
        mark.setSemester(jsonObject.get("semester").getAsLong());
        mark.setSubject((Subject) jsonDeserializationContext.deserialize(jsonObject.get("subject"),Subject.class));
        mark.setUser((User) jsonDeserializationContext.deserialize(jsonObject.get("user"), User.class));


        return mark;
    }
}
