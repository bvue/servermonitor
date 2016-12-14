package edu.matc.entity;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by bvue0 on 12/6/2016.
 */
public class SendEmailTest {
    SendEmail sendEmail = new SendEmail();

    @Test
    public void testRun() throws Exception {
        sendEmail.run();
        assertNotNull(sendEmail);

    }


}