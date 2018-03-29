package com.snowcattle.game;

import java.io.IOException;

/**
 * 
 * @author Joe
 * 2018年1月29日
 * 下午4:53:35
 */
public class GenProtobuf {
    public static void main(String[] args) {
        String protoFile = "joe_response.proto";//  
        String toolPath = "e:/git/JoeServer/game-logic/proto/windows/protoc.exe";
        String projectPath  =  "e:/git/JoeServer/game-logic/";
//        String strCmd = "e:/git/JoeServer/game-logic/proto/windows/protoc.exe -I e:/git/JoeServer/game-logic/proto --java_out=e:/git/JoeServer/game-logic/src/main/java e:/git/JoeServer/game-logic/proto/" + protoFile;
         String strCmd = toolPath + " -I "+projectPath+"proto --java_out=" +projectPath +"src/main/java "+projectPath+"proto/" + protoFile;

        try {
            Runtime.getRuntime().exec(strCmd);
            System.out.println(protoFile + "生成完毕！");
        } catch (IOException e) {
            e.printStackTrace();
        }//通过执行cmd命令调用protoc.exe程序  
    }
}