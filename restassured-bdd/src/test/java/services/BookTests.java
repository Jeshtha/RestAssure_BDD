package services;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;

import org.apache.http.HttpStatus;
import org.junit.Test;


public class BookTests
{
	private static String URL_BOOKS = "https://www.googleapis.com/books/v1/volumes";

	@Test
	public void testGetByISBN(){
		String q = "Boston";

		given().
		param("q", q).
		when().
		get(URL_BOOKS)
		.then().
		statusCode(HttpStatus.SC_OK).
		body(	"totalItems", equalTo(3503),
				"kind", equalTo("books#volumes"),
				"items.volumeInfo.title", containsInAnyOrder("Millennials Rising"),
				"items.volumeInfo.authors", containsInAnyOrder((Object)Arrays.asList("Neil Howe","William Strauss" )),
				"items.volumeInfo.publisher", containsInAnyOrder("Vintage"),
				"items.volumeInfo.pageCount", containsInAnyOrder(432));
	}
}
