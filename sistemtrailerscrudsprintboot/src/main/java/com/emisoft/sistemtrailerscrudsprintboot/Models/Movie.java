package com.emisoft.sistemtrailerscrudsprintboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Movie
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMovie")
    private int id;

    @NotBlank
    private String titleMovie;

    @NotBlank
    private String sinopsis;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate releaseDate;

    @NotBlank
    private  String youtubeTrailerId;

    private String pathImage;

    //relations
    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "relGenderMovie",
               joinColumns = @JoinColumn(name = "idMovie"),
               inverseJoinColumns = @JoinColumn(name = "idGender"))
    private List<Gender> enders;

    @Transient
    private MultipartFile frontPage;

    public Movie()
    {
    }

    public Movie(int id, String titleMovie, String sinopsis, LocalDate releaseDate, String youtubeTrailerId, String pathImage, List<Gender> enders, MultipartFile frontPage)
    {
        this.id = id;
        this.titleMovie = titleMovie;
        this.sinopsis = sinopsis;
        this.releaseDate = releaseDate;
        this.youtubeTrailerId = youtubeTrailerId;
        this.pathImage = pathImage;
        this.enders = enders;
        this.frontPage = frontPage;
    }


    public Movie(String titleMovie, String sinopsis, LocalDate releaseDate, String youtubeTrailerId, String pathImage, List<Gender> enders, MultipartFile frontPage)
    {
        this.titleMovie = titleMovie;
        this.sinopsis = sinopsis;
        this.releaseDate = releaseDate;
        this.youtubeTrailerId = youtubeTrailerId;
        this.pathImage = pathImage;
        this.enders = enders;
        this.frontPage = frontPage;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitleMovie()
    {
        return titleMovie;
    }

    public void setTitleMovie(String titleMovie)
    {
        this.titleMovie = titleMovie;
    }

    public String getSinopsis()
    {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis)
    {
        this.sinopsis = sinopsis;
    }

    public LocalDate getReleaseDate()
    {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    public String getYoutubeTrailerId()
    {
        return youtubeTrailerId;
    }

    public void setYoutubeTrailerId(String youtubeTrailerId)
    {
        this.youtubeTrailerId = youtubeTrailerId;
    }

    public String getPathImage()
    {
        return pathImage;
    }

    public void setPathImage(String pathImage)
    {
        this.pathImage = pathImage;
    }

    public List<Gender> getEnders()
    {
        return enders;
    }

    public void setEnders(List<Gender> enders)
    {
        this.enders = enders;
    }

    public MultipartFile getFrontPage()
    {
        return frontPage;
    }

    public void setFrontPage(MultipartFile frontPage)
    {
        this.frontPage = frontPage;
    }
}
