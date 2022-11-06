package com.example.demo.exception;

public class InvalidFileStructureException extends RuntimeException {

  public InvalidFileStructureException(String message) {
    super(message);
  }
}
