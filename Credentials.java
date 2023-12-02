import java.util.HashMap;

public class Credentials {
    private final HashMap<String, String> loginCredentials = new HashMap<>();

    public HashMap<String, String> getLoginCredentials(){
        return loginCredentials;
    }

    public void setLoginCredentials(String user, String pwd){
        loginCredentials.put(user, pwd);
    }

}