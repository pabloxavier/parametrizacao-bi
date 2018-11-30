package br.com.unicred.parametrizacao.bi.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.unicred.arch.UnicredServicesRunner;

@EnableDiscoveryClient
@EnableFeignClients("br.com.unicred") 
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class })
@ComponentScan("br.com.unicred")
@Configuration
public class App {

	public static void main(String[] args) {
		new UnicredServicesRunner(App.class).run(args);
	}

}
