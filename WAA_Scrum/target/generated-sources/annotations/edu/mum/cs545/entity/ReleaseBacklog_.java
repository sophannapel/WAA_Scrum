package edu.mum.cs545.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ReleaseBacklog.class)
public abstract class ReleaseBacklog_ {

	public static volatile SingularAttribute<ReleaseBacklog, Product> productId;
	public static volatile CollectionAttribute<ReleaseBacklog, UserStory> userStoryCollection;
	public static volatile SingularAttribute<ReleaseBacklog, Date> dueDate;
	public static volatile SingularAttribute<ReleaseBacklog, Employee> scrumMasterId;
	public static volatile SingularAttribute<ReleaseBacklog, String> name;
	public static volatile SingularAttribute<ReleaseBacklog, Integer> id;
	public static volatile SingularAttribute<ReleaseBacklog, String> descriptioon;
	public static volatile SingularAttribute<ReleaseBacklog, String> type;
	public static volatile CollectionAttribute<ReleaseBacklog, Sprint> sprintCollection;
	public static volatile SingularAttribute<ReleaseBacklog, Date> startDate;

}

