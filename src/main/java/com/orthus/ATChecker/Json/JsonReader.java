package com.orthus.ATChecker.Json;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.orthus.ATChecker.*;

import cpw.mods.fml.common.FMLLog;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;


public class JsonReader {
	
	@SuppressWarnings("finally")
	public static String main(String str1) {
		String API = "https://api.atlauncher.com/v1/pack/"+ str1;
		String LatestVersion = "null";
		System.out.println("JsonReader running");
		try 
		{
			
			// read the json file
			URL oracle = new URL(API);
			
			Reader in = new InputStreamReader(oracle.openStream());
			JsonParser jsonParser = new JsonParser();
			JsonObject jsonObject = (JsonObject) jsonParser.parse(in);
			// get a String from the JSON object
			//JsonObject is a JsonElement but you can't use JsonElement as JsonObject, JsonObject is needed to get value data from a key.
			JsonElement JsonCheck = jsonObject.get("error");
			if (JsonCheck.isJsonObject() != true ){
				boolean ErrorMessage = JsonCheck.getAsBoolean();
				if (ErrorMessage == true){
					System.out.println(ErrorMessage);
				}
				else {			// handle a structure into the json object
				JsonObject structure = (JsonObject) jsonObject.get("data");
				// Select key for versions array
				JsonArray Ver = (JsonArray) structure.get("versions");
				// Select latest version to check version string, API v1 uses first object for latest version
				JsonObject LatestObject = Ver.get(0).getAsJsonObject();
				// Send latest version back
				String GotVersion = LatestObject.get("version").getAsString();
				System.out.println(GotVersion);
				LatestVersion = GotVersion;
				}
			}
			else
			{
				LatestVersion = "null";
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			return LatestVersion;
		}
		
	}
}

