import java.util.Random;

public class Produto extends DadoGenerico{
    
    static Random sorteio = new Random();

    String descricao; 
    double preco;
    
    public Produto(String desc){
        descricao = desc;
        preco = 5 + sorteio.nextDouble()*10;
    }

  
    @Override
    public boolean ehIgual(DadoGenerico outro){
        Produto aux = (Produto)outro;
       
        return (descricao.equals(aux.descricao));
    }

    /**
     * Compara o objeto atual com outro Produto, retornando TRUE se é prioritário.
     * O critério atual de prioridade é a maior nota final. 
     * @param outro O Produto a ser comparado
     * @return TRUE se este Produto é prioritário, FALSE se o outro é prioritário
     */
    @Override
     public boolean prioritario(DadoGenerico outro){
        boolean menor = ehMenor(outro);

        return (!menor);
    }

    @Override
    public boolean ehMenor(DadoGenerico outro){
        Produto aux = (Produto)outro;
        if(preco < aux.preco)
            return true;
        else
            return false;
    }

    
   
}


/// DADOS: Produto  (guarda os dados de interesse)
/// APONTADOR/ELEMENTO: Produto + ponteiro (mantem a estrutura de dados)
/// ESTR.DADOS (regras de insercao, retirada (pesquisa))class Produto {
    

