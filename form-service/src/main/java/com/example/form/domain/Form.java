package com.example.form.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_forms")
@JsonIgnoreProperties({"formUsers"})
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "form", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Where(clause = "status = 1")
    private List<FormUser> formUsers = Lists.newArrayList();

    @NotNull
    @ApiModelProperty(notes = "表单名称", required = true)
    private String formName;

    @NotNull
    private String formIdentity;

    private String remark;

    private String source;

    private String diseaseName;

    @NotNull
    @URL
    @ApiModelProperty(notes = "表单URL")
    private String formUrl;

    private Integer parentSpeciality;

    private Integer childSpeciality;

    private int status;

    private Date updateTime;

    private int createType;

    @Transient
    private int formUsersCount;


    public List<FormUser> getFormUsers() {
        return formUsers;
    }

    public void setFormUsers(List<FormUser> formUsers) {
        this.formUsers = formUsers;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getFormIdentity() {
        return formIdentity;
    }

    public void setFormIdentity(String formIdentity) {
        this.formIdentity = formIdentity;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getFormUrl() {
        return formUrl;
    }

    public void setFormUrl(String formUrl) {
        this.formUrl = formUrl;
    }


    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getParentSpeciality() {
        return parentSpeciality;
    }

    public void setParentSpeciality(Integer parentSpeciality) {
        this.parentSpeciality = parentSpeciality;
    }

    public Integer getChildSpeciality() {
        return childSpeciality;
    }

    public void setChildSpeciality(Integer childSpeciality) {
        this.childSpeciality = childSpeciality;
    }

    public int getCreateType() {
        return createType;
    }

    public void setCreateType(int createType) {
        this.createType = createType;
    }

    @Override
    public String toString() {
        return "Form{" +
                "id=" + id +
                ", formName='" + formName + '\'' +
                ", formIdentity='" + formIdentity + '\'' +
                ", remark='" + remark + '\'' +
                ", source='" + source + '\'' +
                ", parentSpeciality='" + parentSpeciality + '\'' +
                ", childSpeciality='" + childSpeciality + '\'' +
                ", diseaseName='" + diseaseName + '\'' +
                ", formUrl='" + formUrl + '\'' +
                ", status=" + status +
                ", updateTime=" + updateTime +
                '}';
    }

    public int getFormUsersCount() {
        if (formUsers != null) {
            formUsersCount = formUsers.size();
        }
        return formUsersCount;
    }

    public void setFormUsersCount(int formUsersCount) {
        this.formUsersCount = formUsersCount;
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
