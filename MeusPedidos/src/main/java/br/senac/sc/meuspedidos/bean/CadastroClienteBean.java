package br.senac.sc.meuspedidos.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.senac.sc.meuspedidos.dao.ClienteDao;
import br.senac.sc.meuspedidos.model.Cliente;
import br.senac.sc.meuspedidos.model.Endereco;

@ManagedBean
@ViewScoped
public class CadastroClienteBean {

	private Cliente cliente;

	private ClienteDao clienteDao;

	private List<Endereco> enderecos;
	
	public void inicializar() {
		if (cliente == null) {
			cliente = new Cliente();
		}
		clienteDao = new ClienteDao();
	}

	public void salvar() {
		
		clienteDao.salvar(cliente);
		
		
		
	}
	
	
	
	
	
	
}
