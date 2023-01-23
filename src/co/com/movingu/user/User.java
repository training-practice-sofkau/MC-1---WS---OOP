package co.com.movingu.user;

//TODO: Complete/Rewrite the class according to the requirements
public abstract class User {
    //TODO: Attributes
    protected String dni;

    protected String name;

    protected int age;

    protected boolean blocked;

    protected int ticketOn;

    public User(String dni, String name, int age) {
        this.dni = dni;
        this.name = name;
        this.age = age;
        this.blocked = false;
        this.ticketOn = 0;
    }

    //Abstract method
    public abstract void statusMsg();

    public String getDni() {
        return dni;
    }

    public int getTicketOn() {
        return ticketOn;
    }

    public boolean isBlocked() {
        return blocked;
    }
}