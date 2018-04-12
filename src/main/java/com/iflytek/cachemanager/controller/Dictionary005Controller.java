package com.iflytek.cachemanager.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iflytek.cachemanager.entity.Dictionary005;
import com.iflytek.cachemanager.mapper.Dictionary005Mapper;
import com.iflytek.cachemanager.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author: tishen
 * @date: 2018/4/10
 * @description:
 */
@RestController
public class Dictionary005Controller {

    @Autowired
    private Dictionary005Mapper dictionary005Mapper;

    private ObjectMapper mapper = new ObjectMapper();

    /**
     * 01_文件数据处理服务状态查看 fileDataProcessingServiceStatusView
     */
    @RequestMapping(value = "fileDataProcessingServiceStatusView", method = RequestMethod.POST)
    public Result fileDataProcessingServiceStatus() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(1);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 02_集群摘要查看 clusterSummaryView
     */
    @RequestMapping(value = "clusterSummaryView", method = RequestMethod.POST)
    public Result clusterSummaryView() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(2);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 03_计划信息查看 planInformationView
     */
    @RequestMapping(value = "planInformationView", method = RequestMethod.POST)
    public Result planInformationView() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(3);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 04_文件数据处理服务汇总查看 fileDataProcessingServiceRollupview
     */
    @RequestMapping(value = "fileDataProcessingServiceRollupview", method = RequestMethod.POST)
    public Result fileDataProcessingServiceRollupview() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(4);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 05_文件数据处理服务事件搜索 fileDataProcessingServiceEventSearch
     */
    @RequestMapping(value = "fileDataProcessingServiceEventSearch", method = RequestMethod.POST)
    public Result fileDataProcessingServiceEventSearch() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(5);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 06_文件数据处理服务内容搜索 fileDataProcessingServiceContentSearch
     */
    @RequestMapping(value = "fileDataProcessingServiceContentSearch", method = RequestMethod.POST)
    public Result fileDataProcessingServiceContentSearch() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(6);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 07_文件数据处理服务服务搜索 fileDataProcessingServiceSearch
     */
    @RequestMapping(value = "fileDataProcessingServiceSearch", method = RequestMethod.POST)
    public Result fileDataProcessingServiceSearch() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(7);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 08_文件数据处理服务角色搜索 fileDataProcessingServiceRoleSearch
     */
    @RequestMapping(value = "fileDataProcessingServiceRoleSearch", method = RequestMethod.POST)
    public Result fileDataProcessingServiceRoleSearch() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(8);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 09_文件数据处理服务运行状况查看 fileDataProcessingServiceHealthView
     */
    @RequestMapping(value = "fileDataProcessingServiceHealthView", method = RequestMethod.POST)
    public Result fileDataProcessingServiceHealthView() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(9);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 10_文件数据处理服务运行状况历史记录 fileDataProcessingServiceHealthHistory
     */
    @RequestMapping(value = "fileDataProcessingServiceHealthHistory", method = RequestMethod.POST)
    public Result fileDataProcessingServiceHealthHistory() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(10);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 11_文件数据处理服务状态摘要查看 fileDataProcessingServiceStatusSummaryView
     */
    @RequestMapping(value = "fileDataProcessingServiceStatusSummaryView", method = RequestMethod.POST)
    public Result fileDataProcessingServiceStatusSummaryView() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(11);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 12_文件数据处理服务启动实例 fileDataProcessingServiceStartupInstance
     */
    @RequestMapping(value = "fileDataProcessingServiceStartupInstance", method = RequestMethod.POST)
    public Result fileDataProcessingServiceStartupInstance() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(12);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 13_文件数据处理服务停止实例 fileDataprocessingServiceStopInstance
     */
    @RequestMapping(value = "fileDataprocessingServiceStopInstance", method = RequestMethod.POST)
    public Result fileDataprocessingServiceStopInstance() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(13);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 14_文件数据处理服务重启实例 fileDataProcessingServiceRestartInstance
     */
    @RequestMapping(value = "fileDataProcessingServiceRestartInstance", method = RequestMethod.POST)
    public Result fileDataProcessingServiceRestartInstance() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(14);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 15_文件数据处理服务实例滚动重启 fileDataProcessingServiceInstanceScrollingRestart
     */
    @RequestMapping(value = "fileDataProcessingServiceInstanceScrollingRestart", method = RequestMethod.POST)
    public Result fileDataProcessingServiceInstanceScrollingRestart() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(15);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 16_文件数据处理服务实例重新授权 fileDataProcessingServiceInstanceReauthorize
     */
    @RequestMapping(value = "fileDataProcessingServiceInstanceReauthorize", method = RequestMethod.POST)
    public Result fileDataProcessingServiceInstanceReauthorize() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(16);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 17_文件数据处理服务实例进入维护模式 fileDataProcessingServiceInstanceIntoMaintenanceMode
     */
    @RequestMapping(value = "fileDataProcessingServiceInstanceIntoMaintenanceMode", method = RequestMethod.POST)
    public Result fileDataProcessingServiceInstanceIntoMaintenanceMode() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(17);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 18_文件数据处理服务实例退出维护模式 fileDataProcessingServiceInstanceExitMaintenanceMode
     */
    @RequestMapping(value = "fileDataProcessingServiceInstanceExitMaintenanceMode", method = RequestMethod.POST)
    public Result fileDataProcessingServiceInstanceExitMaintenanceMode() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(18);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 19_文件数据处理服务删除实例 fileDataProcessingServiceDeleteInstance
     */
    @RequestMapping(value = "fileDataProcessingServiceDeleteInstance", method = RequestMethod.POST)
    public Result fileDataProcessingServiceDeleteInstance() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(19);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 20_文件数据处理服务添加角色实例 fileDataProcessingServiceAddRoleInstance
     */
    @RequestMapping(value = "fileDataProcessingServiceAddRoleInstance", method = RequestMethod.POST)
    public Result fileDataProcessingServiceAddRoleInstance() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(20);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 21_文件数据处理服务启用高可用 fileDataProcessingServicesEnableHighAvailability
     */
    @RequestMapping(value = "fileDataProcessingServicesEnableHighAvailability", method = RequestMethod.POST)
    public Result fileDataProcessingServicesEnableHighAvailability() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(21);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 22_文件数据处理服务滚动编辑 fileDataProcessingServiceScrollingEdit
     */
    @RequestMapping(value = "fileDataProcessingServiceScrollingEdit", method = RequestMethod.POST)
    public Result fileDataProcessingServiceScrollingEdit() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(22);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 23_文件数据处理服务部署客户端配置 fileDataProcessingServiceDeploymentClientConfiguration
     */
    @RequestMapping(value = "fileDataProcessingServiceDeploymentClientConfiguration", method = RequestMethod.POST)
    public Result fileDataProcessingServiceDeploymentClientConfiguration() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(23);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 24_文件数据处理服务下载客户端配置 fileDataProcessingServiceDownloadClientConfiguration
     */
    @RequestMapping(value = "fileDataProcessingServiceDownloadClientConfiguration", method = RequestMethod.POST)
    public Result fileDataProcessingServiceDownloadClientConfiguration() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(24);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 25_文件数据处理服务正在运行的命令查看 fileDataProcessingServiceRunningCommandView
     */
    @RequestMapping(value = "fileDataProcessingServiceRunningCommandView", method = RequestMethod.POST)
    public Result fileDataProcessingServiceRunningCommandView() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(25);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 26_文件数据处理服务最近的命令查看 fileDataProcessingServiceRecentCommandsView
     */
    @RequestMapping(value = "fileDataProcessingServiceRecentCommandsView", method = RequestMethod.POST)
    public Result fileDataProcessingServiceRecentCommandsView() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(26);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 27_文件数据处理服务服务范围配置 fileDataProcessingServiceServiceScopeConfiguration
     */
    @RequestMapping(value = "fileDataProcessingServiceServiceScopeConfiguration", method = RequestMethod.POST)
    public Result fileDataProcessingServiceServiceScopeConfiguration() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(27);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 28_文件数据处理服务服务范围路径配置 fileDataProcessingServiceServiceScopePathConfiguration
     */
    @RequestMapping(value = "fileDataProcessingServiceServiceScopePathConfiguration", method = RequestMethod.POST)
    public Result fileDataProcessingServiceServiceScopePathConfiguration() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(28);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 29_文件数据处理服务服务范围性能配置 fileDataProcessingServiceScopePerformanceConfiguration
     */
    @RequestMapping(value = "fileDataProcessingServiceScopePerformanceConfiguration", method = RequestMethod.POST)
    public Result fileDataProcessingServiceScopePerformanceConfiguration() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(29);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 30_文件数据处理服务服务范围高级配置 fileDataProcessingServiceServiceScopeAdvancedConfiguration
     */
    @RequestMapping(value = "fileDataProcessingServiceServiceScopeAdvancedConfiguration", method = RequestMethod.POST)
    public Result fileDataProcessingServiceServiceScopeAdvancedConfiguration() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(30);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 31_文件数据处理服务服务范围代理配置 fileDataProcessingServiceServiceScopeProxyConfiguration
     */
    @RequestMapping(value = "fileDataProcessingServiceServiceScopeProxyConfiguration", method = RequestMethod.POST)
    public Result fileDataProcessingServiceServiceScopeProxyConfiguration() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(31);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 32_文件数据处理服务服务范围严重性配置 fileDataProcessingServiceScopeSeverityConfiguration
     */
    @RequestMapping(value = "fileDataProcessingServiceScopeSeverityConfiguration", method = RequestMethod.POST)
    public Result fileDataProcessingServiceScopeSeverityConfiguration() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(32);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 33_文件数据处理服务容错控制器配置 fileDataProcessingServiceFaultTolerantControllerConfiguration
     */
    @RequestMapping(value = "fileDataProcessingServiceFaultTolerantControllerConfiguration", method = RequestMethod.POST)
    public Result fileDataProcessingServiceFaultTolerantControllerConfiguration() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(33);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 34_文件数据处理服务容错控制器端口地址配置 fileDataProcessingServiceFaultTolerantControllerPortAddressConfiguration
     */
    @RequestMapping(value = "fileDataProcessingServiceFaultTolerantControllerPortAddressConfiguration", method = RequestMethod.POST)
    public Result fileDataProcessingServiceFaultTolerantControllerPortAddressConfiguration() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(34);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 35_文件数据处理服务容错控制器高级配置 fileDataProcessingServiceFaultTolerantControllerAdvancedConfiguration
     */
    @RequestMapping(value = "fileDataProcessingServiceFaultTolerantControllerAdvancedConfiguration", method = RequestMethod.POST)
    public Result fileDataProcessingServiceFaultTolerantControllerAdvancedConfiguration() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(35);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 36_文件数据处理服务容错控制器日志配置 fileDataProcessingServiceFaultTolerantControllerLogConfiguration
     */
    @RequestMapping(value = "fileDataProcessingServiceFaultTolerantControllerLogConfiguration", method = RequestMethod.POST)
    public Result fileDataProcessingServiceFaultTolerantControllerLogConfiguration() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(36);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 37_文件数据处理服务容错控制器资源管理配置 fileDataProcessingServiceFaultTolerantControllerResourceManagementConfiguration
     */
    @RequestMapping(value = "fileDataProcessingServiceFaultTolerantControllerResourceManagementConfiguration", method = RequestMethod.POST)
    public Result fileDataProcessingServiceFaultTolerantControllerResourceManagementConfiguration() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(37);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 38_文件数据处理服务通道配置 fileDataProcessingServiceChannelConfiguration
     */
    @RequestMapping(value = "fileDataProcessingServiceChannelConfiguration", method = RequestMethod.POST)
    public Result fileDataProcessingServiceChannelConfiguration() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(38);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 39_文件数据处理服务通道作业配置 fileDataProcessingServiceChannelJobConfiguration
     */
    @RequestMapping(value = "fileDataProcessingServiceChannelJobConfiguration", method = RequestMethod.POST)
    public Result fileDataProcessingServiceChannelJobConfiguration() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(39);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 40_文件数据处理服务通道性能配置 fileDataProcessingServiceChannelPerformanceConfiguration
     */
    @RequestMapping(value = "fileDataProcessingServiceChannelPerformanceConfiguration", method = RequestMethod.POST)
    public Result fileDataProcessingServiceChannelPerformanceConfiguration() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(40);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 41_文件数据处理服务通道资源管理配置 fileDataProcessingServiceChannelResourceManagementConfiguration
     */
    @RequestMapping(value = "fileDataProcessingServiceChannelResourceManagementConfiguration", method = RequestMethod.POST)
    public Result fileDataProcessingServiceChannelResourceManagementConfiguration() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(41);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 42_文件数据处理服务通道压缩配置 fileDataProcessingServiceChannelCompressionConfiguration
     */
    @RequestMapping(value = "fileDataProcessingServiceChannelCompressionConfiguration", method = RequestMethod.POST)
    public Result fileDataProcessingServiceChannelCompressionConfiguration() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(42);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * 43_文件数据处理服务通道高级配置 fileDataProcessingServiceChannelAdvancedConfiguration
     */
    @RequestMapping(value = "fileDataProcessingServiceChannelAdvancedConfiguration", method = RequestMethod.POST)
    public Result fileDataProcessingServiceChannelAdvancedConfiguration() throws IOException {
        Dictionary005 dictionary005 = dictionary005Mapper.selectByPrimaryKey(43);
        JsonNode jsonNode = mapper.readTree(dictionary005.getContent());
        return Result.newSuccess(jsonNode);
    }

}
