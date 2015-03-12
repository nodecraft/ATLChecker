package com.orthus.ATLChecker.Json;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonReader {
	public static String main(String packName) {
		String API = "https://api.atlauncher.com/v1/pack/" + packName, LatestVersion = "null";

		try {
			URL oracle = new URL(API);
			JsonParser jsonParser = new JsonParser();
			JsonObject jsonObject = (JsonObject) jsonParser.parse(new InputStreamReader(oracle.openStream()));
			JsonElement JsonCheck = jsonObject.get("error");

			if (!JsonCheck.isJsonObject()) {
				boolean err = JsonCheck.getAsBoolean();
				if (err)
					System.out.println(err);
				else {
					JsonObject structure = (JsonObject) jsonObject.get("data");
					JsonObject LatestObject = ((JsonArray) structure.get("versions")).get(0).getAsJsonObject();
					LatestVersion = LatestObject.get("version").getAsString();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return LatestVersion;
	}
}