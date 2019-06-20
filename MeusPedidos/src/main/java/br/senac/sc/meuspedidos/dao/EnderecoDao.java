package br.senac.sc.meuspedidos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.senac.sc.meuspedidos.interfaces.DaoI;
import br.senac.sc.meuspedidos.model.Categoria;
import br.senac.sc.meuspedidos.model.Endereco;
import br.senac.sc.meuspedidos.util.JpaUtil;

public class EnderecoDao implements DaoI<Endereco> {

	@Override
	public Endereco salvar(Endereco endereco) {
		
		EntityManager manager = JpaUtil.getEntityManager();

		EntityTransaction trx = manager.getTransaction();

		try {
			trx.begin();

			endereco = manager.merge(endereco);
			trx.commit();

		} finally {
			if (trx.isActive()) {
				trx.rollback();
			}
			manager.close();
		}
		return endereco;
	}

	@Override
	public void deletar(Endereco endereco) {
		
		EntityManager manager = JpaUtil.getEntityManager();

		EntityTransaction trx = manager.getTransaction();

		try {
			trx.begin();

			manager.remove(manager.find(Categoria.class, endereco.getId()));
			trx.commit();

		} finally {
			if (trx.isActive()) {
				trx.rollback();
			}
			manager.close();
		}
	}

	@Override
	public List<Endereco> listar() {
		EntityManager manager = JpaUtil.getEntityManager();
		TypedQuery<Endereco> query = manager.createQuery("from Endereco", Endereco.class);

		try {
			return query.getResultList();
		} finally {
			manager.close();
		}
	}

	@Override
	public List<Endereco> listarPorNome(String txt) {
		EntityManager manager = JpaUtil.getEntityManager();
		TypedQuery<Endereco> query = manager.createQuery("from Endereco where descricao LIKE :estado", Endereco.class);
		query.setParameter("estado", "%"+ txt +"%");
		try {
			return query.getResultList();
		} finally {
			manager.close();
		}
	}

	@Override
	public Endereco pesquisarPorID(Long id) {
		EntityManager manager = JpaUtil.getEntityManager();

		try {
			return manager.find(Endereco.class, id);
		} finally {
			manager.close();
		}
	}
}
