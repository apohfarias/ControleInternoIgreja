package br.com.cii.controller;

import java.sql.SQLException;

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

import br.com.cii.dao.Conexao;
import br.com.cii.model.Cidade;

@ManagedBean
@ApplicationScoped
public class FuncionarioController {
	// Listar cidade
	// private List<Cidade> cidades = new ArrayList<Cidade>();
	// Instanciando nova cidade
	private Cidade cidade = new Cidade();
	// Instanciando conexao
	private Connection conn;
	// Instanciando comando
	private Statement comando;

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


	//INSERIR NO BD
	public void inserir() {

	}

	//METODO QUE APAGA POR BUSCA
	public void apagar() {

	}

	//METODO APAGAR POR ID
	public void apagarPorId() {

	}

	//METODO EDITAR
	private void editar() {

	}

	//BUSCAR TODOS OS REGISTROS
	private void buscarTodos() {

	}
	
	//FECHA CONEXÃO DO BD
	public void fechar() {
		try {
			comando.close();
			conn.close();
			System.out.println("Conexão Fechada");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
