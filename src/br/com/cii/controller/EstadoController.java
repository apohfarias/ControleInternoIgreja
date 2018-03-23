package br.com.cii.controller;

import br.com.cii.dao.Conexao;
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
import javax.faces.context.FacesContext;

@ManagedBean
@ApplicationScoped
public class EstadoController {
	// Listar cidade
	private List<Estado> estados = new ArrayList<Estado>();
	// Instanciando nova cidade
	private Estado estado = new Estado();
	// Instanciando conexao
	private Connection conn;
	// Instanciando comando
	private Statement comando;

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public Statement getComando() {
		return comando;
	}

	public void setComando(Statement comando) {
		this.comando = comando;
	}

	public EstadoController() {
		buscarTodos();
	}

	private void buscarTodos() {
		// TODO Auto-generated method stub
		conectar();
		ResultSet rs;
		estados = new ArrayList<>();
		try {
			rs = comando.executeQuery("SELECT * FROM estado");
			while (rs.next()) {
				Estado temp = new Estado();
				
				temp.setIdEstado(rs.getInt("idEstado"));
				temp.setNome(rs.getString("nome"));

				estados.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void conectar() {
		// TODO Auto-generated method stub
		try {
			conn = Conexao.getConexao();
			comando = conn.createStatement();
			System.out.println("Conectado!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
