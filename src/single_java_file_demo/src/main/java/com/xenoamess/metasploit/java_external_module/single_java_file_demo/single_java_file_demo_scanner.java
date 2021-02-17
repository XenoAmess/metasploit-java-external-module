package com.xenoamess.metasploit.java_external_module.single_java_file_demo;

import com.xenoamess.metasploit.java_external_module.core.constants.MsfPluginResourceUrlStrings;
import com.xenoamess.metasploit.java_external_module.core.contexts.MsfContext;
import com.xenoamess.metasploit.java_external_module.core.entities.MsfRequest;
import com.xenoamess.metasploit.java_external_module.core.enums.MsfLogLevelEnum;
import com.xenoamess.metasploit.java_external_module.core.handle.impl.MsfDescribeHandler;
import com.xenoamess.metasploit.java_external_module.core.handle.impl.MsfRunHandler;
import com.xenoamess.metasploit.java_external_module.core.utils.MsfCommandLineUtil;

public class single_java_file_demo_scanner {

    /**
     * your code here
     * @param msfRequest msfRequest
     * @return result for msf(seems not used actually)
     * @throws Throwable when any error.
     */
    public Object handleRun(MsfRequest msfRequest) throws Throwable {
        MsfCommandLineUtil.logJson(MsfLogLevelEnum.INFO, "Your input is : ");
        MsfCommandLineUtil.logJson(MsfLogLevelEnum.INFO, msfRequest);
        MsfCommandLineUtil.logJson(MsfLogLevelEnum.GOOD, "XenoAmess here. Welcome to world of Java.");
        MsfCommandLineUtil.logJson(MsfLogLevelEnum.GOOD, "This is single java file demo.");
        MsfCommandLineUtil.reportRaw("find", "this demo run successfully and find the world full of joy!");
        return msfRequest.getParams();
    }

    public static void main(String[] args) {
        single_java_file_demo_scanner msfPluginEntrance = new single_java_file_demo_scanner();
        MsfContext msfContext = new MsfContext(
                new MsfDescribeHandler(MsfPluginResourceUrlStrings.METADATA),
                new MsfRunHandler(msfPluginEntrance::handleRun)
        );
        msfContext.run(args);
    }
}
