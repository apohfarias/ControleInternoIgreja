package br.com.cii.beans;

import br.com.cii.dao.Conexao;
import br.com.cii.model.Cidade;

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
public class CidadeBean {
	// Listar cidade
	private List<Cidade> cidades = new ArrayList<Cidade>();
	// Instanciando nova cidade
	private Cidade cidade = new Cidade();
	// Instanciando conexao
	private Connection conn;
	// Instanciando comando
	private Statement comando;

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
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

	public CidadeBean() {
		buscarTodos();
	}

	public void buscarTodos() {
		conectar();
		ResultSet rs;
		cidades = new ArrayList<>();
		try {
			rs = comando.executeQuery("SELECT * FROM cidade");
			while (rs.next()) {
				Cidade temp = new Cidade();

				temp.setIdCidade(rs.getInt("idCidade"));
				temp.setNome(rs.getString("nome"));
				// temp.setEstado(rs.getString("estado"));

				cidades.add(temp);
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


	public void inserir() {

	}

	public void apagar() {

	}

	public void apagarPorId() {

	}
	

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
