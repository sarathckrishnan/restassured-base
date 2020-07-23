package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileObject{

    public String baseURL;
    public String accessToken;
    public String username;
    public String password;

    public ConfigFileObject(String propFileName){
         Properties prop = new Properties();
        try {
            File propFile = new File(propFileName);
            prop.load(new FileInputStream(propFile));
            this.baseURL = prop.getProperty("baseURL");
            this.accessToken = prop.getProperty("accessToken");
            this.username = prop.getProperty("username");
            this.password = prop.getProperty("password");

        } catch (IOException e) {
            System.err.println("Error reading "+propFileName);
            e.printStackTrace();
        }
    }


}