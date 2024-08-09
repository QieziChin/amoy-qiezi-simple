package com.amoy.service.simple.utils;

import com.alibaba.nacos.shaded.com.google.gson.JsonObject;

import com.amoy.common.entity.Draw;
import com.amoy.service.simple.mapper.DrawMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class CollectUtils {

    private final static String agent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_0) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.56 Safari/535.11";


    public static void removeByClass(Element box, String classList){
        String[] items = classList.split(",");
        for (String item: items) {
            if (box.getElementsByClass(item).size() > 0){
                box.getElementsByClass(item).remove();
            }
        }
    }

    public static void removeByTag(Element box, String tags){
        String[] tagList = tags.split(",");
        for (String tag: tagList) {
            if (box.getElementsByTag(tag).size() > 0){
                box.getElementsByTag(tag).remove();
            }
        }
    }

    public static void removeById(Element box, String ids){
        //不为空删除， null判断防止Jsoup抛出异常
        String[] idList = ids.split(",");
        for (String id: idList) {
            if (null != box.getElementById(id)){
                box.getElementById(id).remove();
            }
        }
    }

    public static void bietnamDraw(DrawMapper drawMapper, List<Draw> list){
        String host = "https://xosothantai.mobi/";

        Random sead = new Random();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Draw draw: list){
            try{
                /**
                 *  Jsoup.connect("http://csdn.com")
                 *   .data("query", "Java")
                 *   .userAgent("Mozilla")
                 *   .cookie("auth", "token")
                 *   .timeout(8000)
                 *   .post();
                 */
                String news ="";
                String regex = "href\\s*=\\s*\"(.*?)\"";
                Document doc = Jsoup.connect(host + draw.getUrl()).userAgent(agent).get();
                Element body = doc.body();
                Element content = body.getElementsByClass("col-l").first();
                if (Integer.parseInt(draw.getStyle())< 4){
                    CollectUtils.removeByTag(content,"iframe");
                }

                if (draw.getStyle().equals("1")){
                    Elements boxs = content.getElementsByClass("box");
                    boxs.first().getElementsByTag("a").removeAttr("href");
                    boxs.first().getElementsByTag("a").removeAttr("href");

                    news = boxs.first().outerHtml()+boxs.next().outerHtml();

                } else if(draw.getStyle().equals("2")) {
                    Element box = content.getElementById("article-list");
                    box.getElementsByTag("a").removeAttr("href");

                    news = box.outerHtml();
                } else if (draw.getStyle().equals("3")){
                    Elements boxs = content.getElementsByClass("box info-city");
                    boxs.first().getElementsByTag("a").removeAttr("href");
                    news = boxs.first().outerHtml();
                } else if (draw.getStyle().equals("4")){
                    Element box = content.getElementById("result-book");
                    box.getElementsByTag("a").removeAttr("href");
                    box.getElementById("result-see-more").remove();
                    box.addClass("ml-vulva");
                    news = box.outerHtml();
                } else if (draw.getStyle().equals("5")) {
                    Elements boxs = content.getElementsByClass("box cate-news");
                    boxs.first().addClass("ml-vulva");
                    boxs.first().getElementsByTag("a").removeAttr("href");

                    if (draw.getId().equals(68)){
                        Elements imgs = boxs.first().getElementsByTag("img");

                        for (Element img: imgs){
                            img.attr("src", img.attr("data-src"));
                            img.attr("data-src", "");
                        }
                    }

                    news = boxs.first().outerHtml();
                } else if (draw.getStyle().equals("6")) {
                    Elements boxs = content.getElementsByClass("box");

                    CollectUtils.removeById(boxs.first(),"statistic-form");
                    boxs.first().getElementsByTag("a").removeAttr("href");
                    news = boxs.outerHtml();
                } else if (draw.getStyle().equals("61")) {
                    Element box = content.getElementById("loto-cam");
                    CollectUtils.removeById(box,"statistic-form");
                    CollectUtils.removeByTag(box,"button");
                    //nav-tabs
                    CollectUtils.removeByClass(box, "tab-panel,filter-by-number,see-more");
                    box.getElementsByTag("a").removeAttr("href");
                    news = box.outerHtml();
                    news += "\n<script src=\"/assets/js/jquery.3.4.1.min.js?v=1720298150\"></script>\n";
                    news += "<script src=\"/assets/js/qiezi.min.js?v=1720298150\"></script>\n";
                } else if (draw.getStyle().equals("7")) {
                    Element box = content.getElementById("result-book");
                    box.getElementsByTag("a").removeAttr("href");
                    CollectUtils.removeById(box,"statistic-form");
                    box.addClass("ml-vulva");

                    Element subContent = content.getElementById("result-box-content");
                    subContent.getElementsByTag("a").removeAttr("href");
                    CollectUtils.removeById(subContent, "result-see-more");

                    news = box.outerHtml()+ subContent.outerHtml();
                } else if (draw.getStyle().equals("8")) {
                    Element box = content;
                    box.getElementsByTag("a").removeAttr("href");
                    CollectUtils.removeById(box, "statistic-form,result-more");
                    CollectUtils.removeByTag(box, "script");
                    CollectUtils.removeByClass(box, "link-du-doan,tab-panel,see-more,form-horizontal");

                    if (draw.getId().equals(90)){
                        box.getElementsByClass("box box-html")
                                .first()
                                .getElementsByTag("p")
                                .last()
                                .remove();
                        box.getElementsByClass("list-dot-red")
                                .first()
                                .remove();

                        String title = "<h2 class=\"tit-mien bold qie-mei\" id=\"ketquangay\">Kết quả cụ thể hàng ngày</h2>";
                        box.getElementsByClass("box pad5").first().prepend(title);
                    } else if (draw.getId().equals(102)){
                        CollectUtils.removeById(box, "result-book");
                        box.getElementsByClass("box box-html")
                                .first()
                                .getElementsByTag("p")
                                .last()
                                .remove();
                    }

                    box.addClass("ml-vulva");
                    news = box.html();
                }

                news= news.replaceAll(regex, "");
                draw.setContent(news);

                draw.setUpdateTime(LocalDateTime.now());
                drawMapper.update(draw);

                //线程随机休眠时间模拟人的行为
                System.out.println(format.format(new Date())+"     ID:"+draw.getId()+", URL:" + draw.getUrl());
                Thread.sleep(50000 + sead.nextInt(30));

            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String getContent(String url){
        String content ="";
        try{
            Document doc = Jsoup.connect(url).userAgent(agent).get();
            Element body = doc.body();

            if (url.contains("24h.com.vn")){
                Element article = body.getElementById("article_body");
                if (article.getElementsByTag("script").size() > 0){
                    article.getElementsByTag("script").remove();
                }
                content = article.getElementsByTag("article").outerHtml();
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return content;
        }
    }

    //必须要找到有标题的文章
    public static Element getItem(Elements items, Random sead){
        Element item = items.get(sead.nextInt(items.size()));

        if (item.select("a").text().isEmpty()){
            return CollectUtils.getItem(items, sead);
        } else {
            return item;
        }
    }

    public static String routerCall(String host){
        JsonObject article = new JsonObject();

        Random sead = new Random();
        try{
            if (host.contains("24h.com.vn")){
                Document doc = Jsoup.connect(host).userAgent(agent).get();
                Element body = doc.body();

                CollectUtils.removeById(body, "headerd");
                CollectUtils.removeByTag(body,"iframe,ul,nav,footer,script,style,svg");
                CollectUtils.removeByClass(body,"row-addon-24h");

                Elements list1 = body.getElementsByTag("article");
                Element item = CollectUtils.getItem(list1, sead);

                String img = "";
                String abstracts = "";

                String title;
                if (item.getElementsByTag("img").size() > 0){
                    img = item.getElementsByTag("img").first().attr("data-original");
                    title = item.select("a").text();
                } else {
                    title = item.getElementsByTag("a").text();
                }

                if (item.getElementsByTag("p").size() > 0){
                    abstracts = item.getElementsByTag("p").first().text();
                }
                String link = item.getElementsByTag("a").first().attr("href");

                article.addProperty("title", title);
                article.addProperty("abstract", abstracts);
                article.addProperty("link", link);
                article.addProperty("img", img);
            } else {
                Document doc = Jsoup.connect(host).userAgent(agent).get();
                Element body = doc.body();
                Element list = body.getElementById("__next");

                Elements boxs = list.getElementsByClass("bm-card");
                Element box = CollectUtils.getItem(boxs, sead);


                Element imgBox = box.getElementsByTag("img").first();
                if (null != imgBox){
                    article.addProperty("title", imgBox.attr("data-original"));
                }

                Element titleBox = box.getElementsByTag("h3").first();
                if (null != titleBox){
                    article.addProperty("title", titleBox.text());
                }

                article.addProperty("HTML", box.html());
            }

        } catch(Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(article.toString());
            return article.toString();
        }
    }
}
