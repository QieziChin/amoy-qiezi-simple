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

    /**
     * 删除文件夹
     * @param folder
     */
    public static void delete(File folder){
        if (folder.isDirectory()){
            File[] files = folder.listFiles();
            if (files!= null){
                for (File file : files) {
                    if (file.isDirectory()){
                        IOUtils.delete(file);
                    } else {
                        file.delete();
                    }
                }
            }
        } else {
            folder.delete();
        }
    }
}
