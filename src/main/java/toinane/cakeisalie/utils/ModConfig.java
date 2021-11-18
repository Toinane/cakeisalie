package toinane.cakeisalie.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import toinane.cakeisalie.CakeIsALie;

public class ModConfig {
    private static File folder = new File("config");
    private static File configFile;
    private static Gson config = new GsonBuilder().setPrettyPrinting().create();
    public static ConfigInstance INSTANCE;

    public static void init() {
        loadDefaults();
        generateFoldersAndFiles();
        readJson();
    }

    public static void loadDefaults() {
        INSTANCE = new ConfigInstance();
    }

    private static void generateFoldersAndFiles() {
        if (!folder.exists()) {
            folder.mkdir();
        }
        if (folder.isDirectory()) {
            configFile = new File(folder, CakeIsALie.MOD_ID + ".json");
            if (!configFile.exists()) {
                try {
                    configFile.createNewFile();
                    loadDefaults();
                    String json = config.toJson(INSTANCE);
                    FileWriter writer = new FileWriter(configFile);
                    writer.write(json);
                    writer.close();
                } catch (IOException e) {
                    throw new IllegalStateException("Can't create config file", e);
                }
            } else if (configFile.isDirectory()) {
                throw new IllegalStateException("'" + CakeIsALie.MOD_ID + ".json' must be a file!");
            } else {
            }
        } else {
            throw new IllegalStateException("'config' must be a folder!");
        }
    }

    public static void readJson() {
        try {
            INSTANCE = config.fromJson(new FileReader(configFile), ConfigInstance.class);
            if (INSTANCE == null) {
                throw new IllegalStateException("Null configuration");
            }
        } catch (JsonSyntaxException e) {
            System.err.println("Invalid configuration!");
            e.printStackTrace();
        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // No op
        }
    }
}
