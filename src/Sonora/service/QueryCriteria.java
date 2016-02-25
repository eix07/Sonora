package Sonora.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import Sonora.entity.Canciones;

public class QueryCriteria {
	
	public static void main(String[] args){
		
		EntityManagerFactory emfactory=Persistence.createEntityManagerFactory("Sonora");
		EntityManager entitymanager=emfactory.createEntityManager();
		CriteriaBuilder criteriaBuilder=entitymanager.getCriteriaBuilder();
		CriteriaQuery<Object>criteriaquery=criteriaBuilder.createQuery();
		Root<Canciones>from=criteriaquery.from(Canciones.class);
		
		//Select all records
		
		System.out.println("Select all");
		CriteriaQuery<Object>select=criteriaquery.select(from);
		TypedQuery<Object>typedquery=entitymanager.createQuery(select);
		List<Object>resultlist=typedquery.getResultList();
		
		for (Object o : resultlist) {
			Canciones song=(Canciones)o;
			System.out.println(song.toString());
		}
		
		
	}

}
