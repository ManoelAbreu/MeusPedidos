package br.senac.sc.meuspedidos.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.senac.sc.meuspedidos.dao.UsuarioDao;
import br.senac.sc.meuspedidos.model.Usuario;
import br.senac.sc.meuspedidos.util.FacesUtil;

@ManagedBean
@ViewScoped
public class CadastroUsuarioBean {

	
	private Usuario usuario;
	
	private UsuarioDao usuarioDao;
	
	public void inicializar() {
		
		if(usuario == null) {
			usuario = new Usuario();
		}
		
		usuarioDao = new UsuarioDao();
	
	}
	
	public void salvar() {
		usuarioDao.salvar(usuario);
		limpar();
		FacesUtil.addInfoMenssage("Categoria salva com sucesso!");
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void limpar(){
		usuario = new Usuario();
	}

}
