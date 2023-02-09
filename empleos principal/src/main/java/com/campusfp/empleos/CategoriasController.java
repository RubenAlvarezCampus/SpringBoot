package com.campusfp.empleos;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.campusfp.empleos.modelo.Categorias;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {
    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        List<Categorias> lista = new LinkedList<Categorias>();
        lista = listaCategorias();
        model.addAttribute("listadocategorias", lista);
        return "/categorias/listaCategorias";
    }
    
    @GetMapping("/create")
    public String crear(Model model) {
        return "/categorias/formCategoria";
    }
    
    @PostMapping("/save")
    public String guardar(Model model) {
        return "/categorias/listaCategorias";
    }
    
    
    public List<Categorias> listaCategorias(){
        List<Categorias> lista = new LinkedList<Categorias>();
        
        Categorias c1 = new Categorias(1, "DEV");
        Categorias c2 = new Categorias(2, "BigData");
        Categorias c3 = new Categorias(3, "CiberSeguridad");
        
        c2.setActiva(0);
        
        lista.add(c1);
        lista.add(c2);
        lista.add(c3);
        return lista;
        
    }
}
