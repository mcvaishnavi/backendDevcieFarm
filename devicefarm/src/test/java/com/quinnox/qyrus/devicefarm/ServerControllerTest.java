package com.quinnox.qyrus.devicefarm;

import static org.assertj.core.api.Assertions.assertThat;
/*import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.notNullValue;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
*/
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

//import java.util.ArrayList;
import java.util.List;
//import static org.junit.Assert.assertNotNull;

//import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
//import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
/*import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;*/


import com.quinnox.qyrus.devicefarm.controller.ServerController;

import com.quinnox.qyrus.devicefarm.domain.Server;


import com.quinnox.qyrus.devicefarm.repository.ServerRepo;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerControllerTest {
	
	@Autowired
	private ServerController serverController;

	@Autowired
	private ServerRepo serverRepo;
	
	private static long serverId;

	/**
	 * @throws Exception
	 */
	@Test
	public void getbyId() throws Exception {

		Server server = serverRepo.findById(1l).get();

		server.setId(1);
		server.setType_of_device("4554473535453490");
		server.setDate_of_purchase("12/6/2021");
		server.setManufacturer("Samsung");
		server.setMake("2021");
		server.setModel("s9");
		server.setIP_address("10.1.0.108");
		server.setOS("9");
		server.setSerial_number("4554473535453490");
		server.setDevice_id("4554473535453490");
		server.setCurrent_client("vaish");
		server.setStatus("active");
		server.setDescription("currently active");

		Assertions.assertThat(server.getId()).isEqualTo(1l);

	}

	/**
	 * @throws Exception
	 */
	@Test
	public void getall() throws Exception {
		List<Server> list = serverRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	/**
	 * @throws Exception
	 * Unit Test Case to save a mobile object
	 */
	@Test
	public void insertServer() throws Exception {
		Server server = new Server();
		// mobile.setId(1L);
		server.setType_of_device("4554473535453490");
		server.setDate_of_purchase("12/6/2021");
		server.setManufacturer("Samsung");
		server.setMake("2021");
		server.setModel("s9");
		server.setIP_address("10.1.0.108");
		server.setOS("9");
		server.setSerial_number("4554473535453490");
		server.setDevice_id("4554473535453490");
		server.setCurrent_client("sunny");	
		server.setStatus("active");
		server.setDescription("currently active");
		Server newServer = serverRepo.save(server);
		//assigning the newly created object is assigned to a static variable
		serverId = newServer.getId();
		System.out.println(newServer);
		//To check if the return object is not null
		assertNotNull(newServer);
		//Checking the datatype of the created object
		assertThat(Long.class.isInstance(newServer.getId())).isTrue();
		//Comparing the objects
		assertEquals(newServer, server);
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void updateServer() throws Exception {

		Server server = serverRepo.findById(serverId).get();

		server.setStatus("inactive");

		Server updatedServer = serverRepo.save(server);

		Assertions.assertThat(updatedServer.getStatus()).isEqualTo("inactive");
	}

	/**
	 * 
	 */
	@Test
	public void deleteServer() {
		serverRepo.deleteById(serverId);
		assertThat(serverRepo.existsById(serverId)).isFalse();
	}

}
