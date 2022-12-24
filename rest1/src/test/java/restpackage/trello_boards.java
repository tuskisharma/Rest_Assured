package restpackage;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

public class trello_boards {
	public String url="https://api.trello.com/";
	public String keys="840c6ff73133d65cae538c2b01d91f8c";
	public String token="d0f81b8b8acde55269ae56765ca4d9219236005b92dfb7bfcd4767a39dac075b";
	public String id;

		
	@Test(enabled = true)
	public void create_trello_board() {
		//JSONObject jr=new JSONObject();
		RestAssured.baseURI=url;
		Response response=given().queryParam("name", "messi")
		.queryParam("key", keys)
		.queryParam("token", token).header("Content-Type", "application/json")
		.when().contentType(ContentType.JSON).accept(ContentType.JSON).post("/1/boards/").then().assertThat().statusCode(200)
		.contentType(ContentType.JSON)
		.extract().response();
		String jsonresponse = response.asString();
        JsonPath js= new JsonPath(jsonresponse);
		id = js.get("id");
		System.out.println(id);	

		
	}
	@Test(enabled = false)
	public void delete_board() {
		RestAssured.baseURI=url;
		given().queryParam("name", "iniesta").queryParam("key", keys)
		.queryParam("token", token)
		.when().contentType(ContentType.JSON).accept(ContentType.JSON).delete("/1/boards/"+id).then().statusCode(200).log().all();
	}
//	@Test(enabled = true)
//	public void update_board(){
//		RestAssured.baseURI=url;
//		given().queryParam("key", keys).queryParam("token", token).when().contentType(ContentType.JSON).accept(ContentType.JSON).put
//	}

}
