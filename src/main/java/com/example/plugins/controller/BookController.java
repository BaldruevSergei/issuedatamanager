package com.example.plugins.controller;

import com.example.plugins.ao.BookDTO;
import com.example.plugins.issuedatamanager.LibraryService;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Path("/library")
public class BookController {

    private final LibraryService libraryService;

    @Inject
    public BookController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @POST
    @Path("/addBook")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addBook(BookDTO bookDTO) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date publicationDate;

        try {
            publicationDate = sdf.parse(bookDTO.getPublicationDate());
        } catch (ParseException e) {
            return "Ошибка: неверный формат даты. Ожидается yyyy-MM-dd";
        }

        libraryService.addBook(
                bookDTO.getIsbn(),
                bookDTO.getTitle(),
                bookDTO.getAuthor(),
                publicationDate,
                bookDTO.getGenres()
        );
        return "Книга добавлена!";
    }
}
