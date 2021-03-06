package com.psquickit.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.psquickit.manager.DoctorUserManager;
import com.psquickit.pojo.DoctorUserRegisterRequest;
import com.psquickit.pojo.DoctorUserRegisterResponse;
import com.psquickit.pojo.DoctorUserUpdateRequest;
import com.psquickit.pojo.DoctorUserUpdateResponse;
import com.psquickit.pojo.ListAllDegreeResponse;
import com.psquickit.pojo.ListAllMciResponse;
import com.psquickit.pojo.ListAllSpecializationResponse;
import com.psquickit.util.ServiceUtils;

@RestController
@RequestMapping("/user/doctor")
public class DoctorUserController {

	@Autowired
	DoctorUserManager doctorUserManger;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody DoctorUserRegisterResponse registerUser(@RequestBody DoctorUserRegisterRequest request) {
		DoctorUserRegisterResponse response = new DoctorUserRegisterResponse();
		try {
			response = doctorUserManger.registerUser(request);
		} catch (Exception e) {
			return ServiceUtils.setResponse(response, false, "Doctor User Registration", e);
		}
		return response;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody DoctorUserUpdateResponse updateUser(@RequestBody DoctorUserUpdateRequest request) {
		DoctorUserUpdateResponse response = new DoctorUserUpdateResponse();
		try {
			response = doctorUserManger.updateUser(request);
		} catch (Exception e) {
			return ServiceUtils.setResponse(response, false, "Doctor User Registration", e);
		}
		return response;
	}
	
	@RequestMapping(value = "/list/degree", method = RequestMethod.GET)
	@ResponseBody public ListAllDegreeResponse listAllDegrees(){
		ListAllDegreeResponse response = new ListAllDegreeResponse();
		try {
			response = doctorUserManger.listAllDegree();
		} catch (Exception e) {
			return ServiceUtils.setResponse(response, false, "List All Degree", e);
		}
		return response;
	}
	
	@RequestMapping(value = "/list/mci", method = RequestMethod.GET)
	@ResponseBody public ListAllMciResponse listAllMci(){
		ListAllMciResponse response = new ListAllMciResponse();
		try {
			response = doctorUserManger.listAllMci();
		} catch (Exception e) {
			return ServiceUtils.setResponse(response, false, "List All MCI", e);
		}
		return response;
	}
	
	@RequestMapping(value = "/list/specialization", method = RequestMethod.GET)
	@ResponseBody public ListAllSpecializationResponse listAllSpecialization(){
		ListAllSpecializationResponse response = new ListAllSpecializationResponse();
		try {
			response = doctorUserManger.listAllSpecialization();
		} catch (Exception e) {
			return ServiceUtils.setResponse(response, false, "List All MCI", e);
		}
		return response;
	}
}
