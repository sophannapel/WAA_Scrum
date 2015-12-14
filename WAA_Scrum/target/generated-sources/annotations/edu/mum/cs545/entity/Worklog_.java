package edu.mum.cs545.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Worklog.class)
public abstract class Worklog_ {

	public static volatile SingularAttribute<Worklog, Integer> actualEffort;
	public static volatile SingularAttribute<Worklog, UserStory> userStoryId;
	public static volatile SingularAttribute<Worklog, UserStoryWorklog> userStoryWorklog;
	public static volatile SingularAttribute<Worklog, Date> modifiedDate;
	public static volatile SingularAttribute<Worklog, String> effortType;
	public static volatile SingularAttribute<Worklog, Integer> id;

}

