package com.zzj.csdnranks.services;

import com.zzj.csdnranks.entity.Viewlogs;
import com.zzj.csdnranks.repository.ViewlogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("watcherService")
public class WatcherService {

    @Autowired
    private ViewlogsRepository viewlogsRepository;

    public void insert(Viewlogs viewlogs){
        viewlogsRepository.save(viewlogs);
    }

    public List<Viewlogs> find(){
        return viewlogsRepository.findAll();
    }

    public void insert(Map<String,Integer> numsANDranks){
        Viewlogs viewlogs = new Viewlogs();
        viewlogs.setNums(numsANDranks.get("nums"));
        viewlogs.setRanks(numsANDranks.get("ranks"));
        viewlogsRepository.save(viewlogs);
    }
}
