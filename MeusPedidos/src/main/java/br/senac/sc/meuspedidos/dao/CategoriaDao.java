package br.senac.sc.meuspedidos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.senac.sc.meuspedidos.interfaces.DaoI;
import br.senac.sc.meuspedidos.model.Categoria;
import br.senac.sc.meuspedidos.util.JpaUtil;

public class CategoriaDao implements DaoI<Categoria> {

	@Override
	public Categoria salvar(Categoria categoria) {

		EntityManager manager = JpaUtil.getEntityManager();

		EntityTransaction trx = manager.getTransaction();

		try {
			trx.begin();

			categoria = manager.merge(categoria);
			trx.commit();

		} finally {
			if (trx.isActive()) {
				trx.rollback();
			}
			manager.close();

		}

		return categoria;
	}

	

	@Override
	public void deletar(Categoria categoria) {
		EntityManager manager = JpaUtil.getEntityManager();

		EntityTransaction trx = manager.getTransaction();

		try {
			trx.begin();

			manager.remove(manager.find(Categoria.class, categoria.getId()));
			trx.commit();

		} finally {
			if (trx.isActive()) {
				trx.rollback();
			}
			manager.close();

		}
	}

	@Override
	public List<Categoria> listar() {

		EntityManager manager = JpaUtil.getEntityManager();
		TypedQuery<Categoria> query = manager.createQuery("from Categoria", Categoria.class);

		try {
			return query.getResultList();
		} finally {
			manager.close();
		}
		
	}

	@Override
	public List<Categoria> listarPorNome(String txt) {
		EntityManager manager = JpaUtil.getEntityManager();
		TypedQuery<Categoria> query = manager.createQuery("from Categoria where descricao LIKE :descricao", Categoria.class);
		query.setParameter("descricao", "%"+ txt +"%");
		try {
			return query.getResultList();
		} finally {
			manager.close();
		}
	}

	public Categoria buscarPorId(Long id) {

		EntityManager manager = JpaUtil.getEntityManager();

		try {
			return manager.find(Categoria.class, id);
		} finally {
			manager.close();
		}
	}



	@Override
	public Categoria pesquisarPorID(Long id) {
		EntityManager manager = JpaUtil.getEntityManager();

		try {
			return manager.find(Categoria.class, id);
		} finally {
			manager.close();
		}
	}

}
