package com.sample.web;

import io.micrometer.core.annotation.TimedSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.metrics.annotation.Timed;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.Properties;


@RestController
@Timed
public class PingController {

    private static final Logger logger = LoggerFactory.getLogger(PingController.class);

    @Autowired
    ServletContext context;

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    @ResponseBody
    public String ping() {
        logger.debug("executing ping method");

        String implementationVersion = getClass().getPackage().getImplementationVersion();

        try {
            if (implementationVersion == null) {
                Properties properties = new Properties();
                InputStream resourceAsStream = context.getResourceAsStream("/META-INF/MANIFEST.MF");

                if (resourceAsStream != null) {
                    properties.load(resourceAsStream);
                    implementationVersion = properties.getProperty("Implementation-Version");
                }
            }
        } catch (Exception e) {
            logger.error(e.toString());
        }

        String returnString = "Pooooong ... " + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()) + " version: " + implementationVersion+"\n";

        return returnString;
    }

}
