package com.heartgo.controller;

import java.util.concurrent.atomic.AtomicLong;


import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;
import com.heartgo.fabric.ClientBean;
import com.heartgo.fabric.End2end;

import org.hyperledger.fabric.sdk.*;


import com.heartgo.model.Greeting;

@RestController
public class RestApiController {

	public ClientBean newClientBean;
	public End2end end = new End2end();

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(),
				String.format(template, name));

	}

	@RequestMapping(value = "/admin/setclient", method = RequestMethod.GET)
	public void SetupClient() {

		newClientBean = end.InitClient();


	}

	@RequestMapping(value = "/admin/comclient", method = RequestMethod.GET)
	public void ComposeClient() {

		newClientBean = end.composeClient();

	}


	@RequestMapping(value = "/admin/install", method = RequestMethod.GET)
	public String Install() {

		end.InstallChainCode(newClientBean);
		end.InstantById(newClientBean);
		return newClientBean.getRunchannel().getResponse();


	}


	@RequestMapping(value = "/admin/transaction", method = RequestMethod.GET)
	public ResponseEntity<?> Transaction() {
		String[] str=new String[]{"move","a","b","100"};
		end.Transaction(newClientBean, str);

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}


	@RequestMapping(value = "/admin/query", method = RequestMethod.GET)
	public void Query() {

		String[] str=new String[] {"query", "b"};
		System.out.println("str:"+str.toString());
		end.QueryTransation(newClientBean, str);
		System.out.println("transaction ok");
	}
}



