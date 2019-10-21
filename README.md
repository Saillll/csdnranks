# csdnranks
CSDN Ranks Autotask

A crawler for CSDN blog,count the visiter number and the rank of the whole station.

一个CSDN博客的爬虫，用来统计访问量和排名。


Function List

1.pull the nums and ranks

2.save data to mysql

3.send email

功能列表

1.爬取访问量和排名

2.保存数据到mysql数据库

3.发送邮件

提示：如果放在云服务器上，需要关注服务器是否被CSDN加入到IP黑名单，回让你无法爬数据。

TIPS:If you run the jar on Aliyun ECS Server,Be careful,CSDN may put your server into the BlackList to Block your IP.


使用方法  
修改application.yml的  
数据库连接  
##### spring.datasource.url=  
##### spring.datasource.username=  
##### spring.datasource.password=  
发件人邮件地址  
##### spring.mail.host=  
##### spring.mail.port=  
##### spring.mail.username=  
##### spring.mail.password=  
收件人邮件地址  
##### email.from=sss@sss.cn  
##### email.to=xxx@xxx.com,aaa@aaa.com  
需要监测博客地址  
##### blog.address=https://blog.csdn.net/xxxxx  
