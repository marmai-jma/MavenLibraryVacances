package com.bnpp.libraries2.library.book;

public class Book {
    private Long id;
    private String title;
    private String author;
    private int numberOfPages;
    LiteraryGenre literaryGenre;

    private Book(){};

    public Book(String title, String author, int numberOfPages, LiteraryGenre literaryGenre) {
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.literaryGenre = literaryGenre;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public LiteraryGenre getLiteraryGenre() {
        return literaryGenre;
    }
}
