package co.com.movingu.user;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    public static List<User> users = new ArrayList<>(){{
        add(new Student("0976152443", "Carolina Montoya", 24, "201547896", "FIEC"));
        add(new Trainer("0976152443", "Washington Pesantez", 36, "lecturer"));
        add(new Trainer("123", "Larry", 27, "Professor"));
    }};
}
