package fag.objetos;

public class Animal {
    public int id;
    public String nome;
    public String especie;
    public int idade;
    public boolean vacinado;

    public Animal(){
    }
    public Animal(int id, String nome, String especie, int idade, boolean vacinado){
        setId(id);
        setNome(nome);
        setEspecie(especie);
        setIdade(idade);
        setVacinado(vacinado);
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setNome(String nome) {
        if (nome != null && !nome.isBlank()) {
            this.nome = nome;
        } else {
            System.out.println("Digite um nome valido");
        }
    }
    public String getNome(){
            return nome;
        }
    public void setEspecie(String especie){
            if(especie !=null && !especie.isBlank()){
                this.especie = especie;
            }
        }
    public String getEspecie(){
            return especie;
        }
    public void setIdade(int id){
            if(idade>=0){
                this.idade = idade;
            }else {
                System.out.println("Digite uma idade valida")
            }

    public int getId(){
            return id;
        }
    public void setVacinado(boolean vacinado){
            this.vacinado = vacinado;
        }
    public boolean getVacinado(){
            return vacinado;
        }

}
