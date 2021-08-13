import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        try
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Seja bem vindo a tabuada!!");

            System.out.println("Digite o número escolhido para a tabuada: ");
            var tabuada = scanner.nextInt();

            for (int i = 0; i <= 10; i++){
                System.out.println(tabuada+" x "+ i + " = "+ tabuada*i);
            }
            var x = scanner.nextInt();
        }
        catch (Exception err)
        {
            System.out.println("Erro de processamento");
        }

    }
}
