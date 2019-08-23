package com.zzj.csdnranks.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "viewlogs")
public class Viewlogs implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private int nums;

    private int ranks;

    @CreatedDate
    @Column(name = "createdate")
    //在mysql的url中设置时区
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdate;
}
