package com.gmail.shaahi2010.dangodoong.bot.model.base;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class TimeStampableEntity<ID> extends BaseEntity<ID> {

    @CreatedDate
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    @PrePersist
    public void prePersist() {
        createdDate = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        modifiedDate = new Date();
    }
}
