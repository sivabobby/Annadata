package tests;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import base.BaseTest;
import constants.EndPoints;
import io.restassured.response.Response;
import pojo.PojoTest;

public class Taluka extends BaseTest {
	public String annadata_taluka = "AddTaluka";
	public String annadata_GetAllTaluka = "GetAllTaluka";
	public String annadata_GetAllTalukaByCityId = "GetAllTalukaByCityId";
	public String annadata_GetAllCitiesByDistrictId = "GetAllCitiesByDistrictId";
	
	public String annadata_AddBulkDistrict = "AddBulkDistrict";
	
	@Test
	public void AddTaluka() {
		PojoTest user = new PojoTest();
		user.setCityId(115);
		user.setTalukaId(1);
		user.setTalukaName("bobby");
		
		System.out.println(user);
		System.out.println(EndPoints.annadata + annadata_taluka);
		
		given()
		.header("content-type", "application/json")
		.body(user)
		.when()
		.post(EndPoints.annadata + annadata_taluka)
		.then()
		.statusCode(200)
		.log().all().extract().response();
		
	}
	
	@Test
	public void GetAllTaluka() {
		given().header("content-type", "application/json")
		.when().get(EndPoints.annadata + annadata_GetAllTaluka)
		.then().statusCode(200).log().all().extract().response();
		
		
		//System.out.println(repo.jsonPath().getString("talukaName"));
	}
	
	@Test
	public void GetAllTalukaByCityId() {
		System.out.println(EndPoints.annadata + annadata_GetAllTalukaByCityId);
		Response repo = given()
				.header("content-type","application/json")
				.queryParam("id", 115)
				.when()
				.get(EndPoints.annadata + annadata_GetAllTalukaByCityId)
				.then()
				.statusCode(200)
				.log().all()
				.extract().response();
		//.queryParam("id", 105)
		System.out.println("talukaId : " +repo.jsonPath().getInt("data[0].talukaId"));
	}
	
	@Test
	public void GetAllCitiesByDistrictId() {
		
	Response repo =	given()
		.header("content-type", "appliation/json")
		.queryParam("id", 125)
		.when().get(EndPoints.annadata + annadata_GetAllCitiesByDistrictId)
		.then()
		.statusCode(200)
		.log().all()
		.extract().response();
	String user = repo.jsonPath().getString("data[0]");
	System.out.println("user :- " + user);
	System.out.println(repo.jsonPath().getList("data"));
	
	}

	@Test
	public void AddBulkDistrict() {
		
		Map <String, Object> district = new HashMap<>();
		district.put("districtId", "155");
		district.put("districtName", "Narsipatnam");
		district.put("stateId", 5);
		
		List<Map<String, Object>> districtlist = new ArrayList<>();
		districtlist.add(district);
		
		given().header("Content-type","Application/json")
		.body(districtlist)
		.when()
		.post(EndPoints.annadata + annadata_AddBulkDistrict)
		.then().log().all().extract().response();
	}
	
	//System.out.println("something");
}
