package co.com.movingu.ticket;

import java.time.LocalDateTime;
import java.util.Date;

public interface DebtInterface {
    public void updateDebt(LocalDateTime date, boolean helmet, boolean helmetDamage,
                           boolean vehicleDamage, String typeVehicule);

}
