package restpackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class RestAPITesting {
    
	@Test
	public void test_examples() {
		Response re=get("https://reqres.in/api/users?page=2");
		System.out.println(re.getStatusCode());
		System.out.println(re.getStatusLine());
		System.out.println(re.getTime());
		System.out.println(re.getHeader("content-type"));
		System.out.println(re.getBody().asString());
		
		int statuscode=re.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}
	@Test
	public void tc_1() {
		 baseURI = "https://reqres.in";
		 given().get("/api/users?page=2")
		 .then().statusCode(200)
		 .body("data[0].id", equalTo(7)).log().all();
	}
	@Test
	public void testPost() {
		JSONObject js=new JSONObject();
		baseURI="https://reqres.in";
		js.put("name", "tushar");
		js.put("job", "rider");
		System.out.println(js.toJSONString());
		given().header("Content-Type","application/json")
		.body(js.toJSONString()).when().post("api/users").then().statusCode(201).log().all();
		
	}
	@Test
	public void put() {
		JSONObject js=new JSONObject();
		baseURI = "https://reqres.in";
		js.put("name", "tushar");
		js.put("job", "rider");
		System.out.println(js.toJSONString());
		given().header("Content-Type","application/json")
		.body(js.toJSONString()).when().put("api/users/2").then().statusCode(200).log().all();
		

	}
	@Test
	public void patchtest() {
		JSONObject js=new JSONObject();
		baseURI = "https://reqres.in";
		js.put("name", "tushar");
		js.put("job", "biker");
		System.out.println(js.toJSONString());
		given().header("Content-Type","application/json")
		.body(js.toJSONString()).when().patch("api/users/2").then().statusCode(200).log().all();
		
	}
	@Test
	public void deletetest() {
		baseURI = "https://reqres.in";
		when().delete("/api/users/2").then().statusCode(204).log().all();
	}
}
