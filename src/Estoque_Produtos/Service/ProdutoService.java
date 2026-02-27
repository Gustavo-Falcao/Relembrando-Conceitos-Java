package Estoque_Produtos.Service;

import Estoque_Produtos.Exceptions.ValidationException;
import Estoque_Produtos.Helpers.LogUser;
import Estoque_Produtos.Produto;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ProdutoService {

    private Map<String,Produto> produtos;

    public ProdutoService() {
        produtos = new HashMap<>(Map.ofEntries(
                Map.entry("A1", new Produto("A1", "Água Mineral 500ml", 3.50, 0)),
                Map.entry("B12", new Produto("B12", "Banana (kg)", 6.90, 3)),
                Map.entry("TENIS-001", new Produto("TENIS-001", "Tênis Corrida Básico", 299.90, 8)),
                Map.entry("CAMISA-DRY-01", new Produto("CAMISA-DRY-01", "Camiseta Dry-Fit Branca", 69.90, 120)),
                Map.entry("GEL-ENER-30G", new Produto("GEL-ENER-30G", "Gel Energético 30g", 9.99, 2)),
                Map.entry("MEIA-SPORT-38", new Produto("MEIA-SPORT-38", "Meia Esportiva (38–42)", 19.90, 1)),
                Map.entry("REL-SPORT-02", new Produto("REL-SPORT-02", "Relógio Esportivo GPS", 1499.00, 15)),
                Map.entry("FONE-BT-01", new Produto("FONE-BT-01","Fone Bluetooth Esportivo", 159.90, 0)),
                Map.entry("CORD-PULAR-02", new Produto("CORD-PULAR-02", "Corda de Pular Ajustável", 29.90, 4)),
                Map.entry("SQUEEZE-750", new Produto("SQUEEZE-750", "Squeeze 750ml", 24.50, 200)),
                Map.entry("LIVRO-JAVA-01", new Produto("LIVRO-JAVA-01", "Livro: Java para Devs (Edição 2024)", 119.90, 5)),
                Map.entry("KIT-RECUP-01", new Produto("KIT-RECUP-01", "Kit Recuperação (Rolo + Bola + Mini Band)", 189.90, 7))
        ));
    }

    public Map<String,Produto> getProdutos() {
        return produtos;
    }

    public void cadastrarProduto(Produto produto) {

        if(produtos.containsKey(produto.getSku())) {
            throw new ValidationException("Cadastro bloqueado: SKU já existe | sku=" + produto.getSku());
        }

        if(produto.getPreco() < 0) {
            throw new ValidationException("Validação falhou: preco inválido | preco=" + produto.getPreco());
        }

        if(produto.getQuantidade() < 0) {
            throw new ValidationException("Entrada inicial rejeitada: quantidade inváldida | sku=" + produto.getSku() + "add=" + produto.getQuantidade());
        }

        produtos.put(produto.getSku(), produto);
    }

    public Optional<Produto> findProdutoByKey(String key) {
        return Optional.ofNullable(produtos.get(key));
    }

    public void deleteProduto(String key) {
        findProdutoByKey(key).ifPresentOrElse( produto -> {
                produtos.remove(key, produto);
                LogUser.logSucesso("Produto excluido com sucesso!!");
                //LogUser.logHistorico("DELETE PRODUTO - SKU " + key);
            },
                () -> {
                    LogUser.logErro("Produto não encontrado!!");
                    //LogUser.logHistorico("Tentativa de exclusão de produto sem sucesso - [SKU inválido]");
                }
        );
    }

    public void addEstoque(String key, int quantidadeAddEstoque) {
        findProdutoByKey(key).ifPresentOrElse(produto -> {
                produto.setQuantidade(produto.getQuantidade() + quantidadeAddEstoque);
                LogUser.logSucesso("Produto atualizado com sucesso!!");
                //LogUser.logHistorico("ENTRADA " + quantidadeAddEstoque + " - SKU " + produto.getSku());
            },
                () -> {
                    LogUser.logErro("Produto não encontrado!!");
                    //LogUser.logHistorico("Tentativa de entrada de estoque sem sucesso - [SKU inválido]");
                }
        );
    }

    public void saidaEstoque(String key, int quantidadeSaidaEstoque) {
        findProdutoByKey(key).ifPresentOrElse(produto -> {
            produto.setQuantidade(produto.getQuantidade() - quantidadeSaidaEstoque);
            LogUser.logSucesso("Produto atualizado com sucesso!!");
            //LogUser.logHistorico("SAIDA " + quantidadeSaidaEstoque + " - SKU " + produto.getSku());
            },
                () -> {
                    LogUser.logErro("Produto não encontrado!!");
                    //LogUser.logHistorico("Tentativa de saida de estoque sem sucesso - [SKU inválido]");
                }
        );
    }
}
