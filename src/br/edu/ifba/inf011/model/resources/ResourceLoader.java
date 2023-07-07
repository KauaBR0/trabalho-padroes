package br.edu.ifba.inf011.model.resources;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.model.decoratorpattern.*;

public class ResourceLoader {

	public static String DIR_NAME = "C:\\Users\\Zetsu\\Desktop\\trabalho-padroes-main\\src\\br\\edu\\ifba\\inf011\\model\\resources\\data\\";

	public static ResourceLoader loader;

	public static ResourceLoader instance() {
		if(ResourceLoader.loader == null)
			ResourceLoader.loader = new ResourceLoader();
		return ResourceLoader.loader;
	}
	
	public Music comLetraCifra(String nome) throws IOException {
		return new MusicLetra(new MusicNotas(new MusicTitulo(nome)));
	}

	public Music ComLetraCifraTraducao(String nome, String idioma) throws IOException {
		return new MusicTraducao(new MusicLetra(new MusicNotas(new MusicTitulo(nome))), idioma);
	}

	public Music ComLetraTraducao(String nome, String idioma) throws IOException {
		return new MusicLetra(new MusicTraducao(new MusicTitulo(nome), idioma));
	}

	public Music ComCifra(String nome) throws IOException {
		return new MusicNotas(new MusicTitulo(nome));
	}
	
	public List<String> loadNotas(String nome) throws IOException {
		return this.loadResource(nome, "notas");
	}
	
	public List<String> loadLetra(String nome) throws IOException {
		return this.loadResource(nome, "letra");
	}

	public List<String> traducao(String nome, String idioma) throws IOException {
		return this.loadResource(nome, idioma);
	}

	public List<String> loadResource(String nome, String extensao) throws IOException {
		List<String> resource = new ArrayList<String>();
        Path path = Paths.get(ResourceLoader.DIR_NAME + nome + "." + extensao);
        Files.lines(path, StandardCharsets.ISO_8859_1).forEach(resource::add);
        return resource;
	}

}
