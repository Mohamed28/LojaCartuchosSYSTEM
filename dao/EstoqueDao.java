package com.grupo9.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.grupo9.model.Cartucho;
import com.grupo9.model.Produto;
import com.grupo9.util.ConnectionFactory;

public class EstoqueDao {

	Connection connection;

	public EstoqueDao() {
		this.connection = ConnectionFactory.getConnection();
	}

	public boolean adicionar(Produto produto) {
		String sql = "INSERT INTO ESTOQUE (CATEGORIA, MARCA, MODELO, DETALHES, QUANTIDADE, PRECO, DESCRICAO)"
				+ "values (?,?,?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, produto.getCategoria());
			stmt.setString(2, produto.getMarca());
			stmt.setString(3, produto.getModelo());
			stmt.setString(4, produto.getDetalhes());
			stmt.setInt(5, produto.getQuantidade());
			stmt.setBigDecimal(6, produto.getPreco());
			stmt.setString(7, produto.getDescricao());
			stmt.execute();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean alterar(Produto produto) {
		String sql = "UPDATE ESTOQUE SET CATEGORIA=?, MARCA=?, MODELO=?, DETALHES=?, QUANTIDADE=?, PRECO=?, DESCRICAO=? WHERE ID=?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, produto.getCategoria());
			stmt.setString(2, produto.getMarca());
			stmt.setString(3, produto.getModelo());
			stmt.setString(4, produto.getDetalhes());
			stmt.setInt(5, produto.getQuantidade());
			stmt.setBigDecimal(6, produto.getPreco());
			stmt.setString(7, produto.getDescricao());
			stmt.setInt(8, produto.getId());
			stmt.execute();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean remover(int id) {
		String sql = "DELETE FROM ESTOQUE WHERE ID=" + id;
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.execute();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean remover(Produto produto) {
		String sql = "DELETE FROM ESTOQUE WHERE ID=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, produto.getId());
			stmt.execute();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Produto buscar(int id) {
		String sql = "SELECT * FROM ESTOQUE WHERE ID=" + id;
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			Produto produto = null;
			while (rs.next()) {
				switch (rs.getString("CATEGORIA")) {
				case "Cartucho":
					produto = new Cartucho();
					break;
				}
				produto.setId(rs.getInt("ID"));
				produto.setMarca(rs.getString("MARCA"));
				produto.setModelo(rs.getString("MODELO"));
				produto.setDetalhes(rs.getString("DETALHES"));
				produto.setQuantidade(rs.getInt("QUANTIDADE"));
				produto.setPreco(rs.getBigDecimal("PRECO"));
				produto.setDescricao(rs.getString("DESCRICAO"));
			}
			return produto;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Produto buscar(String modelo) {
		String sql = "SELECT FROM ESTOQUE WHERE MODELO=" + modelo;

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			Produto produto = null;
			while (rs.next()) {
				switch (rs.getString("CATEGORIA")) {
				case "Cartucho":
					produto = new Cartucho();
					break;
				}
				produto.setId(rs.getInt("ID"));
				produto.setMarca(rs.getString("MARCA"));
				produto.setModelo(rs.getString("MODELO"));
				produto.setDetalhes(rs.getString("DETALHES"));
				produto.setQuantidade(rs.getInt("QUANTIDADE"));
				produto.setPreco(rs.getBigDecimal("PRECO"));
				produto.setDescricao(rs.getString("DESCRICAO"));
			}
			return produto;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Produto> listar() {
		String sql = "SELECT * FROM ESTOQUE ";
		List<Produto> lista = new ArrayList<>();
		Produto produto = null;

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				if(rs.getString("CATEGORIA").equals("Cartucho")) {
					produto = new Cartucho();
				}
				produto.setId(rs.getInt("ID"));
				produto.setMarca(rs.getString("MARCA"));
				produto.setModelo(rs.getString("MODELO"));
				produto.setDetalhes(rs.getString("DETALHES"));
				produto.setQuantidade(rs.getInt("QUANTIDADE"));
				produto.setPreco(rs.getBigDecimal("PRECO"));
				produto.setDescricao(rs.getString("DESCRICAO"));
				lista.add(produto);
			}
			return lista;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
