package pl.coderslab.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.Book;
import pl.coderslab.MockBookService;

import java.util.List;

@RestController
@RequestMapping("/books")

public class BookController {

    MockBookService mockBookService;// = new MockBookService();


    @Autowired
    public BookController(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @RequestMapping("/helloBookString")
    public String helloBookString() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming").toString();
    }

//    @RequestMapping("/edit/{id}/{title}")
//    public String editBook(@PathVariable("id") Long id,@PathVariable("title") String title){
//        mockBookService.editBook(id,title);
//
//    }

    @GetMapping("/allBooks")
    public List<Book> getALlBooks() {
        return mockBookService.getAllBooks();
    }

    @RequestMapping("getBook/{id}")
    public Book getBook(@PathVariable("id") Long id) {
        return mockBookService.getOne(id);
    }

    @GetMapping("/addBook")
    public ModelAndView hello() {
        ModelAndView mav = new ModelAndView("form");
        return mav;
    }
    @PostMapping("addBook")
    @ResponseBody
    public String createNewBook(//@RequestParam(name="id") Long id ,
                                @RequestParam(name ="isbn") String isbn,
                                @RequestParam(name ="title") String title,
                                @RequestParam(name ="author") String author,
                                @RequestParam(name ="publisher") String publisher,
                                @RequestParam(name ="type") String type) {
        mockBookService.createNewBook(new Book(-1L,isbn,title,author,publisher,type));
        return "book added";

    }

    @DeleteMapping("deleteBook/{id}")

    public Book removeBook(@PathVariable int id) {

        return mockBookService.removeBook(id);
    }
}

