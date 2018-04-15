//package com.iflytek.cachemanager.controller;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.iflytek.cachemanager.entity.Dictionary006;
//import com.iflytek.cachemanager.entity.Dictionary006Example;
//import com.iflytek.cachemanager.mapper.Dictionary006Mapper;
//import com.iflytek.cachemanager.result.Result;
//import com.iflytek.cachemanager.util.DateUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.IOException;
//import java.util.*;
//
///**
// * @author: tishen
// * @date: 2018/4/10
// * @description:
// */
//@RestController
//public class Dictionary006Controller {
//
//    @Autowired
//    private Dictionary006Mapper dictionary006Mapper;
//
//    private ObjectMapper mapper = new ObjectMapper();
//
//    /**
//     * 01_文件与数据转换服务服务状态 fileAndDataTransformationServicesServiceStatus
//     */
//    @RequestMapping(value = "fileAndDataTransformationServicesServiceStatus", method = RequestMethod.POST)
//    public Result fileAndDataTransformationServicesServiceStatus(
//            @RequestParam(defaultValue = "query") String method,
//            @RequestParam(required = false) String summary,
//            @RequestParam(required = false) String currentTime,
//            @RequestParam(required = false) String hostName,
//            @RequestParam(required = false) String hostStatus
//    ) throws IOException {
//        Dictionary006 dictionary006 = dictionary006Mapper.selectByPrimaryKey(1);
//        Map map = mapper.readValue(dictionary006.getContent(), Map.class);
//        if ("query".equals(method)) {
//            return Result.newSuccess(map);
//        } else if ("update".equals(method)) {
//            map.put("summary", summary);
//            map.put("currentTime", currentTime);
//            map.put("hostName", hostName);
//            map.put("hostStatus", hostStatus);
//            dictionary006.setContent(mapper.writeValueAsString(map));
//            dictionary006Mapper.updateByPrimaryKey(dictionary006);
//            return Result.newSuccess(map);
//        }
//        return Result.newFailure("method no found", null);
//    }
//
//    /**
//     * 02_事件搜索 eventSearch
//     */
//    @RequestMapping(value = "eventSearch", method = RequestMethod.POST)
//    public Result eventSearch(
//            @RequestParam(defaultValue = "query") String method,
//            @RequestParam(required = false, defaultValue = "全部") String type,
//            @RequestParam(required = false, defaultValue = "") String desc,
//            @RequestParam(required = false) String reason,
//            @RequestParam(required = false) String serviceID
//    ) throws IOException {
//        if ("query".equals(method)) {
//            Dictionary006Example example = new Dictionary006Example();
//            Dictionary006Example.Criteria criteria = example.createCriteria();
//            criteria.andPidEqualTo(33);
//            List<Dictionary006> list = dictionary006Mapper.selectByExample(example);
//            List sonList = new ArrayList();
//            for (Dictionary006 d : list) {
//                Map map = mapper.readValue(d.getContent(), Map.class);
//                if ("全部".equals(type) || map.get("type").equals(type)) {
//                    if (((String) map.get("desc")).contains(desc)) {
//                        sonList.add(map);
//                    }
//                }
//            }
//            return Result.newSuccess(sonList);
//        } else if ("add".equals(method)) {
//            Dictionary006 dictionary006 = new Dictionary006();
//            dictionary006.setPid(33);
//            dictionary006.setLevel(2);
//            dictionary006.setState(1);
//            dictionary006.setDescmsg("事件-儿子");
//            Map map = new HashMap();
//            map.put("type", type);
//            map.put("id", UUID.randomUUID().toString());
//            map.put("desc", desc);
//            map.put("reason", reason);
//            map.put("serviceID", serviceID);
//            map.put("beginTime", DateUtils.parseDateToStr(new Date(), "yyyy-MM-dd HH:mm:ss"));
//            dictionary006.setContent(mapper.writeValueAsString(map));
//            dictionary006Mapper.insertSelective(dictionary006);
//            return Result.newSuccess(null);
//        }
//        return Result.newFailure("method no found", null);
//    }
//
//    /**
//     * 03_文件与数据转换服务进程查看 fileAndDataTransformationServicesProcessView
//     */
//    @RequestMapping(value = "fileAndDataTransformationServicesProcessView", method = RequestMethod.POST)
//    public Result fileAndDataTransformationServicesProcessView(
//            @RequestParam(defaultValue = "query") String method,
//            @RequestParam(required = false) String program,
//            @RequestParam(required = false) String userGroup,
//            @RequestParam(required = false) String link,
//            @RequestParam(required = false) String configurationFile,
//            @RequestParam(required = false) String processStatus,
//            @RequestParam(required = false) String pid,
//            @RequestParam(required = false) String runTime
//    ) throws IOException {
//        Dictionary006 dictionary006 = dictionary006Mapper.selectByPrimaryKey(3);
//        Map map = mapper.readValue(dictionary006.getContent(), Map.class);
//        if ("query".equals(method)) {
//            return Result.newSuccess(map);
//        } else if ("update".equals(method)) {
//            map.put("program", program);
//            map.put("userGroup", userGroup);
//            map.put("link", link);
//            map.put("configurationFile", configurationFile);
//            map.put("processStatus", processStatus);
//            map.put("pid", pid);
//            map.put("runTime", runTime);
//            dictionary006.setContent(mapper.writeValueAsString(map));
//            dictionary006Mapper.updateByPrimaryKey(dictionary006);
//            return Result.newSuccess(map);
//        }
//        return Result.newFailure("method no found", null);
//    }
//
//    /**
//     * 04_文件与数据转换服务实例查看 fileAndDataTransformationServiceInstanceView
//     */
//    @RequestMapping(value = "fileAndDataTransformationServiceInstanceView", method = RequestMethod.POST)
//    public Result fileAndDataTransformationServiceInstanceView() throws IOException {
//        Dictionary006 dictionary006 = dictionary006Mapper.selectByPrimaryKey(4);
//        JsonNode jsonNode = mapper.readTree(dictionary006.getContent());
//        return Result.newSuccess(jsonNode);
//    }
//
//    /**
//     * 05_文件与数据转换服务启动实例 fileAndDataTransformationServiceStartupInstance
//     */
//    @RequestMapping(value = "fileAndDataTransformationServiceStartupInstance", method = RequestMethod.POST)
//    public Result fileAndDataTransformationServiceStartupInstance() throws IOException {
//        Dictionary006 dictionary006 = dictionary006Mapper.selectByPrimaryKey(5);
//        JsonNode jsonNode = mapper.readTree(dictionary006.getContent());
//        return Result.newSuccess(jsonNode);
//    }
//
//    /**
//     * 06_文件与数据转换服务停止实例 fileAndDataTransformationServiceStopInstance
//     */
//    @RequestMapping(value = "fileAndDataTransformationServiceStopInstance", method = RequestMethod.POST)
//    public Result fileAndDataTransformationServiceStopInstance() throws IOException {
//        Dictionary006 dictionary006 = dictionary006Mapper.selectByPrimaryKey(6);
//        JsonNode jsonNode = mapper.readTree(dictionary006.getContent());
//        return Result.newSuccess(jsonNode);
//    }
//
//    /**
//     * 07_文件与数据转换服务重启实例 fileAndDataTransformationServiceRestartInstance
//     */
//    @RequestMapping(value = "fileAndDataTransformationServiceRestartInstance", method = RequestMethod.POST)
//    public Result fileAndDataTransformationServiceRestartInstance() throws IOException {
//        Dictionary006 dictionary006 = dictionary006Mapper.selectByPrimaryKey(7);
//        JsonNode jsonNode = mapper.readTree(dictionary006.getContent());
//        return Result.newSuccess(jsonNode);
//    }
//
//    /**
//     * 08_文件与数据转换服务实例进入维护模式 fileAndDataTransformationServiceInstanceIntoMaintenanceMode
//     */
//    @RequestMapping(value = "fileAndDataTransformationServiceInstanceIntoMaintenanceMode", method = RequestMethod.POST)
//    public Result fileAndDataTransformationServiceInstanceIntoMaintenanceMode() throws IOException {
//        Dictionary006 dictionary006 = dictionary006Mapper.selectByPrimaryKey(8);
//        JsonNode jsonNode = mapper.readTree(dictionary006.getContent());
//        return Result.newSuccess(jsonNode);
//    }
//
//    /**
//     * 09_文件与数据转换服务实例退出维护模式 fileAndDataTransformationServiceInstanceExitMaintenanceMode
//     */
//    @RequestMapping(value = "fileAndDataTransformationServiceInstanceExitMaintenanceMode", method = RequestMethod.POST)
//    public Result fileAndDataTransformationServiceInstanceExitMaintenanceMode() throws IOException {
//        Dictionary006 dictionary006 = dictionary006Mapper.selectByPrimaryKey(9);
//        JsonNode jsonNode = mapper.readTree(dictionary006.getContent());
//        return Result.newSuccess(jsonNode);
//    }
//
//    /**
//     * 10_文件与数据转换服务删除实例 fileAndDataTransformationServiceDeleteInstance
//     */
//    @RequestMapping(value = "fileAndDataTransformationServiceDeleteInstance", method = RequestMethod.POST)
//    public Result fileAndDataTransformationServiceDeleteInstance() throws IOException {
//        Dictionary006 dictionary006 = dictionary006Mapper.selectByPrimaryKey(10);
//        JsonNode jsonNode = mapper.readTree(dictionary006.getContent());
//        return Result.newSuccess(jsonNode);
//    }
//
//    /**
//     * 11_文件与数据转换服务添加角色实例 filesAndDataTransformationServicesAddRoleInstances
//     */
//    @RequestMapping(value = "filesAndDataTransformationServicesAddRoleInstances", method = RequestMethod.POST)
//    public Result filesAndDataTransformationServicesAddRoleInstances() throws IOException {
//        Dictionary006 dictionary006 = dictionary006Mapper.selectByPrimaryKey(11);
//        JsonNode jsonNode = mapper.readTree(dictionary006.getContent());
//        return Result.newSuccess(jsonNode);
//    }
//
//    /**
//     * 12_创建文件与数据转换服务用户目录 createFilesAndDataTransformationServicesUserDirectory
//     */
//    @RequestMapping(value = "createFilesAndDataTransformationServicesUserDirectory", method = RequestMethod.POST)
//    public Result createFilesAndDataTransformationServicesUserDirectory() throws IOException {
//        Dictionary006 dictionary006 = dictionary006Mapper.selectByPrimaryKey(12);
//        JsonNode jsonNode = mapper.readTree(dictionary006.getContent());
//        return Result.newSuccess(jsonNode);
//    }
//
//    /**
//     * 13_文件与数据转换服务正在运行的命令查看 filesAndDataTransformationServicesRunningCommandsView
//     */
//    @RequestMapping(value = "filesAndDataTransformationServicesRunningCommandsView", method = RequestMethod.POST)
//    public Result filesAndDataTransformationServicesRunningCommandsView() throws IOException {
//        Dictionary006 dictionary006 = dictionary006Mapper.selectByPrimaryKey(13);
//        JsonNode jsonNode = mapper.readTree(dictionary006.getContent());
//        return Result.newSuccess(jsonNode);
//    }
//
//    /**
//     * 14_文件与数据转换服务最近的命令查看 filesAndDataTransformationServicesRecentCommandsView
//     */
//    @RequestMapping(value = "filesAndDataTransformationServicesRecentCommandsView", method = RequestMethod.POST)
//    public Result filesAndDataTransformationServicesRecentCommandsView() throws IOException {
//        Dictionary006 dictionary006 = dictionary006Mapper.selectByPrimaryKey(14);
//        JsonNode jsonNode = mapper.readTree(dictionary006.getContent());
//        return Result.newSuccess(jsonNode);
//    }
//
//    /**
//     * 15_文件与数据转换服务默认服务范围配置 fileAndDataTransformationServicesDefaultServiceScopeConfiguration
//     */
//    @RequestMapping(value = "fileAndDataTransformationServicesDefaultServiceScopeConfiguration", method = RequestMethod.POST)
//    public Result fileAndDataTransformationServicesDefaultServiceScopeConfiguration(
//            @RequestParam(defaultValue = "query") String method,
//            @RequestParam(required = false) String timingCycleTime,
//            @RequestParam(required = false) String synchronizationRestrictions,
//            @RequestParam(required = false) String initializationRestrictions,
//            @RequestParam(required = false) String cleanRetentionCount,
//            @RequestParam(required = false) String enableKerberosAuthentication,
//            @RequestParam(required = false) String leaderService
//    ) throws IOException {
//        Dictionary006 dictionary006 = dictionary006Mapper.selectByPrimaryKey(15);
//        Map map = mapper.readValue(dictionary006.getContent(), Map.class);
//        if ("query".equals(method)) {
//            return Result.newSuccess(map);
//        } else if ("update".equals(method)) {
//            map.put("timingCycleTime", timingCycleTime);
//            map.put("synchronizationRestrictions", synchronizationRestrictions);
//            map.put("initializationRestrictions", initializationRestrictions);
//            map.put("cleanRetentionCount", cleanRetentionCount);
//            map.put("enableKerberosAuthentication", enableKerberosAuthentication);
//            map.put("leaderService", leaderService);
//            dictionary006.setContent(mapper.writeValueAsString(map));
//            dictionary006Mapper.updateByPrimaryKey(dictionary006);
//            return Result.newSuccess(map);
//        }
//        return Result.newFailure("method no found", null);
//    }
//
//    /**
//     * 16_文件与数据转换服务服务范围高级配置 fileAndDataTransformationServicesServiceScopeAdvancedConfiguration
//     */
//    @RequestMapping(value = "fileAndDataTransformationServicesServiceScopeAdvancedConfiguration", method = RequestMethod.POST)
//    public Result fileAndDataTransformationServicesServiceScopeAdvancedConfiguration(
//            @RequestParam(defaultValue = "query") String method,
//            @RequestParam(required = false) String systemUsers,
//            @RequestParam(required = false) String systemGroups,
//            @RequestParam(required = false) String systemUserHomeDirectory,
//            @RequestParam(required = false) String serviceConfigurationReliefValve,
//            @RequestParam(required = false) String environmentReliefValve
//    ) throws IOException {
//        Dictionary006 dictionary006 = dictionary006Mapper.selectByPrimaryKey(16);
//        Map map = mapper.readValue(dictionary006.getContent(), Map.class);
//        if ("query".equals(method)) {
//            return Result.newSuccess(map);
//        } else if ("update".equals(method)) {
//            map.put("systemUsers", systemUsers);
//            map.put("systemGroups", systemGroups);
//            map.put("systemUserHomeDirectory", systemUserHomeDirectory);
//            map.put("serviceConfigurationReliefValve", serviceConfigurationReliefValve);
//            map.put("environmentReliefValve", environmentReliefValve);
//            dictionary006.setContent(mapper.writeValueAsString(map));
//            dictionary006Mapper.updateByPrimaryKey(dictionary006);
//            return Result.newSuccess(map);
//        }
//        return Result.newFailure("method no found", null);
//    }
//
//    /**
//     * 17_文件与数据转换服务默认服务器配置 fileAndDataTransformationServicesDefaultServerConfiguration
//     */
//    @RequestMapping(value = "fileAndDataTransformationServicesDefaultServerConfiguration", method = RequestMethod.POST)
//    public Result fileAndDataTransformationServicesDefaultServerConfiguration(
//            @RequestParam(defaultValue = "query") String method,
//            @RequestParam(required = false) String serverID,
//            @RequestParam(required = false) String dataDirectory,
//            @RequestParam(required = false) String transactionLogDirectory,
//            @RequestParam(required = false) String logDirectory,
//            @RequestParam(required = false) String clientPortAddress,
//            @RequestParam(required = false) String maximumNumberOfClientConnection,
//            @RequestParam(required = false) String minimumSessionTimeout,
//            @RequestParam(required = false) String sessionTimeout,
//            @RequestParam(required = false) String enableJMXAgent,
//            @RequestParam(required = false) String enableAuthenticationCommunicationWithTheJMXAgent,
//            @RequestParam(required = false) String userNameWithReadnlyAccessToJMXProxyPermissions,
//            @RequestParam(required = false) String userPasswordWithJMXDelegateReadonlyAccess,
//            @RequestParam(required = false) String userNameWithJMXDelegateReadAndWriteAccess,
//            @RequestParam(required = false) String userPasswordWithJMXDelegateReadAndWriteAccess
//    ) throws IOException {
//        Dictionary006 dictionary006 = dictionary006Mapper.selectByPrimaryKey(17);
//        Map map = mapper.readValue(dictionary006.getContent(), Map.class);
//        if ("query".equals(method)) {
//            return Result.newSuccess(map);
//        } else if ("update".equals(method)) {
//            map.put("serverID", serverID);
//            map.put("dataDirectory", dataDirectory);
//            map.put("transactionLogDirectory", transactionLogDirectory);
//            map.put("logDirectory", logDirectory);
//            map.put("clientPortAddress", clientPortAddress);
//            map.put("maximumNumberOfClientConnection", maximumNumberOfClientConnection);
//            map.put("minimumSessionTimeout", minimumSessionTimeout);
//            map.put("sessionTimeout", sessionTimeout);
//            map.put("enableJMXAgent", enableJMXAgent);
//            map.put("enableAuthenticationCommunicationWithTheJMXAgent", enableAuthenticationCommunicationWithTheJMXAgent);
//            map.put("userNameWithReadnlyAccessToJMXProxyPermissions", userNameWithReadnlyAccessToJMXProxyPermissions);
//            map.put("userPasswordWithJMXDelegateReadonlyAccess", userPasswordWithJMXDelegateReadonlyAccess);
//            map.put("userNameWithJMXDelegateReadAndWriteAccess", userNameWithJMXDelegateReadAndWriteAccess);
//            map.put("userPasswordWithJMXDelegateReadAndWriteAccess", userPasswordWithJMXDelegateReadAndWriteAccess);
//            dictionary006.setContent(mapper.writeValueAsString(map));
//            dictionary006Mapper.updateByPrimaryKey(dictionary006);
//            return Result.newSuccess(map);
//        }
//        return Result.newFailure("method no found", null);
//    }
//
//    /**
//     * 18_文件与数据转换服务通道资源管理配置 fileAndDataTransformationServiceChannelResourceManagementConfiguration
//     */
//    @RequestMapping(value = "fileAndDataTransformationServiceChannelResourceManagementConfiguration", method = RequestMethod.POST)
//    public Result fileAndDataTransformationServiceChannelResourceManagementConfiguration(
//            @RequestParam(defaultValue = "query") String method,
//            @RequestParam(required = false) String childJavaMaximumStack,
//            @RequestParam(required = false) String maximumVirtualMemory,
//            @RequestParam(required = false) String mapTaskMaximumStack,
//            @RequestParam(required = false) String mapTaskMaximumVirtualMemory,
//            @RequestParam(required = false) String reduceTaskMaximumStack,
//            @RequestParam(required = false) String reduceTaskMaximumVirtualMemory,
//            @RequestParam(required = false) String clientJavaHeapSize
//    ) throws IOException {
//        Dictionary006 dictionary006 = dictionary006Mapper.selectByPrimaryKey(18);
//        Map map = mapper.readValue(dictionary006.getContent(), Map.class);
//        if ("query".equals(method)) {
//            return Result.newSuccess(map);
//        } else if ("update".equals(method)) {
//            map.put("childJavaMaximumStack", childJavaMaximumStack);
//            map.put("maximumVirtualMemory", maximumVirtualMemory);
//            map.put("mapTaskMaximumStack", mapTaskMaximumStack);
//            map.put("mapTaskMaximumVirtualMemory", mapTaskMaximumVirtualMemory);
//            map.put("reduceTaskMaximumStack", reduceTaskMaximumStack);
//            map.put("reduceTaskMaximumVirtualMemory", reduceTaskMaximumVirtualMemory);
//            map.put("clientJavaHeapSize", clientJavaHeapSize);
//            dictionary006.setContent(mapper.writeValueAsString(map));
//            dictionary006Mapper.updateByPrimaryKey(dictionary006);
//            return Result.newSuccess(map);
//        }
//        return Result.newFailure("method no found", null);
//    }
//
//    /**
//     * 19_文件与数据转换服务失败控制器端口地址配置 fileAndDataTransformationServiceFailedControllerPortAddressConfiguration
//     */
//    @RequestMapping(value = "fileAndDataTransformationServiceFailedControllerPortAddressConfiguration", method = RequestMethod.POST)
//    public Result fileAndDataTransformationServiceFailedControllerPortAddressConfiguration(
//            @RequestParam(defaultValue = "query") String method,
//            @RequestParam(required = false) String failedControllerPort
//    ) throws IOException {
//        Dictionary006 dictionary006 = dictionary006Mapper.selectByPrimaryKey(19);
//        Map map = mapper.readValue(dictionary006.getContent(), Map.class);
//        if ("query".equals(method)) {
//            return Result.newSuccess(map);
//        } else if ("update".equals(method)) {
//            map.put("failedControllerPort", failedControllerPort);
//            dictionary006.setContent(mapper.writeValueAsString(map));
//            dictionary006Mapper.updateByPrimaryKey(dictionary006);
//            return Result.newSuccess(map);
//        }
//        return Result.newFailure("method no found", null);
//    }
//
//    /**
//     * 20_文件与数据转换服务失败控制器高级配置 fileAndDataTransformationServiceFailedControllerAdvancedConfiguration
//     */
//    @RequestMapping(value = "fileAndDataTransformationServiceFailedControllerAdvancedConfiguration", method = RequestMethod.POST)
//    public Result fileAndDataTransformationServiceFailedControllerAdvancedConfiguration(
//            @RequestParam(defaultValue = "query") String method,
//            @RequestParam(required = false) String javaConfigurationOptions,
//            @RequestParam(required = false) String automaticRestartProcess,
//            @RequestParam(required = false) String loggingSafetyValve,
//            @RequestParam(required = false) String configuredSafetyValve
//    ) throws IOException {
//        Dictionary006 dictionary006 = dictionary006Mapper.selectByPrimaryKey(20);
//        Map map = mapper.readValue(dictionary006.getContent(), Map.class);
//        if ("query".equals(method)) {
//            return Result.newSuccess(map);
//        } else if ("update".equals(method)) {
//            map.put("javaConfigurationOptions", javaConfigurationOptions);
//            map.put("automaticRestartProcess", automaticRestartProcess);
//            map.put("loggingSafetyValve", loggingSafetyValve);
//            map.put("configuredSafetyValve", configuredSafetyValve);
//            dictionary006.setContent(mapper.writeValueAsString(map));
//            dictionary006Mapper.updateByPrimaryKey(dictionary006);
//            return Result.newSuccess(map);
//        }
//        return Result.newFailure("method no found", null);
//    }
//
//    /**
//     * 21_文件与数据转换服务失败控制器日志配置 fileAndDataTransformationServicesFailedControllerLogConfiguration
//     */
//    @RequestMapping(value = "fileAndDataTransformationServicesFailedControllerLogConfiguration", method = RequestMethod.POST)
//    public Result fileAndDataTransformationServicesFailedControllerLogConfiguration(
//            @RequestParam(defaultValue = "query") String method,
//            @RequestParam(required = false) String logDirectory,
//            @RequestParam(required = false) String recordThresholds,
//            @RequestParam(required = false) String maximumLogSize,
//            @RequestParam(required = false) String maximumLogFileBackup
//    ) throws IOException {
//        Dictionary006 dictionary006 = dictionary006Mapper.selectByPrimaryKey(21);
//        Map map = mapper.readValue(dictionary006.getContent(), Map.class);
//        if ("query".equals(method)) {
//            return Result.newSuccess(map);
//        } else if ("update".equals(method)) {
//            map.put("logDirectory", logDirectory);
//            map.put("recordThresholds", recordThresholds);
//            map.put("maximumLogSize", maximumLogSize);
//            map.put("maximumLogFileBackup", maximumLogFileBackup);
//            dictionary006.setContent(mapper.writeValueAsString(map));
//            dictionary006Mapper.updateByPrimaryKey(dictionary006);
//            return Result.newSuccess(map);
//        }
//        return Result.newFailure("method no found", null);
//    }
//
//    /**
//     * 22_文件与数据转换服务监控服务范围配置 fileAndDataTransformationServicesMonitorServiceScopeConfiguration
//     */
//    @RequestMapping(value = "fileAndDataTransformationServicesMonitorServiceScopeConfiguration", method = RequestMethod.POST)
//    public Result fileAndDataTransformationServicesMonitorServiceScopeConfiguration(
//            @RequestParam(defaultValue = "query") String method,
//            @RequestParam(required = false) String enableServiceLevelHealthAlerts,
//            @RequestParam(required = false) String healthCheck,
//            @RequestParam(required = false) String rootZnodePath,
//            @RequestParam(required = false) String connectionTimeout,
//            @RequestParam(required = false) String sessionTimeout,
//            @RequestParam(required = false) String operationTimeout,
//            @RequestParam(required = false) String enableConfigurationChangeAlerts
//    ) throws IOException {
//        Dictionary006 dictionary006 = dictionary006Mapper.selectByPrimaryKey(22);
//        Map map = mapper.readValue(dictionary006.getContent(), Map.class);
//        if ("query".equals(method)) {
//            return Result.newSuccess(map);
//        } else if ("update".equals(method)) {
//            map.put("enableServiceLevelHealthAlerts", enableServiceLevelHealthAlerts);
//            map.put("healthCheck", healthCheck);
//            map.put("rootZnodePath", rootZnodePath);
//            map.put("connectionTimeout", connectionTimeout);
//            map.put("sessionTimeout", sessionTimeout);
//            map.put("operationTimeout", operationTimeout);
//            map.put("enableConfigurationChangeAlerts", enableConfigurationChangeAlerts);
//            dictionary006.setContent(mapper.writeValueAsString(map));
//            dictionary006Mapper.updateByPrimaryKey(dictionary006);
//            return Result.newSuccess(map);
//        }
//        return Result.newFailure("method no found", null);
//    }
//
//    /**
//     * 23_文件与数据转换服务监控事件和报警 filesAndDataTransformationServicesMonitorEventsAndAlarms
//     */
//    @RequestMapping(value = "filesAndDataTransformationServicesMonitorEventsAndAlarms", method = RequestMethod.POST)
//    public Result filesAndDataTransformationServicesMonitorEventsAndAlarms(
//            @RequestParam(defaultValue = "query") String method,
//            @RequestParam(required = false) String enableLogEventCapture,
//            @RequestParam(required = false) String logEventRetryFrequency
//    ) throws IOException {
//        Dictionary006 dictionary006 = dictionary006Mapper.selectByPrimaryKey(23);
//        Map map = mapper.readValue(dictionary006.getContent(), Map.class);
//        if ("query".equals(method)) {
//            return Result.newSuccess(map);
//        } else if ("update".equals(method)) {
//            map.put("enableLogEventCapture", enableLogEventCapture);
//            map.put("logEventRetryFrequency", logEventRetryFrequency);
//            dictionary006.setContent(mapper.writeValueAsString(map));
//            dictionary006Mapper.updateByPrimaryKey(dictionary006);
//            return Result.newSuccess(map);
//        }
//        return Result.newFailure("method no found", null);
//    }
//
//    /**
//     * 24_文件与数据转换服务监控服务范围阈值 fileAndDataTransformationServicesMonitorServiceScopeThresholds
//     */
//    @RequestMapping(value = "fileAndDataTransformationServicesMonitorServiceScopeThresholds", method = RequestMethod.POST)
//    public Result fileAndDataTransformationServicesMonitorServiceScopeThresholds(
//            @RequestParam(defaultValue = "query") String method,
//            @RequestParam(required = false) String serverMonitoringThresholds
//    ) throws IOException {
//        Dictionary006 dictionary006 = dictionary006Mapper.selectByPrimaryKey(24);
//        Map map = mapper.readValue(dictionary006.getContent(), Map.class);
//        if ("query".equals(method)) {
//            return Result.newSuccess(map);
//        } else if ("update".equals(method)) {
//            map.put("serverMonitoringThresholds", serverMonitoringThresholds);
//            dictionary006.setContent(mapper.writeValueAsString(map));
//            dictionary006Mapper.updateByPrimaryKey(dictionary006);
//            return Result.newSuccess(map);
//        }
//        return Result.newFailure("method no found", null);
//    }
//
//    /**
//     * 25_文件与数据转换服务监控服务器配置 fileAndDataTransformationServicesMonitorServerConfiguration
//     */
//    @RequestMapping(value = "fileAndDataTransformationServicesMonitorServerConfiguration", method = RequestMethod.POST)
//    public Result fileAndDataTransformationServicesMonitorServerConfiguration(
//            @RequestParam(defaultValue = "query") String method,
//            @RequestParam(required = false) String servicesServerProcessHealthCheck,
//            @RequestParam(required = false) String servicesServerHostHealthCheck,
//            @RequestParam(required = false) String enableHealthAlertsForThisRole,
//            @RequestParam(required = false) String extractRulesForEventsFromLogFiles,
//            @RequestParam(required = false) String enableQuorumMembershipCheck,
//            @RequestParam(required = false) String quorumMembershipDetectionWindow,
//            @RequestParam(required = false) String serverConnectionCountMonitoringCycle,
//            @RequestParam(required = false) String serverDidNotProcessRequestMonitoringCycles,
//            @RequestParam(required = false) String unexpectedExitMonitoringCycle,
//            @RequestParam(required = false) String enableConfigurationChangeAlerts
//    ) throws IOException {
//        Dictionary006 dictionary006 = dictionary006Mapper.selectByPrimaryKey(25);
//        Map map = mapper.readValue(dictionary006.getContent(), Map.class);
//        if ("query".equals(method)) {
//            return Result.newSuccess(map);
//        } else if ("update".equals(method)) {
//            map.put("servicesServerProcessHealthCheck", servicesServerProcessHealthCheck);
//            map.put("servicesServerHostHealthCheck", servicesServerHostHealthCheck);
//            map.put("enableHealthAlertsForThisRole", enableHealthAlertsForThisRole);
//            map.put("extractRulesForEventsFromLogFiles", extractRulesForEventsFromLogFiles);
//            map.put("enableQuorumMembershipCheck", enableQuorumMembershipCheck);
//            map.put("quorumMembershipDetectionWindow", quorumMembershipDetectionWindow);
//            map.put("serverConnectionCountMonitoringCycle", serverConnectionCountMonitoringCycle);
//            map.put("serverDidNotProcessRequestMonitoringCycles", serverDidNotProcessRequestMonitoringCycles);
//            map.put("unexpectedExitMonitoringCycle", unexpectedExitMonitoringCycle);
//            map.put("enableConfigurationChangeAlerts", enableConfigurationChangeAlerts);
//            dictionary006.setContent(mapper.writeValueAsString(map));
//            dictionary006Mapper.updateByPrimaryKey(dictionary006);
//            return Result.newSuccess(map);
//        }
//        return Result.newFailure("method no found", null);
//    }
//
//    /**
//     * 26_文件与数据转换服务监控服务器阈值 fileAndDataTransformationServiceMonitorServerThresholds
//     */
//    @RequestMapping(value = "fileAndDataTransformationServiceMonitorServerThresholds", method = RequestMethod.POST)
//    public Result fileAndDataTransformationServiceMonitorServerThresholds(
//            @RequestParam(defaultValue = "query") String method,
//            @RequestParam(required = false) String fileDescriptorMonitoringThresholds,
//            @RequestParam(required = false) String dataDirectoryFreeSpaceToMonitorAbsoluteThresholds,
//            @RequestParam(required = false) String dataDirectoryFreeSpaceMonitoringPercentThresholds,
//            @RequestParam(required = false) String dataLogDirectoryFreeSpaceToMonitorAbsoluteThresholds,
//            @RequestParam(required = false) String dataLogDirectoryFreeSpaceMonitoringPercentThresholds,
//            @RequestParam(required = false) String logDirectoryFreeSpaceToMonitorAbsoluteThresholds,
//            @RequestParam(required = false) String logDirectoryFreeSpaceToMonitorPercentThresholds,
//            @RequestParam(required = false) String garbageCollectionDurationThreshold,
//            @RequestParam(required = false) String garbageCollectionDurationMonitoringCycle,
//            @RequestParam(required = false) String serverMaximumLatencyMonitoringThresholds
//    ) throws IOException {
//        Dictionary006 dictionary006 = dictionary006Mapper.selectByPrimaryKey(26);
//        Map map = mapper.readValue(dictionary006.getContent(), Map.class);
//        if ("query".equals(method)) {
//            return Result.newSuccess(map);
//        } else if ("update".equals(method)) {
//            map.put("fileDescriptorMonitoringThresholds", fileDescriptorMonitoringThresholds);
//            map.put("dataDirectoryFreeSpaceToMonitorAbsoluteThresholds", dataDirectoryFreeSpaceToMonitorAbsoluteThresholds);
//            map.put("dataDirectoryFreeSpaceMonitoringPercentThresholds", dataDirectoryFreeSpaceMonitoringPercentThresholds);
//            map.put("dataLogDirectoryFreeSpaceToMonitorAbsoluteThresholds", dataLogDirectoryFreeSpaceToMonitorAbsoluteThresholds);
//            map.put("dataLogDirectoryFreeSpaceMonitoringPercentThresholds", dataLogDirectoryFreeSpaceMonitoringPercentThresholds);
//            map.put("logDirectoryFreeSpaceToMonitorAbsoluteThresholds", logDirectoryFreeSpaceToMonitorAbsoluteThresholds);
//            map.put("logDirectoryFreeSpaceToMonitorPercentThresholds", logDirectoryFreeSpaceToMonitorPercentThresholds);
//            map.put("garbageCollectionDurationThreshold", garbageCollectionDurationThreshold);
//            map.put("garbageCollectionDurationMonitoringCycle", garbageCollectionDurationMonitoringCycle);
//            map.put("serverMaximumLatencyMonitoringThresholds", serverMaximumLatencyMonitoringThresholds);
//            dictionary006.setContent(mapper.writeValueAsString(map));
//            dictionary006Mapper.updateByPrimaryKey(dictionary006);
//            return Result.newSuccess(map);
//        }
//        return Result.newFailure("method no found", null);
//    }
//
//    /**
//     * 27_文件与数据转换服务角色组查看 fileWithDataTransformationServicesRoleGroupView
//     */
//    @RequestMapping(value = "fileWithDataTransformationServicesRoleGroupView", method = RequestMethod.POST)
//    public Result fileWithDataTransformationServicesRoleGroupView() throws IOException {
//        Dictionary006 dictionary006 = dictionary006Mapper.selectByPrimaryKey(27);
//        JsonNode jsonNode = mapper.readTree(dictionary006.getContent());
//        return Result.newSuccess(jsonNode);
//    }
//
//    /**
//     * 28_文件与数据转换服务创建角色组 filesAndDataTransformationServicesCreateRoleGroups
//     */
//    @RequestMapping(value = "filesAndDataTransformationServicesCreateRoleGroups", method = RequestMethod.POST)
//    public Result filesAndDataTransformationServicesCreateRoleGroups() throws IOException {
//        Dictionary006 dictionary006 = dictionary006Mapper.selectByPrimaryKey(28);
//        JsonNode jsonNode = mapper.readTree(dictionary006.getContent());
//        return Result.newSuccess(jsonNode);
//    }
//
//    /**
//     * 29_文件与数据转换服务审核 fileAndDataTransformationServicesAudit
//     */
//    @RequestMapping(value = "fileAndDataTransformationServicesAudit", method = RequestMethod.POST)
//    public Result fileAndDataTransformationServicesAudit() throws IOException {
//        Dictionary006 dictionary006 = dictionary006Mapper.selectByPrimaryKey(29);
//        JsonNode jsonNode = mapper.readTree(dictionary006.getContent());
//        return Result.newSuccess(jsonNode);
//    }
//
//    /**
//     * 30_文件与数据转换服务审核添加筛选 fileAndDataTransformationServicesAuditAddFilter
//     */
//    @RequestMapping(value = "fileAndDataTransformationServicesAuditAddFilter", method = RequestMethod.POST)
//    public Result fileAndDataTransformationServicesAuditAddFilter() throws IOException {
//        Dictionary006 dictionary006 = dictionary006Mapper.selectByPrimaryKey(30);
//        JsonNode jsonNode = mapper.readTree(dictionary006.getContent());
//        return Result.newSuccess(jsonNode);
//    }
//
//    /**
//     * 31_文件与数据转换服务下载记录文件 fileAndDataTransformationServicesDownloadRecordFile
//     */
//    @RequestMapping(value = "fileAndDataTransformationServicesDownloadRecordFile", method = RequestMethod.POST)
//    public Result fileAndDataTransformationServicesDownloadRecordFile() throws IOException {
//        Dictionary006 dictionary006 = dictionary006Mapper.selectByPrimaryKey(31);
//        JsonNode jsonNode = mapper.readTree(dictionary006.getContent());
//        return Result.newSuccess(jsonNode);
//    }
//
//}
