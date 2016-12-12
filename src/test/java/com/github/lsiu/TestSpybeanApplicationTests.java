package com.github.lsiu;

import com.github.lsiu.TestSpybeanApplication.InterfaceAConsumer;
import com.github.lsiu.TestSpybeanApplication.TheInterface;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.doReturn;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSpybeanApplicationTests {

    @Autowired
    private InterfaceAConsumer consumer;

    @SpyBean
    private TheInterface instance;

    @Test
    public void test() {
        doReturn("fromSpyBean").when(instance).giveMeAString();

        Assert.assertThat(consumer.getTheString(), Matchers.equalTo("fromSpyBean"));
    }

}
