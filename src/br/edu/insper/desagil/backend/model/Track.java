package br.edu.insper.desagil.backend.model;

public class Track {
	private Artist artist;
	private String name;
	private int duration;
	
	public Track(Artist artist, String name, int duration) {
		super();
		this.artist = artist;
		this.name = name;
		this.duration = duration;
	}
	
	public Artist getArtist() {
		return artist;
	}
	
	public String getName() {
		return name;
	}
	
	public int getDuration() {
		return duration;
	}

	public String getDurationString() {
		int minutos, segundos;
		minutos = this.duration/60;
		segundos = this.duration%60;
		if(segundos < 10) {
			return String.valueOf(minutos) + ":" + "0" + String.valueOf(segundos);
		}
		return String.valueOf(minutos) + ":" + String.valueOf(segundos);
		
	}
	
	public String getFullArtistName() {
		return this.artist.getName();
	}
}
