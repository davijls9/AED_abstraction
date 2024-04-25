public class App {
/*
Quando acabar a string, temos 0 letra "a" (nunca é "a")

1)Base: Quando chegarmos ao fim da string, resposta é 0
2)Regra recursiva:
busca(R, P[i]){	
	Se R == P[i], contador=1;
	senão, contador=0;
	
	resultado = contador + busca(R, P[i+1]);
}
*/  
public static int busca(char R, String P, int i){
    if( i == P.length())
        return 0;
    else{
       int contador = 0;
       if(R == P.charAt(i))  
            contador = 1;
       return contador + busca(R, P, i+1);
    }
}


    public static void main(String[] args) throws Exception {
        String nome = "joao caram";
        
        int letras = busca('x', nome, 0);

        System.out.println(letras + " letras.");
    }
}
