package com.luv2code.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
	
	//annotate the class as entity and map it to DB
	
	//define the fields and //annotate the fields to DB columns
	
	//create constructors
	
	//generate setters and getters

	//generate toString() method

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	@Column(name="hobby")
	private String hobby;
	
	//Bi Directional Mapping setup
		//If you want to delete instructor using instructor detail then use
		// @OneToOne(mappedBy="instructorDetail",cascade=CascadeType.ALL)
	
		//If one does not want to delete instructor data using instructor detail then:
	@OneToOne(mappedBy="instructorDetail",
			cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private Instructor theInstructor;
	
	public InstructorDetail() {
		
	}

	public InstructorDetail(String youtubeChannel, String hobby) {

		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}


	public Instructor getTheInstructor() {
		return theInstructor;
	}

	public void setTheInstructor(Instructor theInstructor) {
		this.theInstructor = theInstructor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}
	

}
