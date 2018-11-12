package ari.unr.root.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ari.unr.root.pojo.ConnectedCordinate;
import ari.unr.root.pojo.IotDevice;
import ari.unr.workFlow.ShortestPathWorkFlow;

@RestController
public class Controller {

	@GetMapping("/info")
	public String getAppInfo() {
		return "ShortestPath-Application";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping(path = "/getCall", consumes = "application/json", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public @ResponseBody List<IotDevice> getCall(@RequestBody List<ConnectedCordinate> connectedCordinate) {
		// Check if the user has submitted initial form or moved a device to a new
		// position
		// if modeOfOperation = ***initial ***
		// then follow initial workFlow for setting up initial devices with initial
		// default coordinates and shortest path 
		// else if modeOfOperation = ***reposition ***
		// then follow second iteration of shortest path
		String modeOfOperation = connectedCordinate.get(0).getOperationType();
		if (!connectedCordinate.isEmpty()) {
			if (!StringUtils.isEmpty(modeOfOperation) && modeOfOperation.equalsIgnoreCase("initial")) {

				ShortestPathWorkFlow shortestPathWorkFlow = new ShortestPathWorkFlow();
				//shortestPathWorkFlow.getShortestPathForAllDevices(connectedCordinate);

			} else if (!StringUtils.isEmpty(modeOfOperation) && modeOfOperation.equalsIgnoreCase("reposition")) {

				ShortestPathWorkFlow shortestPathWorkFlow = new ShortestPathWorkFlow();
				//shortestPathWorkFlow.getShortestPathForOneDevice(connectedCordinate);

			} else {

			}
		} else {

		}
		IotDevice iotDevice = new IotDevice();
		// iotDevice.setConnectedCordinate(connectedCordinate);
		iotDevice.setDeviceId("Laptop");
		iotDevice.setHobCount(2);
		iotDevice.setxCoordinate("22.3");
		iotDevice.setyCoordinate("12.2");
		List<IotDevice> testIotDevice = new ArrayList<>();
		testIotDevice.add(iotDevice);
		return testIotDevice;
	}

	/*
	 * @PostMapping("/postCall") public String postCall(){ return
	 * "Spring-Boot-PostCall"; }
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@PostMapping(path = "/postCall")
	public @ResponseBody List<IotDevice> postCall(@RequestBody ConnectedCordinate connectedCordinate) {
		IotDevice iotDevice = new IotDevice();
		iotDevice.setConnectedCordinate(connectedCordinate);
		iotDevice.setDeviceId("Laptop");
		iotDevice.setHobCount(2);
		iotDevice.setxCoordinate("22.3");
		iotDevice.setyCoordinate("12.2");
		List<IotDevice> testIotDevice = new ArrayList<>();
		testIotDevice.add(iotDevice);
		return testIotDevice;
	}

}
