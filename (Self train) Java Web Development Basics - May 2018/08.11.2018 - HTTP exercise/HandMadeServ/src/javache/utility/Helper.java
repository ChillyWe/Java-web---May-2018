package javache.utility;

import java.io.File;

public class Helper {

    private Helper() {}

    public static String getExtension(File file) {
        String fileName = file.getName();

        int index = fileName.lastIndexOf(".");
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}