package br.com.yaw.jdk7;

import java.sql.SQLException;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

/**
 * Exemplo: uso da nova interface RowSetFactory, esse componente gera (cria) os principais tipos de RowSets suportados pelo
 * driver JDBC. Faz parte do JDBC 4.1.
 * 
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
public class JDBCRowSetFactory {

	public static void main(String[] args) throws SQLException {
		String username = "root"; //Coloque o usuario do banco de dados correto
		String password = "root"; //Coloque a senha do banco de dados correta
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/test"; //Coloque a url jdbc correta

		RowSetFactory myRowSetFactory = null;
		JdbcRowSet jdbcRs = null;
		try {
			//o driver jdbc deve suportar RowSetFactory
			myRowSetFactory = RowSetProvider.newFactory();
			
			jdbcRs = myRowSetFactory.createJdbcRowSet();
			jdbcRs.setUrl(jdbcUrl);
			jdbcRs.setUsername(username);
			jdbcRs.setPassword(password);
			jdbcRs.setCommand("select nome, cpf from aluno"); //Ajuste a consulta SQL (Table: Aluno [nome, cpf])
			
			jdbcRs.execute();

			while (jdbcRs.next()) {
				String nome = jdbcRs.getString("nome");
				String cpf = jdbcRs.getString("cpf");

				System.out.printf("Nome:%s\t Cpf:%s %n", nome, cpf);
			}
		} finally {
			if (jdbcRs != null) {
				jdbcRs.close();
			}
		}
	}

}
