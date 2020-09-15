package com.gmail.shaahi2010.dangodoong.bot.model.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.domain.Persistable;
@EqualsAndHashCode(of = "id")
@Data
public abstract class BaseEntity<ID> implements Persistable<ID> {

    public abstract ID getId() ;

    @Override
    public boolean isNew() {
        return getId()==null;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "{" +
                "id=" + getId() +
                '}';
    }
}
