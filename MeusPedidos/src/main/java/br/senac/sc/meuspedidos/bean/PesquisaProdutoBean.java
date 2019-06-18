package br.senac.sc.meuspedidos.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.senac.sc.meuspedidos.dao.ProdutoDao;
import br.senac.sc.meuspedidos.model.Produto;
import br.senac.sc.meuspedidos.util.FacesUtil;

@ManagedBean
@ViewScoped
public class PesquisaProdutoBean {

	private Produto produto;
	
	private ProdutoDao produtoDao;
	
	private List<Produto> produtos;
	
	
	
	public void inicializar() {
		
		produto = new Produto();
		
		produtoDao =  new ProdutoDao();
		
		produtos = produtoDao.listar();
		
		
	}
	
	public void excluir() {
		produtoDao.deletar(produto);
		
		FacesUtil.addInfoMenssage("Excluido com sucesso!");
		
	}

	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public List<Produto> getProdutos() {
		return produtos;
	}


	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public void pesquisarPorNome() {
		
		 if (produto.getNome() != null || produto.getNome().equals("")) {
			 System.out.println("if 1");
			produtos = produtoDao.listarPorNome(produto.getNome());
		}
		 else if(produto.getId()!= null) {
			System.out.println("if 2");
			produtos = produtoDao.listarPorNome(produto.getId().toString());
		}else {
			System.out.println("if 3");
			produtos = produtoDao.listar();
		}
		
	}
}
