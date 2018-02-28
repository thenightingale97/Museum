package com.museum.service.impl.util;

import com.museum.entity.IdentifiableEntity;
import com.museum.repository.Repository;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Validations {

    public static void period(LocalDateTime fromTime, LocalDateTime toTime) {
        Objects.requireNonNull(fromTime, "fromTime");
        Objects.requireNonNull(toTime, "toTime");
        if (fromTime.isAfter(toTime)) {
            throw new IllegalArgumentException(
                    "Parameter 'fromTime' can`t be greater than 'toTime'.");
        }
    }

    public static <E extends IdentifiableEntity<PK>, PK extends Serializable> void entity(Repository<E, PK> repository, E entity, String entityName) {
        Objects.requireNonNull(entity, entityName);
        if (!repository.exists(entity.getId())) {
            throw new IllegalArgumentException("'" + entityName + "' is not real entity.");
        }
    }
}
