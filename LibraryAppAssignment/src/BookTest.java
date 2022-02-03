import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		//fail("Not yet implemented");
		//Book book = new Book();
		
		//Test basic constructors
		assertNotNull(new Book("Title", "1234", "Author"));
		assertNotNull(new Book());
		//Test some getters/setters
		@SuppressWarnings("unused")
		Book book = new Book("Fear and Loathing in Las Vegas", "124564261", "Hunter S. Thompson");
		assertEquals("Fear and Loathing in Las Vegas", book.getTitle());
		assertEquals("124564261", book.getISBN());
		assertEquals("Hunter S. Thompson", book.getAuthor());
		
		//Test setters - not sure if this is an acceptable way..at this time, the setter does not exist prior to creating the tests - both methods are getter/setters are then auto
		// generating - TDD helped understand exactly, at minimum, was needed to build the functionality
		String inputString = "121212";
		int result = Integer.parseInt(inputString);

		
		book.setBookID(inputString);
		assertEquals(result, book.getBookID());
		
		book.setGoodreadsBookID(inputString);
		assertEquals(result, book.getGoodreadsBookID());
		
		book.setBestBookID(inputString);
		assertEquals(result, book.getBestBookID());
		
		book.setWorkID(inputString);
		assertEquals(result, book.getWorkID());
		
		book.setBooksCount(inputString);
		assertEquals(result, book.getBooksCount());
		
		book.setISBN(inputString);
		assertEquals(result, book.getISBN());
		
		book.setISBN13(inputString);
		assertEquals(inputString, book.getISBN13());
		
		book.setAuthor("Author");
		assertEquals("Author", book.getAuthor());
		
		book.setYear("Year");
		assertEquals(2021.0, book.getYear());
		
		book.setTitle("Title");
		assertEquals("Title", book.getTitle());
		
		book.setLanguageCode("Language Code");
		assertEquals("Language Code", book.getLanguageCode());
		
		book.setAvgRating("3.567");
		assertEquals("3.567", book.getAvgRating());
		
		book.setRatingsCount("1234567");
		assertEquals(1234567, book.getRatingsCount());
		
		
		
	}

}

/*





	int work_ratings_count;
	int work_text_reviews_count;
	int ratings1;
	int ratings2;
	int ratings3;
	int ratings4;
	String image_url;
	String small_image_url;
 */
