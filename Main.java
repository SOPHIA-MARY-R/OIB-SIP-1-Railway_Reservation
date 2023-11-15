import java.util.*;

public class Main{
    public static void main(String[] args){
        Credentials credentials = new Credentials();
        Login login = new Login(credentials.getLoginCredentials());
    }
}