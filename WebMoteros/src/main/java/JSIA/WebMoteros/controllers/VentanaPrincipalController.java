package JSIA.WebMoteros.controllers;

import JSIA.WebMoteros.dtos.LoginRequestDto;
import JSIA.WebMoteros.services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VentanaPrincipalController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/ventanaPrincipal")
    public String showLoginPage() {
        return "ventanaPrincipal";
    }

}
