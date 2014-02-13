package com.ngnono.demo.shirodemo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ngnono on 14-1-23.
 * mvn exec:java -Dexec.mainClass="ShiroTest"
 */
public class ShiroTest {
    private static Logger logger = LoggerFactory.getLogger(ShiroTest.class);

    public static void main(String[] args) {
        // Using the IniSecurityManagerFactory, which will use the an INI file
        // as the security file.
        Factory<org.apache.shiro.mgt.SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:auth.ini");

        // Setting up the SecurityManager...
        org.apache.shiro.mgt.SecurityManager securityManager
                = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject user = SecurityUtils.getSubject();

        logger.info("User is authenticated:  " + user.isAuthenticated());

        UsernamePasswordToken token = new UsernamePasswordToken("bjangles", "1dance");

        try {
            user.login(token);
        } catch (AuthenticationException ae) {
            logger.info("UserName or Password error  ");
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            logger.info("500");
        }


        logger.info("User is authenticated:  " + user.isAuthenticated());
    }
}
