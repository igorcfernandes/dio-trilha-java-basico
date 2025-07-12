import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\\n");
        scanner.useLocale(java.util.Locale.US);

        System.out.println("Digite o número da agência:");
        String agencia = scanner.next();

        System.out.println("Digite o número da conta:");
        int conta = scanner.nextInt();

        System.out.println("Digite o seu nome:");
        String nome = scanner.next();

        System.out.println("Digite o saldo inicial:");
        double saldo = scanner.nextDouble();
        
        String mensagem = 
            "Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, "
            + "conta %d e seu saldo %.2f já está disponível para saque";

        System.out.printf(mensagem, nome, agencia, conta, saldo);

        scanner.close();

    }
}
