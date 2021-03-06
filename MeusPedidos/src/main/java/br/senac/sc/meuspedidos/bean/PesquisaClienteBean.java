package br.senac.sc.meuspedidos.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.senac.sc.meuspedidos.dao.ClienteDao;
import br.senac.sc.meuspedidos.model.Cliente;
import br.senac.sc.meuspedidos.model.Endereco;
import br.senac.sc.meuspedidos.util.FacesUtil;

@ManagedBean
@ViewScoped
public class PesquisaClienteBean {

	private Cliente cliente;

	private ClienteDao clienteDao;

	private List<Cliente> clientes;

	private List<Endereco> enderecos;

	public void inicializar() {

		clienteDao = new ClienteDao();

		if (cliente == null) {
			cliente = new Cliente();
		}

		listar();
	}

	public void excluir() {

		clienteDao.deletar(cliente);
		listar();
		FacesUtil.addInfoMenssage("Excluido com sucesso");
	}

	public void listar() {
		clientes = clienteDao.listar();
		
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void pesquisarEndereco() {
		System.out.println("populou");
		enderecos = cliente.getEnderecos();
		for (Endereco end : enderecos) {
			System.out.println(end.getId());
		}
	}

	public List<Endereco> getEnderecos() {
		return enderecos;

	}
	
	public void pesquisarPorNome(){
		
		if(cliente.getNome().isEmpty()) {
			listar();
		}else {
			clientes = clienteDao.listarPorNome(cliente.getNome());
		}
		
		
	}

}
