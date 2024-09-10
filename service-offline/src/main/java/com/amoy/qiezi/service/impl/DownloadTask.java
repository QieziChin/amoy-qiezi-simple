package com.amoy.qiezi.service.impl;

import com.amoy.qiezi.dao.VideoDao;
import com.amoy.qiezi.entity.VideoEntity;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Set;

@Service("downloadTask")
public class DownloadTask extends RobotServiceImpl{

    @Value("${qiezi.image.path}")
    private String imageBase;

    @Resource
    VideoDao videoDao;

    @Override
    public void exec() {
        super.exec();
        Set<Object> tasks = redisUtils.hKeys("download");

        for (Object object: tasks){
            if(stop){break;}
            String url = (String)redisUtils.hGet("download", (String)object);
            try {
                URL image = new URL(url);
                URLConnection conn = image.openConnection();
                InputStream input = conn.getInputStream();
                String path = url.replaceAll("https://", "").replaceAll("http://", "");
                path = path.substring(path.indexOf("/"));
                String filePath = imageBase + path;

                String folderPath = (filePath).substring(0, filePath.lastIndexOf("/"));
                File folder = new File(folderPath);

                if (!folder.exists() || !folder.isDirectory()){
                    folder.mkdirs();
                }

                FileOutputStream out = new FileOutputStream(imageBase + path);
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = input.read(buffer)) != -1){
                    out.write(buffer, 0, bytesRead);
                }
                out.close();
                input.close();

                VideoEntity video = new VideoEntity();
                video.setVideoId(Integer.parseInt((String)object));
                video.setThumbUrl(path);
                videoDao.updateThumb(video);

                redisUtils.delete("download", (String)object);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
