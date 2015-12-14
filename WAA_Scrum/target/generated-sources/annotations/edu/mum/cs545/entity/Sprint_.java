package edu.mum.cs545.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Sprint.class)
public abstract class Sprint_ {

	public static volatile SingularAttribute<Sprint, ReleaseBacklog> releaseId;
	public static volatile CollectionAttribute<Sprint, UserStory> userStoryCollection;
	public static volatile SingularAttribute<Sprint, Date> dueDate;
	public static volatile SingularAttribute<Sprint, String> name;
	public static volatile SingularAttribute<Sprint, Integer> id;
	public static volatile SingularAttribute<Sprint, Date> startDate;

}

