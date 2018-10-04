package organizagrana.controle;
import organizagrana.bean.ContaCorrente;
import organizagrana.dao.ContaCorrenteDao;
import java.sql.SQLException;
import java.util.List;
public class ControleContaCorrente {
    static ContaCorrenteDao ccDao ;

    
    public ControleContaCorrente() throws SQLException, ClassNotFoundException {
        ccDao = new ContaCorrenteDao();
    }
    
    public List<ContaCorrente> listarTodoContaCorrentes() throws SQLException {
        return ccDao.listaTodos();
    }
    public ContaCorrente inserirContaCorrente(ContaCorrente cc) throws SQLException, ClassNotFoundException {
        return ccDao.inseri(cc);
    }
    public ContaCorrente buscarContaCorrente(ContaCorrente cc) throws SQLException {
        return ccDao.busca(cc);
    }
    public ContaCorrente alterarContaCorrente(ContaCorrente cc) throws SQLException {
        return ccDao.alterar(cc);
    }
    public ContaCorrente excluirContaCorrente(ContaCorrente cc) throws SQLException {
        return ccDao.exclui(cc);
    }
    public List<ContaCorrente> listarContaCorrente(ContaCorrente cc) throws SQLException {
        return ccDao.lista(cc);
    }
}
