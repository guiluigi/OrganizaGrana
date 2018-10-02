package organizagrana;

import organizagrana.bean.Usuario;
import organizagrana.controle.ControleUsuario;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
 class OrganizaGrana {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        
        // Usuario
        ControleUsuario contusu = new ControleUsuario();
        List<Usuario> usus = contusu.listarTodosUsuarios();
        for (int i = 0; i < usus.size(); i++) {
            JOptionPane.showMessageDialog(null,"Lista de Alunos: " + usus.get(i).getNome());
        }
        
        // Inserir Usuario
    
        /*Usuario usu1;
        usu1 = new Usuario(7,"Alice Camachi","alice@gmail.com","123456","ativo");
    
        usu1 = contusu.inserirUsuario(usu1);
        if(usu1.getId() != 0) {
            JOptionPane.showMessageDialog(null,"Inserir - Nome: " + usu1.getNome());
            JOptionPane.showMessageDialog(null,"Inserir - Email: " + usu1.getEmail());
            JOptionPane.showMessageDialog(null,"Inserir - Status: " + usu1.getStatus());
        }*/
        
        
        
    }    
}
