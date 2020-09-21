package com.cybertek.vytrack.Config;

public class Config {

    public static String baseUrl;
    public static String usernameDriver;
    public static String passwordDriver;

    public static String usernameManager;
    public static String passwordManager;

    static {
        baseUrl = "https://qa2.vytrack.com/user/login";
        usernameDriver = "user165";
        passwordDriver = "UserUser123";
        usernameManager = "salesmanager265";
        passwordManager = "UserUser123";
    }
}
