import javax.swing.JPanel;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Font;

public class BookPanel extends JPanel {
	Book Book;
	String Author;
	String Title;
	String Rating;
	String Year;
	String ISBN;
	URL ImageURL;
	ImageIcon BookIcon;
	JLabel lblAuthor;
	JLabel lblTitle;
	JLabel lblBookIcon;
	JLabel lblRating;
	JLabel lblYear;
	private JLabel lblISBN;
//Probably dont need getters from the graphical element
	public Book getBook() {
		return Book;
	}

	public void setBook(Book book) {
		this.Book = book;
	}
	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getRating() {
		return Rating;
	}

	public void setRating(String rating) {
		Rating = rating;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String isbn) {
		ISBN = isbn;
	}

	public URL getImageURL() {
		return ImageURL;
	}

	public void setImageURL(String urlString) {
		URL url;
		try {
			url = new URL(urlString);
			ImageURL = url;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setBookIcon(URL imageURL) {
		 try {
			BookIcon = new ImageIcon( ImageIO.read(imageURL));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public ImageIcon getBookIcon() {
		return BookIcon;
	}
		

	/**
	 * Create the panel.
	 */
	/*
	public BookPanel() {
		
	}
*/
	public BookPanel(Book book) {
		String Author = book.author;
		String Title = book.title;
		String smallURL = book.small_image_url;
		String Rating = book.strAvg_Rating;
		String Year = String.valueOf(book.year);
		String ISBN = book.isbn;
		setBounds(new Rectangle(0, 0, 342, 180));
		setBackground(Color.GRAY);
		
		setImageURL(smallURL);
		setBookIcon(this.getImageURL());
		
		
		
		setLayout(null);
		
		lblAuthor = new JLabel(Author);
		lblAuthor.setFont(new Font("Microsoft YaHei", Font.BOLD, 10));
		lblAuthor.setBounds(140, 48, 293, 30);
		add(lblAuthor);
		
		lblTitle = new JLabel(Title);
		lblTitle.setFont(new Font("Microsoft YaHei", Font.BOLD, 10));
		lblTitle.setBounds(140, 7, 293, 30);
		add(lblTitle);
		
		lblBookIcon = new JLabel(BookIcon);
		lblBookIcon.setBackground(Color.LIGHT_GRAY);
		lblBookIcon.setBounds(10, 7, 120, 162);
		add(lblBookIcon);
		
		lblRating = new JLabel("Rating: " + Rating);
		lblRating.setFont(new Font("Microsoft YaHei", Font.BOLD, 10));
		lblRating.setBounds(140, 113, 142, 30);
		add(lblRating);
		
		lblYear = new JLabel(Year);
		lblYear.setFont(new Font("Microsoft YaHei", Font.BOLD, 10));
		lblYear.setBounds(392, 48, 41, 30);
		add(lblYear);
		
		lblISBN = new JLabel("ISBN: " + ISBN);
		lblISBN.setFont(new Font("Microsoft YaHei", Font.PLAIN, 11));
		lblISBN.setBounds(333, 113, 114, 30);
		add(lblISBN);

	}
	public void refreshPanel(Book book) {
		this.setAuthor(book.author);
		this.setTitle(book.title);
		this.setRating(book.strAvg_Rating);
		this.setImageURL(book.small_image_url); 
		this.setBookIcon(ImageURL);
		
		lblAuthor.setText(Author);
		lblTitle.setText(Title);
		lblBookIcon.setIcon(BookIcon);
		lblRating.setText(Rating);
		lblYear.setText(Year);
		
	}
}


