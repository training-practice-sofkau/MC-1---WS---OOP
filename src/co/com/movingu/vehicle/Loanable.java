package co.com.movingu.vehicle;

public interface Loanable {
    default boolean isAvailable(){
        return false;
    }
}
