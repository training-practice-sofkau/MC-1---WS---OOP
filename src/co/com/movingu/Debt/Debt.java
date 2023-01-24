package co.com.movingu.Debt;

public class Debt {


    private double valueDebt;

    public Debt() {
    }

    public void penaltyForNoTime(int pTime){
        this.valueDebt=this.valueDebt+pTime*3;
    }

    public void withoutHelmet(boolean isHelmet){
        if(!isHelmet) this.valueDebt=this.valueDebt+10;
    }

    public void penaltyForDamage(boolean helmetDamaged,boolean vehicleDamage,char typeVH){
        if(helmetDamaged) this.valueDebt=this.valueDebt+5;
        switch (typeVH){
            case 'b':
                this.valueDebt=this.valueDebt+20;
                break;
            case 's':
                this.valueDebt=this.valueDebt+30;
                break;
        }

    }


}
