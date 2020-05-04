package st52572.nnpia.project.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import st52572.nnpia.project.model.ApiResponse;

@RestControllerAdvice
public class ExceptionAdvice {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    protected ApiResponse handleGlobalException(Exception ex) {
        return new ApiResponse(400, ex.getMessage(), null);
    }


}
