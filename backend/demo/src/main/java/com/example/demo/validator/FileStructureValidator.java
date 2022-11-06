package com.example.demo.validator;

import com.example.demo.exception.InvalidFileStructureException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.io.IOException;
import java.io.InputStreamReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
public class FileStructureValidator implements
    ConstraintValidator<ValidFileStructure, MultipartFile> {

  @Override
  public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
    validateFileEncoding(file);
    return true;
  }

  private void validateFileEncoding(MultipartFile file) {
    try (InputStreamReader reader = new InputStreamReader(file.getInputStream())) {
      int firstBytes = (reader.read() << 8) + reader.read();
      if (firstBytes == 0xefbb || firstBytes == 0xfffe || firstBytes == 0xfeff) {
        throw new InvalidFileStructureException("The file use encoding different from UTF-8");
      }
    } catch (IOException exception) {
      log.error(exception.getMessage());
      throw new RuntimeException(exception);
    }
  }
}
