package com.emisoft.sistemtrailerscrudsprintboot.Repositories;

import com.emisoft.sistemtrailerscrudsprintboot.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Long>
{
}
