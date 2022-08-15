package pl.coderslab;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MockBookService {



    private static Long nextId = 4L;
    private static Long counter = 1L;

    private static Book staticBook = new Book(0L, "9999", "some title", "some author", "some publisher", "some type");

    private List<Book> list;

    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    public Book copyBook(Book book) {
        Book bookToReturn = new Book();
        bookToReturn.setIsbn(book.getIsbn());
        bookToReturn.setTitle(book.getTitle());
        bookToReturn.setType(book.getType());
        bookToReturn.setPublisher(book.getPublisher());
        bookToReturn.setAuthor(book.getAuthor());
        return bookToReturn;
    }

    public void createNewBook (Book book) {
        book.setId(nextId);
        list.add(book);
        setNextId();
    }

    public List<Book> getAllBooks() {
        return list;
    }

    public List<Book> editBook(Long id, Book bookToEdit) {
        for (Book book : list) {
            if (id == book.getId()) {
                //book = bookToEdit;// fail
                book.setIsbn(bookToEdit.getIsbn());
                book.setTitle(bookToEdit.getTitle());
                book.setType(bookToEdit.getType());
                book.setPublisher(bookToEdit.getPublisher());
                book.setAuthor(bookToEdit.getAuthor());

            }
        }
        return list;
    }

    public Book getOne(Long id) {

        System.out.println("Start endpointa " + counter);
        counter++;
        Book foundBook = new Book();


        for (Book book : list) {

            if (id == book.getId()) {
                foundBook = copyBook(book);
                foundBook.setId(id);

                break;
            } else foundBook = staticBook;

        }

        return foundBook;

    }

    public static void setNextId() {
        MockBookService.nextId++;
    }

    public Book removeBook (int id) {
        return list.remove(id-1);
    }

}
