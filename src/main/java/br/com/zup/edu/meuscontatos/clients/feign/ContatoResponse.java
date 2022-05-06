package br.com.zup.edu.meuscontatos.clients.feign;

public class ContatoResponse {

    private Long id;
    private String nome;
    private String empresa;

    public ContatoResponse(Long id, String nome, String empresa) {
        this.id = id;
        this.nome = nome;
        this.empresa = empresa;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmpresa() {
        return empresa;
    }

    @Override
    public String toString() {
        return "ContatoResponse{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", empresa='" + empresa + '\'' +
                '}';
    }
}
