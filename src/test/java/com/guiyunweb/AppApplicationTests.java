package com.guiyunweb;

import com.guiyunweb.utils.obs.huaweicloud.ObsUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.query.MongoParameters;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@SpringBootTest
class AppApplicationTests {

	@Test
	void contextLoads() throws IOException {

	}

}
