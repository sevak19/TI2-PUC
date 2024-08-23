package app;

import java.util.List;
import java.util.Scanner;

import dao.DAO;
import dao.UsuarioDAO;
import model.Usuario;

public class Aplicacao {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		int escolhaMENU = 0, escolha = 0, codigo;
		
		while(escolhaMENU != 5) {
			
			System.out.println("\n\n==== MENU === ");
			System.out.println("\n 1) Listar");
			System.out.println("\n 2) Inserir");
			System.out.println("\n 3) Excluir");
			System.out.println("\n 4) Atualizar");
			System.out.println("\n 5) Sair");
			System.out.println("\n============= ");
			
			escolhaMENU = sc.nextInt();
			
			switch (escolhaMENU) {
            	case 1:
                
            		System.out.println("Opção 1 selecionada: Listar itens.");
            		System.out.println("\n\n==== SUBMENU === ");
            		System.out.println("\n 1) Listar usuários do sexo masculino");
            		System.out.println("\n 2) Listar usuários do sexo feminino");
            		System.out.println("\n 3) Listar todos os usuários ordenados por código");
            		System.out.println("\n 4) Listar todos os usuários ordenados por login");
            		System.out.println("\n 5) Voltar");
            		System.out.println("\n============= ");
    			
            		escolha = sc.nextInt();
            		
            		switch(escolha) {
	            		case 1:
	                        System.out.println("\n\n==== Listar usuários do sexo masculino === ");
	                		List<Usuario> usuarios = usuarioDAO.getSexoMasculino();
	                		for (Usuario u: usuarios) {
	                			System.out.println(u.toString());
	                		}
	                        break;
	
	                    case 2:
	                    	System.out.println("\n\n==== Listar usuários do sexo feminino === ");
	                		List<Usuario> usuarios2 = usuarioDAO.getSexoFeminino();
	                		for (Usuario u: usuarios2) {
	                			System.out.println(u.toString());
	                		}
	                        break;
	
	                    case 3:
	                    	System.out.println("\n\n==== Mostrar todos os usuários ordenados por código === ");
	                		usuarios = usuarioDAO.getOrderByCodigo();
	                		for (Usuario u: usuarios) {
	                			System.out.println(u.toString());
	                		}
	                        break;
	
	                    case 4:
	                    	System.out.println("\n\n==== Mostrar todos os usuários ordenados por login === ");
	                		usuarios = usuarioDAO.getOrderByLogin();
	                		for (Usuario u: usuarios) {
	                			System.out.println(u.toString());
	                		}
	                        break;
	
	                    case 5:
	                        System.out.println("Voltando ao menu principal...");
	                        break;
	
	                    default:
	                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
	                        break;
            				
            		}
    			
            		break;

            	case 2:
            		System.out.println("\n\n==== Inserir usuário === ");
                    
                    System.out.print("Digite o codigo do usuário: ");
                    codigo = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.print("Digite o login do novo usuário: ");
                    String login = sc.nextLine();
                    
                    System.out.print("Digite a senha do novo usuário: ");
                    String senha = sc.nextLine();
                    
                    System.out.print("Digite o sexo do usuário (M/F): ");
                    char sexo = sc.next().charAt(0);
            		
            		Usuario usuario = new Usuario(codigo, login, senha, sexo);
            		if(usuarioDAO.insert(usuario) == true) {
            			System.out.println("Inserção com sucesso -> " + usuario.toString());
            		}
            		
            		break;

            	case 3:
            		System.out.println("\n\n==== Excluir usuário === ");
                    
                    System.out.print("Digite o codigo do usuário que deseja excluir: ");
                    int codigo1 = sc.nextInt();
                    sc.nextLine();
            		
            		usuarioDAO.delete(codigo1);
            		
            		break;

            	case 4:
                    
            		System.out.println("Opção 4 selecionada: Atualizar itens.");
            		System.out.println("\n\n==== SUBMENU === ");
            		System.out.println("\n 1) Atualizar login");
            		System.out.println("\n 2) Atualizar senha");
            		System.out.println("\n 3) Atualizar sexo");
            		System.out.println("\n 4) Voltar");
            		System.out.println("\n============= ");
    			
            		escolha = sc.nextInt();
            		
            		switch(escolha) {
	            		case 1:
	                        System.out.print("Digite o codigo do usuário para atualizar o login: ");
	                        codigo = sc.nextInt();
	                        sc.nextLine();
	                        
	                        System.out.print("Digite o novo login: ");
	                        String novoLogin = sc.nextLine();
	                        
	                        Usuario usuario3 = usuarioDAO.get(codigo);
	                        
	                        usuario3.setLogin(novoLogin);
	                        usuarioDAO.update(usuario3);
	                        
	                        break;
	                        
	                    case 2:
	                        System.out.print("Digite o codigo do usuário para atualizar a senha: ");
	                        codigo = sc.nextInt();
	                        sc.nextLine();
	                        
	                        System.out.print("Digite a nova senha: ");
	                        String novaSenha = sc.nextLine();
	                        
	                        Usuario usuario4 = usuarioDAO.get(codigo);
	                        
	                        usuario4.setSenha(novaSenha);
	                        usuarioDAO.update(usuario4);
	                        
	                        break;
	                        
	                    case 3:
	                        System.out.print("Digite o codigo do usuário para atualizar o sexo: ");
	                        codigo = sc.nextInt();
	                        sc.nextLine();
	                        
	                        System.out.print("Digite o novo sexo (M/F): ");
	                        char novoSexo = sc.next().charAt(0);
	                        
	                        Usuario usuario5 = usuarioDAO.get(codigo);
	                        
	                        usuario5.setSexo(novoSexo);
	                        usuarioDAO.update(usuario5);
	                        
	                        break;
	                        
	                    case 4:
	                        System.out.println("Voltando ao menu principal...");
	                        
	                        break;
	                        
	                    default:
	                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
	                        
	                        break;
	            			
            		}
            		
            		break;

            	case 5:
            		System.out.println("Opção 5 selecionada: Sair.");
            		
            		break;

            	default:
            		System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            		
            		break;
            	
			}
		}
		sc.close();
	}
}