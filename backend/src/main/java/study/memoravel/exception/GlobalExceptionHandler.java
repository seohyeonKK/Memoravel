package study.memoravel.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> BusinessExceptionHandler(BusinessException e) {
        System.out.println(e.getMessage());
        ErrorCode errorCode = e.getErrorCode();
        ErrorResponse errorResponse = new ErrorResponse(errorCode.getMessage(), errorCode.getCode());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorCode.getHttpStatus()));
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> otherExceptionHandler(Exception e) {
        System.out.println(e.getMessage());
        ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
        ErrorResponse errorResponse = new ErrorResponse(errorCode.getMessage(), errorCode.getCode());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorCode.getHttpStatus()));
    }
}
