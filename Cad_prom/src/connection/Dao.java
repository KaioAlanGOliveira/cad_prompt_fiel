package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dizimista.Pagamento;
import javaBean.Fiel;

public class Dao {

	private String URL = "jdbc:mysql://localhost:3306/dizimistas";
	private String USER = "root";
	private String PASSWORD = "1234";
	private String DRIVER = "com.mysql.cj.jdbc.Driver";
	private Connection con;
	private ResultSet rs;

//	Dizimistas

	public void adicionaDizimistas(Pagamento p) {

		String create = "INSERT INTO dizimistas (cpf, dataPagamento, pago) VALUES (?,?,?)";

		try (PreparedStatement stmt = con.prepareStatement(create)) {

			stmt.setInt(1, p.getCpf());
			stmt.setDate(2, p.getDataPagamento());
			stmt.setBoolean(3, p.getPago());

			stmt.executeUpdate();
			System.out.println("adicionado!");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public List<Pagamento> listarDizimistas() {

		List<Pagamento> lista = new ArrayList<>();

		String create = "select * from dizimistas";

		try (PreparedStatement stmt = con.prepareStatement(create)) {

			rs = stmt.executeQuery();

			while (rs.next()) {

				Pagamento p = new Pagamento();

				p.setId(rs.getInt("id"));
				p.setCpf(rs.getInt("cpf"));
				p.setDataPagamento(rs.getDate("dataPagamento"));
				p.setPago(rs.getBoolean("pago"));

				lista.add(p);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return lista;
	}

	public void removerDizimistas(Double num) {

		String delete = "DELETE FROM dizimistas WHERE cpf = ?";

		try (PreparedStatement stmt = con.prepareStatement(delete)) {
//			JavaBean p = new JavaBean();
			stmt.setDouble(1, num);
			int linhas = stmt.executeUpdate();

			System.out.println("DELETE! : " + linhas);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Fiel
	public Connection getConnection() {
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public void adicionarFiel(Fiel p) {

		String create = "INSERT INTO fiel (cpf, nome, idade, telefone) VALUES (?,?,?,?)";

		try (PreparedStatement stmt = con.prepareStatement(create)) {

			stmt.setDouble(1, p.getCpf());
			stmt.setString(2, p.getNome());
			stmt.setString(3, p.getIdade());
			stmt.setString(4, p.getTelefone());

			stmt.executeUpdate();
			System.out.println("adicionado!");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public List<Fiel> listarFiel() {

		List<Fiel> lista = new ArrayList<>();

		String create = "select * from fiel";

		try (PreparedStatement stmt = con.prepareStatement(create)) {

			rs = stmt.executeQuery();

			while (rs.next()) {

				Fiel p = new Fiel();

				p.setCpf(rs.getDouble("cpf"));
				p.setNome(rs.getString("nome"));
				p.setIdade(rs.getString("idade"));
				p.setTelefone(rs.getString("telefone"));

				lista.add(p);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return lista;
	}

	public void removerFiel(Double num) {

		String delete = "DELETE FROM fiel WHERE cpf = ?";

		try (PreparedStatement stmt = con.prepareStatement(delete)) {
//				JavaBean p = new JavaBean();
			stmt.setDouble(1, num);
			int linhas = stmt.executeUpdate();

			System.out.println("DELETE! : " + linhas);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
