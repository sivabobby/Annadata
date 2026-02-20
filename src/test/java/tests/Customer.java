package tests;

import base.BaseTest;
import constants.EndPoints;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Test;

public class Customer extends BaseTest{
	
	public String annadata_GetAllCustomer = "GetAllCustomer";
	
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

}
