import java.awt.Color;
import javax.swing.*;

import java.awt.FlowLayout;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class janela implements ActionListener{
    static Font fonte = new Font("SansSerif", Font.BOLD, 15);
    static Font fonteerro = new Font("SansSerif", Font.ITALIC, 12);
    static String inputNome;
    static String inputSenha;
    static boolean enter = false;

    JFrame frame = new JFrame();
    JPanel main = new JPanel();
    JPanel inicial = new JPanel();
    JPanel menu = new JPanel();
    JPanel cadastro = new JPanel();
    JPanel login = new JPanel();
    JPanel cardapio = new JPanel();

    JLabel msgErro = new JLabel();

    JTextField fieldNome = new JTextField(); 
    JTextField fieldSenha = new JTextField(); 
    JTextField fieldNomeL = new JTextField(); 
    JTextField fieldSenhaL = new JTextField(); 

    int tamxLogo = 130;int tamyLogo = 130;
    ImageIcon logo =  new ImageIcon(getClass().getResource("fotos/logo.png"));
    Image logoimagem = logo.getImage();
    Image Nlogoimagem = logoimagem.getScaledInstance(tamxLogo, tamyLogo,  java.awt.Image.SCALE_SMOOTH);
    JLabel logoI = new JLabel(new ImageIcon(Nlogoimagem));
    JLabel logoM = new JLabel(new ImageIcon(Nlogoimagem));

    int tamxhb = 130;int tamyhb = 130;
    ImageIcon fotohb1 =  new ImageIcon(getClass().getResource("fotos/hb1.jpg"));
    Image fotohb1imagem = fotohb1.getImage();
    Image Nfotohb1imagem = fotohb1imagem.getScaledInstance(tamxhb, tamyhb,  java.awt.Image.SCALE_SMOOTH);
    JLabel fotohb1I = new JLabel(new ImageIcon(Nfotohb1imagem));

    int tamxhb2 = 130;int tamyhb2 = 130;
    ImageIcon fotohb2 =  new ImageIcon(getClass().getResource("fotos/hb2.jpg"));
    Image fotohb2imagem = fotohb2.getImage();
    Image Nfotohb2imagem = fotohb2imagem.getScaledInstance(tamxhb2, tamyhb2,  java.awt.Image.SCALE_SMOOTH);
    JLabel fotohb2I = new JLabel(new ImageIcon(Nfotohb2imagem));

    JButton continuar = new JButton( new AbstractAction("Continuar") {
        @Override
        public void actionPerformed( ActionEvent e ) {
            inicial.setVisible(false);
            menu.setVisible(true);
        }
    });
    JButton irCadastro = new JButton( new AbstractAction("Cadastro") {
        @Override
        public void actionPerformed( ActionEvent e ) {
            levarPagCad();
        }
    });
    JButton irLogin = new JButton( new AbstractAction("Login") {
        @Override
        public void actionPerformed( ActionEvent e ) {
            levarPagLogin();
        }
    });
    JButton voltar = new JButton( new AbstractAction("Voltar") {
        @Override
        public void actionPerformed( ActionEvent e ) {
            menu.setVisible(true);
            cadastro.setVisible(false);
            errocadastro.setVisible(false);
        }
    });
    JButton voltarL = new JButton( new AbstractAction("Voltar") {
        @Override
        public void actionPerformed( ActionEvent e ) {
            cadSucesso.setVisible(false);
            menu.setVisible(true);
            login.setVisible(false);
            errologin.setVisible(false);
        }
    });
    JButton logout = new JButton( new AbstractAction("Log Out") {
        @Override
        public void actionPerformed( ActionEvent e ) {
            menu.setVisible(true);
            cardapio.setVisible(false);
        }
    });
    JButton comprado = new JButton( new AbstractAction("Comprar") {
        @Override
        public void actionPerformed( ActionEvent e ) {
            obrigado.setVisible(true);
        }
    });
    JButton comprado2 = new JButton( new AbstractAction("Comprar") { // eu nao queria fazer dois ...
        @Override
        public void actionPerformed( ActionEvent e ) {
            obrigado.setVisible(true);
        }
    });
    JButton confirmarcadastro = new JButton( new AbstractAction("Cadastrar") {
        @Override
        public void actionPerformed( ActionEvent e ) {
            try{
                errocadastro.setVisible(false);
                String nome = fieldNome.getText();
                String senha = fieldSenha.getText();
                fieldNome.setText("");
                fieldSenha.setText("");
                if(!nome.isEmpty() && !senha.isEmpty()){
                    new pessoa(nome, senha);
                    cadSucesso.setVisible(true);
                    levarPagLogin();
                }else{
                    errocadastro.setVisible(true);
                }
            }catch(Exception erro){
                errocadastro.setVisible(true);
                System.out.println(erro);
            }
        }
    });
    JButton confirmarlogin = new JButton( new AbstractAction("Login") {
        @Override
        public void actionPerformed( ActionEvent e ) {
            try{
                errologin.setVisible(false);
                String nome = fieldNomeL.getText();
                String senha = fieldSenhaL.getText();
                fieldNomeL.setText("");
                fieldSenhaL.setText("");
                if(!nome.isEmpty() && !senha.isEmpty()){
                    if(pessoa.autenticar(nome, senha)){
                        // mandar pessoa pra pagina de login
                        System.out.println("Logado com sucesso");
                        levarCardapio();
                    }else{
                        errologin.setVisible(true);
                    }
                }else{
                    errologin.setVisible(true);
                }
            }catch(Exception erro){
                errologin.setVisible(true);
            }
        }
    });
    
    public janela(){ // janela inicial
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,700);
        //frame.setResizable(false);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);

        main.setLayout(new FlowLayout(FlowLayout.CENTER));
        main.setBackground(Color.white);
        main.setSize(frame.getSize());
        main.setLocation(0, 0);
        frame.add(main);

        // COISAS DA PAGINA INICIAL
        JLabel bemvindo = new JLabel("<html><body><div style='text-align: center;'><br><br><br><br><br><br>Bem ao aplicativo da<br>Super Hamburgueria Muito Legal!<br><br>Feito por:<br>Leonardo Matthew Knight<br><br></div></body></html>");
        JLabel ln = new JLabel("<html><body><br><br><br><br><br><br><br><br><br><br><br></body></html>");
        bemvindo.setFont(fonte);
        bemvindo.setForeground(Color.black);
        continuar.setBackground(Color.white);
        continuar.setFocusPainted(false);
        continuar.addActionListener(this);

        inicial.setLayout(new FlowLayout(FlowLayout.CENTER));
        inicial.setPreferredSize(new Dimension(300,600));
        inicial.setBackground(Color.white);
        logoI.setPreferredSize(new Dimension(tamxLogo+100,tamyLogo));
        inicial.add(bemvindo);
        inicial.add(logoI);
        inicial.add(ln);
        inicial.add(continuar);
        main.add(inicial);

        criarmenu();
        voltar.setBackground(Color.white);
        voltar.setFocusPainted(false);
        voltar.addActionListener(this);
        voltar.setVisible(false);
        voltarL.setBackground(Color.white);
        voltarL.setFocusPainted(false);
        voltarL.addActionListener(this);
        voltarL.setVisible(false);
        criarcadastrar();
        criarlogin();
        criarcardapio();

        frame.setVisible(true);
    }

    private void criarmenu(){
        // COISAS DO MENU INICIAL
        JLabel menuinicial = new JLabel("<html><body><div style='text-align: center;'><br><br><br><br><br><br><br><br><br><br><br><br>Selecione uma opcao:<br><br></div></body></html>");
        JLabel ln = new JLabel("<html><body><br><br><br><br></body></html>");
        menuinicial.setFont(fonte);
        menuinicial.setForeground(Color.black);
        irCadastro.setBackground(Color.white);
        irCadastro.setFocusPainted(false);
        irCadastro.addActionListener(this);
        irLogin.setBackground(Color.white);
        irLogin.setFocusPainted(false);
        irLogin.addActionListener(this);
        logoM.setPreferredSize(new Dimension(tamxLogo+100,tamyLogo));
        menu.setBackground(Color.white);
        menu.setPreferredSize(new Dimension(200,600));
        menu.add(menuinicial);
        menu.add(logoM);
        menu.add(ln);
        menu.add(irCadastro);
        menu.add(irLogin);
        main.add(menu);
        menu.setVisible(false);
    }

    JLabel errocadastro = new JLabel("Erro ao cadastrar!");
    private void criarcadastrar(){ // pagina de cadastro
        JLabel cadastrar = new JLabel("<html><body><div style='text-align: center;'><br><br><br><br>Crie a sua conta:<br><br><br></div></body></html>");
        cadastrar.setFont(fonte);
        cadastrar.setForeground(Color.black);
        fieldNome.setBackground(Color.white);
        fieldNome.setForeground(Color.black);
        fieldNome.setColumns(10);
        fieldNome.setBorder(BorderFactory.createLineBorder(Color.black));
        fieldSenha.setBackground(Color.white);
        fieldSenha.setForeground(Color.black);
        fieldSenha.setColumns(10);
        fieldSenha.setBorder(BorderFactory.createLineBorder(Color.black));
        confirmarcadastro.setBackground(Color.white);
        confirmarcadastro.setFocusPainted(false);
        confirmarcadastro.addActionListener(this);
        JLabel labelnome = new JLabel("Nome: ");
        JLabel labelsenha = new JLabel("Senha: ");
        errocadastro.setForeground(Color.red);
        errocadastro.setVisible(false);
        errocadastro.setFont(fonteerro);
        cadastro.setBackground(Color.white);
        cadastro.setPreferredSize(new Dimension(140,600));
        cadastro.add(new JLabel("<html><body><br><br><br><br><br><br><br><br></body></html>"));
        cadastro.add(voltar);
        cadastro.add(cadastrar);
        cadastro.add(labelnome);
        cadastro.add(fieldNome);
        cadastro.add(labelsenha);
        cadastro.add(fieldSenha);
        cadastro.add(confirmarcadastro);
        cadastro.add(errocadastro);
        main.add(cadastro);
        cadastro.setVisible(false);
    }
    JLabel errologin = new JLabel("Usuario ou senha incorreto!");
    JLabel cadSucesso = new JLabel("<html><body><div style='text-align: center;'>Cadastrado com sucesso!<br>Agora faca login!</div></body></html>");
    private void criarlogin(){ // pagina de login
        JLabel facalogin = new JLabel("<html><body><div style='text-align: center;'><br><br><br><br><br><br>Digite os seus dados<br>para fazer login:<br><br><br></div></body></html>");
        facalogin.setFont(fonte);
        facalogin.setForeground(Color.black);
        fieldNomeL.setBackground(Color.white);
        fieldNomeL.setForeground(Color.black);
        fieldNomeL.setColumns(10);
        fieldNomeL.setBorder(BorderFactory.createLineBorder(Color.black));
        fieldSenhaL.setBackground(Color.white);
        fieldSenhaL.setForeground(Color.black);
        fieldSenhaL.setColumns(10);
        fieldSenhaL.setBorder(BorderFactory.createLineBorder(Color.black));
        confirmarlogin.setBackground(Color.white);
        confirmarlogin.setFocusPainted(false);
        confirmarlogin.addActionListener(this);
        JLabel labelnome = new JLabel("Nome: ");
        JLabel labelsenha = new JLabel("Senha: ");
        errologin.setForeground(Color.red);
        errologin.setVisible(false);
        errologin.setFont(fonteerro);
        cadSucesso.setForeground(Color.blue);
        cadSucesso.setVisible(false);
        cadSucesso.setFont(fonteerro);
        login.setBackground(Color.white);
        login.setPreferredSize(new Dimension(160,500));
        login.add(new JLabel("<html><body><br><br><br><br><br><br></body></html>"));
        login.add(voltarL);
        login.add(cadSucesso);
        login.add(facalogin);
        login.add(labelnome);
        login.add(fieldNomeL);
        login.add(labelsenha);
        login.add(fieldSenhaL);
        login.add(confirmarlogin);
        login.add(errologin);
        main.add(login);
        login.setVisible(false);
    }

    //JPanel[] itens = new JPanel[2];
    JPanel areaitens = new JPanel();
    JPanel[] itens = new JPanel[2];
    JLabel obrigado = new JLabel("<html><body>Obrigado por sua compra!</body><br><br></html>");
    private void criarcardapio(){ // pagina que aparece quando voce da login
        areaitens.setLayout(new FlowLayout(FlowLayout.CENTER));
        obrigado.setFont(fonte);
        obrigado.setBackground(Color.white);
        obrigado.setPreferredSize(new Dimension(500, 20));
        JLabel bemvindo = new JLabel("<html><body><div style='text-align: center;'><br><br><br>Bom dia!<br>O que voce deseja hoje?</div></body></html>");
        bemvindo.setFont(fonte);
        bemvindo.setForeground(Color.black);

        JTextArea hb1 = new JTextArea("Muito bom esse\nPreco: R$23.99\nAcompanha refri e batata");
        JTextArea hb2 = new JTextArea("Pao carne e salada\nPreco: R$17.99\nAcompanha refri e batata");
        hb2.setBackground(Color.lightGray);
        hb1.setBackground(Color.lightGray);
        hb1.setFont(fonte);
        hb2.setFont(fonte);
        comprado.setBackground(Color.white);
        comprado.setFocusPainted(false);
        comprado.addActionListener(this);
        comprado2.setBackground(Color.white);
        comprado2.setFocusPainted(false);
        comprado2.addActionListener(this);
        itens[0] = new JPanel();
        itens[0].setPreferredSize(new Dimension(200, 300)); // podia transforma isso num loop
        itens[0].setBackground(Color.lightGray);
        itens[0].setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        itens[0].add(fotohb1I);
        itens[0].add(hb1);
        itens[0].add(comprado);
        itens[1] = new JPanel();
        itens[1].setPreferredSize(new Dimension(200, 300));
        itens[1].setBackground(Color.lightGray);
        itens[1].setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        itens[1].add(fotohb2I);
        itens[1].add(hb2);
        itens[1].add(comprado2);
        areaitens.setPreferredSize(new Dimension(800, 350));
        areaitens.setBackground(Color.white);
        cardapio.setBackground(Color.lightGray);
        cardapio.setPreferredSize(new Dimension(800, 500));
        cardapio.setBackground(Color.white);
        logout.setBackground(Color.white);
        logout.setFocusPainted(false);
        logout.addActionListener(this);

        obrigado.setVisible(false);
        cardapio.setVisible(false);
        cardapio.add(bemvindo);
        areaitens.add(itens[0]);
        areaitens.add(itens[1]);
        areaitens.add(obrigado);
        cardapio.add(areaitens);
        cardapio.add(logout);

        main.add(cardapio);
    }

    private void levarPagLogin(){
        menu.setVisible(false);
        cadastro.setVisible(false);
        login.setVisible(true);
        cardapio.setVisible(false);
        voltarL.setVisible(true);
    }
    private void levarPagCad(){
        menu.setVisible(false);
        cadastro.setVisible(true);
        login.setVisible(false);
        cardapio.setVisible(false);
        voltar.setVisible(true);
    }
    private void levarCardapio(){
        menu.setVisible(false);
        cadastro.setVisible(false);
        login.setVisible(false);
        cardapio.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}