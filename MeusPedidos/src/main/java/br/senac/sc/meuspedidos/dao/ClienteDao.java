package br.senac.sc.meuspedidos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.senac.sc.meuspedidos.interfaces.DaoI;
import br.senac.sc.meuspedidos.model.Cliente;
import br.senac.sc.meuspedidos.util.JpaUtil;

public class ClienteDao implements DaoI<Cliente> {

	@Override
	public Cliente salvar(Cliente cliente) {
		EntityManager manager = JpaUtil.getEntityManager();

		EntityTransaction trx = manager.getTransaction();

		try {
			trx.begin();

			cliente = manager.merge(cliente);
			trx.commit();

		} finally {
			if (trx.isActive()) {
				trx.rollback();
			}
			manager.close();
		}
		return cliente;

	}

	@Override
	public void deletar(Cliente cliente) {
		EntityManager manager = JpaUtil.getEntityManager();

		EntityTransaction trx = manager.getTransaction();

		try {
			trx.begin();

			manager.remove(manager.find(Cliente.class, cliente.getId()));
			trx.commit();

		} finally {
			if (trx.isActive()) {
				trx.rollback();
			}
			manager.close();

		}
		
	}

	@Override
	public List<Cliente> listar() {
		EntityManager manager = JpaUtil.getEntityManager();
		TypedQuery<Cliente> query = manager.createQuery("from Cliente", Cliente.class);
//		TypedQuery<Cliente> query = manager.createQuery("from Cliente c JOIN fetch c.enderecos", Cliente.class);

		try {
			return query.getResultList();
		} finally {
			manager.close();
		}
	}

	@Override
	public List<Cliente> listarPorNome(String txt) {
		EntityManager manager = JpaUtil.getEntityManager();
		TypedQuery<Cliente> query = manager.createQuery("from Cliente where descricao LIKE :nome", Cliente.class);
		query.setParameter("nome", "%"+ txt +"%");
		try {
			return query.getResultList();
		} finally {
			manager.close();
		}
	}

	@Override
	public Cliente pesquisarPorID(Long id) {
		EntityManager manager = JpaUtil.getEntityManager();

		try {
			return manager.find(Cliente.class, id);
		} finally {
			manager.close();
		}
	}
	
	public List<Cliente> listarPorID(Long id) {
		EntityManager manager = JpaUtil.getEntityManager();
		TypedQuery<Cliente> query = manager.createQuery("from Cliente c JOIN fetch c.enderecos where c.id = :id", Cliente.class);
		query.setParameter("id", id);
		try {
			return query.getResultList();
		} finally {
			manager.close();
		}
	}
}
