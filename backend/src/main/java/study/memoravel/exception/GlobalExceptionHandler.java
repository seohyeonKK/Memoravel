package study.memoravel.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import study.memoravel.exception.jwt.JwtExpiredException;
import study.memoravel.util.JWT;

@RestControllerAdvice(basePackages = {"study.memoravel.controller"})
public class GlobalExceptionHandler {
    @ExceptionHandler(JwtExpiredException.class)
    public ResponseEntity<ErrorResponse> JwtExpiredExceptionHandler(JwtExpiredException e) {
        String newJwt = JWT.create(e.getMemberId(), e.getNickname());
        ErrorCode errorCode = e.getErrorCode();
        ErrorResponse errorResponse = new ErrorResponse(errorCode.getMessage(), errorCode.getCode(), newJwt);
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorCode.getHttpStatus()));
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> BusinessExceptionHandler(BusinessException e) {
        ErrorCode errorCode = e.getErrorCode();
        ErrorResponse errorResponse = new ErrorResponse(errorCode.getMessage(), errorCode.getCode());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorCode.getHttpStatus()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> otherExceptionHandler(Exception e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
        ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
        ErrorResponse errorResponse = new ErrorResponse(errorCode.getMessage(), errorCode.getCode());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorCode.getHttpStatus()));
    }
}
