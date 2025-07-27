public class Main {

    public static void main(String[] args) {

        Iphone iphone = new Iphone();

        String musica = "nome da música";
        String telefone = "99999-9999";
        String paginaWeb = "https://site.com.br";


        iphone.tocar();
        iphone.pausar();
        iphone.selecionarMusica(musica);

        iphone.ligar(telefone);
        iphone.atender();
        iphone.iniciarCorreioVoz();

        iphone.exibirPagina(paginaWeb);
        iphone.adicionarNovaAba();
        iphone.atualizarPagina();
    }
}
