import java.util.HashMap;

public class Credentials {
    HashMap<String, String> loginCredentials = new HashMap<>();

    Credentials(){
        loginCredentials.put("Sophia", "pizza");
        loginCredentials.put("Sebasti", "piano");
        loginCredentials.put("Suji", "bun");
    }

    protected HashMap<String, String> getLoginCredentials(){
        return loginCredentials;
    }

}