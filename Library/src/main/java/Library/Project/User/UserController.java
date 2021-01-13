package Library.Project.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import Library.Project.Books.BookRepository;


@Controller
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BookRepository bookRepo;
	
	@PostMapping("/process_register")
	public String processRegistration(User user)
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getPass());
		user.setPass(encodedPassword);
		userRepo.save(user);
		return "redirect:/";
	}
	
	@GetMapping("users")
	public String viewUsersList(Model model,User user)
	{
	List<User> userList=userRepo.findAll();
		model.addAttribute("userList",userList);
		return "users";
	}
	
}
