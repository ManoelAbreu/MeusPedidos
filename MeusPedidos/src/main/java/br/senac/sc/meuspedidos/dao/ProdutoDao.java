package br.senac.sc.meuspedidos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.senac.sc.meuspedidos.interfaces.DaoI;
import br.senac.sc.meuspedidos.model.Produto;
import br.senac.sc.meuspedidos.util.JpaUtil;

public class ProdutoDao implements DaoI<Produto> {

	@Override
	public Produto salvar(Produto produto) {

		EntityManager manager = JpaUtil.getEntityManager();

		EntityTransaction trx = manager.getTransaction();

		try {
			trx.begin();
			produto = manager.merge(produto);
			trx.commit();
		} finally {

			if (trx.isActive()) {
				trx.rollback();
			}
			manager.close();
		}

		return produto;
	}

	@Override
	public void deletar(Produto produto) {
		EntityManager manager = JpaUtil.getEntityManager();

		EntityTransaction trx = manager.getTransaction();

		try {
			trx.begin();
			manager.remove(manager.find(Produto.class, produto.getId()));
			trx.commit();

		} finally {
			if (trx.isActive()) {
				trx.rollback();
			}
			manager.close();

		}

	}

	@Override
	public List<Produto> listar() {
		EntityManager manager = JpaUtil.getEntityManager();

		TypedQuery<Produto> query = manager.createQuery("from Produto", Produto.class);

		try {
			return query.getResultList();
		} finally {

			manager.close();
		}

	}

	@Override
	public List<Produto> listarPorNome(String txt) {
		EntityManager manager = JpaUtil.getEntityManager();

		TypedQuery<Produto> query = manager.createQuery("from Produto WHERE nome LIKE :txt OR id LIKE :txt", Produto.class);
		query.setParameter("txt", "%"+ txt +"%");
		try {
			return query.getResultList();
		} finally {

			manager.close();
		}
	}
//	public List<Produto> listarPorId(Long id) {
//		EntityManager manager = JpaUtil.getEntityManager();
//		
//		TypedQuery<Produto> query = manager.createQuery("from Produto WHERE id = :txt ", Produto.class);
//		query.setParameter("txt", id);
//		try {
//			return query.getResultList();
//		} finally {
//			
//			manager.close();
//		}
//	}

	@Override
	public Produto pesquisarPorID(Long id) {
		EntityManager manager = JpaUtil.getEntityManager();
		try {
			return manager.find(Produto.class, id);
		} finally {
			manager.close();
		}
	}

}
