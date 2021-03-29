package util;

import org.jasypt.util.text.StrongTextEncryptor;

public class Crypto {
    private static final String KEY= "HELLO-FROM-GROUP-4";
    private static final Crypto INSTANCE = new Crypto();

    private final StrongTextEncryptor encryptor = new StrongTextEncryptor();

    private Crypto(){encryptor.setPassword(KEY);}

    public static Crypto getInstance(){return INSTANCE;}

    public String encrypt (String s){return encryptor.encrypt(s);}
    public String decrypt(String s){return encryptor.decrypt(s);}

}
