import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class pessoa {
    String nome;
    String senha;
    String salt;
    static Hash hash = Hash.getInstance();
    static String localArquivo = "usuarios.txt";
    private static Scanner arquivo;

    public pessoa(String nome, String senha){
        this.salt = nome; // isso aqui ja aumenta a dificuldade de quebrar a senha
        this.senha = hash.toString(senha + salt);
        this.nome = nome;
        writetxt(this.nome, this.senha);
    }

    static void writetxt(String s1, String s2){
        try {
            FileWriter listauser = new FileWriter("usuarios.txt", true);
            listauser.append(""+s1+ ","+s2+"\n");
            listauser.close();
            System.out.println("\nUsuario criado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean autenticar(String nome, String senha){
        boolean sucesso = false;
        String tempN = "";
        String tempS = "";
        try{
            arquivo = new Scanner(new File(localArquivo));
            arquivo.useDelimiter("[,\n]");
            while(arquivo.hasNext() && !sucesso){
                tempN = arquivo.next();
                tempS = arquivo.next();
                if(tempN.trim().toLowerCase().equals(nome.trim().toLowerCase()) && tempS.equals(hash.toString(senha + nome.toLowerCase()))){
                    sucesso = true;
                }
            }
            arquivo.close();
            if(sucesso){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            System.out.println("\nERRO: " + e);
        }
        return false;
    }
}

