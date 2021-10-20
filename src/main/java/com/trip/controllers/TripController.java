package com.trip.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trip.model.Maintenence;
import com.trip.model.Priority;
import com.trip.model.Status;
import com.trip.model.Trip;
import com.trip.service.ITripService;

@RestController
@RequestMapping("/trip-service")
public class TripController {
	@Autowired
	ITripService tripService;

	@PostMapping("/trip")
	ResponseEntity<Trip> addTrip(@RequestBody Trip trip) {
		Trip addtrip = tripService.addTrip(trip);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "New trip added ");
		return ResponseEntity.accepted().headers(headers).body(addtrip);

	}

	@PutMapping("/trip")
	ResponseEntity<String> updateTrip(@RequestBody Trip trip) {
		tripService.updateTrip(trip);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Trip updated ");

		return ResponseEntity.ok().headers(headers).body("updated successfully");
	}

	@DeleteMapping("/trip/tripId/{tripId}")
	ResponseEntity<String> deleteTrip(@PathVariable("tripId") int tripId) {
		tripService.deleteTrip(tripId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Trip deleted ");
		return ResponseEntity.ok().headers(headers).body("deleted successfully");
	}

	@GetMapping("/trip")
	ResponseEntity<List<Trip>> getallTrip() {
		List<Trip> alltrips = tripService.getallTrip();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "showing all trip  ");
		return ResponseEntity.ok().headers(headers).body(alltrips);

	}

	@GetMapping("/trip/tripname/{tripname}")
	ResponseEntity<List<Trip>> getBytripName(@PathVariable("tripname") String tripName) {
		List<Trip> tripname = tripService.getByTripName(tripName);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "showing trip by tripname ");
		return ResponseEntity.accepted().headers(headers).body(tripname);
	}

	@GetMapping("/trip/tripowner/{tripowner}")
	ResponseEntity<List<Trip>> getBytripOwner(@PathVariable("tripowner") String tripowner) {
		List<Trip> tripownerlist = tripService.getByTripOwner(tripowner);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "showing trip by tripowner ");
		return ResponseEntity.accepted().headers(headers).body(tripownerlist);

	}

	@GetMapping("/trip/tripstartdate/{availablefrom}")
	ResponseEntity<List<Trip>> getByTripstartDate(@PathVariable("availablefrom") String tripstartdate) {
		List<Trip> tripstartdatelist = tripService.getByTripstartDate(LocalDate.parse(tripstartdate));
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "showing trip by start date ");
		return ResponseEntity.ok().headers(headers).body(tripstartdatelist);

	}

	@GetMapping("/trip/{tripId}")
	ResponseEntity<Trip> getById(@PathVariable("tripId") int tripId) {
		Trip trip = tripService.getById(tripId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "showing trip by ID ");
		return ResponseEntity.ok().headers(headers).body(trip);

	}

	@GetMapping("/trip/priority/{priority}")
	ResponseEntity<List<Trip>> getByTripPriority(@PathVariable("priority") Priority priority) {
		List<Trip> trippriority = tripService.getByTripPriority(priority);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "showing trip by priority ");
		return ResponseEntity.ok().headers(headers).body(trippriority);
	}

	@GetMapping("/trip/status/{status}")
	ResponseEntity<List<Trip>> getByTripStatus(@PathVariable("status") Status status) {
		List<Trip> tripstatus = tripService.getByTripStatus(status);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "showing trip by status ");
		return ResponseEntity.ok().headers(headers).body(tripstatus);
	}
//****************************************************************************************************************//
	// For Maintenence

//Adding maintenece from trip

	@PostMapping("/addmaintenence/tripId/{tripId}")
	ResponseEntity<Maintenence> createMaintenence(@RequestBody Maintenence maintenence,
			@PathVariable("tripId") int tripId) {
		Maintenence response = tripService.createMaintenence(maintenence, tripId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Adding Maintenence ");
		return ResponseEntity.ok().headers(headers).body(response);
	}

	@PutMapping("/updateMaintenence/maintenenceId/{maintenenceId}")
	ResponseEntity<String> updateMaintenence(@RequestBody Maintenence maintenence,
			@PathVariable("maintenenceId") int maintenenceId) {
		tripService.updateMaintenence(maintenence, maintenenceId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Updating Maintenence ");
		return ResponseEntity.ok().body("Updated successfully");
	}

	@DeleteMapping("/deleteMaintenence/{maintenenceId}")
	ResponseEntity<String> deleteMaintenence(@PathVariable("maintenenceId") int maintenenceId) {
		tripService.deleteMaintenence(maintenenceId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Deleting Maintenence ");
		return ResponseEntity.ok().body("deleted Successfully");
	}

	@GetMapping("/tripname/{tripname}/maintenencename/{maintenencename}")
	ResponseEntity<List<Maintenence>> readByTripNameAndMaintenanceMaintenenceName(
			@PathVariable("tripname") String tripname, @PathVariable("maintenencename") String maintenencename) {
		List<Maintenence> maintenencelist = tripService.readByTripNameAndMaintenanceMaintenenceName(tripname,
				maintenencename);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Showing Maintenence List with Trip name ");
		return ResponseEntity.ok(maintenencelist);

	}

	@GetMapping("/maintenence/tripOwner/{tripowner}")
	ResponseEntity<List<Maintenence>> readByTripOwner(@PathVariable("tripowner") String tripowner) {
		List<Maintenence> maintenencelist = tripService.readByTripOwner(tripowner);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Showing Maintenence List with Trip Owner ");
		return ResponseEntity.ok(maintenencelist);

	}

	@GetMapping("/maintenence/tripstartdate/{startdate}")
	ResponseEntity<List<Maintenence>> readByTripstartDate(@PathVariable("startdate") String startdate) {
		List<Maintenence> maintenencelist = tripService.readByTripstartDate(LocalDate.parse(startdate));
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Showing Maintenence List with Trip startdate ");
		return ResponseEntity.ok(maintenencelist);

	}

	@GetMapping("/maintenence/trippriority/{priority}")
	ResponseEntity<List<Maintenence>> readByTripPriority(@PathVariable("priority") Priority priority) {
		List<Maintenence> maintenencelist = tripService.readByTripPriority(priority);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Showing Maintenence List with Trip Priority ");
		return ResponseEntity.ok(maintenencelist);

	}

	@GetMapping("/maintenence/trippriority/{priority}/tripname/{tripname}")
	ResponseEntity<List<Maintenence>> readByTripPriorityAndTripName(@PathVariable("priority") Priority priority,
			@PathVariable("tripname") String tripname) {
		List<Maintenence> maintenencelist = tripService.readByTripPriorityAndTripName(priority, tripname);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Showing Maintenence List with Trip Priority and Trip name ");
		return ResponseEntity.ok(maintenencelist);

	}

	@GetMapping("/maintenence/tripowner/{tripowner}/tripstatus/{status}")
	ResponseEntity<List<Maintenence>> readByTripOwnerAndTripStatus(@PathVariable("tripowner") String tripowner,
			@PathVariable("status") Status status) {
		List<Maintenence> maintenencelist = tripService.readByTripOwnerAndTripStatus(tripowner, status);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Showing Maintenence List with Trip Owner and Trip status ");
		return ResponseEntity.ok(maintenencelist);

	}
}
