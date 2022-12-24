package TestsAPI;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class TestsAPIDemos {
	
	@Test
	public void Get() {
		baseURI="http://localhost:3000/";
		given().get("users").then().statusCode(200).log().all();
	}
	//@Test
	public void Post() {
		JSONObject js=new JSONObject();
		baseURI="http://localhost:3000/";
		js.put("first_name", "kiara");
		js.put("last_name", "sharma");
		js.put("subjectId", 11);
		given().header("Content-Type", "application/json").body(js.toJSONString()).when()
		.post("users").then().statusCode(201).log().all();
	}
	@Test
	public void Put() {
		JSONObject js=new JSONObject();
		baseURI="http://localhost:3000/";
		js.put("first_name", "kylian");
		js.put("last_name", "verma");
		js.put("subjectId", 11);
		given().header("Content-Type", "application/json").body(js.toJSONString()).when()
		.put("users/13").then().statusCode(200).log().all();
	}
	@Test
	public void Patch() {
		JSONObject js=new JSONObject();
		baseURI="http://localhost:3000/";
		js.put("last_name", "suarez");
		
		given().header("Content-Type", "application/json").body(js.toJSONString()).when()
		.patch("users/15").then().statusCode(200).log().all();
	}
	@Test
	public void delete() {
		baseURI="http://localhost:3000/";
		given().when()
		.delete("users/17").then().statusCode(200).log().all();
	}

}
