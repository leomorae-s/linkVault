package com.moraes.LinkVault;

import org.springframework.boot.SpringApplication;

public class TestLinkVaultApplication {

	public static void main(String[] args) {
		SpringApplication.from(LinkVaultApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
