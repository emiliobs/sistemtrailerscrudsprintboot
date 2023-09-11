package com.emisoft.sistemtrailerscrudsprintboot.Services;


import com.emisoft.sistemtrailerscrudsprintboot.Models.Movie;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;

public interface IStoreServices
{
    public  List<Movie> MoviesList();

    public void StarStoreFile();

    public  String StoreFile(MultipartFile file);

    public Path UploadFile(String fileName);

    public Resource UploadAsResouce(String fileName);

    public void DeleteFile(String fileName);
}
