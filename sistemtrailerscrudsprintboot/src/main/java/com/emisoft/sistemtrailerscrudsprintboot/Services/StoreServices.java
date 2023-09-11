package com.emisoft.sistemtrailerscrudsprintboot.Services;

import com.emisoft.sistemtrailerscrudsprintboot.Exceptions.StoreExceptions;
import com.emisoft.sistemtrailerscrudsprintboot.Models.Movie;
import com.emisoft.sistemtrailerscrudsprintboot.Repositories.IGenderRepository;
import com.emisoft.sistemtrailerscrudsprintboot.Repositories.IMovieRepository;
import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.*;
import java.util.List;

@Service
public class StoreServices implements IStoreServices
{

    @Autowired
    private final IMovieRepository movieRepository;

    @Autowired
    private final IGenderRepository genderRepository;

    public StoreServices(IMovieRepository movieRepository, IGenderRepository genderRepository)
    {
        this.movieRepository = movieRepository;
        this.genderRepository = genderRepository;

    }

    @Value("${storage.location}") private String storaLocation;

    @Override public List<Movie> MoviesList()
    {
        return movieRepository.findAll();
    }

    //esta sirve para indicar que este metodose va a ejecutarcada vez que halla una nueva istacia de esta clase
    @PostConstruct @Override public void StarStoreFile()
    {
        try
        {
            Files.createDirectories(Paths.get(storaLocation));
        }
        catch (IOException exception)
        {
            throw new StoreExceptions("Error initializing location in file store.");
        }
    }

    @Override public String StoreFile(MultipartFile file)
    {
        String nameFile = file.getOriginalFilename();

        if (file.isEmpty())
        {
            throw new StoreExceptions("Cannot store an empty file");
        }

        try
        {
            InputStream inputStream = file.getInputStream();
            Files.copy(inputStream, Paths.get(storaLocation).resolve(nameFile), StandardCopyOption.REPLACE_EXISTING);

            return nameFile;

        }
        catch (IOException exception)
        {
            throw new StoreExceptions("Error saving files" + nameFile, exception);
        }


    }

    @Override public Path UploadFile(String fileName)
    {
        return Paths.get(storaLocation).resolve(fileName);
    }

    @Override public Resource UploadAsResouce(String fileName)
    {
        Resource resource = null;
        try
        {
            Path file = UploadFile(fileName);
            resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable())
            {
                return resource;
            }
            else
            {
                throw new StoreExceptions("file could not be found." + fileName);

            }

        }
        catch (MalformedURLException exception)
        {
            throw new StoreExceptions("file could not be found." + fileName, exception);

        }

    }

    @Override public void DeleteFile(String fileName)
    {
        Path file = UploadFile(fileName);
        try
        {
            FileSystemUtils.deleteRecursively(file);
        }
        catch (Exception exception)
        {
            System.out.println("ERROR Delte file in SoreService: " + exception.getMessage());
        }
    }
}
