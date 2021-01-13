package Library.Project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Library.Project.User.User;

@Controller
public class AppController {
	@GetMapping("/index")
	public String viewHomePage()
	{
		
		return "index";
	}
	
	@GetMapping("/register")
	public String showSignUpForm(Model model)
	{
		model.addAttribute("user",new User());
		
		return "signup_form";
	}
	

}
