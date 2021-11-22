package com.example.myapp.Entity;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * @author jiangtao
 */
@Entity
@Table(name="todoEvent")

public class ToDoEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "eventName",nullable = false)
    @NotEmpty
    private String eventName;

    /** status 为0 表示 未完成  1 表示完成
     */
    @Column(name = "status")
    @Max(value = 1)
    @NotNull
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ToDoEvent{" +
                "eventName='" + eventName + '\'' +
                ", status=" + status +
                '}';
    }
}
