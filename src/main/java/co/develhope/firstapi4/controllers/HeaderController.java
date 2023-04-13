package co.develhope.firstapi4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;

@RestController
@RequestMapping("/headers")
public class HeaderController {
    @Autowired
    Environment environment;
    @Value("${server.port}")
    int aPort;
    @GetMapping("/host")
    public String getHosts(){
        String hostPort = environment.getProperty("server.port");
        String hostName = InetAddress.getLoopbackAddress().getHostName();
        String hostAddress = InetAddress.getLoopbackAddress().getHostAddress();

        return "Host: " + hostName + " Port: " + hostAddress + " : " + hostPort ;
    }

}