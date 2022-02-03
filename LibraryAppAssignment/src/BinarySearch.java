import java.io.IOException;
import java.util.ArrayList;

public class BinarySearch {
 
    // Returns index of x if it is present in arr[],
    // else return -1
    static int binarySearch(ArrayList<Book> bookList, String author)
    {
        int l = 0, r = bookList.size()-1;
        while (l <= r) {
            int m = l + (r - l) / 2;
 
            int res = author.compareTo(bookList.get(m).author);
 
            // Check if x is present at mid
            if (res == 0)
                return m;
 
   
            if (res < 0)
                l = m - 1;
 
         
            else
                r = m + 1;
        }
 
        return -1;
    }
 
    // Driver method to test above
    public static void main(String []args) throws IOException
    {
    	ArrayList<Book> bookList = new ArrayList<Book>();
        bookList = LibraryApp.createBookList();
        InsertionSort sorter = new InsertionSort();
        sorter.sortByAuthorAscending(bookList);
        
        
        String author = "John Keegan";
        int result = binarySearch(bookList, author);
 
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at "
                              + "index " + result);
    }
}