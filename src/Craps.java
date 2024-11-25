import java.util.Random;
import java.util.Scanner;

public class Craps {

    // Método para lançar os dados
    public static int lancarDados() {
        Random random = new Random();
        return random.nextInt(6) + 1 + random.nextInt(6) + 1; // Soma de dois dados
    }

    public static void jogarCraps() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao jogo de Craps!");

        // Primeira jogada
        int primeiroLance = lancarDados();
        System.out.println("Você lançou os dados e obteve: " + primeiroLance);

        // Verifica o resultado da primeira jogada
        if (primeiroLance == 7 || primeiroLance == 11) {
            System.out.println("Você é um 'Natural'! Você ganhou!");
        } else if (primeiroLance == 2 || primeiroLance == 3 || primeiroLance == 12) {
            System.out.println("Craps! Você perdeu!");
        } else {
            int ponto = primeiroLance;
            System.out.println("Seu 'Ponto' é: " + ponto);
            
            // Continua jogando até tirar o ponto ou um 7
            while (true) {
                System.out.println("Pressione Enter para lançar os dados novamente...");
                scanner.nextLine(); // Espera o jogador pressionar Enter
                int novoLance = lancarDados();
                System.out.println("Você lançou os dados e obteve: " + novoLance);
                
                if (novoLance == ponto) {
                    System.out.println("Você tirou seu ponto! Você ganhou!");
                    break;
                } else if (novoLance == 7) {
                    System.out.println("Você tirou 7! Você perdeu!");
                    break;
                }
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        jogarCraps();
    }
}