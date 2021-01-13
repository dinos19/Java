package Library.Project.Books;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import Library.Project.User.User;
import Library.Project.User.UserRepository;


@Controller
public class BookController {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BookRepository bookRepo;
	
	@GetMapping("books")
	public String viewBookList(Model model,Book book)
	{
	List<Book> bookList=bookRepo.findAll();
		model.addAttribute("bookList",bookList);
		return "books";
	}
	
	@GetMapping("/book/new")
	public String showNewBookForm(Model model)
	{
		
		model.addAttribute("book",new Book());
		return "book_form";
	}
	
	@PostMapping("process_book")
	public String processRegistration(Book book)
	{
		bookRepo.save(book);
		return "redirect:/books";
	}
	
	@GetMapping("book/edit/{id}")
	public String showEditBookForm(@PathVariable("id") Long id,Model model)
	{
		Book book = bookRepo.findById(id).get();
		model.addAttribute("book",book);
		return "book_form";
	}
	
	@GetMapping("book/delete/{id}")
	public String deleteBookForm(@PathVariable("id") Long id)
	{
		bookRepo.deleteById(id);
		
		return "redirect:/books";
	}
}
