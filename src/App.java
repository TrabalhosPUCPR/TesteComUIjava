import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner input = new Scanner(System.in);
    static ArrayList<pessoa> pessoas = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        new janela();
	}

    static void cadastrar(){
        boolean ok = false;
        String nome = "";
        String senha = "";
        while(!ok){
            System.out.println("\nDigite o seu nome: ");
            nome = input.nextLine();
            if(nome.length() == 4){     // esse codigo aceita qualquer tamanho de nome e senha mas tudo bem
                ok = true;
            }else{
                System.out.println("\nDigite um nome com 4 caracteres!");
            }
        }
        ok = false;
        while(!ok){
            System.out.println("\nDigite uma senha: ");
            senha = input.nextLine();
            if(senha.length() == 4){  
                ok = true;
                pessoas.add(new pessoa(nome, senha));
            }else{
                System.out.println("\nDigite uma senha com 4 caracteres!");
            }
        }
    }

    static void autenticar(){
        System.out.println("\nDigite o nome: ");
        String nome = input.nextLine();
        System.out.println("\nDigite sua senha: ");
        String senha = input.nextLine();
        pessoa.autenticar(nome, senha);
    }
}
