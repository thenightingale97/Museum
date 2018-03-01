package com.museum.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Hall.class)
public abstract class Hall_ extends com.museum.entity.IdentifiableEntity_ {

    public static volatile SingularAttribute<Hall, String> name;
    public static volatile ListAttribute<Hall, Showpiece> showpieces;
    public static volatile SingularAttribute<Hall, Guardian> guardian;

}

