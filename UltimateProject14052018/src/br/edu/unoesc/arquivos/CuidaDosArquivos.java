package br.edu.unoesc.arquivos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CuidaDosArquivos<T> {

	private String path;

	public CuidaDosArquivos(String path) {
		this.path = path;
	}

	public void gravar(List<T> dados) {
		try (FileOutputStream file = new FileOutputStream(path);
				ObjectOutputStream out = new ObjectOutputStream(file)) {
			out.writeObject(dados);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> recuperar() {
		try (FileInputStream file = new FileInputStream(path); ObjectInputStream in = new ObjectInputStream(file)) {
			return (List<T>) in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
}