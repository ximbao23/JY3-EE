package com.neuedu.util;

import java.util.Random;

public class ProId {
    public static String getProId()
    {
        Random random = new Random();
        int i = random.nextInt(100);
        String str=String.valueOf(System.currentTimeMillis());
        if(i<10)
        {
            str+="0"+i;
        }
        return str+=i;

    }
}
