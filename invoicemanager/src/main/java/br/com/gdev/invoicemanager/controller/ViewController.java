package br.com.gdev.invoicemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gdev.invoicemanager.dto.UserCreateDTO;
import br.com.gdev.invoicemanager.service.UserRegistrartionService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/sign-in")
public class ViewController {
	
	@Autowired
	private UserRegistrartionService registerService;
	
	@GetMapping
	public String loginPage() {
		return "loginpage";
	}
	
	@GetMapping("/home")
	public String homePage() {
		return "home";
	}
	
	@GetMapping("/register")
	public String registerPage(Model model) {
		
		model.addAttribute("userCreateDTO", new UserCreateDTO());
		return "registerpage";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("userCreateDTO")UserCreateDTO userCreateDTO, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			model.addAttribute("title", "Registre-se");
			return "registerpage";
		}
		try {
			registerService.registerUser(userCreateDTO);
			return "redirect:/sign-in";
			
		} catch (Exception e) {
			model.addAttribute("title", "Registre-se");
			model.addAttribute("messageError", "Error ao cadastrar: " + e.getMessage());
			return "registerpage";
		}		
		
	}
}
