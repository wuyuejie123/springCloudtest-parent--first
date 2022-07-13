package org.ribbonconfig;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;
/*
* 自定义负载均衡算法：要求实现轮询算法，每一个服务器执行五次后切换下一个
* */
public class CustomRandomRule extends AbstractLoadBalancerRule {


        private int total=0;//总共被调用的次数，目前要求每台被调用五次
        private int currentIndex=0;//当前提供服务的机器号
        public Server choose(ILoadBalancer lb, Object key) {
            if (lb == null) {
                return null;
            } else {
                Server server = null;

                while(server == null) {
                    if (Thread.interrupted()) {
                        return null;
                    }

                    List<Server> upList = lb.getReachableServers();
                    List<Server> allList = lb.getAllServers();
                    int serverCount = allList.size();
                    if (serverCount == 0) {
                        return null;
                    }
                    if(total<3){
                        server = upList.get(currentIndex);
                        total++;
                    }else {
                        total=0;
                        currentIndex++;
                        if(currentIndex>upList.size()){
                            currentIndex=0;
                        }
                    }

//                    server = (Server)upList.get(index);
                    if (server == null) {
                        Thread.yield();
                    } else {
                        if (server.isAlive()) {
                            return server;
                        }

                        server = null;
                        Thread.yield();
                    }
                }

                return server;
            }
        }

        public Server choose(Object key) {
            return this.choose(this.getLoadBalancer(), key);
        }

        public void initWithNiwsConfig(IClientConfig clientConfig) {
        }

}
