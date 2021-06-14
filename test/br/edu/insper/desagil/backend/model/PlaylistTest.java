package br.edu.insper.desagil.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlaylistTest {
	private static double DELTA = 0.000001;
	private Artist a;
	private Track t1;
	private Playlist p;

	

	@BeforeEach
	void setUp() {
		a = new Artist("Olivia Rodrigo");
		t1 = new Track(a, "Good4You", 0);
		t2 = new Track(a, "Dejavu", 0);
		ts = new ArrayList<>();
		r = new HashMap<>();
		p = new Playlist(123);
	}

	@Test
	void testRoundDownToZero() {
		p.addTrack(t1);
		p.putRating("rodrigo", 1);
		p.putRating("hashi", 2);
		p.putRating("carol", 3);
		p.putRating("nati", 3);
		
		assertEquals(2.0 , p.averageRatings());
	}

	@Test
	void testRoundUpToHalf() {
		p.addTrack(t1);
		p.putRating("rodrigo", 1);
		p.putRating("hashi", 2);
		p.putRating("carol", 1);
		
		assertEquals(1.5 , p.averageRatings());
	}

	@Test
	void testRoundDownToHalf() {
		p.addTrack(t1);
		p.putRating("rodrigo", 1);
		p.putRating("hashi", 2);
		p.putRating("carol", 2);
		
		assertEquals(1.5 , p.averageRatings());
	}

	@Test
	void testRoundUpToOne() {
		p.addTrack(t1);
		p.putRating("rodrigo", 1);
		p.putRating("hashi", 1);
		p.putRating("carol", 2);
		p.putRating("nati", 3);
		
		assertEquals(2.0 , p.averageRatings());
	}
}
