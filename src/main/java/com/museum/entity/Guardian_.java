package com.museum.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Guardian.class)
public abstract class Guardian_ extends com.museum.entity.IdentifiableEntity_ {

    public static volatile SingularAttribute<Guardian, String> firstName;
    public static volatile SingularAttribute<Guardian, String> lastName;
    public static volatile ListAttribute<Guardian, Hall> halls;

}

