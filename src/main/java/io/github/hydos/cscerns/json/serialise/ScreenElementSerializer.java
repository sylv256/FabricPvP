package io.github.hydos.cscerns.json.serialise;

import com.google.gson.*;

import java.lang.reflect.Type;

public class ScreenElementSerializer implements JsonSerializer<ScreenElement>, JsonDeserializer<ScreenElement> {
	@Override
	public ScreenElement deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		return null;
	}

	@Override
	public JsonElement serialize(ScreenElement src, Type typeOfSrc, JsonSerializationContext context) {
		return null;
	}
}
