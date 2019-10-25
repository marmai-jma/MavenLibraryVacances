package com.bnpp.libraries2.library.exception;

public class ErrorCodes {
    private ErrorCodes() {}

    public static final String LIBRARY_NOT_FOUND="ERR_0001";
    public static final String LIBRARY_MUST_HAVE_A_DIRECTOR = "ERR_0002";
    public static final String LIBRARY_MUST_HAVE_AN_ADDRESS = "ERR_0003";
    public static final String DIRECTOR_MUST_HAVE_A_SURNAME = "ERR_0004";
    public static final String DIRECTOR_MUST_HAVE_A_NAME = "ERR_0005";
    public static final String ADDRESS_MUST_HAVE_A_STREET = "ERR_0006";
    public static final String ADDRESS_MUST_HAVE_A_CITY = "ERR_0007";
}
