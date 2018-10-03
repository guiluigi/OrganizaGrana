package organizagrana;

import organizagrana.bean.Usuario;
import organizagrana.controle.ControleUsuario;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
 class OrganizaGrana {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        
        // Buscar Todos Usuario
       ControleUsuario contusu = new ControleUsuario();
        List<Usuario> usus = contusu.listarTodosUsuarios();
        for (int i = 0; i < usus.size(); i++) {
            JOptionPane.showMessageDialog(null,"Lista de Usuarios: " + usus.get(i).getNome());
        }
        
        // Inserir Usuario
    
        /*Usuario usu1;
        usu1 = new Usuario(8,"Alice Camachi","alice@gmail.com","123456","ativo");
    
        usu1 = contusu.inserirUsuario(usu1);
        if(usu1.getId() != 0) {
            JOptionPane.showMessageDialog(null,"Inserir - Nome: " + usu1.getNome());
            JOptionPane.showMessageDialog(null,"Inserir - Email: " + usu1.getEmail());
            JOptionPane.showMessageDialog(null,"Inserir - Status: " + usu1.getStatus());
        }*/
        
        //Buscar usuario
        Usuario usu2 = new Usuario(2,"","","","");
        usu2= contusu.buscarUsuario(usu2);
        if(usu2.getId() != 0) {
            JOptionPane.showMessageDialog(null,"Busca - Nome: " + usu2.getNome());
            JOptionPane.showMessageDialog(null,"Busca - Email: " + usu2.getEmail());
            JOptionPane.showMessageDialog(null,"Busca - Status: " + usu2.getStatus());
            JOptionPane.showMessageDialog(null,"Busca - Senha: " + usu2.getSenha());
        }
        
        // Alterar usuario
        Usuario usu3 = new Usuario(3,"Leonardo","leo@gmail.com","123456","ativo");
        usu3 = contusu.alterarUsuario(usu3);
        if(usu3.getId()!= 0) {
            JOptionPane.showMessageDialog(null,"Alterar - Nome: " + usu3.getNome());
            JOptionPane.showMessageDialog(null,"Alterar - Email: " + usu3.getEmail());
            JOptionPane.showMessageDialog(null,"Alterar - Senha: " + usu3.getSenha());
            JOptionPane.showMessageDialog(null,"Alterar - Status: " + usu3.getStatus());
        } 
        
    }    
}
