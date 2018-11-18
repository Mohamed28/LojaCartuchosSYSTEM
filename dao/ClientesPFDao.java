package com.grupo9.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.grupo9.model.ClientePF;
import com.grupo9.util.ConnectionFactory;

public class ClientesPFDao {

	Connection connection;

	public ClientesPFDao() {
		this.connection = ConnectionFactory.getConnection();
	}

	public boolean adicionar(ClientePF cliente) {
		String sql = "INSERT INTO CLIENTE_PF (CPF, NOME_COMPLETO, ENDERECO, TELEFONE, CELULAR, EMAIL)"
				+ "values (?,?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, cliente.getCpf());
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getEndereco());
			stmt.setLong(4, cliente.getTelefone());
			stmt.setLong(5, cliente.getCelular());
			stmt.setString(6, cliente.getEmail());
			stmt.execute();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean alterar(ClientePF cliente) {
		String sql = "UPDATE CLIENTE_PF SET NOME_COMPLETO=?, ENDERECO=?, TELEFONE=?, CELULAR=?, EMAIL=? WHERE CPF=?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setLong(3, cliente.getTelefone());
			stmt.setLong(4, cliente.getCelular());
			stmt.setString(5, cliente.getEmail());
			stmt.setLong(6, cliente.getCpf());
			stmt.execute();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean remover(long cpf) {
		String sql = "DELETE FROM CLIENTE_PF WHERE CPF=" + cpf;
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.execute();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean remover(ClientePF cliente) {
		String sql = "DELETE FROM CLIENTE_PF WHERE CPF=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, cliente.getCpf());
			stmt.execute();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public ClientePF buscar(long cpf) {
		String sql = "SELECT FROM CLIENT_PF WHERE CPF=" + cpf;
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			ClientePF cliente = new ClientePF();
			while (rs.next()) {
				cliente.setCpf(rs.getLong("CPF"));
				cliente.setNome(rs.getString("nome_completo"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setTelefone(rs.getInt("telefone"));
				cliente.setCelular(rs.getInt("celular"));
				cliente.setEmail(rs.getString("email"));
			}
			return cliente;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<ClientePF> listarClientesPF() {
		String sql = "SELECT * FROM CLIENTE_PF ";
		List<ClientePF> lista = new ArrayList<>();

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				ClientePF cliente = new ClientePF();
				cliente.setCpf(rs.getInt("cpf"));
				cliente.setNome(rs.getString("nome_completo"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setTelefone(rs.getInt("telefone"));
				cliente.setCelular(rs.getInt("celular"));
				cliente.setEmail(rs.getString("email"));
				lista.add(cliente);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}
}
