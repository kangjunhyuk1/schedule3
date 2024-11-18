package com.example.schedulemanagement2.dto;

import lombok.Getter;


@Getter
public class ScheduleRequestDto {
    private final  String scheduleName;
    private final  String writerName;
    private final  String task;

    public ScheduleRequestDto(String scheduleName, String writerName, String task) {
        this.scheduleName = scheduleName;
        this.writerName = writerName;
        this.task = task;
    }
}
