package co.com.movingu.user;

public abstract class User {
    //TO DO: Attributes
    protected String dni;
    protected String name;
    protected int age;
    protected boolean blocked;
    protected boolean ticketOn;

    public User(String dni, String name, int age) {
        this.dni = dni;
        this.name = name;
        this.age = age;
        this.blocked = false;
        this.ticketOn = false;
    }

    //Abstract method
    public abstract void statusMsg();

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean isTicketOn() {
        return ticketOn;
    }

    public void setTicketOn(boolean ticketOn) {
        this.ticketOn = ticketOn;
    }
}