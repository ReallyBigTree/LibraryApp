import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;

public class Book {

	int book_id;
	int goodreads_book_id;
	int best_book_id;
	int work_id;
	int books_count;
	String isbn;
	String isbn13;
	String author;
	int year;
	String originalTitle;
	String title;
	String language_code;
	float avg_rating;
	String strAvg_Rating;
	String ratings_count;
	String work_ratings_count;
	String work_text_reviews_count;
	int ratings1;
	int ratings2;
	int ratings3;
	int ratings4;
	String image_url;
	String small_image_url;
	ImageIcon smallImageIcon;
	ImageIcon largeImageIcon;
	URL real_image_URL;
	URL real_small_image_url;


	public ImageIcon getSmallImageIcon() {
		return smallImageIcon;
	}

	public void setSmallImageIcon(ImageIcon smallImageIcon) {
		this.smallImageIcon = smallImageIcon;
	}

	public ImageIcon getLargeImageIcon() {
		return largeImageIcon;
	}
	public ImageIcon getLargeImageIcon(URL real_image_url) {
		return largeImageIcon;
	}

	public void setLargeImageIcon(ImageIcon largeImageIcon) {
		this.largeImageIcon = largeImageIcon;
	}

	public URL getReal_image_URL() {
		return real_image_URL;
	}

	public void setReal_image_URL(String stringURL) throws MalformedURLException {
		URL real_URL= new URL (stringURL);
		this.real_image_URL = real_URL;
	}

	public URL getReal_small_image_url() {
		return real_small_image_url;
	}

	public void setReal_small_image_url(URL real_small_image_url) {
		this.real_small_image_url = real_small_image_url;
	}

	public Book() {

	}

	public Book(String title, String isbn, String author) {

		this.title = title;
		this.isbn = isbn;
		this.author = author;

	}


	public String getISBN() {
		return this.isbn;
	}

	public void setISBN(String inputString) {
		this.isbn = inputString;

	}

	public void setBookID(String inputString) {
		this.book_id = Integer.parseInt(inputString);

	}

	public Integer getBookID() {

		return this.book_id;
	}

	public void setGoodreadsBookID(String inputString) {
		this.goodreads_book_id = Integer.parseInt(inputString);

	}

	public Integer getGoodreadsBookID() {
		return this.goodreads_book_id;
	}

	public void setBestBookID(String inputString) {
		this.best_book_id = Integer.parseInt(inputString);

	}

	public Integer getBestBookID() {
		return this.best_book_id;
	}

	public void setWorkID(String inputString) {
		this.work_id = Integer.parseInt(inputString);

	}

	public Integer getWorkID() {
		return this.work_id;
	}

	public void setBooksCount(String inputString) {
		this.books_count = Integer.parseInt(inputString);

	}

	public Integer getBooksCount() {
		return this.books_count;
	}

	public void setISBN13(String inputString) {
		this.isbn13 = inputString;

	}

	public String getISBN13() {
		return this.isbn13;
	}

	public void setAuthor(String string) {
		this.author = string;

	}

	public String getAuthor() {
		return this.author;
	}

	public void setYear(String string) {
		if(isIntegerNumber(string) && string != "") {
			setYear(Integer.parseInt(string));
		}
		else {
			setYear(-1);
		}
		
	}
	public void setYear(int year) {
		this.year = year;
	}

	public int getYear() {
		return this.year;
	}

	public void setTitle(String string) {
		this.title = string;
		
	}
	
	public String getTitle() {
		return this.title;
	}

	public String getLanguageCode() {
		return language_code;
	}

	public void setLanguageCode(String language_code) {
		this.language_code = language_code;
	}

	public String getRatingsCount() {
		return this.ratings_count;
	}

	public void setRatingsCount(String string) {
		
			this.ratings_count = string;
		
	}

	public int getRatings1() {
		return ratings1;
	}

	public void setRatings1(String string) {
		this.ratings1 = Integer.parseInt(string);
	}

	public int getRatings2() {
		return ratings2;
	}

	public void setRatings2(String string) {
		this.ratings2 = Integer.parseInt(string);
	}

	public int getRatings3() {
		return ratings3;
	}

	public void setRatings3(String string) {
		this.ratings3 = Integer.parseInt(string);
	}

	public int getRatings4() {
		return ratings4;
	}

	public void setRatings4(String string) {
		this.ratings4 = Integer.parseInt(string);
	}
	public String getWork_text_reviews_count() {
		return this.work_text_reviews_count;
	}

	public void setWork_text_reviews_count(String string) {
		this.work_text_reviews_count =  string;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getSmall_image_url() {
		return small_image_url;
	}

	public void setSmall_image_url(String small_image_url) {
		this.small_image_url = small_image_url;
	}

	public void setAvgRating(String string) {
		if(isDecimalNumber(string)) {
			this.strAvg_Rating = string;			
			setAvgRating(Float.parseFloat(string));
		}
		else {
			this.strAvg_Rating = "N/A";
			setAvgRating(-1);
		}
		
		
	}
	public void setAvgRating(float rating) {
		this.avg_rating = rating;
	}
	public float getAvgRating() {
		return this.avg_rating;
	}

	public String getWork_ratings_count() {
		return work_ratings_count;
	}

	public void setWork_ratings_count(String work_ratings_count) {
		this.work_ratings_count = work_ratings_count;
	}
	public void setOriginalTitle(String string) {
		this.originalTitle = string;
		
	}
	
	public String getOriginalTitle() {
		return this.originalTitle;
		
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
	

	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", goodreads_book_id=" + goodreads_book_id + ", best_book_id="
				+ best_book_id + ", work_id=" + work_id + ", books_count=" + books_count + ", isbn=" + isbn
				+ ", isbn13=" + isbn13 + ", author=" + author + ", year=" + year + ", title=" + title
				+ ", language_code=" + language_code + ", avg_rating=" + avg_rating + ", ratings_count=" + ratings_count
				+ ", work_ratings_count=" + work_ratings_count + ", work_text_reviews_count=" + work_text_reviews_count
				+ ", ratings1=" + ratings1 + ", ratings2=" + ratings2 + ", ratings3=" + ratings3 + ", ratings4="
				+ ratings4 + ", image_url=" + image_url + ", small_image_url=" + small_image_url + "]";
	}



}
