package com.techvista.vistastore.cli;

import com.techvista.vistastore.application.service.AuthService;
import com.techvista.vistastore.domain.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class AuthCLI implements CommandLineRunner {
    private final AuthService authService;
    private final Scanner scanner = new Scanner(System.in);
    private final ProductCLI productCLI;

    @Override
    public void run(String... args) {
        while (true) {
            System.out.println("\n1. Login\n2. Registrar\n3. Sair");
            System.out.print("Escolha uma opção: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void login() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Senha: ");
        String password = scanner.nextLine();

        try {
            UserModel user = authService.login(username, password);
            System.out.println("Login realizado com sucesso! Bem-vindo " + user.getUsername());
            productCLI.showProductMenu();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void register() {
        UserModel user = new UserModel();
        System.out.print("Username: ");
        user.setUsername(scanner.nextLine());
        System.out.print("Senha: ");
        user.setPassword(scanner.nextLine());
        user.setRole("USER");

        try {
            authService.register(user);
            System.out.println("Usuário registrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}