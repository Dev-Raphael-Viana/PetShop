package PetShop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Definindo a capacidade máxima do PetShop
    private static final int CAPACIDADE_MAXIMA = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pet> listaPets = new ArrayList<Pet>();
        boolean rodando = true;

        System.out.println("===============================");
        System.out.println("  Seja bem-vindo ao PetShop!   ");
        System.out.println("===============================");

        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1 - Visão Usuário (Cliente)");
            System.out.println("2 - Visão Administrador");
            System.out.println("3 - Encerrar o programa");
            System.out.print("Escolha um perfil: ");

            int perfil = sc.nextInt();

            if (perfil == 1) {
                menuUsuario(sc, listaPets);
            } else if (perfil == 2) {
                if (fazerLoginAdmin(sc)) {
                    menuAdmin(sc, listaPets);
                } else {
                    System.out.println("[Erro] Senha incorreta. Acesso negado.");
                }
            } else if (perfil == 3) {
                rodando = false;
                System.out.println("Encerrando o programa. Até logo!");
            } else {
                System.out.println("Opção inválida!");
            }
        } while (rodando);

        sc.close();
    }

    // VISÃO DO USUÁRIO
    private static void menuUsuario(Scanner sc, List<Pet> listaPets) {
        boolean noMenuUsuario = true;
        do {
            System.out.println("\n--- MENU USUÁRIO ---");
            System.out.println("1 - Cadastrar Novo Pet");
            System.out.println("2 - Consultar Meus Pets");
            System.out.println("3 - Consultar Preços / Simular Serviço");
            System.out.println("4 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarPet(sc, listaPets);
                    break;
                case 2:
                    mostrarPet(listaPets);
                    break;
                case 3:
                    simularPreco(sc, listaPets);
                    break;
                case 4:
                    noMenuUsuario = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (noMenuUsuario);
    }


    // VISÃO DO ADMINISTRADOR
    private static boolean fazerLoginAdmin(Scanner sc) {
        System.out.print("\nDigite a senha do administrador (Dica: admin123): ");
        sc.nextLine();
        String senha = sc.nextLine();
        return senha.equals("admin123");
    }

    private static void menuAdmin(Scanner sc, List<Pet> listaPets) {
        boolean noMenuAdmin = true;
        do {
            System.out.println("\n--- MENU ADMINISTRADOR ---");
            System.out.println("1 - Ver todos os Pets cadastrados (" + listaPets.size() + "/" + CAPACIDADE_MAXIMA + " vagas)");
            System.out.println("2 - Dar baixa / Excluir Pet");
            System.out.println("3 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    mostrarPet(listaPets);
                    break;
                case 2:
                    excluirPet(sc, listaPets);
                    break;
                case 3:
                    noMenuAdmin = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (noMenuAdmin);
    }


    // FUNÇÕES DO SISTEMA
    private static void cadastrarPet(Scanner sc, List<Pet> listaPets) {
        if (listaPets.size() >= CAPACIDADE_MAXIMA) {
            System.out.println("\n[Aviso] Desculpe, atingimos a capacidade máxima de " + CAPACIDADE_MAXIMA + " pets para hoje!");
            return;
        }

        sc.nextLine();
        System.out.print("Digite o nome do Pet: ");
        String name = sc.nextLine();
        System.out.print("Digite os anos do Pet (se tiver menos de 1 ano, digite 0): ");
        int age = sc.nextInt();
        System.out.print("Digite os meses do Pet: ");
        int meses = sc.nextInt();
        System.out.print("Digite o peso do Pet em kg (ex: 5,5): ");
        double peso = sc.nextDouble();

        Pet pet = new Pet(name, age, meses, peso);
        listaPets.add(pet);
        System.out.println("Pet cadastrado com sucesso!");
    }

    private static void mostrarPet(List<Pet> listaPets) {
        if (listaPets.isEmpty()) {
            System.out.println("\nNenhum pet cadastrado no momento.");
            return;
        }

        System.out.println("\n--- LISTA DE PETS ---");
        for (int i = 0; i < listaPets.size(); i++) {
            Pet pet = listaPets.get(i);
            String textoIdade = formatarIdade(pet);

            System.out.println("ID [" + i + "] | Nome: " + pet.getName() + " | Idade: " + textoIdade + " | Peso: " + pet.getPeso() + "kg");
        }
        System.out.println("============================");
    }

    private static void excluirPet(Scanner sc, List<Pet> listaPets) {
        mostrarPet(listaPets);
        if (listaPets.isEmpty()) return;

        System.out.print("Digite o ID do Pet para dar baixa/excluir: ");
        int id = sc.nextInt();

        if (id >= 0 && id < listaPets.size()) {
            Pet removido = listaPets.remove(id);
            System.out.println("Baixa realizada com sucesso no pet: " + removido.getName());
        } else {
            System.out.println("ID inválido!");
        }
    }

    private static void simularPreco(Scanner sc, List<Pet> listaPets) {
        if (listaPets.isEmpty()) {
            System.out.println("\nVocê precisa cadastrar um pet primeiro para simular os preços!");
            return;
        }

        mostrarPet(listaPets);
        System.out.print("Digite o ID do Pet para o orçamento: ");
        int id = sc.nextInt();

        if (id < 0 || id >= listaPets.size()) {
            System.out.println("ID inválido!");
            return;
        }

        Pet petEscolhido = listaPets.get(id);

        System.out.println("\nEscolha o Serviço:");
        System.out.println("1 - Banho (R$ 40 base)");
        System.out.println("2 - Tosa (R$ 40 base)");
        System.out.println("3 - Banho e Tosa (R$ 70 base)");
        System.out.println("4 - Tosa Higiênica (R$ 30 base)");
        int servico = sc.nextInt();

        System.out.println("\nDeseja serviço de busca e entrega (Frete = R$ 20)?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        int frete = sc.nextInt();

        calcularEExibirPreco(petEscolhido, servico, frete);
    }

    private static void calcularEExibirPreco(Pet pet, int opcaoServico, int opcaoFrete) {
        double valorBase = 0;
        switch (opcaoServico) {
            case 1: valorBase = 40.0; break;
            case 2: valorBase = 40.0; break;
            case 3: valorBase = 70.0; break;
            case 4: valorBase = 30.0; break;
            default: System.out.println("Serviço inválido."); return;
        }

        double taxaPeso = 0;
        if (pet.getPeso() >= 5.0 && pet.getPeso() < 15.0) {
            taxaPeso = 10.0; // Pet Médio
        } else if (pet.getPeso() >= 15.0) {
            taxaPeso = 20.0; // Pet Grande
        }

        double taxaIdade = 0;
        if (pet.getAge() >= 10) {
            taxaIdade = 15.0; // Cuidados extras para idosos
        }

        double valorFrete = (opcaoFrete == 1) ? 20.0 : 0.0;

        double total = valorBase + taxaPeso + taxaIdade + valorFrete;

        System.out.println("\n--- ORÇAMENTO FINAL ---");
        System.out.println("Pet: " + pet.getName());
        System.out.println("Serviço Base: R$ " + valorBase);
        System.out.println("Adicional por Peso (" + pet.getPeso() + "kg): R$ " + taxaPeso);
        System.out.println("Adicional por Idade (" + pet.getAge() + " anos): R$ " + taxaIdade);
        System.out.println("Frete: R$ " + valorFrete);
        System.out.println("-------------------------");
        System.out.println("TOTAL A PAGAR: R$ " + total);
        System.out.println("=========================");
    }

    private static String formatarIdade(Pet pet) {
        String palavraAno = (pet.getAge() == 1) ? "Ano" : "Anos";
        String palavraMes = (pet.getMeses() == 1) ? "Mês" : "Meses";
        String textoIdade = "";

        if (pet.getAge() > 0) textoIdade += pet.getAge() + " " + palavraAno;
        if (pet.getMeses() > 0) {
            if (pet.getAge() > 0) textoIdade += " e ";
            textoIdade += pet.getMeses() + " " + palavraMes;
        }
        if (pet.getAge() == 0 && pet.getMeses() == 0) textoIdade = "Recém-nascido";

        return textoIdade;
    }
}