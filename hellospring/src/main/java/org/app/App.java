package org.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by denys on 7/18/2017.
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/annotation-config.xml");
        //CompactDisk compactDisk = context.getBean(CompactDisk.class);
        //compactDisk.play();
        context.getBean("musicService");
       // MusicService musicService = context.getBean(MusicService.class);
      //  musicService.makeAction();
    }
}
