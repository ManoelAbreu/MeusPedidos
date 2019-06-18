package br.senac.sc.meuspedidos.bean;

import java.util.ArrayList;
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
	
	private Endereco endereco;
	
	public void inicializar() {
		if (cliente == null) {
			cliente = new Cliente();
		}
		if(endereco == null) {
			endereco = new Endereco();
		}
		enderecos = new ArrayList<>();
		clienteDao = new ClienteDao();
	}

	public void salvar() {
		if(!enderecos.isEmpty()) {
			cliente.setEnderecos(enderecos);
		}
		clienteDao.salvar(cliente);
		
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	public void adicionarEndereco() {
		enderecos.add(endereco);
		endereco = null;
		endereco = new Endereco();
	}
}
