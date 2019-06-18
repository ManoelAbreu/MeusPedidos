package br.senac.sc.meuspedidos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.senac.sc.meuspedidos.interfaces.DaoI;
import br.senac.sc.meuspedidos.model.Usuario;
import br.senac.sc.meuspedidos.util.JpaUtil;

public class UsuarioDao implements DaoI<Usuario> {

	@Override
	public Usuario salvar(Usuario usuario) {

		EntityManager manager = JpaUtil.getEntityManager();

		EntityTransaction trx = manager.getTransaction();

		try {
			trx.begin();
			usuario = manager.merge(usuario);
			trx.commit();

			return usuario;
		} finally {
			if (trx.isActive()) {
				trx.rollback();
			}
			manager.close();
		}

	}

	@Override
	public void deletar(Usuario usuario) {
		EntityManager manager = JpaUtil.getEntityManager();

		EntityTransaction trx = manager.getTransaction();

		try {
			trx.begin();
			manager.remove(manager.find(Usuario.class, usuario.getId()));
			trx.commit();

		} finally {
			if (trx.isActive()) {
				trx.rollback();
			}
			manager.close();
		}

	}

	@Override
	public List<Usuario> listar() {
		EntityManager manager = JpaUtil.getEntityManager();
		TypedQuery<Usuario> query = manager.createQuery("from Usuario" , Usuario.class);

		try {
			return query.getResultList();
		} finally {
			manager.close();
		}
	}

	@Override
	public List<Usuario> listarPorNome(String txt) {
		EntityManager manager = JpaUtil.getEntityManager();
		TypedQuery<Usuario> query = manager.createQuery("from Usuario where nome LIKE :nome" , Usuario.class);
		query.setParameter("nome","%"+ txt +"%");
		try {
			return query.getResultList();
		} finally {
			manager.close();
		}
	}

	@Override
	public Usuario pesquisarPorID(Long id) {
		EntityManager manager = JpaUtil.getEntityManager();
		try {
			return manager.find(Usuario.class, id);
		} finally {
			manager.close();
		}
	}
}
