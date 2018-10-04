package organizagrana.dao;

import com.mysql.jdbc.Statement;
import organizagrana.bean.ContaCorrente;
import organizagrana.utils.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaCorrenteDao {
    private final Connection c;
    
    public ContaCorrenteDao() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDB().getConnection();
    }
    
        public List<ContaCorrente> listaTodos() throws SQLException{
         // alus: array armazena a lista de registros

        List<ContaCorrente> ccs = new ArrayList<>();
        
        String sql = "select * from conta_corrente";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
               
        while (rs.next()) {      
            // criando o objeto CC
                ContaCorrente cc = new ContaCorrente(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4),   
                    rs.getFloat(5)
            );
            // adiciona o alu à lista de alus
            ccs.add(cc);
        }
        
        rs.close();
        stmt.close();
        return ccs;
    }
    public ContaCorrente inseri(ContaCorrente cc) throws SQLException{
        String sql = "INSERT INTO conta_corrente" + " (banco_id, nome_banco, numero_conta, numero_agencia, saldo_conta)" + " VALUES (?,?,?,?,?)";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1, cc.getIdBanco());
        stmt.setString(2, cc.getNomeBanco());
        stmt.setInt(3, cc.getNumeroConta());
        stmt.setInt(3, cc.getNumeroAgencia());
        stmt.setFloat(3, cc.getSaldo());
       
        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int idBanco = rs.getInt(1);
            cc.setIdBanco(idBanco);
        }
        stmt.close();
        return cc;
    }
        public ContaCorrente busca(ContaCorrente cc) throws SQLException{
        String sql = "select * from conta_corrente WHERE banco_id = ?";
        
            PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,cc.getIdBanco());
            // executa
            ResultSet rs = stmt.executeQuery();
 
            while (rs.next()) {
                // criando o objeto Aluno
                cc.setIdBanco(rs.getInt(1));
                cc.setNomeBanco(rs.getString(2));
                cc.setNumeroConta(rs.getInt(3));
                cc.setNumeroAgencia(rs.getInt(4));
                cc.setSaldo(rs.getFloat(5));
                
                // adiciona o alu à lista de alus
            }
        return cc;
    }
        
    public ContaCorrente alterar(ContaCorrente cc) throws SQLException{
        String sql = "UPDATE conta_corrente SET nome_banco = ?, numero_conta = ?, numero_agencia = ?, saldo_conta = ? WHERE banco_id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        
        stmt.setInt(1, cc.getIdBanco());
        stmt.setString(2, cc.getNomeBanco());
        stmt.setInt(3, cc.getNumeroConta());
        stmt.setInt(3, cc.getNumeroAgencia());
        stmt.setFloat(3, cc.getSaldo());
       
        // executa
        stmt.execute();
        stmt.close();
        return cc;
    }
    
    public ContaCorrente exclui(ContaCorrente cc) throws SQLException{
        String sql = "delete from conta_corrente WHERE banco_id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores  
        stmt.setInt(1,cc.getIdBanco());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return cc;
    }
    
    public List<ContaCorrente> lista (ContaCorrente a) throws SQLException{
        // ccs: array armazena a lista de registros
        List<ContaCorrente> ccs = new ArrayList<>();
        
        String sql = "select * from conta_corrente where nome_banco like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + a.getNomeBanco()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            ContaCorrente cc = new ContaCorrente(
                rs.getInt(1),
                rs.getString(2),
                rs.getInt(3),
                rs.getInt(4),   
                rs.getFloat(5)
            );
            // adiciona o cc à lista de ccs
            ccs.add(cc);
        }
        
        rs.close();
        stmt.close();
        return ccs;          
    }
}
