package study.memoravel.exception.member;

import study.memoravel.exception.BusinessException;
import study.memoravel.exception.ErrorCode;

public class MemberNotFoundException extends BusinessException {
    public MemberNotFoundException() {
        super(ErrorCode.MEMBER_NOT_FOUND_EXCEPTION);
    }
}
