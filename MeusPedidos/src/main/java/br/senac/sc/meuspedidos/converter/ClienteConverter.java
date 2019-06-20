package br.senac.sc.meuspedidos.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.senac.sc.meuspedidos.dao.ClienteDao;
import br.senac.sc.meuspedidos.model.Cliente;

@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter {

	ClienteDao clienteDao;
	
	public ClienteConverter() {
		clienteDao = new ClienteDao();
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null || value.isEmpty()) {
			return null;
		}
		
		return clienteDao.pesquisarPorID(new Long(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return null;
		}

		Cliente cliente  = (Cliente) value;

		if (cliente.getId() == null) {
			return null;
		}
		
		return cliente.getId().toString();
	}

}
