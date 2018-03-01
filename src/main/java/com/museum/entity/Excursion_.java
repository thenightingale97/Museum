package com.museum.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.time.Duration;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Excursion.class)
public abstract class Excursion_ extends com.museum.entity.IdentifiableEntity_ {

    public static volatile SingularAttribute<Excursion, Duration> duration;
    public static volatile SingularAttribute<Excursion, String> imageUrl;
    public static volatile SingularAttribute<Excursion, String> name;
    public static volatile SingularAttribute<Excursion, String> description;
    public static volatile ListAttribute<Excursion, Showpiece> showpieces;
    public static volatile ListAttribute<Excursion, Event> events;
    public static volatile SingularAttribute<Excursion, Integer> maxVisitorAmount;

}

