package az.uni.tech.exception;

public class UserNotFoundException  extends RuntimeException {

    private static final long serialVersionUID = -3042686055658047285L;

    public UserNotFoundException() {
        super("User not found.");
    }

    public UserNotFoundException(String pinCode) {
        super("User with id "+pinCode+" not found.");
    }
}