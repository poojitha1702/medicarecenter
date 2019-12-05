package com.cognizant.medicareservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cognizant.medicareservice.model.Doctor;
import com.cognizant.medicareservice.repository.DoctorRepository;
import com.cognizant.medicareservice.service.UserService;


public class TestUserService {

	@InjectMocks
	UserService userService;
	
	@Mock
	DoctorRepository doctorRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	@Transactional
	public void testDoctorDetails() {
		Doctor doctor = new Doctor();
		doctor.setFirstname("poojitha");
		doctor.setStatus("A");
		List<Doctor> doctors = new ArrayList<>();
		doctors.add(doctor);
		when(doctorRepository.getDoctordetailsapproved()).thenReturn(doctors);
		//test
		List<Doctor> testDoctorList = userService.doctorDetails();
		
		assertEquals(1, testDoctorList.size());
		for(Doctor testDoctor : testDoctorList) {
			assertEquals("poojitha", testDoctor.getFirstname());
		}
	}
	
	@After
	public void shutdown() {
		
	}
}
