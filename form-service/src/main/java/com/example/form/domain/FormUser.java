package com.example.form.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_forms_users")
public class FormUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne()
    @JoinColumn(name = "form_id")
    private Form form;

    private Long userId;

    private int status;

    private Date updateTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public enum Status {
        DELETED(0), NORMAL(1);

        private int value;

        Status(int value) {
            this.value = value;
        }

        public static Status parse(int id) {
            Status status = null; // Default
            for (Status item : Status.values()) {
                if (item.getValue() == id) {
                    status = item;
                    break;
                }
            }
            return status;
        }

        public int getValue() {
            return value;
        }

    }
}
