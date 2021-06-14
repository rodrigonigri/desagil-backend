package br.edu.insper.desagil.backend.model;

import java.util.ArrayList;
import java.util.List;

public class CollaborationTrack extends Track {
	private List<Artist> collaborators;

	public CollaborationTrack(Artist artist, List<Artist> collaborators, String name, int duration) {
		super(artist, name, duration);
		this.collaborators = collaborators;
	}

	@Override
	public String getFullArtistName() {
		List<String> nomesArtistas = new ArrayList<>();
		for (Artist artista: this.collaborators) {
			nomesArtistas.add(artista.getName());
		}
		
		return getArtist().getName() + " (feat. " + String.join(", ", nomesArtistas) + ")";
	}
}
