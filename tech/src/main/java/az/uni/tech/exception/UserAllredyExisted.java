package az.uni.tech.exception;

public class UserAllredyExisted extends RuntimeException {
    private static final long serialVersionUID = -3042686055658047285L;

    public UserAllredyExisted() {
        super("User already existed.");
    }

    public UserAllredyExisted(String pinCode) {
        super("User with pin code "+pinCode+" already existed.");
    }
}