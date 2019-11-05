# spring-boot-postgres-db
Spring Boot Rest Project with Postgres Database

# Using Embedded Server as Tomcat.

#For Enabling JPA Audit. Please follow below steps.

In this article, we will discuss how can we configure JPA to automatically persist the CreatedBy, CreatedDate, LastModifiedBy, and LastModifiedDate columns for any entity. 

Create Generic Auditable Class with Spring Data Annotations @CreatedBy, @CreatedDate, @LastModifiedBy, and @LastModifiedDate.
Add below entries on top of Audit class.
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)

Spring Data JPA provides a JPA entity listener class, AuditingEntityListener, which contains the callback methods (annotated with the @PrePersist and @PreUpdate annotations), which will be used to persist and update these properties when we will persist or update our entity.
JPA provides the @EntityListeners annotation to specify callback listener classes, which we use to register our AuditingEntityListener class.

JPA can analyze createdDate and lastModifiedDate using current system time, but what about the createdBy and lastModifiedBy fields? How will JPA recognize what to store in them?
To tell JPA about currently logged-in users, we will need to provide an implementation of AuditorAware and override the getCurrentAuditor() method. And inside getCurrentAuditor(), we will need to fetch a currently logged-in user.
As of now, I have provided a hard-coded user, but if you are using Spring Security, then use it to find the currently logged-in user.

Now, we want to enable JPA auditing by specifying @EnableJpaAuditing on one of our configuration classes, in this example, I have specified @EnableJpaAuditing on main Springboot2JpaAuditingApplication class. @EnableJpaAuditing accepts one argument, auditorAwareRef, where we need to pass the name of the AuditorAware bean.
