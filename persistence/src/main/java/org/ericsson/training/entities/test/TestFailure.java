package org.ericsson.training.entities.test;

import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.ericsson.training.entities.CallFailure;
import org.ericsson.training.entities.Cause;
import org.ericsson.training.entities.Equipment;
import org.ericsson.training.entities.CompactDisc;

public class TestFailure {

	public static void main(String args[]) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("conygre");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Equipment equipment = createEquipment();
		CallFailure callFailure = createCallFailure();
		em.merge(callFailure);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public static CallFailure createCallFailure() {
		// return new
		// CallFailure.Builder().cause(createCause()).equipment(createEquipment())
		// .failureClass(null).build();
		return new CallFailure.Builder().cause(null).equipment(null)
				.failureClass(null).build();
	}

	public static Equipment createEquipment() {
		return new Equipment.Builder().tAC(2).marketingName("c")
				.manufacturer("b").build();
		// .manufacturer(getManufacturer(rowNumber))
		// .accessCapability(getAccessCapability(rowNumber))
		// .model(getModel(rowNumber))
		// .vendorName(getVendorName(rowNumber))
		// .equipmentType(getEquipmentType(rowNumber))
		// .operatingSystem(getOperatingSystem(rowNumber))
		// .inputMode(getInputMode(rowNumber))
	}

	public static Cause createCause() {
		return new Cause.Builder().causeCode(2).eventId(4).description("b")
				.build();
	}

	private static void test1(EntityManager em) {
		Query q = em.createQuery("select c from CompactDisc c");
		Iterator iter = q.getResultList().iterator();
		while (iter.hasNext()) {
			CompactDisc cd = (CompactDisc) iter.next();
			System.out.println("Found a cd with id " + cd.getId()
					+ " and by the artist " + cd.getArtist());
		}
	}

	private static void test2(EntityManager em) {
		Query q = em.createQuery("select c from CompactDisc c where c.id=16");
		Iterator iter = q.getResultList().iterator();
		while (iter.hasNext()) {
			CompactDisc cd = (CompactDisc) iter.next();
			System.out.println("Found a cd with id " + cd.getId()
					+ " and by the artist " + cd.getArtist());
		}
	}

}
