package br.com.cii.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.cii.dao.EstadoDAO;
import br.com.cii.model.Estado;

@ManagedBean
@ViewScoped
public class EstadoBean {

	private Estado estado;
	private EstadoDAO estadoDao;
	private List<Estado> estados;

	@PostConstruct
	public void init() {
		estadoDao = new EstadoDAO();
		estado = new Estado();

		try {
			estados = estadoDao.listarTodos();
		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
			context.getExternalContext().getFlash().setKeepMessages(true);
		}
	}

	public Estado getEstado() {
		return estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	//PARA PERSISTIR
	public String inserir() {
		try {
			estadoDao.inserir(estado);
			estados = estadoDao.listarTodos();

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Estado adicionado com sucesso!"));
			context.getExternalContext().getFlash().setKeepMessages(true);

		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
			context.getExternalContext().getFlash().setKeepMessages(true);

		}
		return "home";

	}

	public String atualizar() {
		try {
			estadoDao.atualizar(estado);
			estados = estadoDao.listarTodos();

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Estado atualizado com sucesso!"));
			context.getExternalContext().getFlash().setKeepMessages(true);

		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
			context.getExternalContext().getFlash().setKeepMessages(true);

		}
		return "home";

	}

	public String excluir() {
		try {
			estadoDao.excluir(estado.getIdEstado());
			estados = estadoDao.listarTodos();

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Estado excluido com sucesso!"));
			context.getExternalContext().getFlash().setKeepMessages(true);

		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
			context.getExternalContext().getFlash().setKeepMessages(true);

		}
		return "home";

	}

	public void selecionar() {
		try {
			estadoDao.selecionar(estado.getIdEstado());
			if (estado == null || estado.getIdEstado() == 0) {
				estado = new Estado();

				throw new Exception("Estado não encontrado!");
			}

		} catch (Exception e) {		
			FacesMessage message = new FacesMessage(e.getMessage());
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, message);

		}
	}

}
