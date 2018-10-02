package organizagrana.dao;

import com.mysql.jdbc.Statement;
import organizagrana.bean.Usuario;
import organizagrana.utils.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
    
    private final Connection c;
    
    public UsuarioDao() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDB().getConnection();
    }

    
    public List<Usuario> listaTodos() throws SQLException{
         // alus: array armazena a lista de registros

        List<Usuario> usus = new ArrayList<>();
        
        String sql = "select * from usuario";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
               
        while (rs.next()) {      
            // criando o objeto Aluno
                Usuario usu = new Usuario(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),   
                    rs.getString(5)
            );
            // adiciona o alu à lista de alus
            usus.add(usu);
        }
        
        rs.close();
        stmt.close();
        return usus;
    }
    
    public Usuario inseri(Usuario usu) throws SQLException{
        String sql = "INSERT INTO usuario" + " (usuario_id, usuario_nome_completo, usuario_email, usuario_senha, usuario_status)" + " VALUES (?,?,?,?,?)";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1, usu.getId());
        stmt.setString(2, usu.getNome());
        stmt.setString(3, usu.getEmail());
        stmt.setString(4, usu.getSenha());
        stmt.setString(5, usu.getStatus());
       
        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int idUsuario = rs.getInt(1);
            usu.setId(idUsuario);
        }
        stmt.close();
        return usu;
    }
        public Usuario busca(Usuario usu) throws SQLException{
        String sql = "select * from usuario WHERE usuario_id = ?";
        
            PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,usu.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
 
            while (rs.next()) {
                // criando o objeto Aluno
                usu.setId(rs.getInt(1));
                usu.setNome(rs.getString(2));
                usu.setEmail(rs.getString(3));
                usu.setSenha(rs.getString(4));
                usu.setStatus(rs.getString(5));
                
                // adiciona o alu à lista de alus
            }
        return usu;
    }
    
}
