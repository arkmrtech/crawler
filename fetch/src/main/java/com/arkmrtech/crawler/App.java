package com.arkmrtech.crawler;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import junit.framework.Assert;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.net.URL;


/**
 * Hello world!
 *
 */
public class App 
{
//    public static void main( String[] args ){
//        System.out.println( "Hello World!" );
//    }

    @Test
    public void testCrawler() throws Exception {
        String url = "http://hotel.qunar.com/city/guangzhou/dt-3972/comments.html#fromDate=2015-04-09&toDate=2015-04-10&q=7%E5%A4%A9%E8%BF%9E%E9%94%81&from=qunarHotel|sug&fromFocusList=0&filterid=8a5192a3-2bcc-4642-8950-2a24780a709c_A&showMap=0&qptype=brand|group&QHFP=ZSS_A3CDE245";
//        String refer="http://www.cnblogs.com/";
        URL link=new URL(url);
        WebClient wc = new WebClient();
        WebRequest request=new WebRequest(link);
        request.setCharset("UTF-8");
//        request.setProxyHost("120.120.120.x");
//        request.setProxyPort(8080);
//        request.setAdditionalHeader("Referer", refer);//设置请求报文头里的refer字段
//        request.setAdditionalHeader("Referer", refer);
        ////设置请求报文头里的User-Agent字段
        request.setAdditionalHeader("User-Agent", "Mozilla/5.0 (Windows NT 5.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");

//        wc.addRequestHeader();//与request.setAdditionalHeader效果一样
        wc.getOptions().setJavaScriptEnabled(true); //启用JS解释器，默认为true
        wc.getOptions().setCssEnabled(false); //禁用css支持
        wc.getOptions().setThrowExceptionOnScriptError(true); //js运行错误时，是否抛出异常
        wc.getOptions().setTimeout(10000); //设置连接超时时间 ，这里是10S。如果为0，则无限期等待
        HtmlPage page = wc.getPage(request);
        Thread.sleep(10 * 1000);
        String pageXml = page.asXml(); //以xml的形式获取响应文本
        System.out.println(pageXml);
        /**jsoup解析文档*/
//        Document doc = Jsoup.parse(pageXml, "http://cq.qq.com");
//        Element pv = doc.select("#feed_content span").get(1);
//        System.out.println(pv.text());
//        Assert.assertTrue(pv.text().contains("浏览"));

        System.out.println("Thank God!");

    }


}
