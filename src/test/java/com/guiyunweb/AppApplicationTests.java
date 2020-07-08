package com.guiyunweb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.query.MongoParameters;

@SpringBootTest
class AppApplicationTests {

	@Test
	void contextLoads() {
		MatchOperation matchStage = Aggregation.match(new Criteria("foo").is("bar"));
		ProjectionOperation projectStage = Aggregation.project("foo", "bar.baz");

		Aggregation aggregation
				= Aggregation.newAggregation(matchStage, projectStage);


	}

}
