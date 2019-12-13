package com.pactera.bg.budsc.bank.yongfu;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.frw.way.commons.utils.UUIDUtils;

/**
 * 
 * @author Administrator
 * 
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.pactera.bg.budsc.bank.yongfu.mapper")
@ComponentScan(value = { "com.pactera.bg.budsc.bank.yongfu.*", "com.frw.way.config.*" }, excludeFilters = { @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
		@Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
public class YongFuBootStrap implements CommandLineRunner {

	// DataSource dataSource;
	private static Logger logger = LoggerFactory.getLogger(YongFuBootStrap.class);

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(YongFuBootStrap.class, args);
		DruidDataSource druidDataSource = (DruidDataSource) applicationContext.getBean(DataSource.class);
		logger.info("DATASOURCE = " + druidDataSource);
		logger.info("##########  SSC应用启动成功 ###################");
		logger.info("                                                      ");
		logger.info("                    _ooOoo_                           ");
		logger.info("                   o8888888o                          ");
		logger.info("                   88\" . \"88                        ");
		logger.info("                   (| -_- |)                          ");
		logger.info("                    O\\ = /O                          ");
		logger.info("                ____/`---'\\____                      ");
		logger.info("              .   ' \\| |// `.                        ");
		logger.info("               / \\||| : |||// \\                     ");
		logger.info("             / _||||| -:- |||||- \\                   ");
		logger.info("               | | \\\\ - /// | |                     ");
		logger.info("             | \\_| ''\\---/'' | |                    ");
		logger.info("              \\ .-\\__ `-` ___/-. /                  ");
		logger.info("           ___`. .' /--.--\\ `. . __                  ");
		logger.info("        .\"\" '< `.___\\_<|>_/___.' >'\"\".           ");
		logger.info("       | | : `- \\`.;`\\ _ /`;.`/ - ` : | |           ");
		logger.info("         \\ \\ `-. \\_ __\\ /__ _/ .-` / /            ");
		logger.info(" ======`-.____`-.___\\_____/___.-`____.-'======       ");
		logger.info("                    `=---='                           ");
		logger.info("                                                      ");
		logger.info(" ...............................................      ");
		logger.info("###################  SSC应用启动成功 ########################");
	}

	@Override
	public void run(String... arg0) throws Exception {
		new UUIDUtils(1);
	}
}
