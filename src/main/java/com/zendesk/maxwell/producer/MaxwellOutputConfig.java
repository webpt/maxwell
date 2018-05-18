package com.zendesk.maxwell.producer;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class MaxwellOutputConfig {
	public boolean includesBinlogPosition;
	public boolean includesGtidPosition;
	public boolean includesCommitInfo;
	public boolean includesXOffset;
	public boolean includesNulls;
	public boolean includesServerId;
	public boolean includesThreadId;
	public boolean includesRowQuery;
	public boolean outputDDL;
	public List<Pattern> excludeColumns;

	public String init_vector;
	public String secret_key;
	public Integer trimString;
	public boolean removeNonAscii;
	public EncryptionMode encryptionMode;

	public MaxwellOutputConfig() {
		this.includesBinlogPosition = false;
		this.includesGtidPosition = false;
		this.includesCommitInfo = true;
		this.includesNulls = true;
		this.includesServerId = false;
		this.includesThreadId = false;
		this.includesRowQuery = false;
		this.outputDDL = false;
		this.excludeColumns = new ArrayList<>();
		this.init_vector = null;
		this.secret_key = null;
		this.removeNonAscii = false;
		this.trimString = 0;
		this.encryptionMode = EncryptionMode.ENCRYPT_NONE;
	}

	public boolean encryptionEnabled() {
		return encryptionMode != EncryptionMode.ENCRYPT_NONE;
	}
}
