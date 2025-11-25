package fag;

import java.util.Scanner;
import fag.objetos.Animal;
import java.util.List;
import java.util.ArrayList;

public class Principal {
	
	static List<Animal> list = new ArrayList<>();
	public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
    	popularList();
    	mostrarMenu();
    }
    public static void popularList() {
    	Animal animalUm = new Animal (1, "Nyx", "Cachorro", 0, false);
    	Animal animalDois = new Animal (2, "Silas", "Gato", 2, false);
    	Animal animalTres = new Animal (3, "Jonathan", "Tartaruga", 150, true);
    
    	list.add(animalUm);
    	list.add(animalDois);
    	list.add(animalTres);
    }
    public static void mostrarMenu() {
    	int escolha;
    	System.out.println("====Bem-vindo====");
    	do {
    		System.out.println("\n====MENU====");
    		System.out.println("1. Cadastrar animal");
    		System.out.println("2. Listar animais");
    		System.out.println("3. Atualizar animal");
    		System.out.println("4. Remover animal");
    		System.out.println("0. Sair");
    		escolha = scan.nextInt();
    		scan.nextLine();
    		validarEscolha(escolha);
    	}while (escolha !=0);
    }
    public static void validarEscolha(int escolha) {
    	switch(escolha) {
    	case 1:
    		cadastrarAnimal();
    		break;
    	case 2: 
    		listarAnimal();
    		break;
    	case 3:
    		atualizarAnimal();
    		break;
    	case 4: 
    		removerAnimal();
    		break;
    	case 0:
    		System.out.println("Obrigado por utilizar o sistema");
    		break;
    	default:
    		System.out.println("Escolha uma opcao valida");
    		break;
    	}
    }
    public static void listarAnimal() {
    for (Animal animal : list) {
    	System.out.print("ID");
    	System.out.printf(" %d", list.indexOf(animal)+1);
    	animal.mostrarAnimal();
    	}if(list.isEmpty()) {
    		System.out.println("Nao ha animais");
    	}
    }
    public static void cadastrarAnimal(){
    	Animal animal = new Animal();
    	System.out.println("Digite o nome do animal: ");
    	animal.setNome(scan.nextLine());
    	System.out.println("Digite a especie do animal: ");
    	animal.setEspecie(scan.nextLine());
    	System.out.println("Digite a idade do animal: ");
    	animal.setIdade(scan.nextInt());
    	scan.nextLine();
    	int escVac = 0;
    	System.out.println("O animal é vacinado?");
    	System.out.println("1. SIM");
    	System.out.println("2. NÃO");
    	escVac = scan.nextInt();
    	switch(escVac) {
    	case 1:
    		animal.setVacinado(true);
    		break;
    	case 2:
    		animal.setVacinado(false);
    	default:
    		System.out.println("Escolha uma opcao valida");
    	}
    	list.add(animal);
    	System.out.println("Animal cadastrado com sucesso");
    	}
    public static void atualizarAnimal() {
    	listarAnimal();
    	System.out.println("Escolha o animal que deseja atualizar: ");
    	System.out.println("Digite 0 para cancelar"); 
    	int escAtu = scan.nextInt();
    	scan.nextLine();
    	if (escAtu==0) {
    		return;
    	}
    	if(list.size()>= escAtu && escAtu >0) {
    		mostrarMenuAtu();
    		int escMenu = scan.nextInt();
    		scan.nextLine();
    		if (escMenu>4 || escMenu < 0) {
    			System.out.println("Escolha uma opcao valida");
    			atualizarAnimal();
    		}else {
    			alterarDados(escAtu, escMenu);
    		}
    	}
    }
    public static void mostrarMenuAtu() {
    	System.out.println("Selecione uma opcao para editar:");
    	System.out.println("1. Nome");
    	System.out.println("2. Especie");
    	System.out.println("3. Idade;");
    	System.out.println("4. Vacinacao");
    }
    public static void alterarDados(int escAtu, int escMenu) {
    	if(escMenu==1) {
    		System.out.println("Digite o novo nome");
    		list.get(escAtu-1).setNome(scan.nextLine());
    	}else if (escMenu==2) {
    		System.out.println("Digite a nova especie");
    		list.get(escAtu-1).setEspecie(scan.nextLine());
    	}else if(escMenu==3) {
    		System.out.println("Digite a nova idade");
    		list.get(escAtu-1).setIdade(scan.nextInt());
    		scan.nextLine();
    	}else if(escMenu==4) {
    		System.out.println("Esta vacinado?");
    		System.out.println("1.SIM");
    		System.out.println("2.NÃO");
    		int escVac2 = scan.nextInt();
    		switch(escVac2) {
        	case 1:
        		list.get(escAtu-1).setVacinado(true);
        		break;
        	case 2:
        		list.get(escAtu-1).setVacinado(false);
        	default:
        		System.out.println("Escolha uma opcao valida");
        	}
    	}
    }
    public static void removerAnimal() {
    	listarAnimal();
    	System.out.println("Escolha o animal que deseja remover: ");
    	System.out.println("Digite 0 para cancelar: ");
    	int escRem = scan.nextInt();
    	scan.nextLine();
    	if(escRem==0) {
    		return;
    	}if (list.size() >= escRem && escRem > 0 ) {
    		list.remove(escRem-1);
    		System.out.println("Animal removido com sucesso");
    	}else {
    		System.out.println("Escolha uma opcao valida");
    		removerAnimal();
    	}
    	
    }
}
