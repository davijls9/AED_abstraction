public class App {

    
    public static int fatorialRec(int n) {
        if(n==0)
            return 1;
        else
            return n * fatorialRec(n-1);
    }

    public static int fatorialIter(int n){
        int res = 1;
        for(int i=n; i>=1; i--)
            res *= i;
        return res;
    }

    /* 1 1 2 3 5 8 13 21 34 55 89 ...*/
    public static int fibonacciIter(int n){
        if(n<=2)
            return 1;
        else{
            int ant1 = 1;
            int ant2 = 1;
            int atual = 0;
            for(int i=3; i<=n; i++ ){
                atual = ant1+ant2;
                ant1 = ant2;
                ant2 = atual;
            }
            return atual;
        }
    }

    public static int fibonacciRec(int n){
        if(n<=2)
            return 1;
        else return fibonacciRec(n-1)+fibonacciRec(n-2);
    }


    public static void main(String[] args) throws Exception {
        final int[] TAM_TESTES = {22, 24, 26, 28, 30, 32, 34, 36, 38, 40};
        //final int[] TAM_TESTES = {10, 100, 500,1000, 2000, 5000, 10000};
        final double QT_TESTES = 10d;
        final double NANO = 1_000_000_000d;
        long tempoInicio;
        long tempoFim;
        double tempoTotal=0d;
        double tempoExecucao=0d;
        int posTeste =0;

        

        for(posTeste=0; posTeste<TAM_TESTES.length;posTeste++){
            tempoTotal=0d;
            System.out.println("------------------------------");
            double media=0d;
            //#region teste fibonacciIter
            for(int i=0; i<QT_TESTES; i++){
                tempoInicio = System.nanoTime();
                    fibonacciIter(TAM_TESTES[posTeste]);
                tempoFim = System.nanoTime();

                tempoExecucao = (tempoFim-tempoInicio);
                //System.out.print(tempoExecucao+" ");
                tempoTotal += tempoExecucao;
            }
            media = tempoTotal/QT_TESTES;
            System.out.println(TAM_TESTES[posTeste]+" Tempo médio iterativo: "+String.format("%10.1f",media)+ " nanossegundos.\n");

            //#endregion

            //#region teste fibonacciRec
            tempoTotal=0d;
            for(int i=0; i<QT_TESTES; i++){
                tempoInicio = System.nanoTime();
                    fibonacciRec(TAM_TESTES[posTeste]);
                tempoFim = System.nanoTime();

                tempoExecucao = (tempoFim-tempoInicio);
               // System.out.print(tempoExecucao+" ");
                tempoTotal += tempoExecucao;
            }
            media = tempoTotal/QT_TESTES;
            System.out.println(TAM_TESTES[posTeste]+" Tempo médio recursivo: "+String.format("%10.1f",media)+ " nanossegundos.");
            //#endregion
            
        }

    }
}
