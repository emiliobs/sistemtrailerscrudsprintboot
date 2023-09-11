package com.emisoft.sistemtrailerscrudsprintboot.Controllers;

import com.emisoft.sistemtrailerscrudsprintboot.Models.Gender;
import com.emisoft.sistemtrailerscrudsprintboot.Models.Movie;
import com.emisoft.sistemtrailerscrudsprintboot.Repositories.IGenderRepository;
import com.emisoft.sistemtrailerscrudsprintboot.Repositories.IMovieRepository;
import com.emisoft.sistemtrailerscrudsprintboot.Services.StoreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller @RequestMapping("/admin")
public class AdminController
{

    @Autowired private IMovieRepository movieRepository;

    @Autowired private IGenderRepository genderRepository;

    @Autowired private StoreServices storeServices;

    //    @GetMapping(value = {"/index", "/"})
    //    public String GetAllStudents(Model model)
    //    {
    //        //        List<Student> studentList = this.studentService.StudentsList();
    //        model.addAttribute("movies", storeServices.MoviesList());
    //        //        return studentList;
    //        return "index";
    //    }
    @GetMapping("")
    public ModelAndView SeeHomePage(@PageableDefault(sort = "titulo", size = 5) Pageable pageable)
    {
        Page<Movie> movies = movieRepository.findAll(pageable);
        return new ModelAndView("index").addObject("movies", movies);
    }

    @GetMapping("/movies/new")
    public ModelAndView ShowNewMovieForm()
    {
        List<Gender> genders = genderRepository.findAll(Sort.by("title"));
        return new ModelAndView("admin/newMovie").addObject("movie", new Movie())
                                                          .addObject("genders",genders);
    }

//    @PostMapping("/movies/new")
//    public ModelAndView RegisterMovie(@Validated Movie movie, BindingResult bindingResult)
//    {
//
//    }


    //    @GetMapping("/peliculas/nuevo")
    //    public ModelAndView mostrarFormularioDeNuevaPelicula() {
    //        List<Gender> generos = genderRepository.findAll(Sort.by("titulo"));
    //        return new ModelAndView("admin/nueva-pelicula")
    //                .addObject("pelicula", new Pelicula())
    //                .addObject("generos",generos);
    //    }
    //
    //    @PostMapping("/peliculas/nuevo")
    //    public ModelAndView registrarPelicula(@Validated Pelicula pelicula,BindingResult bindingResult) {
    //        if(bindingResult.hasErrors() || pelicula.getPortada().isEmpty()) {
    //            if(pelicula.getPortada().isEmpty()) {
    //                bindingResult.rejectValue("portada","MultipartNotEmpty");
    //            }
    //
    //            List<Genero> generos = generoRepositorio.findAll(Sort.by("titulo"));
    //            return new ModelAndView("admin/nueva-pelicula")
    //                    .addObject("pelicula",pelicula)
    //                    .addObject("generos",generos);
    //        }
    //
    //        String rutaPortada = servicio.almacenarArchivo(pelicula.getPortada());
    //        pelicula.setRutaPortada(rutaPortada);
    //
    //        peliculaRepositorio.save(pelicula);
    //        return new ModelAndView("redirect:/admin");
    //    }
    //
    //    @GetMapping("/peliculas/{id}/editar")
    //    public ModelAndView mostrarFormilarioDeEditarPelicula(@PathVariable Integer id) {
    //        Pelicula pelicula = peliculaRepositorio.getOne(id);
    //        List<Genero> generos = generoRepositorio.findAll(Sort.by("titulo"));
    //
    //        return new ModelAndView("admin/editar-pelicula")
    //                .addObject("pelicula",pelicula)
    //                .addObject("generos",generos);
    //    }
    //
    //    @PostMapping("/peliculas/{id}/editar")
    //    public ModelAndView actualizarPelicula(@PathVariable Integer id,@Validated Pelicula pelicula,BindingResult bindingResult) {
    //        if(bindingResult.hasErrors()) {
    //            List<Genero> generos = generoRepositorio.findAll(Sort.by("titulo"));
    //            return new ModelAndView("admin/editar-pelicula")
    //                    .addObject("pelicula",pelicula)
    //                    .addObject("generos",generos);
    //        }
    //
    //        Pelicula peliculaDB = peliculaRepositorio.getOne(id);
    //        peliculaDB.setTitulo(pelicula.getTitulo());
    //        peliculaDB.setSinopsis(pelicula.getSinopsis());
    //        peliculaDB.setFechaEstreno(pelicula.getFechaEstreno());
    //        peliculaDB.setYoutubeTrailerId(pelicula.getYoutubeTrailerId());
    //        peliculaDB.setGeneros(pelicula.getGeneros());
    //
    //        if(!pelicula.getPortada().isEmpty()) {
    //            servicio.eliminarArchivo(peliculaDB.getRutaPortada());
    //            String rutaPortada = servicio.almacenarArchivo(pelicula.getPortada());
    //            peliculaDB.setRutaPortada(rutaPortada);
    //        }
    //
    //        peliculaRepositorio.save(peliculaDB);
    //        return new ModelAndView("redirect:/admin");
    //    }
    //
    //    @PostMapping("/peliculas/{id}/eliminar")
    //    public String eliminarPelicula(@PathVariable Integer id) {
    //        Pelicula pelicula = peliculaRepositorio.getOne(id);
    //        peliculaRepositorio.delete(pelicula);
    //        servicio.eliminarArchivo(pelicula.getRutaPortada());
    //
    //        return "redirect:/admin";
    //    }
}