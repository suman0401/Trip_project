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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Task {

	@Id
	@GeneratedValue(generator = "task_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "task_gen", sequenceName = "task_seq", initialValue = 1, allocationSize = 1)
	private Integer taskId;
	@Column(length = 40)
	private String taskName;
	@Column(length = 40)
	private String taskOwner;
	private LocalDate taskStartDate;
	private LocalDate taskEndDate;
	@Column(length = 40)
	@Enumerated(EnumType.STRING)
	private Priority taskPriority;
	@Column(length = 40)
	private String taskDuration;
	@Column(length = 40)
	@Enumerated(EnumType.STRING)
	private Status taskStatus;
//	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	@JoinColumn(name = "task_id")
//	private Set<Workers> workersList;
	@ManyToOne
	@JoinColumn(name = "maintenence_id")
	private Maintenence maintenence;
	@ManyToOne
	@JoinColumn(name = "trip_id")
	private Trip trip;




}
