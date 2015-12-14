package edu.mum.cs545.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Status.class)
public abstract class Status_ {

	public static volatile CollectionAttribute<Status, Product> productCollection;
	public static volatile SingularAttribute<Status, String> name;
	public static volatile SingularAttribute<Status, String> description;
	public static volatile SingularAttribute<Status, Integer> id;

}

