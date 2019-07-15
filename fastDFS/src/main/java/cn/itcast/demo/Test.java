package cn.itcast.demo;

import org.csource.fastdfs.*;

public class Test {
    public static void main(String[] args) throws Exception {
        //1.加载配置文件
        ClientGlobal.init("D:\\\\IdeaProjects\\\\fastDFS\\\\src\\\\main\\\\resources\\\\fdfs_client.conf");
        //2.构建管理者客户端
        TrackerClient trackerClient = new TrackerClient();
        //3.连接管理者服务端
        TrackerServer trackerServer = trackerClient.getConnection();
        //4.声明存储者服务端
        StorageServer storageServcr=null;
        //5.获取存储服务端的客户端对象
        StorageClient storageClient=new StorageClient(trackerServer,storageServcr);
        //上传文件
        String[] pngs = storageClient.upload_file("D:\\18.png", "png", null);
        for(String p:pngs){
            System.out.println(p);
        }


    }
}
