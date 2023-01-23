package com.bijie;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

/**
 * @author 曹哨明
 * @create 2023-01-19  23:40
 */
public class HbaseConnection {
    public static void main(String[] args) {
        Configuration entries = new Configuration();
        Connection connection = ConnectionFactory.createConnection(entries);
    }
}
