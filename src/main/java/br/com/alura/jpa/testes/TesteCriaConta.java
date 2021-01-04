package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TesteCriaConta {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();

		conta.setTitular("Ricardo");
		conta.setNumero(12345);
		conta.setAgencia(54321);
		conta.setSaldo(100.0);

		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		em.close(); // A partir do momento que fecha, nenhuma conta é managed, passa a ser tudo
					// deteched: não há sincronização automática, possui registro no banco mas não está sincronizada

		EntityManager em2 = emf.createEntityManager();
		conta.setSaldo(500.0);
		em2.getTransaction().begin();
		em2.merge(conta); // transforma um deteched em managed dnv -> sendo managed, ocorre a verificação
							// atributo por atributo novamente, se houver mudança em algum, é disparado um
							// update no banco de dados
		em2.getTransaction().commit();
	}
}
