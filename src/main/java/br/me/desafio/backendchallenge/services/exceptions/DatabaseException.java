package br.me.desafio.backendchallenge.services.exceptions;

public class DatabaseException extends RuntimeException {

    public DatabaseException (String msg) {
        super(msg);
    }
}
