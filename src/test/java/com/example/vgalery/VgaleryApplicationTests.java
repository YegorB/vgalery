package com.example.vgalery;

import com.example.vgalery.controller.PaintingController;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VgaleryApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	@Ignore
	public void uploadTests() throws Exception {
		for (int i = 0; i < 200; i++) {
			File inputFile = new File("src/test/resources/maxresdefault.jpg");
            HttpEntity entity = MultipartEntityBuilder.create()
                    .addPart("file", new FileBody(inputFile))
                    .build();
            HttpPost request = new HttpPost("http://vgalery-service.appspot.com/rest/image");
            request.setEntity(entity);
            HttpClient client = HttpClientBuilder.create().build();
            client.execute(request);
		}
	}
}
