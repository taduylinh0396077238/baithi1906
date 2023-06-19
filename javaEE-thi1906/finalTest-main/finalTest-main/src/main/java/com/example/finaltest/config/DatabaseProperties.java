package com.example.finaltest.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class DatabaseProperties {
    public static void main(String[] args){
        DatabaseProperties dbProps = new DatabaseProperties();
        System.err.println(dbProps);
    }
    private String url;
    private String username;
    private String password;
    private String driver;
    public DatabaseProperties(){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream("application.properties");
        try {
            Properties properties = new Properties();
            properties.load(input);
            this.setUrl(properties.getProperty("database.properties.url").trim());
            this.setUsername(properties.getProperty("database.properties.username").trim());
            this.setPassword(properties.getProperty("database.properties.password").trim()); // todo : hashcode  -> decode
            this.setDriver(properties.getProperty("database.properties.driver-class-name").trim());
        } catch (IOException e) {
            System.err.println("Cannot read file properties \n");
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}