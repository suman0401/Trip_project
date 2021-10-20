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
@Entity
@ToString
public class Trip {

	@Id
	@GeneratedValue(generator = "trip_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "trip_gen", sequenceName = "trip_seq", initialValue = 1, allocationSize = 1)
	private Integer tripId;
	@Column(length = 40)
	private String tripName;
	@Column(length = 40)
	private String tripOwner;
	private LocalDate tripStartDate;
	private LocalDate tripEndDate;
	@Column(length = 40)
	@Enumerated(EnumType.STRING)
	private Priority tripPriority;
	@Column(length = 40)
	@Enumerated(EnumType.STRING)
	private Status tripStatus;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "trip",fetch=FetchType.EAGER)
	private Set<Maintenence> maintenece;

	public Trip(String tripName, String tripOwner, LocalDate tripStartDate, LocalDate tripEndDate,
			Priority tripPriority, Status tripStatus) {
		super();
		this.tripName = tripName;
		this.tripOwner = tripOwner;
		this.tripStartDate = tripStartDate;
		this.tripEndDate = tripEndDate;
		this.tripPriority = tripPriority;
		this.tripStatus = tripStatus;
	}

	@Override
	public String toString() {
		return "Trip [tripName=" + tripName + ", tripOwner=" + tripOwner + ", tripStartDate=" + tripStartDate
				+ ", tripEndDate=" + tripEndDate + ", tripPriority=" + tripPriority + ", tripStatus=" + tripStatus
				+ "]";
	}

}
