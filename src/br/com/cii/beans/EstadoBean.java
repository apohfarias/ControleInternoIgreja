package br.com.cii.beans;

import br.com.cii.dao.Conexao;
import br.com.cii.dao.EstadoDAO;
import br.com.cii.model.Cidade;
import br.com.cii.model.Estado;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
			// TODO: handle exception
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

	public String inserir() {
		try {
			estadoDao.inserir(estado);
			estados = estadoDao.listarTodos();

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Estado adicionado com sucesso!"));
			context.getExternalContext().getFlash().setKeepMessages(true);

		} catch (Exception e) {
			// TODO: handle exception
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
			// TODO: handle exception
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
			// TODO: handle exception
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
			context.getExternalContext().getFlash().setKeepMessages(true);

		}
		return "home";

	}

	public String selecionar() {
		try {
			estadoDao.selecionar(estado.getIdEstado());
			if (estado == null || estado.getIdEstado() == 0) {
				estado = new Estado();

				throw new Exception("Estado não encontrado!");
			}

		} catch (Exception e) {
			// TODO: handle exception
			FacesMessage message = new FacesMessage(e.getMessage());
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, message);

		}
		return "home";

	}

}
