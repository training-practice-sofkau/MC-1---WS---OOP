package co.com.movingu.ticket;

import java.util.Date;

public interface DebtInterface {
    public void updateDebt(Date date, boolean helmet, boolean helmetDamage,
                           boolean vehicleDamage, String typeVehicule);

}
