package br.senac.sc.meuspedidos.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.senac.sc.meuspedidos.dao.CategoriaDao;
import br.senac.sc.meuspedidos.model.Categoria;
import br.senac.sc.meuspedidos.util.FacesUtil;

@ManagedBean
@ViewScoped
public class PesquisaCategoriaBean {

	private CategoriaDao categoriaDao;

	private List<Categoria> categorias;

	private Categoria categoriaSelecionada;

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public void inicializar() {
		if(categoriaSelecionada == null) {
			categoriaSelecionada = new Categoria();
		}
		categoriaDao = new CategoriaDao();
		categorias = categoriaDao.listar();
	}

	public void excluir() {
		categoriaDao.deletar(this.categoriaSelecionada);
		buscarCategorias();

		FacesUtil.addInfoMenssage("Categoria excluida com sucesso!");
	}

	public void buscarCategorias() {
		categorias = categoriaDao.listar();
	}

	public Categoria getCategoriaSelecionada() {
		return categoriaSelecionada;
	}

	public void setCategoriaSelecionada(Categoria categoriaSelecionada) {
		this.categoriaSelecionada = categoriaSelecionada;
	}

	public void pesquisarPorNome() {

		if (categoriaSelecionada.getDescricao() == null || categoriaSelecionada.getDescricao().equals("")){
			categorias = categoriaDao.listar();
		} else {
			categorias = categoriaDao.listarPorNome(categoriaSelecionada.getDescricao());
		}

	}

}
