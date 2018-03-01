package com.museum.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Guide.class)
public abstract class Guide_ extends com.museum.entity.IdentifiableEntity_ {

    public static volatile SingularAttribute<Guide, String> firstName;
    public static volatile SingularAttribute<Guide, String> lastName;
    public static volatile SingularAttribute<Guide, String> phoneNumber;
    public static volatile SingularAttribute<Guide, GuidePosition> position;
    public static volatile ListAttribute<Guide, Event> events;

}

