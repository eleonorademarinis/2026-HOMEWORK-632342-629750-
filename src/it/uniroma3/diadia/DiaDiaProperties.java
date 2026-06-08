package it.uniroma3.diadia;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DiaDiaProperties {

    private static Properties prop = new Properties();

    static {
        try {
            InputStream is = new FileInputStream("diadia.properties");
            prop.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Impossibile leggere diadia.properties", e);
        }
    }

    public static int getCFUIniziali() {
        return Integer.parseInt(prop.getProperty("cfu_iniziali"));
    }

    public static int getPesoMaxBorsa() {
        return Integer.parseInt(prop.getProperty("peso_max_borsa"));
    }
}