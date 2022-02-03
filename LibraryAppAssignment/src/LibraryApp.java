import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.function.Executable;

public class LibraryApp {
	static ArrayList<Book> bookList = new ArrayList<Book>();
	static HashMap<String, Book> bookMap = new HashMap<String, Book>();
	static Book book;

	public static void main(String[] args) throws IOException {
		
		readBooksFromCSV();
		insertionSortByLowRating(bookList);
		insertionSortByHighRating(bookList);
		
		measurePerformance();
		

	}

	public static void readBooksFromCSV() throws IOException {
			setBookAttributes();	
			
			//The Assignment Mentions that we can use different data structures without duplicating the code  - I'm doing that here, but..
			//I duplicate the code to return different data structures i.e. createBookList(), createBookMap();
			bookList.add(book);
			bookMap.put(book.isbn, book);
			
			
			
	
	
		
	}
	public static ArrayList<Book> createBookList() throws IOException{
		setBookAttributes();
		return bookList;
		
	}

	private static void setBookAttributes() throws FileNotFoundException, IOException {
		FileReader fReader = new FileReader("books.csv");
		BufferedReader reader = new BufferedReader(fReader);
		String header = reader.readLine();
		String line = reader.readLine();
		System.out.println(header);
		
		while (line != null) {
			String[] attributes = line.split(",");
			book = new Book();
			
			book.setBookID(attributes[0]);
			book.setGoodreadsBookID(attributes[1]);
			book.setBestBookID(attributes[2]);
			book.setWorkID(attributes[3]);
			book.setBooksCount(attributes[4]);
			book.setISBN(attributes[5]);
			book.setISBN13(attributes[6]);
			book.setAuthor(attributes[7]);
			book.setYear(attributes[8]);
			book.setOriginalTitle(attributes[9]);
			book.setTitle(attributes[10]);
			book.setLanguageCode(attributes[11]);
			book.setAvgRating(attributes[12]);
			book.setRatingsCount(attributes[13]);
			book.setWork_ratings_count(attributes[14]);
			book.setWork_text_reviews_count(attributes[15]);
			book.setRatings1(attributes[16]);
			book.setRatings2(attributes[17]);
			book.setRatings3(attributes[18]);
			book.setRatings4(attributes[19]);
			book.setImage_url(attributes[20]);
			book.setSmall_image_url(attributes[21]);
			
			System.out.println(book.toString());			
			bookList.add(book);					
			line = reader.readLine();
			
		}
		reader.close();
	}
	public static HashMap<String, Book> createBookMap() throws IOException{
		FileReader fReader = new FileReader("books.csv");
		BufferedReader reader = new BufferedReader(fReader);
		String header = reader.readLine();
		String line = reader.readLine();
		System.out.println(header);
		
		while (line != null) {
			String[] attributes = line.split(",");
			book = new Book();
			book.setBookID(attributes[0]); // now the parsing happens in the book class, and the tests were developed prior to implementation. 
			book.setGoodreadsBookID(attributes[1]);
			book.setBestBookID(attributes[2]);
			book.setWorkID(attributes[3]);
			book.setBooksCount(attributes[4]);
			book.setISBN(attributes[5]);
			book.setISBN13(attributes[6]);
			book.setAuthor(attributes[7]);
			book.setYear(attributes[8]);
			book.setOriginalTitle(attributes[9]);
			book.setTitle(attributes[10]);
			book.setLanguageCode(attributes[11]);
			book.setAvgRating(attributes[12]);
			book.setRatingsCount(attributes[13]);
			book.setWork_ratings_count(attributes[14]);
			book.setWork_text_reviews_count(attributes[15]);
			book.setRatings1(attributes[16]);
			book.setRatings2(attributes[17]);
			book.setRatings3(attributes[18]);
			book.setRatings4(attributes[19]);
			book.setImage_url(attributes[20]);
			book.setSmall_image_url(attributes[21]);
			
			System.out.println(book.toString());	
			
			bookMap.put(book.isbn, book);
			line = reader.readLine();
			
		}
		return bookMap;
	}
	public static Book getBookByISBN(String isbnKey, HashMap<String, Book> bookMap) {
		Book book = new Book();
		
		if(bookMap.containsKey(isbnKey)) {
			book = bookMap.get(isbnKey);
			System.out.println("FOUND BOOK: \n" + book.toString());
		}
		else {
			System.out.println("ISBN NOT FOUND");
		}
		
		return book;
		
	}
	public static ArrayList<Book> insertionSortByLowRating(ArrayList<Book> bookList) {
		
		//Need to remove books with -1 rating (unrated) or only print val > -1...probably only printing is best, don't want to lose the data.
		InsertionSort sorter = new InsertionSort();
		sorter.sortByLowRating(bookList);
		System.out.println("ratings by low: ");
		InsertionSort.printArray(bookList);
		return bookList;
	}
	public static ArrayList<Book> insertionSortByHighRating(ArrayList<Book> bookList){
		InsertionSort sorter = new InsertionSort();
		sorter.sortByHighRating(bookList);
		System.out.println("ratings by high: ");
		InsertionSort.printArray(bookList);
		return bookList;
	}
	
	public static void measurePerformance() {
		InsertionSort sort = new InsertionSort();
		long startTime;
		long endTime;
		
		startTime = System.currentTimeMillis();
		sort.sortByHighRating(bookList);
		endTime = System.currentTimeMillis();
		System.out.println("insertionSortByRating():  " + (endTime - startTime) + " milliseconds");
		
		startTime = System.currentTimeMillis();
		sort.sortByAuthorAscending(bookList);
		endTime = System.currentTimeMillis();
		System.out.println("sortAuthorAscending():  " + (endTime - startTime) + " milliseconds");
		
		startTime = System.currentTimeMillis();
		BinarySearch.binarySearch(bookList, "J.K. Rowling");
		endTime = System.currentTimeMillis();
		System.out.println("BinarySearch(): :  " + (endTime - startTime) + " milliseconds");
	}
	
	
	public boolean isDecimalNumber(String stringNumber) {
		String hasSpecial = ":";
		String regexDecimalPattern = "[+-]?([0-9]*[.])?[0-9]+";
		Pattern pattern = Pattern.compile(regexDecimalPattern);
		Matcher matcher = pattern.matcher(stringNumber);
		
		if(matcher.matches()) {
			//System.out.println(stringNumber + "is match");
			return true;
			
		}
		else if (stringNumber.contains(hasSpecial)) {
			//System.out.println(stringNumber + " Is not a match");
			return false;
		}
		else {
			return false;
		}
	}
	public boolean isIntegerNumber(String stringNumber) {
		String rgx = "^[0-9]*$";
		Pattern pattern = Pattern.compile(rgx);
		Matcher matcher = pattern.matcher(stringNumber);
		if(matcher.matches()) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean isEnglishKeyboard(String string) {
		//This is not working as intended, and the sublist contains titles and authors in other languages
		String rgx = "[a-zA-Z0-9\\t\\n ./<>?;:\"'`!@#$%^&*()\\[\\]{}_+=|\\\\-]";
		Pattern pattern = Pattern.compile(rgx);
		Matcher matcher = pattern.matcher(string);
		if(matcher.matches()) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
	
	/** Someday.... methods
	public void getTopTen() {
		  
		
	}
	public void getTopThreeKnn() {
		//Someday....
	}
*/

}
