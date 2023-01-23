package co.com.movingu.ticket;

import java.util.Date;

public interface DebtInterface {
    public void updateDebt(Date date, boolean helmet, String helmetCondition,
                           String vehicleCondition);
}
