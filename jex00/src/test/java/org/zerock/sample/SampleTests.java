package org.zerock.sample;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.config.RootConfig;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
// xml이 아닌 Java를 이용하는 경우의 테스트(RootConfig.class의 경로를 지정)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class SampleTests {

}