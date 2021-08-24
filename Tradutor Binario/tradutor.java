import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class tradutor {
    public static void main(String[] args) {
        
        try
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Seja bem vindo ao Tradutor Binário");

            System.out.println("----------------------------------");
            var moveOn = true;

            do
            {
                moveOn = false;
                System.out.println("O que deseja fazer hoje?\n 1 - Traduzir texto para binário\n 2 - Traduzir binário para texto \n 3 - Sair");

                try
                {
                    var option = scanner.nextInt();
                    System.out.println("----------------------------------");
                    
                    if(option == 1)
                    {
                        System.out.println("Digite o texto que deseja passar para binário: ");
                        var text = System.console().readLine();
                        System.out.println("O binário retornado é: ");
                        
                        System.out.println(textToBinary(text.trim()));
                    }
                    else if (option == 2)
                    {
                        System.out.println("Digite o binário que deseja passar para texto: ");
                        var text = System.console().readLine();
                        System.out.println("O texto retornado é: ");
                        
                        System.out.println(binaryToText(text.trim()));
                    }
                    else
                        moveOn = false;

                    System.out.println("Gostaria de fazer mais uma tradução? (Y/N)");
                    String x = System.console().readLine().toUpperCase();
                    
                    if(x.equals("Y")){
                        moveOn = true;
                    }
                    else
                    {
                        System.out.println("Tem certeza de que deseja sair? (Y/N)");
                        if (System.console().readLine().toUpperCase().equals("Y"))
                            moveOn = false;
                        else
                            moveOn = true;
                    }
                    
                }
                catch(Exception err)
                {
                    System.out.println("Selecione uma opção válida");
                    moveOn = true;
                }

            }while(moveOn);
            
            System.out.println("Obrigada por utilizar o tradutor binário");
            scanner.close();
        }
        catch (Exception err)
        {
            System.out.println("Erro de processamento");
        }
    }

    public static String textToBinary(String text)
    {
        try
        {
            var result = "";
            ArrayList<Integer> decimals = new ArrayList<Integer>();
            char[] chars = text.toCharArray();
            for (char ch : chars) {
                decimals.add((int)ch);
            }
            Stack<String> stack = new Stack<String>();
            var number = 0;
            var leftover = 0;
            for (int ascii : decimals) {
                number = ascii;
                do
                {
                    leftover = number % 2;
                    stack.push(String.valueOf(leftover));

                    number = number - leftover;
                    number = number / 2;

                }while (number != 1 && number != 0);

                stack.push(String.valueOf(number));

                while (stack.size() != 0)
                {
                    result += stack.pop();
                }

                result += " ";
            }

            return result.trim();
        }
        catch(Exception err)
        {
            return "Erro na tradução";
        }
    }

    public static String binaryToText(String text)
    {
        try
        {
            String[] caracteres = text.split(" ");
            Stack<String> stack = new Stack<String>();
            ArrayList<Double> asciiValues = new ArrayList<Double>();
            var response = "";

            for (String caracter : caracteres) {

                if (caracter.matches("[a-zA-Z]+") == true && caracter.length() > 0)
                {
                    return "O valor passado está inválido, logo não foi possível traduzir";
                }

                char[] chars = caracter.toCharArray();
                for (char unit : chars) {
                    if (unit != '1' && unit != '0')
                    {
                        //não é binário
                        return "O valor passado está inválido, logo não foi possível traduzir";
                    }

                    stack.push(String.valueOf(unit)); 
                }

                int i = 0;
                double value = 0;

                while (stack.size() != 0)
                {
                    String aux = stack.pop();
                    value += Math.pow(2, i) * Integer.parseInt(aux);

                    i++;
                }
                
                asciiValues.add(value);
            }

            for (Double value : asciiValues) {
                response += String.valueOf((char)value.intValue());
            }
            
            return response;
        }
        catch(Exception err)
        {
            return "Erro na tradução";
        }
    }
    
}