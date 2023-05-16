package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Genero;
import application.model.GeneroRepository;
import application.model.Livro;
import application.model.LivroRepository;

@Controller
public class GeneroController {

    @Autowired
    private GeneroRepository generoRepo;

    @RequestMapping("/genero")
    public String list(Model model) {
        model.addAttribute("generos", generoRepo.findAll());
        return "WEB-INF/listGenero.jsp";
    }

    @RequestMapping("/insertGenero")
    public String insert() {
        return "WEB-INF/insertGenero.jsp";
    }

    @RequestMapping(value = "/insertGenero", method = RequestMethod.POST)
    public String insert(@RequestParam("titulo") String titulo) {
        Genero genero = new Genero();
        genero.setNome(titulo);

        generoRepo.save(genero);

        return "redirect:/genero";
    }

    @RequestMapping("/updateGenero")
    public String update(Model model, @RequestParam("id") int id) {
        Optional<Genero> genero = generoRepo.findById(id);

        if(!genero.isPresent()) {
            return "redirect:/genero";
        }

        model.addAttribute("genero", genero.get());
        return "WEB-INF/updateGenero.jsp";
    }

    @RequestMapping(value = "/updateGenero", method = RequestMethod.POST)
    public String update(
        @RequestParam("titulo") String titulo,
        @RequestParam("id") int id
        
    ) {
        Optional<Genero> genero = generoRepo.findById(id);
        if(!genero.isPresent()) {
            return "redirect:/genero";
        }

        genero.get().setNome(titulo);

        generoRepo.save(genero.get());
        return "redirect:/genero";
    }

    @RequestMapping("/deleteGenero")
    public String delete(Model model, @RequestParam("id") int id) {
        Optional<Genero> genero = generoRepo.findById(id);

        if(!genero.isPresent()) {
            return "redirect:/genero";
        }

        model.addAttribute("genero", genero.get());
        return "WEB-INF/deleteGenero.jsp";
    }

    @RequestMapping(value = "/deleteGenero", method = RequestMethod.POST)
    public String delete(@RequestParam("id") int id) {
        generoRepo.deleteById(id);
        return "redirect:/genero";
    }

}
