import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LibFrame extends JFrame {

	private JPanel contentPane;
	static ArrayList<Book> bookList = new ArrayList<Book>();
	private JTextField txtISBN;
	JLabel lblISBN;
	JLabel lblISBNicon;
	URL defaultImageURL = new URL(
			"https://s.gr-assets.com/assets/nophoto/book/111x148-bcc042a9c91a29c1d680899eff700a03.png");
	JPanel panel;
	BookPanel bookPanel1;
	BookPanel bookPanel2;
	BookPanel bookPanel3;
	BookPanel bookPanel4;
	BookPanel bookPanel5;
	private JLabel lblLookupYear;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibFrame frame = new LibFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public LibFrame() throws IOException {
		try {
			bookList = LibraryApp.createBookList();
		} catch (IOException e) {
			e.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1019, 694);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Sorted panel (Right side of window)
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(508, 58, 463, 582);
		contentPane.add(panel);
		panel.setLayout(null);

		bookPanel1 = new BookPanel(bookList.get(13));
		bookPanel1.setBackground(Color.GRAY);
		bookPanel1.setBounds(10, 10, 443, 180);
		panel.add(bookPanel1);

		bookPanel2 = new BookPanel(bookList.get(53));
		bookPanel2.setBackground(Color.GRAY);
		bookPanel2.setBounds(10, 201, 443, 180);
		panel.add(bookPanel2);

		bookPanel3 = new BookPanel(bookList.get(8152));
		bookPanel3.setBackground(Color.GRAY);
		bookPanel3.setBounds(10, 392, 443, 180);
		panel.add(bookPanel3);

		// Search ISBN
		JLabel lblLookupISBN = new JLabel("ISBN Lookup: ");
		lblLookupISBN.setBounds(30, 11, 76, 32);
		contentPane.add(lblLookupISBN);

		txtISBN = new JTextField();
		txtISBN.setText("679785892");
		txtISBN.setBounds(111, 17, 239, 20);
		contentPane.add(txtISBN);
		txtISBN.setColumns(10);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(21, 247, 463, 393);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		// ISBN LOOKUP
		JLabel lblLookupAuthor = new JLabel("Author: ");
		lblLookupAuthor.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 12));
		lblLookupAuthor.setBounds(160, 109, 263, 26);
		contentPane.add(lblLookupAuthor);

		JLabel lblLookupTitle = new JLabel("Title: ");
		lblLookupTitle.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 18));
		lblLookupTitle.setBounds(160, 71, 304, 27);
		contentPane.add(lblLookupTitle);

		JLabel lblLookupRating = new JLabel("Rating");
		lblLookupRating.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 12));
		lblLookupRating.setBounds(160, 146, 161, 27);
		contentPane.add(lblLookupRating);

		lblISBN = new JLabel("ISBN");
		lblISBN.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblISBN.setAutoscrolls(true);
		lblISBN.setBounds(160, 184, 161, 26);
		contentPane.add(lblISBN);

		lblISBNicon = new JLabel(new ImageIcon(ImageIO.read(defaultImageURL)));
		lblISBNicon.setAutoscrolls(true);
		lblISBNicon.setBounds(10, 61, 140, 162);
		contentPane.add(lblISBNicon);

		lblLookupYear = new JLabel("Year");
		lblLookupYear.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 12));
		lblLookupYear.setBounds(433, 109, 51, 27);
		contentPane.add(lblLookupYear);

		bookPanel4 = new BookPanel(bookList.get(700));
		bookPanel4.setBackground(Color.GRAY);
		bookPanel4.setBounds(10, 11, 443, 180);
		panel_1.add(bookPanel4);

		bookPanel5 = new BookPanel(bookList.get(5070));
		bookPanel5.setBackground(Color.GRAY);
		bookPanel5.setBounds(10, 202, 443, 180);
		panel_1.add(bookPanel5);

		JButton btnSearchISBN = new JButton("Search");
		btnSearchISBN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lookupByISBN(lblLookupAuthor, lblLookupTitle, lblLookupRating);

			}

			private void lookupByISBN(JLabel lblLookupAuthor, JLabel lblLookupTitle, JLabel lblLookupRating) {
				HashMap<String, Book> bookMap = new HashMap<String, Book>();
				String isbn = txtISBN.getText();
				Book book = new Book();
				try {
					bookMap = LibraryApp.createBookMap();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				book = LibraryApp.getBookByISBN(isbn, bookMap);
				lblLookupAuthor.setText(book.author);
				lblLookupTitle.setText(book.title);
				lblLookupRating.setText("Rating: " + book.strAvg_Rating);
				lblLookupYear.setText(String.valueOf(book.year));
				lblISBN.setText("isbn: " + book.isbn);
				String urlStr = book.small_image_url;
				URL url;
				try {
					url = new URL(urlStr);
					ImageIcon bookIcon = new ImageIcon(ImageIO.read(url));
					lblISBNicon.setIcon(bookIcon);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSearchISBN.setBounds(375, 16, 89, 23);
		contentPane.add(btnSearchISBN);

		// In the combo box item state changed event we will update the book panels with
		// the sorted results - this will probably get ugly.
		String[] comboBoxOptions = { "Recommended", "Title A-Z", "Author A-Z", "Ratings High", "Ratings Low",
				"Year Low", "Year High" };
		JComboBox comboBox = new JComboBox(comboBoxOptions);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				getComboBoxSelection(comboBox, e);

			}

			private void getComboBoxSelection(JComboBox comboBox, ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (comboBox.getSelectedIndex() == 0) {
						System.out.println("sort()   Recommended"); // maybe this function could find books by the same
																	// author or something
						InsertionSort sorter = new InsertionSort();
						sorter.sortByBookIDAscending(bookList);
						updateBookPanels(bookList.get(13), bookList.get(53), bookList.get(8152)); // random testing
					}
					if (comboBox.getSelectedIndex() == 1) {
						System.out.println("sort()   Title A-Z ");
						InsertionSort sorter = new InsertionSort();
						sorter.sortByTitleAscending(bookList);
						updateBookPanels(bookList.get(0), bookList.get(1), bookList.get(2));

					}
					if (comboBox.getSelectedIndex() == 2) {
						System.out.println("sort()   Author A-Z ");
						ArrayList<Book> sublist = new ArrayList<Book>();
						InsertionSort sorter = new InsertionSort();
						sorter.sortByAuthorAscending(bookList);
						sublist = sorter.getNormalizedRatingsList(bookList);
						updateBookPanels(sublist.get(0), sublist.get(1), sublist.get(2));

					}
					if (comboBox.getSelectedIndex() == 3) {
						System.out.println("sort()   Ratings High-Low ");
						InsertionSort sorter = new InsertionSort();
						sorter.sortByHighRating(bookList);
						updateBookPanels(bookList.get(0), bookList.get(1), bookList.get(2));

					}
					if (comboBox.getSelectedIndex() == 4) {
						ArrayList<Book> sublist = new ArrayList<Book>();
						System.out.println("sort()   Ratings Low-high");
						InsertionSort sorter = new InsertionSort();
						sorter.sortByLowRating(bookList);
						sublist = sorter.getNormalizedRatingsList(bookList);
						// wee need to find the indices where the -1 ratings are gone, and the URL is
						// okay..maybe regex "http"
						updateBookPanels(sublist.get(0), sublist.get(1), sublist.get(2));
					}
					if (comboBox.getSelectedIndex() == 5) {
						System.out.println("sort()  Year Low-High");
						InsertionSort sorter = new InsertionSort();
						sorter.sortByBookYearAscending(bookList);
						updateBookPanels(bookList.get(0), bookList.get(1), bookList.get(2));

					}
					if (comboBox.getSelectedIndex() == 6) {
						System.out.println("sort()   Year High-Low");
						InsertionSort sorter = new InsertionSort();
						sorter.sortByBookYearDescending(bookList);
						updateBookPanels(bookList.get(0), bookList.get(1), bookList.get(2));

					}
				}
			}
		});
		comboBox.setBounds(772, 16, 191, 22);
		contentPane.add(comboBox);

		// Random button
		lblNewLabel = new JLabel("Randomize");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int n = bookList.size();
				int index = randomInt(n);
				bookPanel4.refreshPanel(bookList.get(index));
				index = randomInt(n);
				bookPanel5.refreshPanel(bookList.get(index));
			}
		});
		lblNewLabel.setBounds(408, 208, 76, 32);
		contentPane.add(lblNewLabel);

	}

	private void updateBookPanels(Book book1, Book book2, Book book3) {
		bookPanel1.refreshPanel(book1);
		bookPanel2.refreshPanel(book2);
		bookPanel3.refreshPanel(book3);
	}

	private int randomInt(int max) {
		Random rand = new Random();
		int randInt = rand.nextInt(max);
		return randInt;
	}
}
