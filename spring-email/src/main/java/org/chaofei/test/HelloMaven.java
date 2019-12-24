package org.chaofei.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import junit.framework.Assert;

public class HelloMaven {
    @Test
    public void test() {
        Assert.assertEquals("Hello Maven", new String("Hello Maven"));
        assertThat(new String("Hello Maven"), equalTo("Hello Maven"));
    }
}
