package com.bnpp.libraries2.library;

import java.util.List;

public interface LibraryRepository {
    Long save(Library Library);

    Library obtain (Long id);

    List<Library> findAll ();

    void delete (Long id);
}
