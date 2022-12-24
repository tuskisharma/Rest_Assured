package GoogleMaps;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
public class GoogleMapsTests {
	public String key="qaclick123";
	public String str;
	@Test
	public void Post() {
		JSONObject js=new JSONObject();
		JSONArray je=new JSONArray();
		JSONObject ja=new JSONObject();
		JsonPath jr=new JsonPath(ja.toJSONString());
		str=jr.get("place_id");
		baseURI="http://216.10.245.166";
		js.put("lat", -38.383494);
		js.put("lng", 33.427362);
		je.add(js);
		ja.put("location",js);
		ja.put("accuracy", 50);
		ja.put("name", "Frontline house");
		ja.put("phone_number", "(+91)9838933937");
		ja.put("address", "29, side layout, cohen 09");
		ja.put("types", "shoe park");
		ja.put("website", "http://google.com");
		ja.put("language","French-IN" );
		
		given().header("Content-Type","application/json")
		.body(ja.toJSONString()).when().post("/maps/api/place/add/json")
		.then().statusCode(200).log().all();
		given().queryParam(key);
	}
	@Test
	public void delete() {
		JSONObject js=new JSONObject();
		js.put("place_id", str);
		baseURI="http://216.10.245.166";
		given().queryParam(key).header("Content-Type","application/json")
		.body(js.toJSONString()).when().delete("maps/api/place/delete/json")
		.then().statusCode(200).log().all();
	}

}
