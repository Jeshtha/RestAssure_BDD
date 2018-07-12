package stepdefs;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.jayway.restassured.specification.RequestSpecification;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class BookStepDefinitions {

	private Response response;
	private RequestSpecification request;
	private String paramval;

	private String URIBooks = "https://www.googleapis.com/books/v1/volumes";


	@Given("a book exists with q of (.*)")
	public void a_book_exists_with_q(String q){
		paramval = q;
		System.out.println("paramval: "+paramval);
		request = RestAssured.with();
		request.given().baseUri(URIBooks);
		
	}

	@When("a user retrieves the book by q")
	public void a_user_retrieves_the_book_by_q(){
		response = request.queryParam("q", paramval).when().get(URIBooks);
		System.out.println("response: " + response.prettyPrint());
	}

	@Then("the status code is (\\d+)")
	public void verify_status_code(int statusCode){
		
		assertEquals("Status Check Failed!", statusCode, response.getStatusCode());
	}

	
}


