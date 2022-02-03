import java.io.IOException;
import java.util.ArrayList;

// Java program for implementation of Insertion Sort
class InsertionSort {
	/* Function to sort array using insertion sort */
	void sortByLowRating(ArrayList<Book> bookList) {
		int n = bookList.size();
		for (int i = 1; i < n; ++i) {
			Book key = bookList.get(i);
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			while (j >= 0 && bookList.get(j).avg_rating > key.avg_rating) {
				bookList.set(j + 1, bookList.get(j));
				j = j - 1;
			}
			bookList.set(j + 1, key);
		}
	}
	void sortByHighRating(ArrayList<Book> bookList) {
		int n = bookList.size();
		for (int i = 1; i < n; ++i) {
			Book key = bookList.get(i);
			int j = i - 1;

			while (j >= 0 && bookList.get(j).avg_rating < key.avg_rating) {
				bookList.set(j + 1, bookList.get(j));
				j = j - 1;
			}
			bookList.set(j + 1, key);
		}
	}	
	void sortByBookIDDescending(ArrayList<Book> bookList) {
		int n = bookList.size();
		for (int i = 1; i < n; ++i) {
			Book key = bookList.get(i);
			int j = i - 1;

			while (j >= 0 && bookList.get(j).book_id < key.book_id) {
				bookList.set(j + 1, bookList.get(j));
				j = j - 1;
			}
			bookList.set(j + 1, key);
		}
	}
	void sortByBookIDAscending(ArrayList<Book> bookList) {
		int n = bookList.size();
		for (int i = 1; i < n; ++i) {
			Book key = bookList.get(i);
			int j = i - 1;

			while (j >= 0 && bookList.get(j).book_id > key.book_id) {
				bookList.set(j + 1, bookList.get(j));
				j = j - 1;
			}
			bookList.set(j + 1, key);
		}
	}
	void sortByBookYearDescending(ArrayList<Book> bookList) {
		int n = bookList.size();
		for (int i = 1; i < n; ++i) {
			Book key = bookList.get(i);
			int j = i - 1;

			while (j >= 0 && bookList.get(j).year > key.year) {
				bookList.set(j + 1, bookList.get(j));
				j = j - 1;
			}
			bookList.set(j + 1, key);
		}
	}
	void sortByBookYearAscending(ArrayList<Book> bookList) {
		int n = bookList.size();
		for (int i = 1; i < n; ++i) {
			Book key = bookList.get(i);
			int j = i - 1;

			while (j >= 0 && bookList.get(j).year < key.year) {
				bookList.set(j + 1, bookList.get(j));
				j = j - 1;
			}
			bookList.set(j + 1, key);
		}
	}	
	void sortByAuthorAscending(ArrayList<Book> bookList) {
		int n = bookList.size();
		for (int i = 1; i < n; ++i) {
			Book key = bookList.get(i);
			int j = i - 1;

			while (j >= 0 && key.author.compareTo(bookList.get(j).author) > 0) {
				bookList.set(j + 1, bookList.get(j));
				j = j - 1;
			}
			bookList.set(j + 1, key);
		}
	}
	void sortByTitleAscending(ArrayList<Book> bookList) {
		int n = bookList.size();
		for (int i = 1; i < n; ++i) {
			Book key = bookList.get(i);
			int j = i - 1;

			while (j >= 0 && key.title.compareTo(bookList.get(j).title) > 0) {
				bookList.set(j + 1, bookList.get(j));
				j = j - 1;
			}
			bookList.set(j + 1, key);
		}
	}
		
	//This method is to get a list of the top ten books from the list sorted by rating low to high
	//Because rating in which the dataset was missing or containing string were given a value -1,
	// we need to remove these books from the result. 
	public ArrayList<Book> getNormalizedRatingsList(ArrayList<Book> bookList){
		ArrayList<Book> listOfTen = new ArrayList<Book>();
		
		
		int i = 0;
		int count = 0;
		while(i < bookList.size() && count < 10) {
			if(bookList.get(i).avg_rating > -1.0) {
				listOfTen.add(bookList.get(i));
				count++;
			}
			i++;			
		}
		return listOfTen;
		
	}
	//Will filter the foreign text characters from the list and return a list of ten
	public ArrayList<Book> getNormalizedAuthorList(ArrayList<Book> bookList){
		ArrayList<Book> sublist = new ArrayList<Book>();
		int i = 0;
		int count = 0;
		while(i < bookList.size() &&  count < 10) {
			if(Book.isEnglishKeyboard(bookList.get(i).author)) {
				sublist.add(bookList.get(i));
				count++;
			}
			i++;
		}
		return sublist;
	}
	//Will filter the foreign text characters from the list and return a list of ten
	public ArrayList<Book> getNormalizedTitleList(ArrayList<Book> bookList){
		ArrayList<Book> sublist = new ArrayList<Book>();
		int i = 0;
		int count = 0;
		while(i < bookList.size() &&  count < 10) {
			if(Book.isEnglishKeyboard(bookList.get(i).author)) {
				sublist.add(bookList.get(i));
				count++;
			}
			i++;
		}
		return sublist;
	}
	

	/* A utility function to print array of size n */
	static void printArray(ArrayList<Book> bookList) {
		int n = bookList.size();
		/* this loop will print all the books in order, without -1 ratings
		for (int i = 0; i < n; ++i) {
			if (bookList.get(i).avg_rating > -1.0) {
				System.out.println(bookList.get(i).toString() + " ");
			}
		}
		*/
		
		// This Loop will print only the ten books without -1.0 ratings...
		int i = 0;
		int count = 0;
		while(i < n && count < 10) {
			if(bookList.get(i).avg_rating > -1.0) {
				System.out.println(bookList.get(i).toString());
				count++;
			}
			i++;			
		}
		
		System.out.println();
	}

	// Driver method
	public static void main(String args[]) throws IOException {
		
	}
}