package com.bnpp.libraries2.library;

import com.bnpp.libraries2.library.exception.ErrorCodes;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.Set;

public class Director {
    private String surname;
    private String name;

    private Director() {}

    public Director(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }
    public void validate(Set<String> errors){
        if (this == null){
            errors.add(ErrorCodes.LIBRARY_MUST_HAVE_A_DIRECTOR);
        }
        if (StringUtils.isEmpty(this.surname)){
            errors.add(ErrorCodes.DIRECTOR_MUST_HAVE_A_SURNAME);
        }
        if (StringUtils.isEmpty(this.name)){
            errors.add(ErrorCodes.DIRECTOR_MUST_HAVE_A_NAME);
        }
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director director = (Director) o;
        return surname.equals(director.surname) &&
                name.equals(director.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name);
    }

}
