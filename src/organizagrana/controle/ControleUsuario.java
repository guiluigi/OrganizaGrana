package organizagrana.controle;

import organizagrana.bean.Usuario;
import organizagrana.dao.UsuarioDao;
import java.sql.SQLException;
import java.util.List;

public class ControleUsuario {
    
    static UsuarioDao usuDao ;

    
    public ControleUsuario() throws SQLException, ClassNotFoundException {
        usuDao = new UsuarioDao();
    }
    
    public List<Usuario> listarTodosUsuarios() throws SQLException {
        return usuDao.listaTodos();
    }
    public Usuario inserirUsuario(Usuario usu) throws SQLException, ClassNotFoundException {
        return usuDao.inseri(usu);
    }
    public Usuario buscarUsuario(Usuario usu) throws SQLException {
        return usuDao.busca(usu);
    }
    public Usuario alterarUsuario(Usuario usu) throws SQLException {
        return usuDao.alterar(usu);
    }
    public Usuario excluirUsuario(Usuario usu) throws SQLException {
        return usuDao.exclui(usu);
    }
}
