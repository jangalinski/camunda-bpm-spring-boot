package org.camunda.bpm.extension.spring.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;


/**
 * Created by hawky4s on 10.02.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SampleCamundaBootApplication.class)
@WebIntegrationTest(randomPort = true)
@DirtiesContext
public class SampleCamundaBootApplicationTest {

  @Value("${local.server.port}")
  private int port;

  @Test
  public void testHome() throws Exception {
    ResponseEntity<String> entity = new TestRestTemplate().getForEntity(
      "http://localhost:" + this.port, String.class);
    assertEquals(HttpStatus.OK, entity.getStatusCode());
    assertEquals("Hello World", entity.getBody());
  }

}
