package com.airsoftware.saas.datasource.sample.provider;

import com.airsoftware.saas.datasource.core.SaaSDataSourceCreator;
import com.airsoftware.saas.datasource.provider.SaaSDataSourceProvider;
import com.airsoftware.saas.datasource.sample.entity.DataSourceConfig;
import com.airsoftware.saas.datasource.sample.mapper.DataSourceConfigMapper;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * 数据源提供者实现
 *
 * @author bit
 */
@Component
public class MySaaSDataSourceProvider implements SaaSDataSourceProvider {
    
    @Resource
    private DataSourceConfigMapper dataSourceConfigMapper;
    
    @Resource
    private SaaSDataSourceCreator saasDataSourceCreator;
    
    public static String JDBC_URL_PREFIX = "jdbc:mysql://";
    
    public static String JDBC_URL_SUFFIX = "?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&serverTimezone=GMT%2B8&autoReconnect=true&autoReconnectForPools=true&allowMultiQueries=true&allowPublicKeyRetrieval=true";
    
    @Override
    public DataSource createDataSource(String dsKey) {
        DataSourceConfig dataSourceConfig = dataSourceConfigMapper.selectById(dsKey);
        String jdbcUrl = JDBC_URL_PREFIX + dataSourceConfig.getHost() + "/" + dataSourceConfig.getSchemaName() + JDBC_URL_SUFFIX;
        
        DataSourceProperty dataSourceProperty = new DataSourceProperty();
        dataSourceProperty.setUrl(jdbcUrl);
        dataSourceProperty.setUsername(dataSourceConfig.getUsername());
        dataSourceProperty.setPassword(dataSourceConfig.getPassword());
        dataSourceProperty.setPoolName(dsKey);
        
        return saasDataSourceCreator.createDruidDataSource(dataSourceProperty);
    }
    
}
