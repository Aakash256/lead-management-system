package com.business.manager.service;

import com.business.manager.common.dto.ErrorDTO;
import com.business.manager.common.exception.ResourceNotFoundException;
import com.business.manager.repository.ErrorRepository;
import com.business.manager.repository.entity.Error;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @Autowired
  private ErrorRepository errorRepository;

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
    List<String> details = new ArrayList<>();
    details.add(ex.getMessage());
    details.add(ex.getLocalizedMessage());
    ErrorDTO error = new ErrorDTO("Apologies !! Something went wrong !! We will fix it asap !! ",
        details);
    persistErrorIntoDB(error, ex, HttpStatus.INTERNAL_SERVER_ERROR);
    return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private void persistErrorIntoDB(ErrorDTO errorDTO, Exception ex, HttpStatus httpStatus) {
    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    ex.printStackTrace(pw);
    Error error = new Error(ex.getMessage(), String.valueOf(httpStatus.value()),
        httpStatus.getReasonPhrase(), sw.toString());
    log.error("Persisted error into database - " + error);
    errorRepository.save(error);
  }

  @ExceptionHandler(value
      = {IllegalAccessException.class})
  protected ResponseEntity<Object> handleBadRequestException(
      RuntimeException ex, WebRequest request) {
    List<String> details = new ArrayList<>();
    details.add(ex.getLocalizedMessage());
    ErrorDTO error = new ErrorDTO(ex.getMessage(), details);
    persistErrorIntoDB(error, ex, HttpStatus.BAD_REQUEST);
    return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value
      = {ResourceNotFoundException.class})
  protected ResponseEntity<Object> handleResourceNotFoundException(
      RuntimeException ex, WebRequest request) {
    List<String> details = new ArrayList<>();
    details.add(ex.getLocalizedMessage());
    ErrorDTO error = new ErrorDTO(ex.getMessage(), details);
    persistErrorIntoDB(error, ex, HttpStatus.NOT_FOUND);
    return new ResponseEntity(error, HttpStatus.NOT_FOUND);
  }


}
