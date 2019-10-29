package com.zzj.csdnranks.spider;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class PollService {

    @Value("${blog.address}")
    private String blogAddress;

    public Map<String,Integer> poll(){
        Map<String,Integer> numsANDranks = new HashMap<>(4);
        int nums = 0;
        int ranks = 0;
        try{
            System.out.println("The CSDN Address is " + blogAddress);
            Document document = Jsoup.connect(blogAddress).get();
            String title = document.title();
            System.out.println("The Blog Title is : " + title);
            if("".equals(title)){
                numsANDranks.put("nums",nums);
                numsANDranks.put("ranks",ranks);
                return numsANDranks;
            }
            Element asideProfile = document.getElementById("asideProfile");
            Elements numElements = asideProfile.getElementsByClass("data-info d-flex item-tiling");
            Elements num_dls = numElements.get(0).getElementsByTag("dl");
            Element numsElement = num_dls.get(4);
            Elements numsDDS = numsElement.getElementsByTag("dl");
            Element numsDl = numsDDS.get(0);
            String numsString = numsDl.attr("title");
            nums = Integer.valueOf(numsString);

            Elements fourElements = asideProfile.getElementsByClass("grade-box clearfix");
            Elements dls = fourElements.get(0).getElementsByTag("dl");
            Element ranksElement = dls.get(3);
            Elements ranksDDS = ranksElement.getElementsByTag("dl");
            Element ranksDl = ranksDDS.get(0);
            String ranksString = ranksDl.attr("title");
            ranks = Integer.valueOf(ranksString);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            numsANDranks.put("nums",nums);
            numsANDranks.put("ranks",ranks);
            return numsANDranks;
        }

    }
}
