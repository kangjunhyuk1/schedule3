package com.example.schedulemanagement2.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "schedule")
@Getter
public class ScheduleEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;

    @Column(nullable = false)
    private String scheduleName;

    @Column(nullable = false)
    private String task;

    private String writerName;

    @ManyToOne
    @JoinColumn(name = "Id")
    private UserEntity userEntity;

    public ScheduleEntity() {

    }

    public ScheduleEntity(String scheduleName, String task, String writerName) {
        this.writerName = writerName;
        this.task = task;
        this.scheduleName = scheduleName;
    }



}

