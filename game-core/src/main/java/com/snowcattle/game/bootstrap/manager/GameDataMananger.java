package com.snowcattle.game.bootstrap.manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.snowcattle.game.common.annotation.MessageCommandAnnotation;
import com.snowcattle.game.common.constant.Loggers;
import com.snowcattle.game.common.scanner.ClassScanner;
import com.snowcattle.game.common.scanner.PackageScaner;
import com.snowcattle.game.message.handler.AbstractMessageHandler;
import com.snowcattle.game.message.handler.IMessageHandler;
import com.snowcattle.game.service.classes.loader.DefaultClassLoader;
import com.snowcattle.game.service.classes.loader.DynamicGameClassLoader;

/**
 * 
 * @author Joe
 *
 */
public class GameDataMananger extends AbstractGameManager{
	
	public static Logger logger = Loggers.serverLogger;
	
	public static Map<String,Object>  WoldDate = new HashMap<String,Object>();

    public static GameDataMananger instance = new GameDataMananger();

    public static GameDataMananger getInstance(){
        return instance;
    }

 

    @Override
    public <T> void add(Object service, Class<T> inter) {
        super.add(service, inter);
//        if (service instanceof GameTcpMessageProcessor) {
//            this.gameTcpMessageProcessor = (GameTcpMessageProcessor) service;
//        } else if (service instanceof GameUdpMessageOrderProcessor) {
//            this.gameUdpMessageOrderProcessor = (GameUdpMessageOrderProcessor) service;
//        } else if (service instanceof GameUdpMessageProcessor) {
//            this.gameUdpMessageProcessor = (GameUdpMessageProcessor) service;
//        } else if (service instanceof UpdateService) {
//            this.updateService = (UpdateService) service;
//        }

    }
    
    public void init() {
    	
    	
    	
    }

	public static void main(String[] args) {
		try {
			loadPackage("com.snowcattle.gameData", "server");
			
			Object j = (Map) WoldDate.get("Q_attribute");
			Map c =   (Map) j;
//			System.out.println(WoldDate.get("Q_attribute"));
			System.out.println(c.get(1));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    
    public static void loadPackage(String namespace, String ext)throws Exception {
    	
    	
    	 
    	
    	ClassScanner classScanner = new ClassScanner();
    	
//        if(fileNames == null){
        	String[]  fileNames = classScanner.scannerPackage(namespace, ext);
//        }
        // 加载class,获取协议命令
//        DefaultClassLoader defaultClassLoader = LocalMananger.getInstance().getLocalSpringServiceManager().getDefaultClassLoader();
//        defaultClassLoader.resetDynamicGameClassLoader();
//        DynamicGameClassLoader dynamicGameClassLoader = defaultClassLoader.getDynamicGameClassLoader();

        if(fileNames != null) {
            for (String fileName : fileNames) {
//                String realClass = namespace
//                        + "."
//                        + fileName.subSequence(0, fileName.length() - (ext.length()));
              
            	
                if(fileName.indexOf(".json.server") <0 ) {
                	continue;
                }
//                System.out.println(  fileName);
                
                
               List list =  loadJsonFile(  fileName);
               
               int size = list.size();
//               System.out.println( size);
               
               Map map = new HashMap();
               for(int i = 0;i<size;i++ ){
            	   Object j = list.get(i);
            	   map.put(i, j);
               }
               
//               System.out.println( fileName);
               if(map.size()>0 && fileName != null) {
            	   
//            	   System.out.println( fileName.split(".").length);
            	   String key = fileName.split("\\.")[0];
                   WoldDate.put(key, map);
               } 

            }
        }
    }
   
    
    
	public static List<Object> loadJsonFile(String filePath) {
		
 		String a = "E:/git/JoeServer/game-core/src/main/java/com/snowcattle/gameData/";
//		 System.out.println(filePath);
		 filePath = a + filePath;
		File file = new File(filePath);
		List<Object>  beanlist = new ArrayList<>();
		try {
			if (file.exists()) {
				FileInputStream fr = new FileInputStream(file);
				BufferedReader br = new BufferedReader(new InputStreamReader(fr, "UTF-8"));
				String line = "";
				int version = 0;
				String checkValue = "";
				String templine = "";
				String headstr = "";
				while ((line = br.readLine()) != null) {
					headstr += line.trim();
					if (headstr.contains("}")) {
						String[] split = headstr.split("}");
						line = headstr;
						headstr = split[0] + "}";
						templine = line.replace(headstr, "");
						break;
					}
				}
				if (headstr != null && !"".equals(headstr)) {
					headstr = headstr.trim();
					Map<String, String> parseObject = JSON.parseObject(headstr,
							new TypeReference<Map<String, String>>() {
							});
					if (parseObject.containsKey("version")) {
						version = Integer.valueOf(parseObject.get("version"));
					}
					if (parseObject.containsKey("checkvalue")) {
						checkValue = parseObject.get("checkvalue");
					}

				}
				if ("".equals(checkValue) || version == 0) {
					logger.error(filePath + "数据头解析失败，请重新生成！");
//					com.gamebase.server.impl.GameServer.systemExit(0);
				}
				StringBuilder sb = new StringBuilder();
				sb.append(templine);
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				String jsonstr = sb.toString();
				
				
				
				System.out.println( "加载中。");
				beanlist = JSON.parseArray(jsonstr);
				
//				BaseDataBean bean = cla.newInstance();
//				if (version >= bean.getVersion() && checkValue.toLowerCase().contains(bean.getCheckValue().toLowerCase())) {
//					beanlist = JSON.parseArray(jsonstr);
//					logger.error(name + "加载成功！");
//					FILETIME_MAP.put(file.getPath(), file.lastModified());
//				} else {
//					String logString = name + "数据不是最新，请检查生成时间（version）和表结果校验值（checkvalue），再重新生成！";
//					logger.error(logString);
//					if (GameServer.getMe().getServer_test() == 1) {
//						beanlist = JSON.parseArray(jsonstr, cla);
//						logger.error(name + "容错加载成功！");
//						FILETIME_MAP.put(file.getPath(), file.lastModified());
//						// 测试服务器字段有变化不关闭，只提示
//						DataManager.LOG_STRINGS.add(logString);
//					} else {
//						com.gamebase.server.impl.GameServer.systemExit(0);
//					}
//				}
				fr.close();
			} else {
				logger.error(filePath + "文件不存在");
//				com.gamebase.server.impl.GameServer.systemExit(0);
			}
		} catch (Exception e) {
//			logger.error(e, e);
			logger.error("文件解析出错");
//			com.gamebase.server.impl.GameServer.systemExit(0);
		}
		return beanlist;
	}

}
