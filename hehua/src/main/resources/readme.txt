 org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'shiroFilter'
 defined in ServletContext resource [/WEB-INF/spring-shiro.xml]:
 BeanPostProcessor before instantiation of bean failed;
 nested exception is org.springframework.beans.factory.BeanCreationException:
 Error creating bean with name 'org.springframework.transaction.config.internalTransactionAdvisor':
 Cannot resolve reference to bean 'org.springframework.transaction.annotation.AnnotationTransactionAttributeSource#0'
  while setting bean property 'transactionAttributeSource';
  nested exception is org.springframework.beans.factory.BeanCreationException:
  Error creating bean with name 'org.springframework.transaction.annotation.AnnotationTransactionAttributeSource#0':
   BeanPostProcessor before instantiation of bean failed;
   nested exception is org.springframework.beans.factory.BeanCreationException:
   Error creating bean with name 'org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor#0'
    defined in ServletContext resource [/WEB-INF/spring-shiro.xml]:
    Cannot resolve reference to bean 'securityManager' while setting bean property 'securityManager';
    nested exception is org.springframework.beans.factory.BeanCreationException:
     Error creating bean with name 'securityManager'
     defined in ServletContext resource [/WEB-INF/spring-shiro.xml]:
     Cannot resolve reference to bean 'userRealm' while setting bean property 'realm';
     nested exception is org.springframework.beans.factory.BeanCreationException:
     Error creating bean with name 'userRealm' defined in ServletContext resource [/WEB-INF/spring-shiro.xml]:
     Cannot resolve reference to bean 'credentialsMatcher' while setting bean property 'credentialsMatcher';
     nested exception is org.springframework.beans.factory.BeanCreationException:
     Error creating bean with name 'credentialsMatcher' defined in ServletContext resource [/WEB-INF/spring-shiro.xml]:
      Cannot resolve reference to bean 'cacheManager' while setting constructor argument;
      nested exception is org.springframework.beans.factory.BeanCreationException:
      Error creating bean with name 'cacheManager' defined in ServletContext resource [/WEB-INF/spring-shiro.xml]:
      Initialization of bean failed; nested exception is org.springframework.beans.FatalBeanException:
       Error initializing bean [cacheManager]; nested exception is org.apache.shiro.cache.CacheException:
       net.sf.ehcache.CacheException: Error configuring from input stream. Initial cause was null:24:
       Element <cache> does not allow attribute "maxEntriesLocalHeap".
