package com.lesBaos.drivingSchool_backend.mappers;

import com.lesBaos.drivingSchool_backend.data.*;
import com.lesBaos.drivingSchool_backend.dto.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class Mappers {
    public AdministratorDTO fromAdministrator(Administrator administrator){
        AdministratorDTO administratorDTO = new AdministratorDTO();
        BeanUtils.copyProperties(administrator, administratorDTO);
        return administratorDTO;
    }
    public Administrator fromAdministratorDTO(AdministratorDTO administratorDTO){
        Administrator administrator = new Administrator();
        BeanUtils.copyProperties(administratorDTO, administrator);
        return administrator;
    }

    public CandidateDTO fromCandidate(Candidate candidate){
        CandidateDTO candidateDTO = new CandidateDTO();
        BeanUtils.copyProperties(candidate, candidateDTO);
        return candidateDTO;
    }
    public Candidate fromCandidateDTO(CandidateDTO candidateDTO) {
        Candidate candidate = new Candidate();
        BeanUtils.copyProperties(candidateDTO, candidate);
        return candidate;
    }

    public CarDTO fromCar(Car car){
        CarDTO carDTO = new CarDTO();
        BeanUtils.copyProperties(car, carDTO);
        return carDTO;
    }
    public Car fromCarDTO(CarDTO carDTO) {
        Car car = new Car();
        BeanUtils.copyProperties(carDTO, car);
        return car;
    }

    public CourseDTO fromCourse(Course course){
        CourseDTO courseDTO = new CourseDTO();
        BeanUtils.copyProperties(course, courseDTO);
        return courseDTO;
    }
    public Course fromCourseDTO(CourseDTO courseDTO) {
        Course course = new Course();
        BeanUtils.copyProperties(courseDTO, course);
        return course;
    }

    public InstructorDTO fromInstructor(Instructor instructor){
        InstructorDTO instructorDTO = new InstructorDTO();
        BeanUtils.copyProperties(instructor, instructorDTO);
        return instructorDTO;
    }
    public Instructor fromInstructorDTO(InstructorDTO instructorDTO) {
        Instructor instructor = new Instructor();
        BeanUtils.copyProperties(instructorDTO, instructor);
        return instructor;
    }

    public PaymentDTO fromPayment(Payment payment){
        PaymentDTO paymentDTO = new PaymentDTO();
        BeanUtils.copyProperties(payment, paymentDTO);
        return paymentDTO;
    }
    public Payment fromPaymentDTO(PaymentDTO paymentDTO) {
        Payment payment = new Payment();
        BeanUtils.copyProperties(paymentDTO, payment);
        return payment;
    }

    public PlanningDTO fromPlanning(Planning planning){
        PlanningDTO planningtDTO = new PlanningDTO();
        BeanUtils.copyProperties(planning, planningtDTO);
        return planningtDTO;
    }
    public Planning fromPlanningDTO(PlanningDTO planningDTO) {
        Planning planning = new Planning();
        BeanUtils.copyProperties(planningDTO, planning);
        return planning;
    }

    public SupportDTO fromSupport(Support support){
        SupportDTO supportDTO = new SupportDTO();
        BeanUtils.copyProperties(support, supportDTO);
        return supportDTO;
    }
    public Support fromSupportDTO(SupportDTO supportDTO) {
        Support support = new Support();
        BeanUtils.copyProperties(supportDTO, support);
        return support;
    }
}
