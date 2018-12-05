package ari.unr.root.controller;

import ari.unr.root.pojo.ConnectedCordinate;
import ari.unr.root.pojo.IotDevice;
import ari.unr.root.pojo.ResponseIotDevice;
import ari.unr.workFlow.ShortestPathWorkFlow;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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


	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@PostMapping(path = "/postCall")
	public List<ResponseIotDevice> postCall(@RequestBody List<IotDevice> iotDevice) {

		// Check if the user has submitted initial form or moved a device to a new
		// position
		// if modeOfOperation = ***initial ***
		// then follow initial workFlow for setting up initial devices with initial
		// default coordinates and shortest path
		// else if modeOfOperation = ***reposition ***
		// then follow second iteration of shortest path
		List<ResponseIotDevice> ResponseIotDevice =  null;
		String modeOfOperation = iotDevice.get(0).getOperationType();

		if (!iotDevice.isEmpty()) {
			if (!StringUtils.isEmpty(modeOfOperation) && modeOfOperation.equalsIgnoreCase("initial")) {

				ShortestPathWorkFlow shortestPathWorkFlow = new ShortestPathWorkFlow();
				ResponseIotDevice = shortestPathWorkFlow.getShortestPathForAllDevices(iotDevice);

			} else if (!StringUtils.isEmpty(modeOfOperation) && modeOfOperation.equalsIgnoreCase("reposition")) {

				ShortestPathWorkFlow shortestPathWorkFlow = new ShortestPathWorkFlow();
				ResponseIotDevice = shortestPathWorkFlow.getShortestPathForOneDevice(iotDevice);

			} else {

			}
		} else {

		}
		return ResponseIotDevice;
	}

}