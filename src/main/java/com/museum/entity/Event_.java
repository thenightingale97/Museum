package com.museum.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Event.class)
public abstract class Event_ extends com.museum.entity.IdentifiableEntity_ {

    public static volatile ListAttribute<Event, Visitor> visitors;
    public static volatile SingularAttribute<Event, LocalDateTime> finishTime;
    public static volatile SingularAttribute<Event, LocalDateTime> startTime;
    public static volatile SingularAttribute<Event, Excursion> excursion;
    public static volatile SingularAttribute<Event, Guide> guide;

}

