import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoIMDB implements ExtratorDeConteudo {

	public List<Conteudo> extraiConteudos(String json) {
        // extrair s� os dados que interessam (titulo, poster, classifica��o)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        return listaDeAtributos.stream()
        .map(atributos -> new Conteudo(atributos.get("title"), atributos.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg")))
        .toList();

   }
}
