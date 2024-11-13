package main;
import java.util.Scanner;

class Animal {
    private String nome;
    private String classe;
    private String familia;
    private int idade;
    private boolean vivo;
    private int caloria;
    private int força;

    // Construtor
    public Animal(String nome, String classe, String familia) {
        this.nome = nome;
        this.classe = classe;
        this.familia = familia;
        this.idade = 0;
        this.vivo = true;
        this.caloria = 10;
        this.força = 10;
    }

    // Métodos
    public void nascer() {
        System.out.printf("O animal se chama %s, é da classe %s da família %s. ", nome, classe, familia);
        System.out.printf("O animal possui força %d, caloria %d e idade %d.%n", força, caloria, idade);
    }

    public void morrer() {
        vivo = false;
        força = 0;
        System.out.println("O animal morreu!");
    }

    public void comer() {
        if (!vivo) {
            System.out.println("O animal está morto e não pode comer!");
            return;
        }
        if (caloria >= 100) {
            System.out.println("O animal já está cheio e não pode comer mais!");
            return;
        }
        caloria = Math.min(caloria + 10, 100);
        força = Math.max(força - 2, 0);
        System.out.printf("O animal comeu e agora sua força é %d e suas calorias valem %d.%n", força, caloria);
    }

    public void correr() {
        if (!vivo) {
            System.out.println("O animal está morto e não pode correr!");
            return;
        }
        if (caloria <= 0) {
            System.out.println("O animal está exausto e não pode correr!");
            return;
        }
        força = Math.max(força - 5, 0);
        caloria = Math.max(caloria - 5, 0);
        System.out.printf("O animal está correndo! Agora sua força é de %d e suas calorias valem %d.%n", força, caloria);
    }

    public void dormir() {
        if (!vivo) {
            System.out.println("O animal está morto e não pode dormir!");
            return;
        }
        força = Math.min(força + 10, 100);
        caloria = Math.max(caloria - 2, 0);
        System.out.printf("O animal está dormindo agora! Sua força aumentou para %d e suas calorias diminuíram para %d.%n", força, caloria);
    }

    public boolean isVivo() {
        return vivo;
    }
}

public class BichinhoVirtual {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criar o animal
        System.out.println("Crie seu novo animal");
        System.out.print("Insira o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Insira a classe: ");
        String classe = scanner.nextLine();
        System.out.print("Insira a família: ");
        String familia = scanner.nextLine();

        Animal animal = new Animal(nome, classe, familia);
        animal.nascer();

        // Loop do jogo
        while (animal.isVivo()) {
            System.out.println("O que o animal vai fazer agora?");
            System.out.println("1- Comer");
            System.out.println("2- Correr");
            System.out.println("3- Dormir");
            System.out.println("4- Morrer");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    animal.comer();
                    break;
                case 2:
                    animal.correr();
                    break;
                case 3:
                    animal.dormir();
                    break;
                case 4:
                    animal.morrer();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        System.out.println("GAME OVER!");
        scanner.close();
    }
}
