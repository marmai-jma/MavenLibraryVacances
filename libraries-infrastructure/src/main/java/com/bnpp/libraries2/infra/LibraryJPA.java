package com.bnpp.libraries2.infra;

import com.bnpp.libraries2.library.Address;
import com.bnpp.libraries2.library.Director;
import com.bnpp.libraries2.library.Library;
import com.bnpp.libraries2.library.Type;

import javax.persistence.*;

@Entity(name = "LIBRARY")
public class LibraryJPA {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private Type type;

    @Column(name = "ADDRESS_NUMBER")
    private int addressNumber;
    @Column(name = "ADDRESS_STREET")
    private String addressStreet;
    @Column(name = "ADDRESS_POSTALCODE")
    private int addressPostalCode;
    @Column(name = "ADDRESS_CITY")
    private String addressCity;

    @Column(name = "DIRECTOR_SURNAME")
    private String directorSurname;
    @Column(name = "DIRECTOR_NAME")
    private String directorName;

    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "LIBRARY_ID",referencedColumnName = "ID")
    //private List<Book> books;

    private LibraryJPA() {}

    public LibraryJPA(Library library) {
        this.id = library.getId();
        this.type = library.getType();
        this.addressNumber = library.getAddress().getNumber();
        this.addressStreet = library.getAddress().getStreet();
        this.addressPostalCode = library.getAddress().getPostalCode();
        this.addressCity = library.getAddress().getCity();
        this.directorSurname = library.getDirector().getSurname();
        this.directorName = library.getDirector().getName();
    }

    public Library toLibrary(){
        Address address = new Address(addressNumber,addressStreet,addressPostalCode,addressCity);
        Director director = new Director(directorSurname,directorName);
        return new Library(id,type,address,director,null);
    }

    public Long getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public int getAddressNumber() {
        return addressNumber;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public int getAddressPostalCode() {
        return addressPostalCode;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public String getDirectorSurname() {
        return directorSurname;
    }

    public String getDirectorName() {
        return directorName;
    }
}
