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
	public String getCall(@RequestBody List<IotDevice> iotDevice) {
		//public @ResponseBody List<IotDevice> getCall(@RequestBody List<IotDevice> iotDevice) {
		// Check if the user has submitted initial form or moved a device to a new
		// position
		// if modeOfOperation = ***initial ***
		// then follow initial workFlow for setting up initial devices with initial
		// default coordinates and shortest path 
		// else if modeOfOperation = ***reposition ***
		// then follow second iteration of shortest path
	/*	String modeOfOperation = connectedCordinate.get(0).getOperationType();
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

		}*/
		IotDevice iotDevices = new IotDevice();
		ConnectedCordinate connectedCordinates =  new ConnectedCordinate();
		connectedCordinates.setxCoordinate(123.0);
		connectedCordinates.setyCoordinate(123.0);
		List<ConnectedCordinate> connectedCordinates2 =  new ArrayList<>();
		connectedCordinates2.add(connectedCordinates);
		iotDevices.setConnectedCordinate(connectedCordinates2);
		iotDevices.setDeviceId("Laptop");
		iotDevices.setHobCount(2);
		iotDevices.setxCoordinate(22.3);
		iotDevices.setyCoordinate(12.0);
		List<IotDevice> testIotDevice = new ArrayList<>();
		testIotDevice.add(iotDevices);
		return "testIotDevice";
	}

	/*
	 * @PostMapping("/postCall") public String postCall(){ return
	 * "Spring-Boot-PostCall"; }
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@PostMapping(path = "/postCall")
	public List<IotDevice> postCall(@RequestBody List<IotDevice> iotDevice) {
		//public @ResponseBody List<IotDevice> postCall(@RequestBody List<IotDevice> iotDevice) {
		/*IotDevice iotDevices = new IotDevice();
		ConnectedCordinate connectedCordinates =  new ConnectedCordinate();
		connectedCordinates.setxCoordinate(123.0);
		connectedCordinates.setyCoordinate(123.0);
		List<ConnectedCordinate> connectedCordinates2 =  new ArrayList<>();
		connectedCordinates2.add(connectedCordinates);
		iotDevices.setConnectedCordinate(connectedCordinates2);
		iotDevices.setDeviceId("Laptop");
		iotDevices.setHobCount(2);
		iotDevices.setxCoordinate(22.3);
		iotDevices.setyCoordinate(12.2);
		List<IotDevice> testIotDevice = new ArrayList<>();
		testIotDevice.add(iotDevices);
		return iotDevices;*/
		// Check if the user has submitted initial form or moved a device to a new
		// position
		// if modeOfOperation = ***initial ***
		// then follow initial workFlow for setting up initial devices with initial
		// default coordinates and shortest path 
		// else if modeOfOperation = ***reposition ***
		// then follow second iteration of shortest path
		List<IotDevice> iresultIotDevice =  null;
		String modeOfOperation = iotDevice.get(0).getOperationType();
		
		if (!iotDevice.isEmpty()) {
			if (!StringUtils.isEmpty(modeOfOperation) && modeOfOperation.equalsIgnoreCase("initial")) {

				ShortestPathWorkFlow shortestPathWorkFlow = new ShortestPathWorkFlow();
				iresultIotDevice = shortestPathWorkFlow.getShortestPathForAllDevices(iotDevice);

			} else if (!StringUtils.isEmpty(modeOfOperation) && modeOfOperation.equalsIgnoreCase("reposition")) {

				ShortestPathWorkFlow shortestPathWorkFlow = new ShortestPathWorkFlow();
				iresultIotDevice = shortestPathWorkFlow.getShortestPathForOneDevice(iotDevice);

			} else {

			}
		} else {

		}
		return iresultIotDevice;
	}

}
