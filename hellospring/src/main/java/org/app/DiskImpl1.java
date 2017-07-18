package org.app;

import org.springframework.stereotype.Component;

/**
 * Created by denys on 7/18/2017.
 */
@Component("musicService")
public class DiskImpl1 implements CompactDisk {

    public void play() {
        System.out.println("Disk1.play");
    }
}
