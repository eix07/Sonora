package Sonora.service;

import java.util.HashSet;
import java.util.Set;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Sonora.entity.Artista;
import Sonora.entity.Canciones;

public class DAOManyToMany {

	public static void main(String[] arg){
		EntityManagerFactory managerfactory= Persistence.createEntityManagerFactory("Sonora");
		EntityManager entitymanager=managerfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
		//Creando Canciones
		Canciones c1= new Canciones(0,"Dangerous",10,5,null);
		Canciones c2= new Canciones(0,"Lovers on the sun",11,6,null);
		Canciones c3= new Canciones(0,"Ten more days",9,5,null);
		Canciones c4= new Canciones(0,"When i was your man",6,2,null);
		
		//Store Canciones
		
		entitymanager.persist(c1);
		entitymanager.persist(c2);
		entitymanager.persist(c3);
		entitymanager.persist(c4);
		
		// Creando caciones set1
		Set<Canciones> classSet1= new HashSet();
		classSet1.add(c1);
		classSet1.add(c2);
		
		
		// Creando caciones set2
		Set<Canciones> classSet2= new HashSet();
		classSet2.add(c3);
		
		
		// Creando caciones set3
		Set<Canciones> classSet3= new HashSet();
		classSet3.add(c4);
				
		
		//Creando Artista
		Artista art1=new Artista(0,"David Guetta","Electronica",classSet1);
		Artista art2=new Artista(0,"Avicii","Electronica",classSet2);
		Artista art3=new Artista(0,"Bruno Mars","Pop",classSet3);
		
		// Store Artista
		entitymanager.persist(art1);
		entitymanager.persist(art2);
		entitymanager.persist(art3);
		
		entitymanager.getTransaction().commit();
		entitymanager.close();
		managerfactory.close();
		
	}
}
