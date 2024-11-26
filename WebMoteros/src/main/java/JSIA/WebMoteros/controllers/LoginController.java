package JSIA.WebMoteros.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import JSIA.WebMoteros.dtos.LoginRequestDto;
import JSIA.WebMoteros.services.ApiService;

@Controller
public class LoginController {

	@Autowired
	private ApiService apiService;

	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}

	@PostMapping("/login")
	public String handleLogin(@RequestParam String mail, @RequestParam String contrasenya) {

		LoginRequestDto loginRequest = new LoginRequestDto(mail, contrasenya);

		String response = apiService.sendLoginData(loginRequest, "usuarios");

		if ("success".equalsIgnoreCase(response)) {
			return "redirect:/ventanaPrincipal";
		}

		response = apiService.sendLoginData(loginRequest, "clubes");
		return "redirect:/login?error";

	}
}
