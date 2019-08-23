package com.zzj.csdnranks.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${email.from}")
    private String from;

    @Value("${email.to}")
    private String[] to;

    @Value("${email.title}")
    private String title;

    public void send(Map<String,Integer> numsANDranks){
        String content =  "The nums is [" + numsANDranks.get("nums") +"],The ranks is [" + numsANDranks.get("ranks") +"]";
        send(content);
    }

    private void send(String content){
        defaultSend(this.from,this.to,this.title,content);
    }

    private void defaultSend(String from,String[] to,String title,String content){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(title);
        simpleMailMessage.setText(content);
        javaMailSender.send(simpleMailMessage);
    }
}
