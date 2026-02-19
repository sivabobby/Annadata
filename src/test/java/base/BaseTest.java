package base;

import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;

public class BaseTest {
	
	@BeforeTest
	public void SetUp() {
		RestAssured.baseURI = "https://freeapi.miniprojectideas.com";
	}

}
