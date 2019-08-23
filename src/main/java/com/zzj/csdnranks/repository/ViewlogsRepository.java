package com.zzj.csdnranks.repository;

import com.zzj.csdnranks.entity.Viewlogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewlogsRepository extends JpaRepository<Viewlogs,Integer> {
}
