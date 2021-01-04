package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Cliente;
import br.com.alura.jpa.modelo.Conta;

public class TestaClienteConta {

	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setAgencia(12345);
		conta.setNumero(54321);
		conta.setSaldo(500.0);
		conta.setTitular("Robson");
		
		Cliente cliente = new Cliente();
		cliente.setNome("Robson");
		cliente.setEndereco("Rua sei la, 123");
		cliente.setProfissao("Professor");
		cliente.setConta(conta);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(cliente);
		em.persist(conta);
		
		em.getTransaction().commit();
		
		em.close();
	}
}
