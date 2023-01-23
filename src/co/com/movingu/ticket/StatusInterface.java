package co.com.movingu.ticket;

import java.util.Date;

public interface StatusInterface {
    public void updateStatus(Date date, boolean vehicleDamage, boolean payedDebt,
                             boolean available);

}
