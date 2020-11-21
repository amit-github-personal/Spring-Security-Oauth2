package co.springcoders.security.jwt;

import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@SuppressWarnings("deprecation")
public class JwtTokenEnhancer extends JwtAccessTokenConverter {
	
	private static final String PRIVATE_KEY = "-----BEGIN RSA PRIVATE KEY-----\n"
			+ "MIIEowIBAAKCAQEAyZVavMW7DfgeVEIDyKh8W/GYiEjpIkNBdqn1rDCdGmfPcE+1\n"
			+ "shw6GpZihPPkV5uuZwI7jTkCeyaBTu1xgZoQG26xqcGB+fE+QqNlSoIQSYJqIVaL\n"
			+ "ad7v5E2GmSa54gB3apqDNZA3fLqKLm9vAEIo9hgZDwBZgYOuNxbyq0qdRZO26K/P\n"
			+ "1+9WSwcjz2WrBTXiBDDAIt+OtQbnNAt8NtmlG5s/pNHMEvrgIOnJA0R89ffBcuKs\n"
			+ "yRe6MIkTox+hr+fQ2dgHeKmp/YU+/fqFU/JMBHPxU5jVLoa3dfe+TBUSSS6DjjYK\n"
			+ "EzKwIA39cqrDLghT5HSZT0Z8g6UymekIYc5D4QIDAQABAoIBADEVsxCAPTn7jrcJ\n"
			+ "lA5KKG3i+DdHOa1kHw6b9/xDoh2J5ZL9dcq24NcUg0zIbnN+rwraGlIa7aW7DIWB\n"
			+ "f8AFGaL0Y0JoohOQUI69Zq6r2PdtUBZqEmxnIpa+4eVs7po/btSAZy6lvT0b1wXT\n"
			+ "kH3Jnlu+Jmvms+S7gbJcXh6jfoQwMwZsmQ7qL11EiimQgrrWTtDzMnc32FpF8WMt\n"
			+ "mxvJLAo3PH7XaZOmxpy+GGp4kOBb5R5Z2L5lt55QuSIIp9lljWUF+6cP3Jyp1C9Q\n"
			+ "e4yQowXyUrkWTJr31ZcxHaJglZ5NCXrvKAPe/6Z4zBIebcCuNYyPfU7+2WHCy8z7\n"
			+ "sgiI89kCgYEA680CFAw23P0tNX6CkkKylSRID2TmlZY9wNsKrEhbeuvg5Cunz3nE\n"
			+ "7d0h1dQB9bbjCPkBPerlhWvI1lqEBwqBCGi/g2SRVhyhdbflEZmf5I9cDFxHRHb/\n"
			+ "MQi43LJgPPzJGMMl439lKVn8ibDmhFsZ3G73W/hjxiZd8LntAIla738CgYEA2tn5\n"
			+ "6On8+BwXF7PzztDvJBNOwnpduXaYc45whl9L5ECuFvjkjLxej4yiCjZFRBRM4FpT\n"
			+ "igHdytNwpbSjh+BA6TDG4gEb5Ow9k4vjaz2jvoZNDBYSK/v1PoJxJNtpTpg7lTWC\n"
			+ "IXWgncEm8J0uvCjB5eFnZHE5ZdrzCxQhIsKufJ8CgYEAsYrVksSzlmbmYE3WAExJ\n"
			+ "7DO6MiUV3PGXo5sJiTid8Iqj9QjNvFECLtr+O+L6asj+XuYlwjoYAQJr4MGcgTSu\n"
			+ "fOdps4PITl8WTu1cg4j5M/2hIAlm+6zhbkkT79A62BC5VXSyFX35bE498GqK1oNF\n"
			+ "kIzYoJ4AedSvjK5hPbMuDf8CgYBubeDRawgvdZUda7sRV5HjpS5vqWkThUklvfD/\n"
			+ "jKRxt0Vg6BQDA6W/T1oQRxQqZwfniQxwLcLpbkmAA6ckj76RLACe16pol9/2THbj\n"
			+ "jQXLxF6qQ5TFxuwXr6BB1cjMVLpz7r0L/xudnnH0pYuIfBRi15rhLtSklZdftreF\n"
			+ "n7CFxwKBgA0/baztEqP0Qa+aTq0NSbsmVdy99o7gNdB55/ezS3F1A2ZUChRuE14X\n"
			+ "1ZMYfWa46HhYft9MrHOk4eR5Rd0EmCG9pec/RqI3Gqc7eiYZT3xYKhsxSgH+WRE2\n"
			+ "e+cS8UpiP0UcmqU/9QdxRDPT/orSa1/4RVwfW7HSDUa/H5vBEGvu\n"
			+ "-----END RSA PRIVATE KEY-----\n"
			+ "";
	private static final String PUBLIC_KEY = "-----BEGIN PUBLIC KEY-----\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyZVavMW7DfgeVEIDyKh8\n"
			+ "W/GYiEjpIkNBdqn1rDCdGmfPcE+1shw6GpZihPPkV5uuZwI7jTkCeyaBTu1xgZoQ\n"
			+ "G26xqcGB+fE+QqNlSoIQSYJqIVaLad7v5E2GmSa54gB3apqDNZA3fLqKLm9vAEIo\n"
			+ "9hgZDwBZgYOuNxbyq0qdRZO26K/P1+9WSwcjz2WrBTXiBDDAIt+OtQbnNAt8Ntml\n"
			+ "G5s/pNHMEvrgIOnJA0R89ffBcuKsyRe6MIkTox+hr+fQ2dgHeKmp/YU+/fqFU/JM\n"
			+ "BHPxU5jVLoa3dfe+TBUSSS6DjjYKEzKwIA39cqrDLghT5HSZT0Z8g6UymekIYc5D\n"
			+ "4QIDAQAB\n"
			+ "-----END PUBLIC KEY-----\n"
			+ "";
	
	public JwtTokenEnhancer(String publicKey, String privateKey) {
		super.setSigningKey(privateKey);
		super.setVerifierKey(publicKey);
	}
	
	public static JwtAccessTokenConverter getInstance() {
		return new JwtTokenEnhancer(JwtTokenEnhancer.PUBLIC_KEY, JwtTokenEnhancer.PRIVATE_KEY);
	}
	
	
}
