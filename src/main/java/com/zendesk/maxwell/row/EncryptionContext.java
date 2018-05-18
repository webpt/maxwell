package com.zendesk.maxwell.row;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

class EncryptionContext {
	String secretKey;
	String iv;

	EncryptionContext(String secretKey, String iv) {
		this.secretKey = secretKey;
		this.iv = iv;
	}

	public static EncryptionContext create(String secretKey, String initVector) throws NoSuchAlgorithmException {
		return new EncryptionContext(secretKey, initVector);
	}
}


