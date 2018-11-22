package com.reader.modelo;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;


/**
 * Classe responsavel por coletar os dados para serem usados na geração do PDF
 */
public class RetanguloPDF {

    private PDFTextStripperByArea stripper;
    private int x;
    private int y;
    private int largura;
    private int altura;
    private String nomeRegiao;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public void setNomeRegiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }

    /**
     * Framework para a criação dos retângulos
     * @param filename - Diretório do PDF desejado
     * @return - Retorna as informações para serem passadas para a classe ArquivoXML chamada pelo main
     */
    public PDFTextStripperByArea parse(String filename) {

        try {

            File file = new File(filename);
            PDDocument document = PDDocument.load(file);
            stripper = new PDFTextStripperByArea();

            criarRegiao(getX(), getY(), getLargura(), getAltura(), getNomeRegiao());


            for (int p = 0; p < document.getNumberOfPages(); p++) {
                stripper.extractRegions(document.getPage(p));
            }

        } catch (InvalidPasswordException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            String texto = stripper.getTextForRegion("cliente");

            System.out.println(texto);

            System.out.println("\n-----------------------------------------------------\n");

//            texto = stripper.getTextForRegion("item");
//
//            System.out.println(texto);

        } catch (NullPointerException npe){
            npe.printStackTrace();
            System.err.println("Não há nada aqui para essa região.");
        }

        return stripper;
    }

    /**
     * Metodo gerado para facilitar na criação dos retangulos
     * @param x - Largura ponto no eixo X de cima para baixo esquerda para direita
     * @param y - Largura ponto no eixo Y de cima para baixo esquerda para direita
     * @param largura - Largura do retângulo criado
     * @param altura - Altura do retângulo criado
     * @param nomeRegiao - Nome desse retângulo
     */
    private void criarRegiao(int x, int y, int largura, int altura, String nomeRegiao) {

        Rectangle2D region = new Rectangle2D.Double(x, y, largura, altura);
        String regionName = nomeRegiao;

        stripper.addRegion(regionName, region);

    }
}
