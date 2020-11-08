package com.woxiangbo.selenium;


import org.openqa.selenium.WebDriver;

public class BaseDriver {
    private String hubIp = "localhost";
    private String hubPort = "4444";
    private String routedIpAndPort;
    private WebDriver webDriver;

    public BaseDriver() {
//        this.webDriver = demonstrateToWhichNodeWasMyTestRoutedTo();
    }

    public String getRoutedIpAndPort() {
        return routedIpAndPort;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

//    public WebDriver demonstrateToWhichNodeWasMyTestRoutedTo() {
//
//        RemoteWebDriver rwd = null;
//        Host hub = new Host(hubIp, hubPort);
//        try {
//            String url = String.format("http://%s:%d/wd/hub", hub.getIpAddress(), hub.getPort());
//
//            DesiredCapabilities capability = new DesiredCapabilities();
//            capability.setBrowserName("chrome");
//            capability.setPlatform(Platform.WINDOWS);
//
//            rwd = new RemoteWebDriver(new URL(url), capability);
//
//            rwd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//            rwd.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
//            rwd.manage().timeouts().setScriptTimeout(120, TimeUnit.SECONDS);
//
//
//            //First lets get hold of the session id for our test.
//            String sessionId = rwd.getSessionId().toString();
//            GridApiAssistant assistant = new GridApiAssistant(hub);
//            //Now lets query the Hub to figure out to which node did the hub route our test to.
//            Host node = assistant.getNodeDetailsForSession(sessionId);
//            assertNotNull(node);
//            Reporter.log("Test routed to " + node.toString(), true);
//            //Lets check what does the node configuration look like.
//            NodeConfiguration nodeConfig = assistant.getNodeConfigForSession(node);
//            //Here's how we get hold of the capabilities that are supported by this node.
//            assertNotNull(nodeConfig.getCapabilities());
//            routedIpAndPort = node.getIpAddress() + ":" + node.getPort();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return rwd;
//    }
}
