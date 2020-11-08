package com.woxiangbo.gridExtends;

import org.openqa.selenium.json.Json;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class GridServlet extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(200);

        String command = req.getParameter("command");
        Map<String, String> map = new HashMap<>();

        if ("start".equals(command)) {
            System.out.println("start................???");

        } else if ("downloadFile".equals(command)) {
            String filePath = req.getParameter("filePath");
            File file = new File(filePath);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                String fileName = URLEncoder.encode(file.getName(), "utf-8");
                byte[] b = new byte[fis.available()];
                fis.read(b);
                response.setHeader("Content-Disposition", "attachment; filename=" + fileName + "");
                ServletOutputStream out = response.getOutputStream();
                //输出
                out.write(b);
                out.flush();
                out.close();
            }
        }

        map.put("node_ip", InetAddress.getLocalHost().getHostAddress());
        map.put("action", command);
        response.getWriter().append(new Json().toJson(map));
    }
}
