package tests;

import base.BaseTest;
import constants.EndPoints;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Test;

public class Customer extends BaseTest{
	
	public String annadata_GetAllCustomer = "GetAllCustomer";
	public String annadata_GetCustomerById = "GetCustomerById";
	
	@Test
	public void GetAllCustomers(){
		Response response = given().header("content-type","application/json")
				.when()
				.get(EndPoints.annadata_bigbasket + annadata_GetAllCustomer);
				//.then()
				//.log().all().statusCode(200).extract().response();
		
		List<String> Names = response.jsonPath().getList("data.name");
		System.out.println(Names);
	}
	
	@Test
	public void GetCustomerBy() {
		Response response = given()
				.header("content-type", "application/json")
				.queryParam("Id", 380)
				.when()
				.get(EndPoints.annadata_bigbasket + annadata_GetCustomerById)
				.then().log().all().extract().response();
		
		System.out.println("Name :" + response.jsonPath().getString("data.name"));
	}

}
