package util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Config {

    private static final String CONFIG_FILE = "/config/config.properties";
    private static final Config INSTANCE = new Config();
    private final Properties properties = new Properties();

    private final Logger LOGGER = Logger.getLogger(Config.class.getName());

    private Config(){
        try (InputStream ris = getClass().getResourceAsStream(CONFIG_FILE)) {
        properties.load(ris);
        } catch (IOException ex){
            LOGGER.log(Level.SEVERE, "Unable to load configuration", ex);
            throw new DatabaseException("Unable to load configuration.");
        }
    }

    public static Config getInstance(){return INSTANCE;}

    public String readSetting(String key, String defaultValue){return properties.getProperty(key,defaultValue);}

    public String readSetting(String key){
        return readSetting(key,null);
    }

    public void writeSetting(String key, String value){
        properties.setProperty(key,value);
        storeSettingsToFile();
    }

    private void storeSettingsToFile() {
        String path = getClass().getResource(CONFIG_FILE).getPath();

        try(FileOutputStream fos = new FileOutputStream(path)){
            properties.store(fos, null);

        } catch (IOException ex){
            LOGGER.log(Level.SEVERE, "Unable to write config settings", ex);
            throw new DatabaseException("Unable to write config settings");
        }
    }

}
