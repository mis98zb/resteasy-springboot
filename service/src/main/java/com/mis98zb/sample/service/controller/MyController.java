package com.mis98zb.sample.service.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;

import com.mis98zb.sample.api.IMyService;
import com.mis98zb.sample.model.MyModel;


@Controller
public class MyController implements IMyService {
	@Override
	public MyModel test(String name) {
		var ret = new MyModel();
		ret.setAge(1000);
		ret.setName(name);
		return ret;
	}

	@Override
	public Response testResponse(String name) {
		var data = new MyModel();
		data.setAge(1000);
		data.setName(name);
		// return Response.status(Response.Status.OK).entity(data).build();
		// return Response.ok().entity(data).build();
		return Response.ok(data).build();
	}

	@Override
	public Response testStream(String fname) {
		String fileName = "加密服务平台.vsdx";
		File f = new File("d:\\" + fileName);
		try {
			InputStream fis = new FileInputStream(f);
			String encodFileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8);
			return Response.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + encodFileName)
					.header(HttpHeaders.CONTENT_LENGTH, f.length())
					.entity(fis)
					.build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
		}
	}
}
