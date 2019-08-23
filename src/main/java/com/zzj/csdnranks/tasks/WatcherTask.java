package com.zzj.csdnranks.tasks;

import com.zzj.csdnranks.services.WatcherService;
import com.zzj.csdnranks.spider.PollService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import java.util.Map;

public class WatcherTask extends QuartzJobBean {

    @Autowired
    private WatcherService watcherService;

    @Autowired
    private PollService pollService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Map<String,Integer> numsANDranks = pollService.poll();
        watcherService.insert(numsANDranks);
        System.out.println("Done");
    }
}
