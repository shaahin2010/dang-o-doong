package com.gmail.shaahi2010.dangodoong.bot.model;

import com.gmail.shaahi2010.dangodoong.bot.model.base.BaseEntity;
import com.gmail.shaahi2010.dangodoong.bot.model.base.TimeStampableEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
@Table(name = "tguser")
public class User extends TimeStampableEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;

    private String firstName;

    private String lastName;

    @Column(name = "email")
    private String emailAddress;

    private String cellPhone;

}
