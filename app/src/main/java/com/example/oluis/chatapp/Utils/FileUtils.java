package com.example.oluis.chatapp.Utils;

import android.content.Context;
import android.os.Environment;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Usuario on 01/09/2017.
 */

public class FileUtils {

    public static File createFile(Context context, String extension) throws IOException{
        String timeStamp =  new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = timeStamp + "_";
        File storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        return File.createTempFile(imageFileName, extension, storageDir);
    }

    public static byte[] readFromFile(File file) throws IOException{
        byte[] bytes = new byte[(int)file.length()];

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        DataInputStream dis = new DataInputStream(bis);
        dis.readFully(bytes);
        return bytes;
    }

    public static void writeToFile(File file, byte[] bytes)throws IOException{
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
        bos.write(bytes);
    }
}
