package com.example.schedulemanagement2.dto;

import com.example.schedulemanagement2.entity.ScheduleEntity;
import lombok.Getter;


import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {

    private final Long scheduleId;
    private  final String scheduleName;
    private  final String task;
    private final String writerName;
    private  final LocalDateTime createdAt;
    private  final LocalDateTime modifiedAt;

    public ScheduleResponseDto(Long scheduleId, String writerName, String task, String scheduleName, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.scheduleId = scheduleId;
        this.writerName = writerName;
        this.task = task;
        this.scheduleName = scheduleName;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public static ScheduleResponseDto toDto(ScheduleEntity scheduleEntity) {
        return new ScheduleResponseDto(
                scheduleEntity.getScheduleId(),
                scheduleEntity.getWriterName(),
                scheduleEntity.getTask(),
                scheduleEntity.getScheduleName(),
                scheduleEntity.getCreatedAt(),
                scheduleEntity.getModifiedAt()
        );
    }
}
