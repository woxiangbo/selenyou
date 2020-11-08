package com.woxiangbo.proxy;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.openqa.grid.common.RegistrationRequest;
import org.openqa.grid.internal.GridRegistry;
import org.openqa.grid.internal.TestSession;
import org.openqa.grid.selenium.proxy.DefaultRemoteProxy;

import java.util.logging.Logger;

public class VideoProxy extends DefaultRemoteProxy {
    private static final Logger log = Logger.getLogger(VideoProxy.class.getName());
    boolean isCurrentlyRecording = false;
    private HttpClient client;
    private String serviceUrl;

    public VideoProxy(RegistrationRequest request, GridRegistry registry) {
        super(request, registry);
        System.out.println("getRemoteHost >>>>>>>" + getRemoteHost());
        serviceUrl = getRemoteHost() + "/extra/GridServlet";
    }

    @Override
    public void beforeSession(TestSession testSession) {
        super.beforeSession(testSession);
        HttpPost r = new HttpPost(serviceUrl + "?command=start");
        try {
            HttpResponse response = client.execute(r);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                log.warning("Could not start video reporting: " + EntityUtils.toString(response.getEntity()));
                return;
            }

            isCurrentlyRecording = true;

            log.info("Started recording for new session on node: " + getId());

        } catch (Exception e) {
            log.warning("Could not start video reporting due to exception: " + e.getMessage());
            e.printStackTrace();
            return;
        } finally {
            r.releaseConnection();
        }
    }
}
