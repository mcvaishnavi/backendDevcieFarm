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
import com.quinnox.qyrus.devicefarm.controller.MobileController;
import com.quinnox.qyrus.devicefarm.domain.Mobile;
import com.quinnox.qyrus.devicefarm.repository.MobileRepo;
//import com.quinnox.qyrus.devicefarm.services.MobileService;

@RunWith(SpringRunner.class)
@SpringBootTest
//@DataJpaTest
public class MobileControllerTest {

	@Autowired
	private MobileController mobileController;

	@Autowired
	private MobileRepo mobileRepo;
	
	private static long mobileId;

	/**
	 * @throws Exception
	 */
	@Test
	public void getbyId() throws Exception {

		Mobile mobile = mobileRepo.findById(3l).get();

		mobile.setId(1);
		mobile.setType_of_device("4554473535453490");
		mobile.setDate_of_purchase("12/6/2021");
		mobile.setManufacturer("Samsung");
		mobile.setMake("2021");
		mobile.setModel("s9");
		mobile.setIP_address("10.1.0.108");
		mobile.setOS("9");
		mobile.setSerial_number("4554473535453490");
		mobile.setDevice_id("4554473535453490");
		mobile.setCurrent_client("vaish");
		mobile.setPhno("9110621963");
		mobile.setServer_connected("samsung mini");
		mobile.setStatus("active");
		mobile.setDescription("currently active");

		Assertions.assertThat(mobile.getId()).isEqualTo(1l);

	}

	/**
	 * @throws Exception
	 */
	@Test
	public void getall() throws Exception {
		List<Mobile> list = mobileRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	/**
	 * @throws Exception
	 * Unit Test Case to save a mobile object
	 */
	@Test
	public void insert() throws Exception {
		Mobile mobile = new Mobile();
		// mobile.setId(1L);
		mobile.setType_of_device("4554473535453490");
		mobile.setDate_of_purchase("12/6/2021");
		mobile.setManufacturer("Samsung");
		mobile.setMake("2021");
		mobile.setModel("s9");
		mobile.setIP_address("10.1.0.108");
		mobile.setOS("9");
		mobile.setSerial_number("4554473535453490");
		mobile.setDevice_id("4554473535453490");
		mobile.setCurrent_client("sunny");
		mobile.setPhno("9110621963");
		mobile.setServer_connected("samsung mini");
		mobile.setStatus("active");
		mobile.setDescription("currently active");
		Mobile newMobile = mobileRepo.save(mobile);
		//assigning the newly created object is assigned to a static variable
		mobileId = newMobile.getId();
		System.out.println(mobileId);
		//To check if the return object is not null
		assertNotNull(newMobile);
		//Checking the datatype of the created object
		assertThat(Long.class.isInstance(newMobile.getId())).isTrue();
		//Comparing the objects
		assertEquals(newMobile, mobile);
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void updateMobile() throws Exception {

		Mobile mobile = mobileRepo.findById(mobileId).get();

		mobile.setCurrent_client("STG");

		Mobile updatedMobile = mobileRepo.save(mobile);

		Assertions.assertThat(updatedMobile.getCurrent_client()).isEqualTo("STG");
	}

	/**
	 * 
	 */
	@Test
	public void deleteMobile() {
		mobileRepo.deleteById(mobileId);
		assertThat(mobileRepo.existsById(mobileId)).isFalse();
	}

}
