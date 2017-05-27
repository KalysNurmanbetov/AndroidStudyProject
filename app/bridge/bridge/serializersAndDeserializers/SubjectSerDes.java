package android.kalys.androidisaev.bridge.serializersAndDeserializers;

import android.kalys.androidisaev.entities.*;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Created by kalys on 26.05.17.
 */

public class SubjectSerDes implements JsonSerializer<Subject>, JsonDeserializer<Subject>{
    @Override
    public JsonElement serialize(Subject subject, Type type, JsonSerializationContext jsonSerializationContext) {

        return new JsonPrimitive(subject.getSubjectName());
    }

    @Override
    public Subject deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Subject subject = new Subject();

        JsonObject jsonObject = jsonElement.getAsJsonObject();

        subject.setSubjectName(jsonObject.get("subjectName").getAsString());

        return subject;
    }
}
