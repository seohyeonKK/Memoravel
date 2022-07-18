package study.memoravel.exception.member;

import study.memoravel.exception.BusinessException;
import study.memoravel.exception.ErrorCode;

public class EmailDuplicateException extends BusinessException {
    public EmailDuplicateException() {
        super(ErrorCode.EMAIL_DUPLICATE_EXCEPTION);
    }
}
