package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraSaldoConta {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta contaDoLucas = em.find(Conta.class, 1L);
//		System.out.println("Conta do Lucas: " + contaDoLucas.getTitular());
		
		em.getTransaction().begin();
		contaDoLucas.setSaldo(20.0);
		em.getTransaction().commit();
	}
}
