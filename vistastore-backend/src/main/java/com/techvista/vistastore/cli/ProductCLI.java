package com.techvista.vistastore.cli;

import com.techvista.vistastore.domain.model.ProductModel;
import com.techvista.vistastore.application.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class ProductCLI {
    private final ProductService productService;
    private final Scanner scanner = new Scanner(System.in);

//    public void showProductMenu() {
//        boolean running = true;
//        while (running) {
//            try {
//            System.out.println("\n=== Menu de Produtos ===");
//            System.out.println("1. Listar Produtos");
//            System.out.println("2. Adicionar Produto");
//            System.out.println("3. Atualizar Produto");
//            System.out.println("4. Remover Produto");
//            System.out.println("5. Verificar Estoque");
//            System.out.println("6. Voltar");
//            System.out.print("Escolha uma opção: ");
//
//            String input = scanner.nextLine();
//            int option = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (option) {
//                case 1:
//                    listProducts();
//                    break;
//                case 2:
//                    addProduct();
//                    break;
//                case 3:
//                    updateProduct();
//                    break;
//                case 4:
//                    deleteProduct();
//                    break;
//                case 5:
//                    checkStock();
//                    break;
//                case 6:
//                    running = false;
//                    break;
//                default:
//                    System.out.println("Opção inválida!");
//            } catch (NumberFormatException e) {
//                System.out.println("Por favor, digite um número válido.");
//            } catch (Exception e) {
//                System.out.println("Erro: " + e.getMessage());
//            }
//        }
//    }
//
//    private void listProducts() {
//        System.out.println("\n=== Lista de Produtos ===");
//        productService.findAllProducts().forEach(product ->
//                System.out.printf("ID: %d | Nome: %s | Código: %s | Preço: R$%.2f | Estoque: %d%n",
//                        product.getId(), product.getName(), product.getBarCode(),
//                        product.getPrice(), product.getStock())
//        );
//    }
//
//    private void addProduct() {
//        try {
//            ProductModel product = new ProductModel();
//
//            System.out.print("Nome: ");
//            product.setName(scanner.nextLine());
//
//            System.out.print("Descrição: ");
//            product.setDescription(scanner.nextLine());
//
//            System.out.print("Código de Barras: ");
//            product.setBarCode(scanner.nextLine());
//
//            System.out.print("Preço: ");
//            product.setPrice(Double.parseDouble(scanner.nextLine()));
//
//            System.out.print("Quantidade em estoque: ");
//            product.setStock(Integer.parseInt(scanner.nextLine()));
//
//            ProductModel savedProduct = productService.saveProduct(product);
//            System.out.println("Produto adicionado com sucesso! ID: " + savedProduct.getId());
//        } catch (NumberFormatException e) {
//            System.out.println("Erro: Digite um número válido para preço e estoque");
//        } catch (Exception e) {
//            System.out.println("Erro ao adicionar produto: " +
//                    (e.getMessage() != null ? e.getMessage() : "Erro desconhecido"));
//        }
//    }
//


    public void showProductMenu() {
        boolean running = true;
        while (running) {
            try {
                System.out.println("\n=== Menu de Produtos ===");
                System.out.println("1. Listar Produtos");
                System.out.println("2. Adicionar Produto");
                System.out.println("3. Atualizar Produto");
                System.out.println("4. Remover Produto");
                System.out.println("5. Verificar Estoque");
                System.out.println("6. Voltar");
                System.out.print("Escolha uma opção: ");

                String input = scanner.nextLine();
                int option = Integer.parseInt(input);

                switch (option) {
                    case 1:
                        listProducts();
                        break;
                    case 2:
                        addProduct();
                        break;
                    case 3:
                        updateProduct();
                        break;
                    case 4:
                        deleteProduct();
                        break;
                    case 5:
                        checkStock();
                        break;
                    case 6:
                        running = false;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido.");
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

    }

    private void listProducts() {
        System.out.println("\n=== Lista de Produtos ===");
        productService.findAllProducts().forEach(product ->
                System.out.printf("ID: %d | Nome: %s | Código: %s | Preço: R$%.2f | Estoque: %d%n",
                        product.getId(), product.getName(), product.getBarCode(),
                        product.getPrice(), product.getStock())
        );
    }

    private void addProduct() {
        try {
            ProductModel product = new ProductModel();

            System.out.print("Nome: ");
            product.setName(scanner.nextLine());

            System.out.print("Descrição: ");
            product.setDescription(scanner.nextLine());

            System.out.print("Código de Barras: ");
            product.setBarCode(scanner.nextLine());

            System.out.print("Preço: ");
            product.setPrice(Double.parseDouble(scanner.nextLine()));

            System.out.print("Quantidade em estoque: ");
            product.setStock(Integer.parseInt(scanner.nextLine()));

            ProductModel savedProduct = productService.saveProduct(product);
            System.out.println("Produto adicionado com sucesso! ID: " + savedProduct.getId());
        } catch (NumberFormatException e) {
            System.out.println("Erro: Digite um número válido para preço e estoque");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar produto: " +
                    (e.getMessage() != null ? e.getMessage() : "Erro desconhecido"));
        }
    }

    private void updateProduct() {
        try {
            System.out.print("ID do produto: ");
            Long id = Long.parseLong(scanner.nextLine());

            ProductModel product = productService.findProductById(id)
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            System.out.print("Novo nome (Enter para manter): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) product.setName(name);

            System.out.print("Nova descrição (Enter para manter): ");
            String description = scanner.nextLine();
            if (!description.isEmpty()) product.setDescription(description);

            System.out.print("Novo preço (Enter para manter): ");
            String priceStr = scanner.nextLine();
            if (!priceStr.isEmpty()) {
                double price = Double.parseDouble(priceStr.replace(",", "."));
                if (price > 0) product.setPrice(price);
            }

            System.out.print("Nova quantidade (Enter para manter): ");
            String stockStr = scanner.nextLine();
            if (!stockStr.isEmpty()) {
                int stock = Integer.parseInt(stockStr);
                if (stock >= 0) product.setStock(stock);
            }

            productService.updateProduct(product);
            System.out.println("Produto atualizado com sucesso!");
        } catch (NumberFormatException e) {
            System.out.println("Erro: Digite um número válido");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void deleteProduct() {
        System.out.print("ID do produto para remover: ");
        Long id = scanner.nextLong();

        try {
            productService.deleteProduct(id);
            System.out.println("Produto removido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao remover produto: " + e.getMessage());
        }
    }

    private void checkStock() {
        System.out.print("ID do produto: ");
        Long id = scanner.nextLong();

        try {
            ProductModel product = productService.findProductById(id)
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            System.out.printf("Produto: %s%nEstoque atual: %d%nPreço: R$%.2f%n",
                    product.getName(), product.getStock(), product.getPrice());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}