package com.grupo9.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.grupo9.model.ClientePJ;
import com.grupo9.util.ConnectionFactory;

public class ClientesPJDao {

	Connection connection;

	public ClientesPJDao() {
		this.connection = ConnectionFactory.getConnection();
	}

	public boolean adicionar(ClientePJ cliente) {
		String sql = "INSERT INTO CLIENTE_PJ (CNPJ, NOME_COMPLETO, INSCRICAO_ESTADUAL, ENDERECO, TELEFONE, CELULAR, EMAIL)"
				+ "values (?,?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, cliente.getCnpj());
			stmt.setString(2, cliente.getNome());
			stmt.setLong(3, cliente.getInscricaoEstadual());
			stmt.setString(4, cliente.getEndereco());
			stmt.setLong(5, cliente.getTelefone());
			stmt.setLong(6, cliente.getCelular());
			stmt.setString(7, cliente.getEmail());
			stmt.execute();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean alterar(ClientePJ cliente) {
		String sql = "UPDATE CLIENTE_PJ SET NOME_COMPLETO=?, INSCRICAO_ESTADUAL=?, ENDERECO=?, TELEFONE=?, CELULAR=?, EMAIL=? WHERE CNPJ=?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setLong(3, cliente.getInscricaoEstadual());
			stmt.setLong(4, cliente.getTelefone());
			stmt.setLong(5, cliente.getCelular());
			stmt.setString(6, cliente.getEmail());
			stmt.setLong(7, cliente.getCnpj());
			stmt.execute();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean remover(long cnpj) {
		String sql = "DELETE FROM CLIENTE_PJ WHERE CNPJ=" + cnpj;
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.execute();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean remover(ClientePJ cliente) {
		String sql = "DELETE FROM CLIENTE_PJ WHERE CNPJ=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, cliente.getCnpj());
			stmt.execute();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public ClientePJ buscar(long cnpj) {
		String sql = "SELECT FROM CLIENT_PF WHERE CNPJ=" + cnpj;
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			ClientePJ cliente = new ClientePJ();
			while (rs.next()) {
				cliente.setCnpj(rs.getInt("cnpj"));
				cliente.setNome(rs.getString("nome_completo"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setInscricaoEstadual(rs.getLong("inscricao_estadual"));
				cliente.setTelefone(rs.getInt("telefone"));
				cliente.setCelular(rs.getInt("celular"));
				cliente.setEmail(rs.getString("email"));
			}
			return cliente;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<ClientePJ> listarClientesPF() {
		String sql = "SELECT * FROM CLIENTE_PJ ";
		List<ClientePJ> lista = new ArrayList<>();

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				ClientePJ cliente = new ClientePJ();
				cliente.setCnpj(rs.getInt("cnpj"));
				cliente.setNome(rs.getString("nome_completo"));
				cliente.setInscricaoEstadual(rs.getLong("inscricao_estadual"));
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
