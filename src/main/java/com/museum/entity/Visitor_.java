package com.museum.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Visitor.class)
public abstract class Visitor_ extends IdentifiableEntity_ {

    public static volatile SingularAttribute<Visitor, String> firstName;
    public static volatile SingularAttribute<Visitor, String> lastName;
    public static volatile SingularAttribute<Visitor, String> password;
    public static volatile SingularAttribute<Visitor, VisitorRole> accessLevel;
    public static volatile SingularAttribute<Visitor, String> login;
    public static volatile ListAttribute<Visitor, Event> events;

}

