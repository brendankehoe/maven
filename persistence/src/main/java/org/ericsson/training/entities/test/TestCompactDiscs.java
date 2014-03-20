package org.ericsson.training.entities.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.ericsson.training.entities.CompactDisc;
import org.ericsson.training.entities.Track;

public class TestCompactDiscs {

	public static void main(String args[]) {
		
		CompactDisc disc = new CompactDisc(5);
		disc.setArtist("Muse");
		disc.setPrice(19.99);
		disc.setTitle("Absolution");
		disc.setTracks(9);
		Set<Track> tracks = new HashSet<Track>();
		Track track1 = new Track();
		track1.setCdId(1);
		track1.setDisc(disc);
		track1.setId(5);
		track1.setTitle("Track 1");
		disc.setTrackTitles(tracks);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("conygre");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		test1(em);
//		test2(em);
//		CompactDisc disc = createDisc();
		em.merge(disc);
		em.merge(track1);
//		em.persist(disc);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
//	public static CompactDisc createDisc() {
//		CompactDisc disc = new CompactDisc(1);
//		disc.setArtist("Muse");
//		disc.setPrice(19.99);
//		disc.setTitle("Absolution");
//		disc.setTracks(9);
//		Set<Track> tracks = new HashSet<Track>();
//		Track track1 = new Track();
//		track1.setCdId(1);
//		track1.setDisc(disc);
//		track1.setId(1);
//		track1.setTitle("Track 1");
//		disc.setTrackTitles(tracks);
//		return disc;
//	}
	
	private static void test1(EntityManager em) {
		Query q = em.createQuery("select c from CompactDisc c");
		Iterator iter = q.getResultList().iterator();
	    while(iter.hasNext())
	    {
	      CompactDisc cd = (CompactDisc)iter.next();
	      System.out.println("Found a cd with id " + cd.getId() + " and by the artist " + cd.getArtist());
	    }
	}
	
	private static void test2(EntityManager em) {
		Query q = em.createQuery("select c from CompactDisc c where c.id=16");
		Iterator iter = q.getResultList().iterator();
	    while(iter.hasNext())
	    {
	      CompactDisc cd = (CompactDisc)iter.next();
	      System.out.println("Found a cd with id " + cd.getId() + " and by the artist " + cd.getArtist());
	    }
	}
	
}
