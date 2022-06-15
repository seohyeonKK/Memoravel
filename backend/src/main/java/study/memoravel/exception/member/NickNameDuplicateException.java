package study.memoravel.exception.member;

import study.memoravel.exception.BusinessException;
import study.memoravel.exception.ErrorCode;

public class NickNameDuplicateException extends BusinessException {
    public NickNameDuplicateException() {
        super(ErrorCode.NICKNAME_DUPLICATE_EXCEPTION);
    }
}
