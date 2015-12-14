package edu.mum.cs545.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserStory.class)
public abstract class UserStory_ {

	public static volatile SingularAttribute<UserStory, Product> productId;
	public static volatile SingularAttribute<UserStory, Integer> estimateTestEffort;
	public static volatile SingularAttribute<UserStory, Date> dueDate;
	public static volatile CollectionAttribute<UserStory, Worklog> worklogCollection;
	public static volatile SingularAttribute<UserStory, String> description;
	public static volatile SingularAttribute<UserStory, Integer> estimateDevEffort;
	public static volatile SingularAttribute<UserStory, String> priority;
	public static volatile SingularAttribute<UserStory, Employee> ownerId;
	public static volatile SingularAttribute<UserStory, Sprint> sprintId;
	public static volatile SingularAttribute<UserStory, Employee> developerId;
	public static volatile SingularAttribute<UserStory, ReleaseBacklog> releaseId;
	public static volatile SingularAttribute<UserStory, String> name;
	public static volatile CollectionAttribute<UserStory, UserStoryWorklog> userStoryWorklogCollection;
	public static volatile SingularAttribute<UserStory, Employee> testId;
	public static volatile SingularAttribute<UserStory, Integer> id;
	public static volatile SingularAttribute<UserStory, Date> startDate;

}

