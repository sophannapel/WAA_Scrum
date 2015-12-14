package edu.mum.cs545.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Employee.class)
public abstract class Employee_ {

	public static volatile SingularAttribute<Employee, String> firstname;
	public static volatile SingularAttribute<Employee, String> password;
	public static volatile CollectionAttribute<Employee, ReleaseBacklog> releaseBacklogCollection;
	public static volatile CollectionAttribute<Employee, Product> productCollection;
	public static volatile CollectionAttribute<Employee, UserStory> userStoryCollection2;
	public static volatile SingularAttribute<Employee, Role> roleId;
	public static volatile CollectionAttribute<Employee, UserStory> userStoryCollection;
	public static volatile CollectionAttribute<Employee, UserStory> userStoryCollection1;
	public static volatile SingularAttribute<Employee, Integer> id;
	public static volatile SingularAttribute<Employee, String> lastname;
	public static volatile SingularAttribute<Employee, String> username;
	public static volatile SingularAttribute<Employee, String> status;

}

