package application.controller;

import application.model.User;
import application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {


	private UserService userService;

	public IndexController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/")
	public String showAllUsers(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("All Users");
		model.addAttribute("messages", messages);
		List<User> allUsers = userService.getAllUsers();
		System.out.println(allUsers);
		model.addAttribute("user", allUsers);
		return "index";
	}

	@RequestMapping(value = "/addUser")
	public String addUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
	return "addUser";
	}

	@RequestMapping(value = "/saveUser")
	public String saveUser(@ModelAttribute("user") User user) {
//		userService.saveUser(user);
		return "redirect:/";
	}
}