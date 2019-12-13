package com.pactera.bg.budsc.bank.yongfu.config;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.config.ScheduledTask;

import com.frw.way.commons.utils.CollectionUtil;
import com.frw.way.commons.utils.UUIDUtils;
import com.frw.way.config.druid.DruidMonitoring;

@Configuration
public class SysInitData implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		DruidMonitoring druidMonitoring = new DruidMonitoring();
		druidMonitoring.loginPassword = "admin";
		druidMonitoring.loginUsername = "admin";
	}
}
