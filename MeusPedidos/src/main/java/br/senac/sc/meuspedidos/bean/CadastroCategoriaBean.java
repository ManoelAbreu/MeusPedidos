package br.senac.sc.meuspedidos.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.senac.sc.meuspedidos.dao.CategoriaDao;
import br.senac.sc.meuspedidos.model.Categoria;
import br.senac.sc.meuspedidos.util.FacesUtil;

@ViewScoped
@ManagedBean
public class CadastroCategoriaBean {

	private CategoriaDao categoriaDao;

	private Categoria categoria;

	public void salvar() {

		categoriaDao.salvar(categoria);

		limpar();

		FacesUtil.addInfoMenssage("Categoria salva com sucesso!");
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void inicializar() {

		if (categoria == null) {

			categoria = new Categoria();
		}

		categoriaDao = new CategoriaDao();

	}

	public void limpar() {
		categoria = new Categoria();
	}
}
