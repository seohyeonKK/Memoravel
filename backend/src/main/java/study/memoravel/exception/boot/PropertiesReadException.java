package study.memoravel.exception.boot;

import study.memoravel.exception.BusinessException;
import study.memoravel.exception.ErrorCode;

public class PropertiesReadException extends BusinessException {
    public PropertiesReadException() {
        super(ErrorCode.PROPERTIES_READ_EXCEPTION);
    }
}
