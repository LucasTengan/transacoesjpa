package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;


public class TestandoEstados {

	public static void main(String[] args) {
		// Estados: managed, detached, transient, removed
		// Transient - possível candidato para ser managed no futuro
		Conta conta = new Conta();
		conta.setTitular("Almiro");
		conta.setAgencia(123);
		conta.setNumero(321);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		// Tudo precisa estar dentro de uma transação
		em.getTransaction().begin();
		
		// Transforma transient em managed
		em.persist(conta);
		
		// Managed -> Removed
		em.remove(conta);
		
		em.getTransaction().commit();
	}
}
