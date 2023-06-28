package comm.geekaca.test.atm;


import java.util.HashMap;
import java.util.Map;

public class AccountMap {
    private static AccountMap instance = new AccountMap();
    private static Map<String,Account> accountMap = new HashMap<>();

    private AccountMap(){}

    public static AccountMap getInstance() {
        return instance;
    }

    public static Map<String, Account> getAccountMap() {
        return accountMap;
    }


}
