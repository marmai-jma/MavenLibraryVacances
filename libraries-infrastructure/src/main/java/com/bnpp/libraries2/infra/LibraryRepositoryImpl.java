package com.bnpp.libraries2.infra;

import com.bnpp.libraries2.library.Library;
import com.bnpp.libraries2.library.LibraryRepository;
import com.bnpp.libraries2.library.exception.ErrorCodes;
import com.bnpp.libraries2.library.exception.MyLibraryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class LibraryRepositoryImpl implements LibraryRepository {
    @Autowired
    private LibraryDAO libraryDAO;

    @Override
    public Long save(Library library) {
        LibraryJPA libraryJPA = libraryDAO.save(new LibraryJPA(library));
        return libraryJPA.getId();
    }

    @Override
    public Library obtain(Long id) {
        return libraryDAO
                .findById(id)
                .map(LibraryJPA::toLibrary)
                .orElseThrow(()-> new MyLibraryException(ErrorCodes.LIBRARY_NOT_FOUND));
    }

    @Override
    public List<Library> findAll() {
        return libraryDAO.findAll().stream()
                .map(LibraryJPA::toLibrary)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        libraryDAO.deleteById(id);
    }
}
