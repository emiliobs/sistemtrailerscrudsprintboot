package com.emisoft.sistemtrailerscrudsprintboot.Repositories;

import com.emisoft.sistemtrailerscrudsprintboot.Models.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenderRepository extends JpaRepository<Gender, Long>
{
}
