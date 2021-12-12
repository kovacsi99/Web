package app.error;

public class BurgerNotFoundException extends RuntimeException{
    public BurgerNotFoundException(Long id) {
        super("Burger id not found : " + id);
    }
}
