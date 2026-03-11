package PetShop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class Main  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pet> listaPets = new ArrayList<Pet>();
        boolean controle = true;
        System.out.println("========================");
        System.out.println("Seja bem-vindo ao PetShop");
        System.out.println("========================");
        do {
            System.out.println("Escolha um dos números");
            System.out.println("1 - Cadastrar Pet");
            System.out.println("2 - Mostrar Pets Cadastrados");
            System.out.println("3 - Encerrar o programa");
            System.out.println("========================");
            int escolha = sc.nextInt();

            if (escolha == 1) {
                cadastrarPet(sc, listaPets);

            } else if (escolha == 2) {
                mostrarPet(listaPets);

            } else  if (escolha == 3) {
                controle = false;

            }



        } while (controle);

        sc.close();
    }

    private static void mostrarPet(List<Pet> listaPets) {
        for (Pet pet : listaPets) {
            String palavraAno = (pet.getAge() == 1) ? "Ano" : "Anos";
            String palavraMes = (pet.getMeses() == 1) ? "Mês" : "Meses";
            String textoIdade = "";
            if (pet.getAge() > 0) {
                textoIdade = textoIdade + pet.getAge() + " " + palavraAno;
            }
            if (pet.getMeses() > 0) {
                if (pet.getAge() > 0) {
                    textoIdade = textoIdade + " e ";
                }
                textoIdade = textoIdade + pet.getMeses() + " " + palavraMes;
            }
            if (pet.getAge() == 0 && pet.getMeses() == 0) {
                textoIdade = "Recém-nascido";
            }
            System.out.println();
            System.out.println("Nome: " + pet.getName());
            System.out.println("Idade: " + textoIdade);
            System.out.println("============================");
        }

    }
    private static void cadastrarPet(Scanner sc, List<Pet> listaPets) {
        sc.nextLine();
        System.out.println("Digite o nome do Pet:");
        String name = sc.nextLine();
        System.out.println("Digite os anos do Pet (se tiver menos de 1 ano, digite 0):");
        int age = sc.nextInt();
        System.out.println("Digite os meses do Pet:");
        int meses = sc.nextInt();
        Pet pet = new Pet(name, age, meses);
        listaPets.add(pet);
        System.out.println("Pet cadastrado com sucesso!");
    }
}

