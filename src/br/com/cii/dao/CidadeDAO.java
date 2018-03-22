package br.com.cii.dao;

public class CidadeDAO {

	/*
	 private final Connection connection;

    public CidadeDAO() {
        try {
            this.connection = new ConnectionFactory().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void adiciona(Cidade cidade){
        String sql= "insert into cidade (nome, cep, id_estado) values (?,?,?)";
        PreparedStatement stmt;
        try{
            stmt= connection.prepareStatement(sql);
            stmt.setString(1, cidade.getNome());
            stmt.setString(2, cidade.getCep());
            //  como faço o setString do estado?
            stmt.execute();
            stmt.close();  
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
	 */
	
}
