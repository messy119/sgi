package ifrn.pi.sgi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index() {
		System.out.println("deu certo");
		return "redirect:/sgi";
	}
}
