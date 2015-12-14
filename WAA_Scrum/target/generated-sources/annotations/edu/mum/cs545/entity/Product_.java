package edu.mum.cs545.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class Product_ {

	public static volatile CollectionAttribute<Product, ReleaseBacklog> releaseBacklogCollection;
	public static volatile SingularAttribute<Product, Status> statusId;
	public static volatile CollectionAttribute<Product, UserStory> userStoryCollection;
	public static volatile SingularAttribute<Product, Date> dueDate;
	public static volatile SingularAttribute<Product, String> name;
	public static volatile SingularAttribute<Product, String> description;
	public static volatile SingularAttribute<Product, Employee> employeeId;
	public static volatile SingularAttribute<Product, Integer> id;
	public static volatile SingularAttribute<Product, Date> startDate;

}

