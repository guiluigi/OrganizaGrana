package organizagrana.bean;
public class ContaCorrente {
    private int idBanco;
    private String nomeBanco;
    private int numeroConta;
    private int numeroAgencia;
    private float saldo;
    private Usuario Usuario;

    public ContaCorrente() {
    }

    public ContaCorrente(String nomeBanco, int numeroConta, int numeroAgencia, float saldo, Usuario Usuario) {
        this.idBanco = idBanco;
        this.nomeBanco = nomeBanco;
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.saldo = saldo;
        this.Usuario = Usuario;
    }

    public int getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int idBanco) {
        this.idBanco = idBanco;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(int numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }

    
}
