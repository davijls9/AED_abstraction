package app;

class Estudante implements IDados{

    private int matricula;
    private String nome;
    private float notaFinal;

    public Estudante(String nome, int matricula) throws IllegalArgumentException{
        if((nome.length()<5)||!nome.contains(" "))
            throw new IllegalArgumentException("Nome inválido");
        else this.nome = nome;
        if((matricula/100000 <1) || (matricula/100000>9))
            throw new IllegalArgumentException("Matrícula inválida");
        else this.matricula = matricula;

        this.notaFinal = 0f;
    }

    public String getNome(){ return nome;}
    
    public float nota(){ return notaFinal;}
    
    public void setNota(float nota){
        if((nota>=0)&&(nota<=100)) {
            this.notaFinal = nota;
        }   
        else this.notaFinal=0;
    }

    @Override
    public int compareTo(IDados o) {
        Estudante aux = (Estudante)o;
        return (aux.nome.compareTo(this.nome));
    }

    @Override
    public boolean equals(Object obj){
        Estudante aux = (Estudante)obj;
        return (aux.matricula==this.matricula);
    }

    @Override
    public String toString(){
        return this.matricula + " - "+this.nome+ " - Nota: "+this.notaFinal;
    }
    @Override
    public int getID() {
        return this.matricula;
    }

    
}