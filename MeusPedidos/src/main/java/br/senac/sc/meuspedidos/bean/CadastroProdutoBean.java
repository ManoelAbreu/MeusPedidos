package br.senac.sc.meuspedidos.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import br.senac.sc.meuspedidos.dao.CategoriaDao;
import br.senac.sc.meuspedidos.dao.ProdutoDao;
import br.senac.sc.meuspedidos.model.Categoria;
import br.senac.sc.meuspedidos.model.Produto;
import br.senac.sc.meuspedidos.util.FacesUtil;

@ManagedBean
@ViewScoped
public class CadastroProdutoBean {

	private ProdutoDao produtoDao;
	
	private Produto produto;
	
	private List<Categoria> categorias;
	
	private List<SelectItem> categoriasLista;
	
	private CategoriaDao categoriaDao;
	
	
	public void inicializar() {
		
		if(produto == null) {
			produto = new Produto();
			
		}
		produtoDao = new ProdutoDao();
		categoriaDao = new CategoriaDao();
		categorias = categoriaDao.listar();
	}
	
	public void salvar() {
		produtoDao.salvar(produto);
		limpar();
		
		FacesUtil.addInfoMenssage("Salvo com sucesso!");
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public void limpar() {
		produto = new Produto();
	}
	
	public void listaCerta() {
		categorias = categoriaDao.listar();
	}
	
	
}
