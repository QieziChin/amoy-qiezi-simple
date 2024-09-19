package com.amoy.common.utils;

import java.io.File;

public class IOUtils {
    public static void mkdirs(File folder){
        if (!folder.exists() || !folder.isDirectory()){
            if(!folder.mkdirs()){
                throw new RuntimeException("Failed to create folder!");
            }
        }
    }
}
