package us.tobyschz.authlink.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import us.tobyschz.authlink.exception.URLNotFoundException;
import us.tobyschz.authlink.model.URLEntity;
import us.tobyschz.authlink.service.URLService;

import java.net.URI;
import java.net.URISyntaxException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(ShortenController.class)
class ShortenControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private URLService urlService;

    private URLEntity urlEntity;

    @BeforeEach
    public void setup() {
        urlEntity = new URLEntity("http://example.com", "test creator");
    }

    @Test
    public void testCreateShortenURL() throws Exception {
        when(urlService.createShortURL(anyString(), anyString())).thenReturn("shortURL");

        mockMvc.perform(post("/shorten/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"fullURL\":\"http://example.com\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("shortURL"));
    }

    @Test
    public void testGetShortenURL() throws Exception {
        URI uri = new URI("http://example.com");
        when(urlService.getLongURI(anyString())).thenReturn(uri);

        mockMvc.perform(get("/shorten/{id}", "shortURL"))
                .andExpect(status().isFound())
                .andExpect(header().string("Location", "http://example.com"));
    }

    @Test
    public void testGetShortenURL_NotFound() throws Exception {
        when(urlService.getLongURI(anyString())).thenThrow(new URLNotFoundException());

        mockMvc.perform(get("/shorten/{id}", "shortURL"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetShortenURL_InvalidURI() throws Exception {
        when(urlService.getLongURI(anyString())).thenThrow(new URISyntaxException("invalid URI", "reason"));

        mockMvc.perform(get("/shorten/{id}", "shortURL"))
                .andExpect(status().isNotFound());
    }
}
