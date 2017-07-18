package org.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by denys on 7/18/2017.
 */
@Service

public class MusicService {
  //  @Autowired
    private CompactDisk compactDisk;

    public void makeAction(){
        compactDisk.play();
    }

    public CompactDisk getCompactDisk() {
        return compactDisk;
    }

    public void setCompactDisk(CompactDisk compactDisk) {
        this.compactDisk = compactDisk;
    }
}
