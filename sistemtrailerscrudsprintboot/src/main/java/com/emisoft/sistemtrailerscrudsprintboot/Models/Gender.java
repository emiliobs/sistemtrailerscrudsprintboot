package com.emisoft.sistemtrailerscrudsprintboot.Models;

import jakarta.persistence.*;

@Entity
public class Gender
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGender")
    private int id;

    @Column
    private  String title;

    public Gender()
    {
    }

    public int getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public Gender(String title)
    {
        this.title = title;
    }
}
