package br.senac.sc.meuspedidos.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory("MeusPedidosPU");

	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

}
