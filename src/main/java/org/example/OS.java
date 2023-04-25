package org.example;

public enum OS {
    WINDOWS, LINUX;

    public static OS current() {
        String os = System.getProperty("os.name");
        if (os.contains("Windows")){
            return WINDOWS;
        }
        return null;
    }
}
