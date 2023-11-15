import java.util.ArrayList;
import java.util.List;

public class Produto {
    private String nome;
    private String codigo;
    private String descricao;
    private String categoria;
    private int quantidadeEmEstoque;
    private List<String> lotes;

    public Produto(String nome, String codigo, String descricao, String categoria, int quantidadeEmEstoque) {
        this.nome = nome;
        this.codigo = codigo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.lotes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public List<String> getLotes() {
        return lotes;
    }

    public void atualizarQuantidadeEmEstoque(int quantidade) {
        this.quantidadeEmEstoque += quantidade;
    }

    public void adicionarLote(String lote) {
        this.lotes.add(lote);
    }
}
