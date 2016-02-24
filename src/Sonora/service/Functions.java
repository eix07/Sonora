package Sonora.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import javax.persistence.Query;

import Sonora.entity.Canciones;

public class Functions {
	
	public static void main(String[] args){
		EntityManagerFactory emfactory=Persistence.createEntityManagerFactory("Sonora");
		EntityManager entitymanager=emfactory.createEntityManager();
		
		//Scalar funtcion
	
		Query query1 =entitymanager.createQuery("SELECT e FROM Canciones e");
		List<Canciones>list1=query1.getResultList();
				
		for(Canciones e:list1){
			System.out.println("Nombre de la cancion: "+e);
		}

		
	}

}
