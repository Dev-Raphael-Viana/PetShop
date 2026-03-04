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

    }

    private static void mostrarPet(List<Pet> listaPets) {
        for (Pet pet : listaPets) {
            System.out.println();
            System.out.println("Nome: " + pet.name);
            System.out.println("Idade " + pet.age + " Anos");
            System.out.println("============================");
        }
    }
    private static void cadastrarPet(Scanner sc, List<Pet> listaPets) {
        Pet pet = new Pet();
        System.out.println("Digite o nome do Pet:");
        pet.name = sc.next();
        System.out.println("Digite a idade:");
        pet.age = sc.nextInt();
        listaPets.add(pet);

    }
}