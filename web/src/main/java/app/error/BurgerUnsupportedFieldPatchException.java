package app.error;

import java.util.Set;

public class BurgerUnsupportedFieldPatchException extends RuntimeException {
    public BurgerUnsupportedFieldPatchException(Set<String> keys) {
        super("Field " + keys.toString() + " update is not allow.");
    }
}
