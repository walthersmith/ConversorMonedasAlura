package com.walther.models;

import com.google.gson.*;
import com.google.gson.annotations.JsonAdapter;

import java.lang.reflect.Type;

public class CurrencyAdapter  implements JsonDeserializer<Currency> {


    @Override
    public Currency deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonArray jsonObject = json.getAsJsonArray();
        String code = jsonObject.get(0).getAsString();
        String name = jsonObject.get(1).getAsString();
        return new Currency(code, name);
    }
}
