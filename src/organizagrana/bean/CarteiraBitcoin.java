package organizagrana.bean;
public class CarteiraBitcoin {
    private String chavePublica;
    private String nomeCarteira;
    private float saldo;
    private Usuario Usuario;

    public CarteiraBitcoin() {
    }
    
    public CarteiraBitcoin(String nomeCarteira, float saldo, Usuario Usuario) {
        this.chavePublica = chavePublica;
        this.nomeCarteira = nomeCarteira;
        this.saldo = saldo;
        this.Usuario = Usuario;
    }

    
    public String getChavePublica() {
        return chavePublica;
    }

    public void setChavePublica(String chavePublica) {
        this.chavePublica = chavePublica;
    }

    public String getNomeCarteira() {
        return nomeCarteira;
    }

    public void setNomeCarteira(String nomeCarteira) {
        this.nomeCarteira = nomeCarteira;
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
