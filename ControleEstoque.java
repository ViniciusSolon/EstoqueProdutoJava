import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class ControleEstoque {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Produto> listaProdutos = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("=== Sistema de Controle de Estoque ===");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Movimentar Estoque");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    realizarMovimentacaoEstoque();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }

    private static void cadastrarProduto() {
        System.out.println("\n=== Cadastro de Produto ===");
        System.out.print("Nome do Produto: ");
        String nome = scanner.nextLine();

        // Gerar código único para o produto usando UUID
        String codigo = UUID.randomUUID().toString();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();

        Produto produto = new Produto(nome, codigo, descricao, categoria, 0);
        listaProdutos.add(produto);

        System.out.println("Produto cadastrado com sucesso!\n");
    }

    private static void listarProdutos() {
        System.out.println("\n=== Lista de Produtos ===");
        if (listaProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.\n");
        } else {
            for (Produto produto : listaProdutos) {
                System.out.println("Nome: " + produto.getNome());
                System.out.println("Código: " + produto.getCodigo());
                System.out.println("Descrição: " + produto.getDescricao());
                System.out.println("Categoria: " + produto.getCategoria());
                System.out.println("Quantidade em Estoque: " + produto.getQuantidadeEmEstoque());
                System.out.println("------------------------");
            }
        }
    }

    private static void realizarMovimentacaoEstoque() {
        System.out.print("\nInforme o código do produto: ");
        String codigoProduto = scanner.nextLine();

        Produto produtoEncontrado = buscarProdutoPorCodigo(codigoProduto);

        if (produtoEncontrado != null) {
            System.out.print("1. Registrar Entrada\n2. Registrar Saída\n3. Rastrear Produto por Lote\nEscolha uma opção: ");
            int opcaoMovimentacao = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoMovimentacao) {
                case 1:
                    registrarEntrada(produtoEncontrado);
                    break;
                case 2:
                    registrarSaida(produtoEncontrado);
                    break;
                case 3:
                    rastrearProdutoPorLote(produtoEncontrado);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static Produto buscarProdutoPorCodigo(String codigo) {
        for (Produto produto : listaProdutos) {
            if (produto.getCodigo().equals(codigo)) {
                return produto;
            }
        }
        return null;
    }

    private static void registrarEntrada(Produto produto) {
        System.out.print("Informe a quantidade de entrada: ");
        int quantidadeEntrada = scanner.nextInt();
        scanner.nextLine();

        produto.atualizarQuantidadeEmEstoque(quantidadeEntrada);

        System.out.println("Entrada registrada com sucesso.");
        System.out.println("Nova quantidade em estoque: " + produto.getQuantidadeEmEstoque() + "\n");
    }

    private static void registrarSaida(Produto produto) {
        System.out.print("Informe a quantidade de saída: ");
        int quantidadeSaida = scanner.nextInt();
        scanner.nextLine();

        if (quantidadeSaida > produto.getQuantidadeEmEstoque()) {
            System.out.println("Quantidade indisponível em estoque.");
        } else {
            produto.atualizarQuantidadeEmEstoque(-quantidadeSaida);
            System.out.println("Saída registrada com sucesso.");
            System.out.println("Nova quantidade em estoque: " + produto.getQuantidadeEmEstoque() + "\n");
        }
    }

    private static void rastrearProdutoPorLote(Produto produto) {
        // Implemente a lógica para rastrear por lote, se aplicável
        System.out.println("Rastreamento de produtos por lote.");
    }
}
