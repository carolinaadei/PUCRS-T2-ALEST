import estruturas.ArvoreBinariaPesquisa;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        App app = new App();
        app.rodarAplicacao();
    }

    public void rodarAplicacao() {
        String arquivoEntrada = "entrada.txt";

        int[] chaves = new int[500];
        int cont = 0;

        int chaveBusca = -1;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoEntrada))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = linha.trim();
                if (!linha.isEmpty()) {
                    if (cont >= chaves.length) {
                        System.out.println("Limite máximo de chaves excedido.");
                        return;
                    }
                    chaves[cont++] = Integer.parseInt(linha);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }
        if (cont == 0) {
            System.out.println("Arquivo vazio ou inválido.");
            return;
        }

        chaveBusca = chaves[cont - 1];
        cont--;

        ArvoreBinariaPesquisa abp = new ArvoreBinariaPesquisa();
        for (int i = 0; i < cont; i++) {
            abp.adicionar(chaves[i]);
        }

        String arvore = abp.imprimirArvore();

        escreverArquivo("preordem.txt", "Árvore:\n" + arvore + "\nCaminhamento Pré-Ordem:\n" + abp.caminharPreOrdem());
        escreverArquivo("posordem.txt", "Árvore:\n" + arvore + "\nCaminhamento Pós-Ordem:\n" + abp.caminharPosOrdem());
        escreverArquivo("central.txt", "Árvore:\n" + arvore + "\nCaminhamento Central:\n" + abp.caminharCentral());
        escreverArquivo("largura.txt", "Árvore:\n" + arvore + "\nCaminhamento em Largura:\n" + abp.caminharLargura());

        String resultadoBusca = abp.buscarComRastreamento(chaveBusca);
        String[] partes = resultadoBusca.split(";");
        String nodosVisitados = partes[0];
        int quantidade = Integer.parseInt(partes[1]);
        boolean achou = Boolean.parseBoolean(partes[2]);

        StringBuilder sb = new StringBuilder();
        sb.append("Chave a ser localizada: ").append(chaveBusca).append("\n");
        sb.append("Nodos visitados: ").append(nodosVisitados).append("\n");
        sb.append("Quantidade de nodos visitados: ").append(quantidade).append("\n");
        sb.append(achou ? "Achou" : "Não Achou").append("\n");

        escreverArquivo("resultado.txt", sb.toString());


        System.out.println("Arquivos gerados com sucesso.");
    }

    private void escreverArquivo(String nomeArquivo, String conteudo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo))) {
            bw.write(conteudo.trim());
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo " + nomeArquivo + ": " + e.getMessage());
        }
    }
}