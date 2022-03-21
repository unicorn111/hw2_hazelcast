import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;

public class HazelcastTask1 {
    public static void main(String[] args) {
        Config clusterConfig = new Config();
        clusterConfig.setClusterName("myCluster");

        HazelcastInstance hz = Hazelcast.newHazelcastInstance(clusterConfig);
        HazelcastInstance hz2 = Hazelcast.newHazelcastInstance(clusterConfig);
        HazelcastInstance hz3 = Hazelcast.newHazelcastInstance(clusterConfig);

        Map<Integer, String> map = hz.getMap("values");
        for(int i=0;i<1000;i++ ){
            map.put(i, String.valueOf(i));
        }

        System.out.println(map.get(1));
        System.out.println(map.get(998));

    }
}