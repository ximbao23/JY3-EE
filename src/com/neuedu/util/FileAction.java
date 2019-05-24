package com.neuedu.util;

import javax.servlet.http.Part;
import java.io.*;
import java.util.UUID;

public class FileAction {
    public static String uploadFile(Part part)
    {
        String getSubmittedfilename=part.getSubmittedFileName();
        InputStream inputStream=null;
        //创建UUID
        UUID uuid=UUID.randomUUID();
        OutputStream outputStream= null;
        String name=uuid+getSubmittedfilename;
        try {
            inputStream=part.getInputStream();
            outputStream = new FileOutputStream("F:\\img\\"+name);
            int buffer=0;
            byte[] bs=new byte[1024];
            while((buffer=inputStream.read(bs))!=-1)
            {
                outputStream.write(bs,0,buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return name;
    }
}
