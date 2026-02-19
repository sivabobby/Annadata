package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import constants.EndPoints;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import pojo.PojoTest;

import static io.restassured.RestAssured.*;

public class Annadatadashboard extends BaseTest {

	// all Url's Links and tags
	public String annadata_dashboard = "GetAdminDasboardData";
	public String annadata_vendor_dasboard ="GetVendorDasboardById";
	public String annadata_Farmer_dasboard ="GetFarmerDasboardById";

	@Test
	public void getAdminDetails() {
		Response repo = given()
				.header("content-type", "application/json")
				.when()
				.get(EndPoints.annadata + annadata_dashboard)
				.then()
				.statusCode(200)
				.log().all()
				.extract()
				.response();

		// System.out.print(response.body());
	}
	
	@Test
	public void GetVendorDasboardById() {
		System.out.println(EndPoints.annadata + annadata_vendor_dasboard);
		
		given()
		.header("content-type","application/json")
		.queryParam("id", 115)
		.when()
		.get(EndPoints.annadata + annadata_vendor_dasboard)
		.then()
		.statusCode(200)
		.log().body();
		
	}

	@Test
	public void GetFarmerDasboardById() {
		
		given().header("content-type", "application/json")
		.queryParam("id", 115)
		.when().get(EndPoints.annadata + annadata_Farmer_dasboard)
		.then().statusCode(200).log().all();
	}
	
	
}
