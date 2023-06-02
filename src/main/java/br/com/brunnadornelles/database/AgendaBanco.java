package br.com.brunnadornelles.database;

import br.com.brunnadornelles.model.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgendaBanco {

    public boolean addContato(Contato contato) {
        String sqlComando = "INSERT INTO Contatos(id, " +
                "nome, telefone, email) VALUES(?,?,?,?)";
        try (Connection connection = ConectarBanco.conectar();
             PreparedStatement pstmt = connection.prepareStatement(sqlComando)) {
            pstmt.setInt(1, Math.toIntExact(contato.getId()));
            pstmt.setString(2, contato.getNome());
            pstmt.setString(3, contato.getTelefone());
            pstmt.setString(4, contato.getEmail());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deletarContato(Contato contato) {
        String sqlComando = "DELETE FROM Contatos WHERE id = ?";

        try (Connection connection = ConectarBanco.conectar();
             PreparedStatement pstmt = connection.prepareStatement(sqlComando)) {

            pstmt.setInt(1, Math.toIntExact(contato.getId()));
            pstmt.executeUpdate();
            System.out.println("Contatos removidos com sucesso!");
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Contato> listarContatosPeloNome() {
        String sqlComando = " SELECT * FROM Contatos ORDER BY nome ASC";
        List<Contato> contatos = new ArrayList<Contato>();
        ResultSet rs = null;

        try (Connection connection = ConectarBanco.conectar();
             PreparedStatement pstmt = connection.prepareStatement(sqlComando)){
            rs = pstmt.executeQuery();

            while(rs.next()){
                Contato contato = new Contato(
                        (long) rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("email")
                );
                contatos.add(contato);
            }
            return contatos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Contato> listarContatos() {
        String sqlComando = " SELECT * FROM Contatos ORDER BY id";
        List<Contato> contatos = new ArrayList<Contato>();
        ResultSet rs = null;

        try (Connection connection = ConectarBanco.conectar();
             PreparedStatement pstmt = connection.prepareStatement(sqlComando)){
            rs = pstmt.executeQuery();

            while(rs.next()){
                Contato contato = new Contato(
                        (long) rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("email")
                );
                contatos.add(contato);
            }
            return contatos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Contato> buscarContatoNome(String nome){
        String sqlComando = " SELECT * FROM Contatos WHERE nome = ?";
        List<Contato> contatos = new ArrayList<Contato>();
        ResultSet rs = null;

        try (Connection connection = ConectarBanco.conectar();
             PreparedStatement pstmt = connection.prepareStatement(sqlComando)){

            pstmt.setString(1, nome);
            rs = pstmt.executeQuery();

            while(rs.next()){
                Contato contato = new Contato(
                        (long) rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("email")
                );
                contatos.add(contato);
            }
            return contatos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Contato> buscarContatoId(int id){
        String sqlComando = " SELECT * FROM Contatos WHERE id = ?";
        List<Contato> contatos = new ArrayList<Contato>();
        ResultSet rs = null;

        try (Connection connection = ConectarBanco.conectar();
             PreparedStatement pstmt = connection.prepareStatement(sqlComando)){

            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while(rs.next()){
                Contato contato = new Contato(
                        (long) rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("email")
                );
                contatos.add(contato);
            }
            return contatos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}