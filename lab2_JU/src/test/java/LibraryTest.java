import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    private Library library;
    private List<Book> books;

    @BeforeEach
    public void setUp() {
        library = new Library();
        books = new ArrayList<>();
        books.add(new Book("The Catcher in the Rye", "J.D. Salinger", 1951, 10.99));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960, 12.99));
        books.add(new Book("1984", "George Orwell", 1949, 14.99));
        books.add(new Book("Moby Dick", "Herman Melville", 1851, 11.99));
        books.add(new Book("Pride and Prejudice", "Jane Austen", 1813, 9.99));
    }

    @Test
    public void testSortByTitle() {
        library.sortByTitle(books);
        assertEquals("1984", books.get(0).getTitle());
        assertEquals("Moby Dick", books.get(1).getTitle());
        assertEquals("Pride and Prejudice", books.get(2).getTitle());
        assertEquals("The Catcher in the Rye", books.get(3).getTitle());
        assertEquals("To Kill a Mockingbird", books.get(4).getTitle());
    }

    @Test
    public void testSortByAuthor() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("C Programming", "Author C", 1990, 29.99));
        books.add(new Book("Java Basics", "Author A", 2005, 39.99));
        books.add(new Book("Algorithms", "Author B", 2010, 49.99));

        Library library = new Library();
        library.sortByAuthor(books);

        assertEquals("Author A", books.get(0).getAuthor());
        assertEquals("Author B", books.get(1).getAuthor());
        assertEquals("Author C", books.get(2).getAuthor());
    }

    @Test
    public void testSortByYear() {
        library.sortByYear(books);
        assertEquals(1813, books.get(0).getYear());
        assertEquals(1851, books.get(1).getYear());
        assertEquals(1949, books.get(2).getYear());
        assertEquals(1951, books.get(3).getYear());
        assertEquals(1960, books.get(4).getYear());
    }

    @Test
    public void testSortByPrice() {
        library.sortByPrice(books);
        assertEquals(9.99, books.get(0).getPrice(), 0.01);
        assertEquals(10.99, books.get(1).getPrice(), 0.01);
        assertEquals(11.99, books.get(2).getPrice(), 0.01);
        assertEquals(12.99, books.get(3).getPrice(), 0.01);
        assertEquals(14.99, books.get(4).getPrice(), 0.01);
    }

    @Test
    public void testSortWithEmptyList() {
        List<Book> emptyList = new ArrayList<>();
        library.sortByTitle(emptyList);
        assertTrue(emptyList.isEmpty());
    }

    @Test
    public void testSortWithSingleBook() {
        List<Book> singleBookList = new ArrayList<>();
        singleBookList.add(new Book("Single Book", "Single Author", 2023, 19.99));
        library.sortByTitle(singleBookList);
        assertEquals("Single Book", singleBookList.get(0).getTitle());
    }
    @Test
    public void testSortByYearWithSameYearBooks() {
        books.add(new Book("Brave New World", "Aldous Huxley", 1949, 15.99));
        library.sortByYear(books);
        assertEquals(1813, books.get(0).getYear());
        assertEquals(1851, books.get(1).getYear());
        assertEquals(1949, books.get(2).getYear());
        assertEquals("1984", books.get(2).getTitle());
        assertEquals(1949, books.get(3).getYear());
        assertEquals("Brave New World", books.get(3).getTitle());
        assertEquals(1951, books.get(4).getYear());
    }

    @Test
    public void testSortByYearEmptyList() {
        List<Book> emptyBooks = new ArrayList<>();
        library.sortByYear(emptyBooks);
        assertTrue(emptyBooks.isEmpty());
    }
    @Test
    public void testSortByPriceWithSamePrice() {
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 10.99));
        library.sortByPrice(books);
        assertEquals(9.99, books.get(0).getPrice(), 0.01);
        assertEquals(10.99, books.get(1).getPrice(), 0.01);
        assertEquals("The Catcher in the Rye", books.get(1).getTitle());
        assertEquals(10.99, books.get(2).getPrice(), 0.01);
        assertEquals("The Great Gatsby", books.get(2).getTitle());
    }

    @Test
    public void testSortByPriceEmptyList() {
        List<Book> emptyBooks = new ArrayList<>();
        library.sortByPrice(emptyBooks);
        assertTrue(emptyBooks.isEmpty());
    }

}
