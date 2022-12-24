package restpackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class rest1 {
public String url="https://reqres.in/api/users?page=2";
@Test(enabled=true)
public void tc1() {
	Response re=RestAssured.get(url);
	int actual=re.statusCode();
	Assert.assertEquals(actual, 200);
}
@Test(enabled = false)
public void get_tc2() {
	given().get(url).then().statusCode(200).log().all();
	given().get(url).then().statusCode(200).body("data.first_name", hasItems("Michael"));
}
@Test(enabled = false)
public void post_tc3() {
	JSONObject jso=new JSONObject();
	jso.put("name", "tushar");
	jso.put("job", "tester");
	given().body(jso.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();
	given().body(jso.toJSONString()).when().put("https://reqres.in/api/users/2").then().statusCode(200).log().all();
	given().body(jso.toJSONString()).when().post("https://reqres.in/api/register").then().statusCode(200).log().all();
}
}
