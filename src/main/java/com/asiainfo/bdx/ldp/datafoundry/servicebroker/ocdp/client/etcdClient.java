package com.asiainfo.bdx.ldp.datafoundry.servicebroker.ocdp.client;

import java.net.URI;

import com.justinsb.etcd.EtcdClient;
import com.justinsb.etcd.EtcdClientException;
import com.justinsb.etcd.EtcdResult;

/**
 * Java Client for manipulate Etcd.
 *
 * @author whitebai1986@gmail.com
 *
 */
public class etcdClient {

    private EtcdClient etcdclient;

    public etcdClient(String etcd_endpoint){
        this.etcdclient = new EtcdClient(URI.create(etcd_endpoint));
    }

    public EtcdResult read(String key){
        EtcdResult result = new EtcdResult();
        try{
            result = this.etcdclient.get(key);
        }catch(EtcdClientException e){
            e.printStackTrace();
        }
        return result;
    }

    public String readToString(String key){
        EtcdResult result = this.read(key);
        return (result.node != null) ? result.node.value : null;
    }

    public EtcdResult write(String key, String value){
        EtcdResult result = new EtcdResult();
        try{
            result = this.etcdclient.set(key, value);
        }catch(EtcdClientException e){
            e.printStackTrace();
        }
        return result;
    }

    public EtcdResult createDir(String key) {
        EtcdResult result = new EtcdResult();
        try {
            result = this.etcdclient.createDirectory(key);
        } catch (EtcdClientException e) {
            e.printStackTrace();
        }
        return result;
    }

    public EtcdResult delete(String key){
        EtcdResult result = new EtcdResult();
        try{
            result = this.etcdclient.delete(key);
        }catch(EtcdClientException e){
            e.printStackTrace();
        }
        return result;
    }

    public EtcdResult deleteDir(String key){
        EtcdResult result = new EtcdResult();
        try {
            result = this.etcdclient.deleteDirectory(key);
        } catch (EtcdClientException e) {
            e.printStackTrace();
        }
        return result;
    }

}
