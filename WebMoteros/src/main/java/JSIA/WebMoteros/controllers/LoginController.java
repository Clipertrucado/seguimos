package JSIA.WebMoteros.controllers;


import JSIA.WebMoteros.models.LoginRequest;
import JSIA.WebMoteros.services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    	
        LoginRequest loginRequest = new LoginRequest(mail, contrasenya);
        
        String response = apiService.sendLoginData(loginRequest);

        if ("success".equalsIgnoreCase(response)) {
            return "redirect:/dashboard";
        }
        return "redirect:/login?error";
    }
}
