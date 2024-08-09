package com.amoy.common.utils;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONArray;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Iterator;

public class BulletUtil {


    public static Element recursion(Element child){
        Iterator<Element> iterator = child.children().iterator();


        while (iterator.hasNext()){
            Element el = iterator.next();


            System.out.println(el.html());
        }

        return child;
    }

    public static String getBulletById(String id){

        try {
            Document doc = Jsoup.connect("http://ccav.com/danmu.php").get();

            JSONObject obj = new JSONObject();
            obj.put("code", 0);
            JSONArray array = new JSONArray();


            Iterator<Element> iterator = doc.getElementsByTag("d").iterator();

            while (iterator.hasNext()){
                Element el = iterator.next();
                String[] list = el.attr("p").split(",");
                JSONArray item = new JSONArray();
                int type = 0;
                if (list[1].equals("4")){
                    type = 2;
                } else if (list[1].equals("5")){
                    type = 1;
                }
                item.add(Float.parseFloat(list[0]));
                item.add(type);
                item.add(Integer.parseInt(list[3]));
                item.add(list[6]);
                item.add(el.text());

                array.add(item.toString());
            }

            obj.put("data", array.toString());

            return obj.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }



        return "";
    }
}
