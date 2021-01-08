package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TestaMovimentacaoConta {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		Movimentacao movimentacao = em.find(Movimentacao.class, 2L);
		Conta conta = movimentacao.getConta();
		int qtdMovimentacoes = conta.getMovimentacoes().size();
		
		System.out.println("Quantidade de movimentações: " + qtdMovimentacoes);
		System.out.println("Titular da conta: " + conta.getTitular());
	}
}
