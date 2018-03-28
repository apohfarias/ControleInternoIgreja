package br.com.cii.beans;

import br.com.cii.dao.CidadeDAO;
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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class CidadeBean {
	
	private Cidade cidade;
	private CidadeDAO cidadeDao;
	private List<Cidade> cidades;
	
	
}