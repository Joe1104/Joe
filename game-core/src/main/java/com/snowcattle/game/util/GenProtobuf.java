package com.snowcattle.game.util;

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
//        String strCmd = "D:/Program Files/protobuf-master/src/protoc.exe -I=./proto --java_out=./src/main/java ./proto/"+ protoFile;  
        String strCmd = "e:/git/JoeServer/game-core/proto/windows/protoc.exe -I e:/git/JoeServer/game-core/proto --java_out=e:/git/JoeServer/game-core/src/main/java e:/git/JoeServer/game-core/proto/" + protoFile;

        try {
            Runtime.getRuntime().exec(strCmd);
            System.out.println(protoFile + "生成完毕！");
        } catch (IOException e) {
            e.printStackTrace();
        }//通过执行cmd命令调用protoc.exe程序  
    }
}