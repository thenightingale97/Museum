package com.museum.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Showpiece.class)
public abstract class Showpiece_ extends IdentifiableEntity_ {

    public static volatile SingularAttribute<Showpiece, ShowpieceMaterial> material;
    public static volatile SingularAttribute<Showpiece, Author> author;
    public static volatile SingularAttribute<Showpiece, String> imageUrl;
    public static volatile SingularAttribute<Showpiece, String> name;
    public static volatile ListAttribute<Showpiece, Excursion> excursions;
    public static volatile SingularAttribute<Showpiece, ShowpieceTechnique> technique;
    public static volatile SingularAttribute<Showpiece, Hall> hall;
    public static volatile SingularAttribute<Showpiece, String> description;
    public static volatile SingularAttribute<Showpiece, LocalDate> creationDate;

}

