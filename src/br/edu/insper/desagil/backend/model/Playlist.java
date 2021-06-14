package br.edu.insper.desagil.backend.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Playlist {
	private int id;
	private List<Track> tracks;
	private Map<String, Integer> ratings;
	
	public Playlist(int id) {
		this.id = id;
		this.tracks = new ArrayList<>();
		this.ratings = new HashMap<>();
	}

	public int getId() {
		return id;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public Map<String, Integer> getRatings() {
		return ratings;
	}

	public void addTrack(Track track) {
		this.tracks.add(track);
		
	}
	
	public void putRating(String name, int avaliacao) {
		this.ratings.put(name, avaliacao);
	}
	
	public double averageRatings() {
		double soma = 0.0;
		int contador = 0;
		double media;
		for (int avaliacao: ratings.values()) {
			soma += avaliacao;
			contador += 1;
		}
		
		media = soma / contador;
		
		int inteira = (int) media;
		double fracionaria = media - inteira;
		
		if (fracionaria < 0.26) {
			return (double) inteira;
		}
		else if(fracionaria < 0.74) {
			return (double) inteira + 0.5;
		}
		else {
			return (double) inteira + 1.0;
		}
	}
	
	
	

}
