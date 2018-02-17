package io.ulti.dao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:hibernate.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="io.pandaschool.dao.repository")
public class HibernateConfig {


    /*
     * @Autowired private Environment env;
     * 
     * @Bean public LocalContainerEntityManagerFactoryBean
     * entityManagerFactory() { final LocalContainerEntityManagerFactoryBean em
     * = new LocalContainerEntityManagerFactoryBean();
     * em.setDataSource(dataSource()); em.setPackagesToScan(new String[] {
     * "io.pandaschool.dao.model" });
     * 
     * final HibernateJpaVendorAdapter vendorAdapter = new
     * HibernateJpaVendorAdapter(); em.setJpaVendorAdapter(vendorAdapter);
     * em.setJpaProperties(additionalProperties()); return em; }
     * 
     * @Bean public DataSource dataSource() { final DriverManagerDataSource
     * dataSource = new DriverManagerDataSource();
     * dataSource.setDriverClassName(Preconditions.checkNotNull(env.getProperty(
     * "jdbc.driverClassName")));
     * dataSource.setUrl(Preconditions.checkNotNull(env.getProperty("jdbc.url"))
     * ); dataSource.setUsername(Preconditions.checkNotNull(env.getProperty(
     * "jdbc.user")));
     * dataSource.setPassword(Preconditions.checkNotNull(env.getProperty(
     * "jdbc.pass")));
     * 
     * return dataSource; }
     * 
     * @Bean public PlatformTransactionManager transactionManager(final
     * EntityManagerFactory emf) { final JpaTransactionManager
     * transactionManager = new JpaTransactionManager();
     * transactionManager.setEntityManagerFactory(emf); return
     * transactionManager; }
     * 
     * @Bean public PersistenceExceptionTranslationPostProcessor
     * exceptionTranslation() { return new
     * PersistenceExceptionTranslationPostProcessor(); }
     * 
     * final Properties additionalProperties() { final Properties
     * hibernateProperties = new Properties();
     * hibernateProperties.setProperty("hibernate.hbm2ddl.auto",
     * env.getProperty("hibernate.hbm2ddl.auto"));
     * hibernateProperties.setProperty("hibernate.dialect",
     * env.getProperty("hibernate.dialect"));
     * hibernateProperties.setProperty("hibernate.show_sql",
     * env.getProperty("hibernate.showSql")); return hibernateProperties; }
     */
}
