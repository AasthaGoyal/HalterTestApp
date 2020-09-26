package herd;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class CowNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(CowNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String cowNotFoundHandler(CowNotFoundException ex) {
        return ex.getMessage();
    }
}