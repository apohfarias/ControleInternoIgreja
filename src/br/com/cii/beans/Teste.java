package br.com.cii.beans;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {

	private static EntityManagerFactory entityManagerFactory;
	
	public static void main(String[] args) {
		
		entityManagerFactory = Persistence.createEntityManagerFactory("controleinternoigreja");
 
	}

}
