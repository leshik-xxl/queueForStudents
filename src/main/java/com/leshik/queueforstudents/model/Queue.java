package com.leshik.queueforstudents.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "queue_table")
public class Queue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entry_time")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date entryTime = Calendar.getInstance().getTime();
}
