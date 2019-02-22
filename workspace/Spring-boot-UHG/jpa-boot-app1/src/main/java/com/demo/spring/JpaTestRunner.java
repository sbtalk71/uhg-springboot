package com.demo.spring;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.spring.entity.Emp;

//@Component
//@Transactional
public class JpaTestRunner implements CommandLineRunner {

	//@Autowired
	//EntityManagerFactory emf;
	//EntityManager em;
	
@PersistenceContext
EntityManager em;
	
	
	@Override
	public void run(String... args) throws Exception {
		//EntityManager em=emf.createEntityManager();
		Emp e=new Emp(108, "James", "Mimbai", 80000);
		//em.persist(e);
		
		Emp e1=em.find(Emp.class, 108);
		System.out.println(e1);
		
		
		Query query=em.createQuery("select e from Emp e");
		
		query.getResultList().stream().forEach(System.out::println);

	}

}
