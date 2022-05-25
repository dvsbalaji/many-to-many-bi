package com.ty.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Cab;
import com.ty.dto.Person;

public class TestSaveCabPerson {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		
		Cab cab1 = new Cab() ;
		cab1.setDriverName("sins");
		cab1.setCost(15);
		
		Cab cab2 = new Cab() ;
		cab2.setDriverName("dany");
		cab2.setCost(11);
		
		Cab cab3 = new Cab() ;
		cab3.setDriverName("jeff");
		cab3.setCost(13);
		
		List<Cab> cabs1 = new ArrayList<Cab>() ;
		cabs1.add(cab1) ;
		cabs1.add(cab2) ;
		cabs1.add(cab3) ;
		
		List<Cab> cabs2 = new ArrayList<Cab>() ;
		cabs2.add(cab1) ;
		cabs2.add(cab3) ;
		
		List<Cab> cabs3 = new ArrayList<Cab>() ;
		cabs3.add(cab2) ;
		cabs3.add(cab3) ;
		
		Person person =  new Person() ;
		person.setName("bunny");
		person.setEmail("bunny@mail.com");
		person.setAge(25);
		person.setCabs(cabs1);
		
		Person person1 =  new Person() ;
		person1.setName("nuthan");
		person1.setEmail("nuthan@mail.com");
		person1.setAge(32);
		person1.setCabs(cabs2);
		
		Person person2 =  new Person() ;
		person2.setName("chetan");
		person2.setEmail("chetan@mail.com");
		person2.setAge(30);
		person2.setCabs(cabs3);
		
//		List<Person> persons = new ArrayList<Person>() ;
//		persons.add(person) ;
//		persons.add(person1) ;
//		persons.add(person2) ;
		
		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(person1);
		entityManager.persist(person2);
		entityManager.persist(cab1);
		entityManager.persist(cab2);
		entityManager.persist(cab3);
		entityTransaction.commit();
		
		
		
	}
}
