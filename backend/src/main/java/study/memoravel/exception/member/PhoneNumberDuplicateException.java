package study.memoravel.exception.member;

import study.memoravel.exception.BusinessException;
import study.memoravel.exception.ErrorCode;

public class PhoneNumberDuplicateException extends BusinessException {
    public PhoneNumberDuplicateException() {
        super(ErrorCode.PHONE_NUMBER_DUPLICATE_EXCEPTION);
    }
}
