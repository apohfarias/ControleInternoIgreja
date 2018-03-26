package br.com.cii.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.cii.beans.JpaResourceBean;
import br.com.cii.model.Estado;

import java.util.List;

//import br.com.cii;

public class EstadoDAO {

	// METODO LISTAR TODOS DO BD
	public List<Estado> listarTodos() throws Exception {
		EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();
		List<Estado> estados = null;

		try {
			estados = em.createQuery("from Estado").getResultList();

		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e);
		} finally {
			em.close();
		}

		return estados;
	}

	// METODO QUE INSERE NO BD
	public void inserir(Estado _estado) throws Exception {
		EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

		try {
			em.getTransaction().begin(); // inicia conexao no bd
			em.persist(_estado); // passa informacoes para o bd
			em.getTransaction().commit();// realmente salva no bd

		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
		} finally {
			em.close();// fecha a conexão do bd
		}
	}

	// METODO QUE ATUALIZA
	public void atualizar(Estado _estado) throws Exception {
		EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

		try {
			em.getTransaction().begin(); // inicia conexao no bd
			em.merge(_estado); // passa informacoes para o bd
			em.getTransaction().commit();// realmente salva no bd

		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
		} finally {
			em.close();// fecha a conexão do bd
		}
	}

	// METODO QUE EXCLUI POR ID
	public void excluir(long id) throws Exception {
		EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

		try {
			em.getTransaction().begin(); // inicia conexao no bd
			Estado estado = em.find(Estado.class, id);
			em.remove(estado);
			em.getTransaction().commit();// realmente salva no bd

		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
		} finally {
			em.close();// fecha a conexão do bd
		}
	}

	// METODO QUE SELECIONA POR ID
	public Estado selecionar(long id) throws Exception {
		Estado estado;

		EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

		try {
			estado = em.find(Estado.class, id);
		} finally {
			// TODO: handle finally clause
			em.close();
		}

		return estado;
	}

}
