package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.dao.MovimentacaoDAO;
import br.com.alura.jpa.modelo.MediaComData;

public class TesteMediaDiaria {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		List<MediaComData> mediaDasMovimentacoes = new MovimentacaoDAO(em).getMediaDiariaDasMovimentacoes();

		for (MediaComData resultado : mediaDasMovimentacoes) {
			System.out.println(
					"A média das movimentações do dia " + resultado.getDia() + "/" + resultado.getMes() + " é: " + resultado.getValor());
		}

	}
}
