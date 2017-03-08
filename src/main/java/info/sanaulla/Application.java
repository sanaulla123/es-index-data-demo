package info.sanaulla;

import java.net.InetSocketAddress;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	
	@Value("${es.cluster-name}")
	String clusterName;
	
	@Value("${es.host}")
	String esHost;
	
	@Value("${es.port}")
	Integer esPort;

	public static void main(String[] args){
		new SpringApplication(Application.class).run(args);
	}
	
	@Bean
	public Client esClient(){
		Settings settings = Settings.settingsBuilder().put(
				"cluster.name", clusterName).build();
		return TransportClient.builder().settings(settings).build()
				.addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress(esHost, esPort)));
	}
}
