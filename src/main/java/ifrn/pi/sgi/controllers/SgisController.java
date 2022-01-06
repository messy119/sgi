package ifrn.pi.sgi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ifrn.pi.sgi.models.SGI;
import ifrn.pi.sgi.models.Usuario;
import ifrn.pi.sgi.repositories.SgiRepository;
import ifrn.pi.sgi.repositories.UsuarioRepository;

@Controller
@RequestMapping("/sgi")
public class SgisController {

	@Autowired
	private SgiRepository er;
	@Autowired
	private UsuarioRepository cr;

	@GetMapping("/form")
	public String form(SGI sgi) {
		return "sgi/formSGI";
	}

	@PostMapping
	public String salvar(SGI sgi) {
		System.out.println(sgi);
		er.save(sgi);
		return "redirect:/sgi";
	}

	@GetMapping
	public ModelAndView listar() {
		List<SGI> sgi = er.findAll();
		ModelAndView mv = new ModelAndView("sgi/lista");
		mv.addObject("sgi", sgi);
		return mv;
	}

	@GetMapping("/{Id}")
	public ModelAndView detalhar(@PathVariable long Id) {
		ModelAndView md = new ModelAndView();
		Optional<SGI> opt = er.findById(Id);
		if (opt.isEmpty()) {
			md.setViewName("redirect:/sgi");
			return md;
		}
		md.setViewName("sgi/detalhe");
		SGI sgi = opt.get();
		md.addObject("SGI", sgi);

		List<Usuario> usuarios = cr.findBySgi(sgi);
		md.addObject("usuarios", usuarios);

		return md;
	}

	@PostMapping("/{IdEvento}")
	public String salvarUsuario(@PathVariable long IdEvento, Usuario usuario) {

		Optional<SGI> opt = er.findById(IdEvento);
		if (opt.isEmpty()) {
			return "redirect:/sgi";
		}
		SGI sgi = opt.get();
		usuario.setSgi(sgi);
		cr.save(usuario);
		return "redirect:/sgi/{IdEvento}";
	}

	@GetMapping("/{Id}/selecionar")
	public ModelAndView selectSgi(@PathVariable Long Id) {
		ModelAndView md = new ModelAndView();
		Optional<SGI> opt = er.findById(Id);
		if (opt.isEmpty()) {
			md.setViewName("redirect:/sgi");
			return md;
		}
		SGI sgi = opt.get();
		md.setViewName("sgi/formSGI");
		md.addObject("sgi", sgi);
		
		return md;
	}

	@GetMapping("/{IdSGI}/Usuarios/{idUsuario}/selecionar")
	public ModelAndView selecioarSgi(@PathVariable Long IdSGI, @PathVariable Long idUsuario) {
		ModelAndView md = new ModelAndView();

		Optional<SGI> optSGI = er.findById(IdSGI);
		Optional<Usuario> optUsuario = cr.findById(idUsuario);

		if (optSGI.isEmpty() || optUsuario.isEmpty()) {
			md.setViewName("redirect:/sgi");
			return md;
		}

		SGI sgi = optSGI.get();
		Usuario usuario = optUsuario.get();
		
		if (sgi.getId() != usuario.getSgi().getId()) {
			md.setViewName("redirect:/sgi");
			return md;
		}
		md.setViewName("sgi/detalhe");
		md.addObject("usuario", usuario);
		md.addObject("sgi", sgi);
		md.addObject("ususarios", cr.findBySgi(sgi));
		
		return md;
	}

	@GetMapping("/{Id}/remover")
	public String removerSgi(@PathVariable Long Id) {
		Optional<SGI> opt = er.findById(Id);
		if (!opt.isEmpty()) {
			SGI sgi = opt.get();
			List<Usuario> usuarios = cr.findBySgi(sgi);
			cr.deleteAll(usuarios);
			er.delete(sgi);
		}

		return "redirect:/sgi";
	}

}
