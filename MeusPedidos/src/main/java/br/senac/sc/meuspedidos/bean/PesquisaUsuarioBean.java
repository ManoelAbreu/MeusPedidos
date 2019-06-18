package br.senac.sc.meuspedidos.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.senac.sc.meuspedidos.dao.UsuarioDao;
import br.senac.sc.meuspedidos.model.Usuario;
import br.senac.sc.meuspedidos.util.FacesUtil;

@ManagedBean
@ViewScoped
public class PesquisaUsuarioBean {

	private Usuario usuario;
	
	private UsuarioDao dao;
	
	private List<Usuario> usuarios;
	
	public void inicializar(){
		
		usuario = new Usuario();
		dao =  new UsuarioDao();
		usuarios = dao.listar();
		
	}
	
	public void excluir() {
		dao.deletar(usuario);
		listar();
		FacesUtil.addInfoMenssage("Usuario excluido com sucesso!");
	}

	
	
	public void listar() {
		usuarios =  dao.listar();
		
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void pesquisarPorNome() {
		
		if(usuario.getNome().isEmpty()) {
			usuarios = dao.listar();
		}else {
			usuarios = dao.listarPorNome(usuario.getNome());
		}
	}
}
