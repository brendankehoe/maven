package org.ericsson.training.entities;

import java.util.Set;
import javax.persistence.*;

@Entity @Table(name="compact_discs")
public class CompactDisc {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="title")
	private String title;
	@Column(name="artist")
	private String artist;
	@Column(name="price")
	private double price;
	@Column(name="tracks")
	private int tracks;
	@OneToMany(mappedBy="cdId")
	private Set<Track> trackTitles;
	
	public CompactDisc() {
		
	}
	
	public CompactDisc(int id) {
		this.id = id;		
	}
	
	
	public void addTrack(Track t) { 
		 t.setDisc(this); 
		 trackTitles.add(t); 
	} 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getTracks() {
		return tracks;
	}
	public void setTracks(int tracks) {
		this.tracks = tracks;
	}
	
	public Set<Track> getTrackTitles() {
		return trackTitles;
	}
	public void setTrackTitles(Set<Track> trackTitles) {
		this.trackTitles = trackTitles;
	}
	
}
