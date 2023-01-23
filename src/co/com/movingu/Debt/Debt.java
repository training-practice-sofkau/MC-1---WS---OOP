package co.com.movingu.Debt;

public class Debt {

    private boolean isHelmet;
    private boolean noTime;
    private boolean damage;

    public Debt(boolean isHelmet, boolean noTime, boolean damage) {
        this.isHelmet = isHelmet;
        this.noTime = noTime;
        this.damage = damage;
    }

    public boolean isHelmet() {
        return isHelmet;
    }

    public void setHelmet(boolean helmet) {
        isHelmet = helmet;
    }

    public boolean isNoTime() {
        return noTime;
    }

    public void setNoTime(boolean noTime) {
        this.noTime = noTime;
    }

    public boolean isDamage() {
        return damage;
    }

    public void setDamage(boolean damage) {
        this.damage = damage;
    }
}
