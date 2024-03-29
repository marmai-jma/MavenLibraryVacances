package com.bnpp.libraries2.expo;

import com.bnpp.libraries2.application.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LibraryRessource {
    @Autowired
    private LibraryService libraryService;

    @RequestMapping(method = RequestMethod.POST,path = {"/libraries/"})
    @ResponseStatus(HttpStatus.CREATED)
    public Long createLibrary (@Valid @RequestBody LibraryDTO libraryDTO){
        return this.libraryService.create(LibraryAdapter.TransformToLibrary(libraryDTO));
    }

    @RequestMapping(method = RequestMethod.GET,path = {"/libraries/{libraryId}"})
    public LibraryDTO obtainLibrary (@PathVariable("libraryId") Long id){
        return LibraryAdapter.adaptToLibraryDTO(this.libraryService.obtain(id));
    }

    @RequestMapping(method = RequestMethod.GET,path = {"/libraries/"})
    public List<LibraryDTO> findAllLibary (){
        return LibraryAdapter.adaptToLibraryDTOList(this.libraryService.findAll());
    }

    @RequestMapping(method = RequestMethod.PUT,path = {"/libraries/{libraryId}"})
    public void updateLibrary (@PathVariable("libraryId") Long id, @RequestBody LibraryDTO libraryDTO){
        this.libraryService.update(id, LibraryAdapter.TransformToLibrary(libraryDTO));
    }

    @RequestMapping(method = RequestMethod.DELETE,path = {"/libraries/{libraryId}"})
    public void deleteLibrary (@PathVariable("libraryId") Long id){
        this.libraryService.delete(id);
    }
}
