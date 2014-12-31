package com.xianzhi.testweb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestWebSpeed {
	private Process mProcess;
        private int count;
	public TestWebSpeed(progressListener listener,int count) {
            this.listener=listener;
            this.count=count;
	}
        progressListener listener;
	public void excute(String cmd) {
            
		try {
			mProcess = Runtime.getRuntime().exec("cmd.exe /C " + cmd);

			BufferedReader br = new BufferedReader(new InputStreamReader(
					mProcess.getInputStream(),"gbk"));
			String result;
                        int index=0;
			while ((result = br.readLine()) != null) {
				if(result.contains("统计信息")){
                                    if(listener!=null){
                                        listener.onfinal(result.substring(result.indexOf("统计信息:")));
                                    }
					System.out.println(result.substring(result.indexOf("统计信息:")));
				}else{
                                    if(listener!=null){
                                        listener.progress(index,result);
                                    }
					System.out.println(result);
				}
                                index++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
        public interface progressListener{
            void progress(int index,String result);
            void onfinal(String result);
        }
	public void stop() {
		mProcess.destroy();
	}

}
