package com.suphawking.zookeeper;

/**
 * Created by loveknut on 2017/2/8.
 */

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;


public class Zkclient {

  private ZooKeeper zk;
  private CountDownLatch connSignal = new CountDownLatch(0);

  public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
    String connectString = "10.1.1.58:3881";
    int sessionTimeout = 2000;
    Watcher watcher = null;
    ZooKeeper zk = new ZooKeeper(connectString, sessionTimeout, watcher);
    String a = new String(zk.getChildren("/rpc_groups/default_saturn", false).toString());
    zk.create();
    System.out.println(a.toString());



  }

}
