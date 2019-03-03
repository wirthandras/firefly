package hu.wirthandras.firefly.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import hu.wirthandras.firefly.TestBase;
import hu.wirthandras.firefly.service.IGeneratorService;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthorizationController.class)
public class AuthorizationControllerTest extends TestBase {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private IGeneratorService service;

	@Before
	public void setUp() throws IOException {
		when(service.generate()).thenReturn(folder.newFile());
	}

	@Test
	public void shouldAuthorizationNavigatetoAuthorizationView() throws Exception {
		mockMvc.perform(get("/authorization"))
		.andExpect(status().isOk())
		.andExpect(view().name("authorization"))
		.andExpect(model().hasNoErrors());
	}

	@Test
	public void shouldPostSetRedirectToPdfEndpoint() throws Exception {
		mockMvc.perform(post("/set"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:pdf"))
		.andExpect(model().hasNoErrors());
	}

	@Test
	public void pdfEndpointProductePdf() throws Exception {
		mockMvc.perform(get("/pdf"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_OCTET_STREAM_VALUE));
	}

}
