package br.senac.sc.meuspedidos.dao;

import java.util.List;

import br.senac.sc.meuspedidos.interfaces.DaoI;
import br.senac.sc.meuspedidos.model.Cliente;

public class ClienteDao implements DaoI<Cliente> {

	@Override
	public Cliente salvar(Cliente cliente) {
		System.out.println("chegou aki  !!!!");
		return null;
	}

	@Override
	public void deletar(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> listarPorNome(String txt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente pesquisarPorID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
