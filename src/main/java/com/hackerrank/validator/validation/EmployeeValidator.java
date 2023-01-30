package com.example.validator.validation;

import com.example.validator.model.Employee;
import org.apache.commons.validator.GenericValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class EmployeeValidator implements Validator {
	@Override
	public boolean supports(Class<?> aClass) {
		return Employee.class.isAssignableFrom(aClass);
	}

	@Override
	public void validate(Object employeeObject, Errors errors) {
		Employee employee = (Employee) employeeObject;
		if (employee.getFullName() == null || employee.getFullName().isEmpty()) {
			errors.rejectValue("fullName", "fullName", "The fullName is a mandatory field");
		}
		if (employee.getMobileNumber() == null || employee.getMobileNumber().toString().length() != 10) {
			errors.rejectValue("mobileNumber", "mobileNumber", "The mobileNumber is a mandatory field");
		}
		if (employee.getEmailId() == null || employee.getEmailId().isEmpty()) {
			errors.rejectValue("emailId", "emailId", "The emailId is a mandatory field");
		}
		if (employee.getEmailId() != null && !employee.getEmailId().isEmpty() && !employee.getEmailId().contains("@")) {
			errors.rejectValue("emailId", "emailId", "The emailId should be in a valid email format");
		}
		if (employee.getDateOfBirth() == null || employee.getDateOfBirth().isEmpty()) {
			errors.rejectValue("dateOfBirth", "dateOfBirth", "The dateOfBirth is a mandatory field");
		}
		if (employee.getDateOfBirth() != null && !employee.getDateOfBirth().isEmpty() && !GenericValidator.isDate(employee.getDateOfBirth(), "yyyy-MM-dd", true)) {
			errors.rejectValue("dateOfBirth", "dateOfBirth", "The dateOfBirth should be in YYYY-MM-DD format");
		}
	}
}
