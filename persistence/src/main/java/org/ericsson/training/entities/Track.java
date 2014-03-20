package org.ericsson.training.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name="tracks")
public class Track implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="title")
	private String title;
	@Column(name="cd_id", insertable=false, updatable=false) 
	private int cdId;
    @JoinColumn (name="cd_id", referencedColumnName="id")
    @ManyToOne
	private CompactDisc disc;
	
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
	public int getCdId() {
		return cdId;
	}
	public void setCdId(int cdId) {
		this.cdId = cdId;
	}
	public CompactDisc getDisc() {
		return disc;
	}
	public void setDisc(CompactDisc disc) {
		this.disc = disc;
	}
	
}
