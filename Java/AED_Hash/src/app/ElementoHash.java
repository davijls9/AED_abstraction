package app;

/** Elemento para uma tabela hash de endereçamento aberto (com atributo de validade) */
public class ElementoHash {
    public Jogador dado;
    public boolean valido;

    public ElementoHash(Jogador novo)
    {
        this.dado = novo;
        this.valido = true;
    }

    @Override
    public int hashCode(){
        if(valido)
            return dado.hashCode();
        else
            return -1;
    }

    @Override
    public String toString(){
        if(valido)
            return dado.toString();
        else
            return "";
    }
}