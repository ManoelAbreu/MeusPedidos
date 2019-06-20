package br.senac.sc.meuspedidos.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.senac.sc.meuspedidos.dao.ClienteDao;
import br.senac.sc.meuspedidos.model.Cliente;
import br.senac.sc.meuspedidos.model.Endereco;
import br.senac.sc.meuspedidos.model.TipoPessoa;
import br.senac.sc.meuspedidos.util.FacesUtil;

@ManagedBean
@ViewScoped
public class CadastroClienteBean {

	private Cliente cliente;

	private ClienteDao clienteDao;

	private TipoPessoa[] tipoPessoa = TipoPessoa.values();

	private List<Endereco> enderecos;

	private Endereco endereco;

	public void inicializar() {
		if (cliente == null) {
			cliente = new Cliente();
		}
		if (endereco == null) {
			endereco = new Endereco();
		}
		enderecos = new ArrayList<>();
		clienteDao = new ClienteDao();
	}

	public void salvar() {
		if (!enderecos.isEmpty()) {
			cliente.setEnderecos(enderecos);
		}
		clienteDao.salvar(cliente);
		limpar();
		FacesUtil.addInfoMenssage("Cliente salvo com sucesso!!!");
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
		System.out.println("---------------" + endereco.getCidade());
		this.endereco = endereco;
	}

	public void adicionarEndereco() {

		boolean aux = true;

		for (Endereco endereco : enderecos) {
			if (endereco == this.endereco) {
				aux = false;
			}
		}

		if (aux) {

			enderecos.add(endereco);
		}
		endereco = new Endereco();
	}

	public void removerEndereco() {

		Iterator<Endereco> it = enderecos.iterator();

		while(it.hasNext()) {
			Endereco end = it.next();
			if(end == this.endereco) {
				it.remove();
			}
		}
		
		
		
		endereco = new Endereco();
	}

	public void limpar() {
		cliente = new Cliente();
		endereco = new Endereco();
		enderecos = new ArrayList<>();
	}

	public TipoPessoa[] getTipoPessoa() {
		return tipoPessoa;
	}

	public void teste() {
		System.out.println(endereco.getCidade());
		for (Endereco endereco : enderecos) {
			if (endereco == this.endereco) {
				System.out.println("igual");
			}
		}

	}

}
