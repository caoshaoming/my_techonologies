package com.bijie.zk;

import org.apache.zookeeper.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author 曹哨明
 * @create 2023-01-20  22:33
 */
public class ZkClient {
    private ZooKeeper zooKeeper = null;
    private CountDownLatch awitLatch = null;

    @BeforeEach
    public void init() throws IOException {
        zooKeeper = new ZooKeeper("hadoop01:2181,hadoop02:2181,hadoop03:2181", 2000, new Watcher() {
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }

    @Test
    public void create() throws KeeperException, InterruptedException {
        String s = zooKeeper.create("/caoshaoming", "perfect".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    @Test
    public void getChlidrens() throws KeeperException, InterruptedException {
        List<String> children = zooKeeper.getChildren("/", true);
        for (String child : children) {
            System.out.println(child);
        }
    }

}
