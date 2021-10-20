package com.trip.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Maintenence {

	public Maintenence(String maintenenceName, String maintenenceOwner, LocalDate maintenenceStartDate,
			LocalDate maintenenceEndDate, Priority maintenencePriority, Status maintenenceStatus) {
		super();
		this.maintenenceName = maintenenceName;
		this.maintenenceOwner = maintenenceOwner;
		this.maintenenceStartDate = maintenenceStartDate;
		this.maintenenceEndDate = maintenenceEndDate;
		this.maintenencePriority = maintenencePriority;
		this.maintenenceStatus = maintenenceStatus;
	}


	@Id
	@GeneratedValue(generator = "maintenence_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "maintenence_gen", sequenceName = "maintenence_seq", allocationSize = 1, initialValue = 1)
	private Integer maintenenceId;
	@Column(length = 30)
	private String maintenenceName;
	@Column(length = 30)
	private String maintenenceOwner;
	private LocalDate maintenenceStartDate;
	private LocalDate maintenenceEndDate;
	@Enumerated(EnumType.STRING)
	private Priority maintenencePriority;
	
	@Column(length = 30)
	@Enumerated(EnumType.STRING)
	private Status maintenenceStatus;

	@ManyToOne
	@JoinColumn(name = "trip_id")
	private Trip trip;
	

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) 
	@JoinColumn(name = "maintenencet_id")
	@JsonIgnore
	private Set<Task> taskList;
	

}
