package com.xenoamess.metasploit.java_external_module.core.handle.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.xenoamess.metasploit.java_external_module.core.constants.MsfPluginResourceUrlStrings;
import com.xenoamess.metasploit.java_external_module.core.entities.MsfRequest;
import com.xenoamess.metasploit.java_external_module.core.entities.response.MsfResponse;
import com.xenoamess.metasploit.java_external_module.core.enums.MsfMethodTypeEnum;
import com.xenoamess.metasploit.java_external_module.core.handle.MsfCannotHandleException;
import com.xenoamess.metasploit.java_external_module.core.handle.MsfRequestHandler;
import com.xenoamess.metasploit.java_external_module.core.utils.JsonUtil;
import java.io.IOException;
import java.io.InputStream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.xenoamess.metasploit.java_external_module.core.enums.MsfMethodTypeEnum.DESCRIBE;

public class MsfDescribeHandler implements MsfRequestHandler<MsfRequest, MsfResponse<JsonNode>> {

    private static final transient Logger LOGGER =
            LoggerFactory.getLogger(MsfDescribeHandler.class);

    private JsonNode msfMetadata;

    public MsfDescribeHandler() {
        this.initMsfMetadata(MsfPluginResourceUrlStrings.METADATA);
    }

    public MsfDescribeHandler(String metadataFilePath) {
        this.initMsfMetadata(metadataFilePath);
    }

    private void initMsfMetadata(String metadataFilePath) {
        try (
                InputStream msfMetadataInputStream =
                        this.getClass().getClassLoader().getResourceAsStream(metadataFilePath);
        ) {
            this.msfMetadata = JsonUtil.getObjectMapper().readValue(msfMetadataInputStream, JsonNode.class);
        } catch (IOException e) {
            LOGGER.error("cannot load msfMetadata:", e);
        }
    }

    @Override
    public @NotNull MsfMethodTypeEnum[] handleMethodTypes() {
        return new MsfMethodTypeEnum[]{DESCRIBE};
    }

    @Nullable
    @Override
    public MsfResponse<JsonNode> handle(@NotNull MsfRequest msfRequest) throws MsfCannotHandleException {
        return new MsfResponse<>(msfRequest.getJsonrpc(), msfRequest.getId(), this.msfMetadata);
    }

    //-----getters and setters

    public JsonNode getMsfMetadata() {
        return msfMetadata;
    }

    public void setMsfMetadata(JsonNode msfMetadata) {
        this.msfMetadata = msfMetadata;
    }
}
